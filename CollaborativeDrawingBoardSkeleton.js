class DrawingBoard {
    constructor() {
        this.canvas = document.createElement('canvas');
        this.ctx = this.canvas.getContext('2d');
        this.isDrawing = false;
        this.brushSize = 5;
        this.color = '#000000';
        this.actions = [];
        this.redoStack = [];
        
        this.setupCanvas();
        this.setupWebSocket();
        this.addEventListeners();
    }
    
    setupCanvas() {
        this.canvas.width = window.innerWidth * 0.8;
        this.canvas.height = window.innerHeight * 0.8;
        document.body.appendChild(this.canvas);
    }
    
    setupWebSocket() {
        this.ws = new WebSocket('ws://localhost:8080');
        this.ws.onmessage = (event) => {
            const action = JSON.parse(event.data);
            this.drawAction(action);
        };
    }
    
    addEventListeners() {
        this.canvas.addEventListener('mousedown', this.startDrawing.bind(this));
        this.canvas.addEventListener('mousemove', this.draw.bind(this));
        this.canvas.addEventListener('mouseup', this.stopDrawing.bind(this));
        
        document.addEventListener('keydown', (e) => {
            if (e.ctrlKey && e.key === 'z') this.undo();
            if (e.ctrlKey && e.key === 'y') this.redo();
        });
    }
    
    startDrawing(e) {
        this.isDrawing = true;
        this.ctx.beginPath();
        this.ctx.moveTo(e.clientX - this.canvas.offsetLeft, 
                       e.clientY - this.canvas.offsetTop);
    }
    
    draw(e) {
        if (!this.isDrawing) return;
        
        const action = {
            type: 'draw',
            x: e.clientX - this.canvas.offsetLeft,
            y: e.clientY - this.canvas.offsetTop,
            color: this.color,
            size: this.brushSize
        };
        
        this.drawAction(action);
        this.actions.push(action);
        this.ws.send(JSON.stringify(action));
    }
    
    drawAction(action) {
        this.ctx.lineTo(action.x, action.y);
        this.ctx.strokeStyle = action.color;
        this.ctx.lineWidth = action.size;
        this.ctx.stroke();
    }
    
    undo() {
        if (this.actions.length === 0) return;
        
        this.redoStack.push(this.actions.pop());
        this.redrawCanvas();
    }
    
    redrawCanvas() {
        this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);
        this.actions.forEach(action => this.drawAction(action));
    }
}
class TaskManager {
    constructor() {
        this.tasks = new Map();
        this.categories = new Set();
        this.subscribers = new Set();
    }

    addTask(task) {
        task.id = this.generateId();
        task.createdAt = new Date();
        task.status = 'pending';

        this.tasks.set(task.id, task);
        if (task.category) this.categories.add(task.category);

        this.notifySubscribers('taskAdded', task);
        this.saveToLocalStorage();
    }

    updateTaskStatus(taskId, newStatus) {
        const task = this.tasks.get(taskId);
        if (!task) return;

        task.status = newStatus;
        task.updatedAt = new Date();

        if (newStatus === 'completed') {
            task.completedAt = new Date();
        }

        this.notifySubscribers('taskUpdated', task);
        this.saveToLocalStorage();
    }

    generateAnalytics() {
        const analytics = {
            totalTasks: this.tasks.size,
            completedTasks: 0,
            categoryBreakdown: {},
            averageCompletionTime: 0
        };

        let totalCompletionTime = 0;
        let completedCount = 0;

        this.tasks.forEach(task => {
            // Category breakdown
            if (task.category) {
                analytics.categoryBreakdown[task.category] =
                    (analytics.categoryBreakdown[task.category] || 0) + 1;
            }

            // Completion statistics
            if (task.status === 'completed') {
                analytics.completedTasks++;
                totalCompletionTime += task.completedAt - task.createdAt;
                completedCount++;
            }
        });

        if (completedCount > 0) {
            analytics.averageCompletionTime = totalCompletionTime / completedCount;
        }

        return analytics;
    }

    subscribe(callback) {
        this.subscribers.add(callback);
        return () => this.subscribers.delete(callback);
    }

    notifySubscribers(event, data) {
        this.subscribers.forEach(callback => callback(event, data));
    }

    saveToLocalStorage() {
        localStorage.setItem('tasks',
            JSON.stringify(Array.from(this.tasks.entries())));
    }

    loadFromLocalStorage() {
        const saved = localStorage.getItem('tasks');
        if (saved) {
            this.tasks = new Map(JSON.parse(saved));
            this.tasks.forEach(task => {
                if (task.category) this.categories.add(task.category);
            });
        }
    }
}

// Usage example with UI components
class TaskUI {
    constructor(taskManager) {
        this.taskManager = taskManager;
        this.setupEventListeners();
        this.renderDashboard();

        // Subscribe to task updates
        this.taskManager.subscribe((event, data) => {
            this.updateUI(event, data);
        });
    }

    setupEventListeners() {
        document.getElementById('addTask').addEventListener('submit', (e) => {
            e.preventDefault();
            const taskData = new FormData(e.target);
            this.taskManager.addTask({
                title: taskData.get('title'),
                category: taskData.get('category'),
                priority: taskData.get('priority')
            });
        });
    }

    updateUI(event, data) {
        // Update task list and analytics display
        this.renderTaskList();
        this.renderAnalytics();
    }
}
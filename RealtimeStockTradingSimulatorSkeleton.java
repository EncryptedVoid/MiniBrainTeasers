import java.util.concurrent.*;
import java.util.*;

class Stock {
    private String symbol;
    private double price;
    private final Object lock = new Object();

    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public void updatePrice(double newPrice) {
        synchronized (lock) {
            this.price = newPrice;
            notifyObservers();
        }
    }
}

class TradingAccount {
    private double balance;
    private Map<String, Integer> portfolio = new HashMap<>();

    public void buyStock(Stock stock, int quantity) {
        // Implementation for buying stocks
    }

    public void sellStock(Stock stock, int quantity) {
        // Implementation for selling stocks
    }

    public double calculateNetWorth(Map<String, Double> currentPrices) {
        return portfolio.entrySet().stream()
                .mapToDouble(entry -> entry.getValue() * currentPrices.get(entry.getKey()))
                .sum() + balance;
    }
}

class MarketSimulator {
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Map<String, Stock> stocks = new ConcurrentHashMap<>();

    public void startSimulation() {
        scheduler.scheduleAtFixedRate(() -> {
            stocks.values().forEach(stock -> {
                double priceChange = (Math.random() - 0.5) * 2; // Random price movement
                // Update stock price
            });
        }, 0, 1, TimeUnit.SECONDS);
    }
}
package src.util;

public class Logger {
    private static Logger instance = null;
    private boolean isActive = false;

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void print(String message) {
        if (isActive) 
            System.out.println(message);
    }
}

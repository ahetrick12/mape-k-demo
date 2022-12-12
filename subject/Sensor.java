package subject;

public interface Sensor {
    public void register(Component component);
    public void deregister(Component component);
    public void notify(int num);
}

package src.subject;

import src.mapek.Listener;

public interface Sensor {
    public void register(Listener component);
    public void deregister(Listener component);
    public void notify(int num);
}

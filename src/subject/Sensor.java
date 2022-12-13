package src.subject;

import src.mapek.Listener;

/*
 * Subject interface in observer pattern, used on objects that can be observed to see changes in some a value(s)
 */
public interface Sensor {
    public void register(Listener component);
    public void deregister(Listener component);
    public void notify(int num);
}

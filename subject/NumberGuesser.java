package subject;
import java.util.*;

import util.Bounds;

public class NumberGuesser implements Sensor {

    private List<Component> listeningComponents = new ArrayList<Component>();

    public void run() throws InterruptedException {
        Bounds bounds = new Bounds(0, 10000);
        Random rand = new Random();

        while (true)
        {
            int number = rand.nextInt(bounds.getUpper() - bounds.getLower()) + bounds.getLower();
            notify(number);

            Thread.sleep(1000);
        }
    }

    @Override
    public void register(Component component) {
        listeningComponents.add(component);
    }

    @Override
    public void deregister(Component component) {
        listeningComponents.remove(component);
    }

    @Override
    public void notify(int num) {
        for (Component component: listeningComponents) {
            component.update(num);
        }
    }
}

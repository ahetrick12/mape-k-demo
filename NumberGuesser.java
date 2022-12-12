import java.util.Random;

public class NumberGuesser {

    public void run() throws InterruptedException {
        Bounds bounds = new Bounds(0, 10000);
        Random rand = new Random();

        while (true)
        {
            int number = rand.nextInt(bounds.getUpper() - bounds.getLower()) + bounds.getLower();
            // Notify observers

            Thread.sleep(1000);
        }
    }

    
}

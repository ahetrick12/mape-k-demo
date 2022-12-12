package src.mapek;

import src.util.Bounds;
import src.subject.NumberGuesser;

public class Execute implements Component<Bounds> {

    private NumberGuesser adaptee;

    @Override
    public void execute(Bounds newBounds) {
        if (newBounds == null) {
            System.out.println("Number found");
            return;
        }

        Knowledge.getInstance().updateBounds(newBounds);
        System.out.println("New bounds: " + newBounds);

        
    } 
}

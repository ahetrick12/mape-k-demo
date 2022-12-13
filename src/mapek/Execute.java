package src.mapek;

import src.util.Bounds;
import src.subject.NumberGuesser;

public class Execute implements Component<Bounds> {

    private NumberGuesser adaptee;

    public Execute(NumberGuesser adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void execute(Bounds newBounds) {
        if (newBounds == null) {
            adaptee.notifyEndGame();
            return;
        }

        Knowledge.getInstance().updateBounds(newBounds);
        adaptee.setBounds(newBounds);
    } 
}

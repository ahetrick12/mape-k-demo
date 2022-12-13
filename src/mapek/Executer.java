package src.mapek;

import src.util.Bounds;
import src.subject.NumberGuesser;

public class Executer implements Component<Bounds> {

    private NumberGuesser game;

    public Executer(NumberGuesser game) {
        this.game = game;
    }

    @Override
    public void execute(Bounds newBounds) {
        if (newBounds == null) {
            game.notifyEndGame();
            System.out.println("\t> EXECUTER: Notify the end of game");
            return;
        }

        Knowledge.getInstance().updateBounds(newBounds);
        game.setBounds(newBounds);

        System.out.println("\t> EXECUTER: Alter the system to have new bounds of " + newBounds);
    } 
}

package src.mapek;

import src.util.Bounds;
import src.util.Logger;
import src.subject.NumberGuesser;

/*
 * Carries out action(s) that the planner decides to do
 */
public class Executer implements Component<Bounds> {

    private NumberGuesser game;
    private Logger logger = Logger.getInstance();

    public Executer(NumberGuesser game) {
        this.game = game;
    }

    @Override
    public void execute(Bounds newBounds) {
        if (newBounds == null) {
            // If null was passed in, target was reached and game has ended
            game.notifyEndGame();
            logger.print("\t> EXECUTER: Notify the end of game");
            return;
        }

        Knowledge.getInstance().updateBounds(newBounds);
        game.setBounds(newBounds);

        logger.print("\t> EXECUTER: Alter the system to have new bounds of " + newBounds);
    } 
}

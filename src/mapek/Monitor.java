package src.mapek;

import src.util.Logger;

/*
 * Gathers data from the game, stores it in the shared knowledge, and sends it to the analyzer
 */
public class Monitor implements Listener, Component<Integer> {

    private Analyzer analyzer;
    private Logger logger = Logger.getInstance();

    public Monitor(Analyzer analyze) {
        this.analyzer = analyze;
    }

    @Override
    public void update(int num) {
        execute(num);
    } 

    @Override
    public void execute(Integer guess) {
        logger.print("\t> MONITOR: Recieved guess of " + guess);

        Knowledge.getInstance().updateGuess(guess);
        analyzer.execute(guess);
    }
}

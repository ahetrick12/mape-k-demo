package src.mapek;

public class Monitor implements Listener, Component<Integer> {

    private Analyzer analyzer;

    public Monitor(Analyzer analyze) {
        this.analyzer = analyze;
    }

    @Override
    public void update(int num) {
        execute(num);
    } 

    @Override
    public void execute(Integer guess) {
        System.out.println("\t> MONITOR: Recieved guess of " + guess);

        Knowledge.getInstance().updateGuess(guess);
        analyzer.execute(guess);
    }
}

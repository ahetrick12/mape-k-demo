package src.mapek;

public class Monitor implements Listener, Component<Integer> {

    private Analyze analyze;

    public Monitor(Analyze analyze) {
        this.analyze = analyze;
    }

    @Override
    public void update(int num) {
        execute(num);
    } 

    @Override
    public void execute(Integer guess) {
        Knowledge.getInstance().updateGuess(guess);
        analyze.execute(guess);
    }
}

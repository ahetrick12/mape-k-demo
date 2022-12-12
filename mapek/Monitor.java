package mapek;

import subject.Component;

public class Monitor implements Component {

    private Analyze analyze;

    public Monitor(Analyze analyze) {
        this.analyze = analyze;
    }

    @Override
    public void update(int num) {
        Knowledge.getInstance().updateGuess(num);
        analyze.update(num);
    } 
}

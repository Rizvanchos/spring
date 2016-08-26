package perform;

import stage.instrument.Instrument;

public abstract class VirtuosoMusician implements Performable {

    @Override
    public void perform() {
        System.out.print("Playing: ");
        getInstrument().play();
    }

    public abstract Instrument getInstrument();
}

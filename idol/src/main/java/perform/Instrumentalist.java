package perform;

import stage.instrument.Instrument;

public class Instrumentalist implements Performable {

    private String song;
    private Instrument instrument;

    @Override
    public void perform() {
        System.out.println("Playing song: " + song);
        instrument.play();
    }

    public String getSong() {
        return song;
    }

    public void setSong(final String song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(final Instrument instrument) {
        this.instrument = instrument;
    }

}

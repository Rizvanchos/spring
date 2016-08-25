package perform;

import stage.instrument.Instrument;

public class Instrumentalist implements Perfomable {

    private String song;
    private Instrument instrument;

    @Override
    public void perfom() {
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

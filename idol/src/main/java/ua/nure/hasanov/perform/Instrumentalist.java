package ua.nure.hasanov.perform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.nure.hasanov.stage.instrument.Instrument;

@Component
@Scope("prototype")
public class Instrumentalist implements Performable {

    @Autowired
    @Qualifier("guitar")
    private Instrument instrument;

    private String song;

    @Override
    public void perform() {
        System.out.println("Playing song: " + song);
        instrument.play();
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

}

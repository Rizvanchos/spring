package ua.nure.hasanov.perform;

import org.springframework.stereotype.Component;
import ua.nure.hasanov.stage.instrument.Instrument;

@Component
public abstract class VirtuosoMusician implements Performable {

    @Override
    public void perform() {
        System.out.print("Playing: ");
        getInstrument().play();
    }

    public abstract Instrument getInstrument();
}

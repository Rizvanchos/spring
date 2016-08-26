package ua.nure.hasanov.stage.instrument;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument {

    @Override
    public void play() {
        System.out.println("Guitar playing...");
    }
}

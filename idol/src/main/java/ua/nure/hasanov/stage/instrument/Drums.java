package ua.nure.hasanov.stage.instrument;

import org.springframework.stereotype.Component;

@Component
public class Drums implements Instrument {

    @Override
    public void play() {
        System.out.println("Playing drums...");
    }
}

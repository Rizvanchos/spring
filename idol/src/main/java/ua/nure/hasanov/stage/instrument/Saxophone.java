package ua.nure.hasanov.stage.instrument;

import org.springframework.stereotype.Component;

@Component
public class Saxophone implements Instrument {

    @Override
    public void play() {
        System.out.println("Saxophone: Too Too Too");
    }
}

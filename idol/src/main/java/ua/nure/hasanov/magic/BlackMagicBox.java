package ua.nure.hasanov.magic;

import org.springframework.stereotype.Component;

@Component
public class BlackMagicBox implements MagicBox {

    @Override
    public String getContent() {
        return "Black ua.nure.hasanov.magic box!";
    }
}

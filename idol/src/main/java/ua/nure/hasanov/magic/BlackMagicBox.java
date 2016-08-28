package ua.nure.hasanov.magic;

import org.springframework.stereotype.Component;

@Component("magicBox")
public class BlackMagicBox implements MagicBox {

    @Override
    public String getContent() {
        return "Black magic box!";
    }
}

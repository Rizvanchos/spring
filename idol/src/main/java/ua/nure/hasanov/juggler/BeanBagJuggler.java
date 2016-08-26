package ua.nure.hasanov.juggler;

import org.springframework.stereotype.Component;
import ua.nure.hasanov.perform.Performable;

@Component
public class BeanBagJuggler implements Performable {
    private int beanBags = 3;

    public BeanBagJuggler() {
    }

    public BeanBagJuggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");
    }
}

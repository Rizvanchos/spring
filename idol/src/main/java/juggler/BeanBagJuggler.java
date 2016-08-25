package juggler;

import perform.Perfomable;

public class BeanBagJuggler implements Perfomable {
    private int beanBags = 3;

    public BeanBagJuggler() {
    }

    public BeanBagJuggler(final int beanBags) {
        this.beanBags = beanBags;
    }

    public void perfom() {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");
    }
}

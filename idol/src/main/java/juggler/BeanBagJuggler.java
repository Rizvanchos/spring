package juggler;

import perform.Performable;

public class BeanBagJuggler implements Performable {
    private int beanBags = 3;

    public BeanBagJuggler() {
    }

    public BeanBagJuggler(final int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");
    }
}

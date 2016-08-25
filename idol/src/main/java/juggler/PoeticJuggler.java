package juggler;

import poem.Poem;

public class PoeticJuggler extends BeanBagJuggler {
    private final Poem poem;

    public PoeticJuggler(final Poem poem) {
        this.poem = poem;
    }

    public PoeticJuggler(final int beanBags, final Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public void perfom() {
        super.perfom();
        System.out.println("While reciting...");
        poem.recite();
    }
}

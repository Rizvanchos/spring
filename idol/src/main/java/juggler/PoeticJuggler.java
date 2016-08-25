package juggler;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import poem.Poem;

public class PoeticJuggler extends BeanBagJuggler implements InitializingBean, DisposableBean {
    private final Poem poem;

    public PoeticJuggler(final Poem poem) {
        this.poem = poem;
    }

    public PoeticJuggler(final int beanBags, final Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("PoeticJuggler.afterPropertiesSet");
    }

    @Override
    public void perfom() {
        super.perfom();
        System.out.println("While reciting...");
        poem.recite();
    }

    public void destroy() throws Exception {
        System.out.println("PoeticJuggler.destroy");
    }

}

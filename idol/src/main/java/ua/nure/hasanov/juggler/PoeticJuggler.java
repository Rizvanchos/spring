package ua.nure.hasanov.juggler;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.hasanov.poem.Poem;

@Component
public class PoeticJuggler extends BeanBagJuggler implements InitializingBean, DisposableBean {

    @Autowired
    private Poem poem;

    public PoeticJuggler() {
    }

    public PoeticJuggler(Poem poem) {
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PoeticJuggler.afterPropertiesSet");
    }

    @Override
    public void perform() {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PoeticJuggler.destroy");
    }

}

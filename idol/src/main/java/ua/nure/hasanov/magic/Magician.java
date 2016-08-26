package ua.nure.hasanov.magic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ua.nure.hasanov.perform.Performable;

@Component
public class Magician implements Performable, BeanPostProcessor {

    @Autowired
    private MagicBox magicBox;

    public void setMagicBox(MagicBox magicBox) {
        this.magicBox = magicBox;
    }

    @Override
    public void perform() {
        System.out.println("Prepare for ua.nure.hasanov.magic ua.nure.hasanov.magic: " + magicBox.getContent());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

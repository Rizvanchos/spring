package ua.nure.hasanov.magic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ua.nure.hasanov.perform.Performable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Component
public class Magician implements Performable, MindReader, BeanPostProcessor, Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Integer id;

    @OneToOne(targetEntity = BlackMagicBox.class, cascade = CascadeType.ALL)
    private MagicBox magicBox;

    private String thoughts;

    public void setMagicBox(MagicBox magicBox) {
        this.magicBox = magicBox;
    }

    @Override
    public void perform() {
        System.out.println("Prepare for magic: " + magicBox.getContent());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer’s thoughts");
        this.thoughts = thoughts;
    }

    public MagicBox getMagicBox() {
        return magicBox;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

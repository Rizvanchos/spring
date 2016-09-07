package ua.nure.hasanov.magic;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "magicBox")
@Component("magicBox")
public class BlackMagicBox implements MagicBox {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Integer id;

    @Column
    private Integer weight;

    @OneToOne(targetEntity = Magician.class)
    @PrimaryKeyJoinColumn
    private Magician magician;

    @Override
    public String getContent() {
        return "Black magic box!";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Magician getMagician() {
        return magician;
    }

    public void setMagician(Magician magician) {
        this.magician = magician;
    }
}

package ua.nure.hasanov.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class DomainEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Type(type = "uuid-binary")
    @Column(length = 32, unique = true, nullable = false)
    private UUID domainId = UUID.randomUUID();

    @Override
    public int hashCode() {
        return domainId.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        DomainEntity otherDomainEntity = (DomainEntity) o;
        return domainId.equals(otherDomainEntity.getDomainId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getDomainId() {
        return domainId;
    }

    public void setDomainId(UUID domainId) {
        this.domainId = domainId;
    }
}
package ua.nure.hasanov.repository;

import ua.nure.hasanov.entity.DomainEntity;

public interface Repository<T extends DomainEntity> {
    long count();

    T load(int id);

    Iterable<T> loadAll();

    void add(T t);

    void delete(T t);

    void commit();
}

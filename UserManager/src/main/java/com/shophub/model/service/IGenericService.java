package com.shophub.model.service;

import java.util.List;

public interface IGenericService<T, E> {

    List<T> findAll();

    T find(final Long id);

    T save(final T t);

    void remove(final Long id);

    T update(final T t);

    List<T> saveAll(final List<T> t);

    E convertToEntity(T t);

    T convertToDto(E e);
}

package com.shophub.model.service;

public interface ILoginService<T, E> extends IGenericService<T, E>{

    T findByEmail(final String email);
    boolean userExist(String email);
}

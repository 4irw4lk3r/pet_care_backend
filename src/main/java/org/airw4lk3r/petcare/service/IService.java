package org.airw4lk3r.petcare.service;

import java.util.List;

/**
 * IService
 */
public interface IService<T, ID>{

    public List<T> getAll();
    public T getById(final ID id);
    public void createOrModify(final T t);

}
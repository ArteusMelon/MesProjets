package com.example.EDLB.services.postgre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IServicePostgre<T>{

    List<T> getAll();
    Optional<T> getById(UUID id);
    void delete(UUID id);
    T save(T t);
}
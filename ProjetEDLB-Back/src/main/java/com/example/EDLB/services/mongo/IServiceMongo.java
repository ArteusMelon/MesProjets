package com.example.EDLB.services.mongo;

import org.bson.types.ObjectId;
import java.util.List;
import java.util.Optional;

public interface IServiceMongo<T>{
    List<T> getAll();
    Optional<T> getById(ObjectId id);
    void delete(ObjectId id);
    T save(T t);
}
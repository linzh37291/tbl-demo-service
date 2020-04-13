package com.ligeit.demo.biz.domain.repository;

public interface Repository<T> {
     void add(T model);
     T get(String id);
     void modify(T model);
}

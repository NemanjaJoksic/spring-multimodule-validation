package org.joksin.multimodule.validation.core.repository;

import org.joksin.multimodule.validation.core.model.GenericEntity;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class GenericRepository<T extends GenericEntity> implements InitializingBean {

    private final Map<Integer, T> dataMap = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public void afterPropertiesSet() throws Exception {
        loadInitData();
    }

    protected void loadInitData() {}

    public T add(T data) {
        data.setId(nextId.getAndAdd(1));
        dataMap.put(data.getId(), data);
        return data;
    }

    public T findById(Integer id) {
        return dataMap.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(dataMap.values());
    }

    public boolean existsById(Integer id) {
        return dataMap.containsKey(id);
    }

}

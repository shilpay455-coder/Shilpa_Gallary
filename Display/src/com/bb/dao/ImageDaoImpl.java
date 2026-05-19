package com.bb.dao;

import com.bb.model.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * In-memory implementation of ImageDao. Useful for demos and tests.
 */
public class ImageDaoImpl implements ImageDao {
    private final Map<Integer, Image> store = new ConcurrentHashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public Image add(Image image) {
        int id = idGenerator.incrementAndGet();
        image.setId(id);
        store.put(id, image);
        return image;
    }

    @Override
    public Image getById(int id) {
        return store.get(id);
    }

    @Override
    public List<Image> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(store.values()));
    }

    @Override
    public Image update(Image image) {
        int id = image.getId();
        if (!store.containsKey(id)) {
            return null;
        }
        store.put(id, image);
        return image;
    }

    @Override
    public boolean delete(int id) {
        return store.remove(id) != null;
    }
}

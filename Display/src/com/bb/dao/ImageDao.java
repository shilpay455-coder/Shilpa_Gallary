package com.bb.dao;

import com.bb.model.Image;
import java.util.List;

/**
 * Data access operations for Image objects.
 */
public interface ImageDao {
    Image add(Image image);
    Image getById(int id);
    List<Image> getAll();
    Image update(Image image);
    boolean delete(int id);
}

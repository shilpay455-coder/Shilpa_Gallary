package com.bb.controller;

import com.bb.dao.ImageDao;
import com.bb.model.Image;

import java.util.List;

/**
 * Controller that coordinates between UI/clients and the ImageDao.
 */
public class ImageController {
    private final ImageDao dao;

    public ImageController(ImageDao dao) {
        this.dao = dao;
    }

    public Image createImage(String name, String path, String description) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name is required");
        }
        Image img = new Image();
        img.setName(name.trim());
        img.setPath(path != null ? path.trim() : null);
        img.setDescription(description);
        return dao.add(img);
    }

    public Image getImage(int id) {
        return dao.getById(id);
    }

    public List<Image> listImages() {
        return dao.getAll();
    }

    public Image updateImage(Image image) {
        if (image == null || image.getId() <= 0) {
            throw new IllegalArgumentException("image with valid id is required");
        }
        return dao.update(image);
    }

    public boolean deleteImage(int id) {
        return dao.delete(id);
    }
}

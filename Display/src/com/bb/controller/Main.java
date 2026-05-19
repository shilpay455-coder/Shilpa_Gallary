package com.bb.controller;

import com.bb.dao.ImageDao;
import com.bb.dao.ImageDaoImpl;
import com.bb.model.Image;

import java.util.List;

/**
 * Small demo runner for the gallery classes.
 */
public class Main {
    public static void main(String[] args) {
        ImageDao dao = new ImageDaoImpl();
        ImageController controller = new ImageController(dao);

        System.out.println("Creating images...");
        Image a = controller.createImage("Sunset", "images/sunset.jpg", "A beautiful sunset.");
        Image b = controller.createImage("Mountain", "images/mountain.jpg", "Snowy mountain peak.");

        System.out.println("Listing images after creation:");
        print(controller.listImages());

        System.out.println("Updating image id=1 name -> 'Sunset Over Sea'");
        a.setName("Sunset Over Sea");
        controller.updateImage(a);

        System.out.println("Get image id=1:");
        System.out.println(controller.getImage(1));

        System.out.println("Deleting image id=2");
        controller.deleteImage(2);

        System.out.println("Final list:");
        print(controller.listImages());
    }

    private static void print(List<Image> list) {
        for (Image i : list) {
            System.out.println(i);
        }
    }
}

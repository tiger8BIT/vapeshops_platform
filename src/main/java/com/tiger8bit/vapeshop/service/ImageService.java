package com.tiger8bit.vapeshop.service;

import com.tiger8bit.vapeshop.model.Image;

import java.util.List;

public interface ImageService {
    List<Image> findAll();
    Image save(Image value);
    void deleteByID(int id);
    Image findByID(int id);
    Image addImage(String p_url);
}

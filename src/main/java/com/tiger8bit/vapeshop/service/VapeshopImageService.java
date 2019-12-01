package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.VapeshopImage;
import java.util.List;

public interface VapeshopImageService {
    List<VapeshopImage> findAll();
    VapeshopImage save(VapeshopImage value);
    void deleteByID(long id);
    VapeshopImage findByID(long id);
}

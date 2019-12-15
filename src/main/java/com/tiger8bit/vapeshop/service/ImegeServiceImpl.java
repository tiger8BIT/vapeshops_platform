package com.tiger8bit.vapeshop.service;

import com.tiger8bit.vapeshop.model.Image;
import com.tiger8bit.vapeshop.repository.ImageProcedures;
import com.tiger8bit.vapeshop.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImegeServiceImpl implements ImageService {
    @Autowired
    private ImageRepository repository;

    @Override
    public List<Image> findAll() {
        return (List<Image>) repository.findAll();
    }

    @Override
    public Image save(Image value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.existsById(id);
    }

    @Override
    public Image findByID(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Image addImage(String p_url) {
        return repository.addImage(p_url);
    }
}

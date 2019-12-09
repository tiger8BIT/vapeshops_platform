package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.BlendRatio;
import java.util.List;

public interface BlendRatioService {
    List<BlendRatio> findAll();
    BlendRatio save(BlendRatio value);
    void deleteByID(int id);
    BlendRatio findByID(int id);
}

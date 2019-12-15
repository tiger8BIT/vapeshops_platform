package com.tiger8bit.vapeshop.repository;

import com.tiger8bit.vapeshop.model.Image;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class ImageRepositoryImpl implements ImageProcedures {

    @PersistenceContext
    private EntityManager em;
    @Override
    public Image addImage(String p_url) {
        StoredProcedureQuery addImageProcedure =
                em.createNamedStoredProcedureQuery("addImage");
        addImageProcedure.setParameter("p_url", p_url);
        addImageProcedure.execute();
        return (Image) addImageProcedure.getSingleResult();
    }
}

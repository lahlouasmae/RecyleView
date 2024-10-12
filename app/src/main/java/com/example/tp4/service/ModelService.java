package com.example.tp4.service;

import com.example.tp4.beans.Model;
import com.example.tp4.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class ModelService implements IDao<Model> {
    private List<Model> models;
    private static ModelService instance;
    private ModelService() {
        this.models = new ArrayList<>();
    }
    public static ModelService getInstance() {
        if(instance == null)
            instance = new ModelService();
        return instance;
    }
    @Override
    public boolean create(Model o) {
        return models.add(o);
    }
    @Override
    public boolean update(Model o) {
        for(Model m : models){
            if(m.getStar() == o.getId()){

                m.setImg(o.getImg());
                m.setName(o.getName());
                m.setStar(o.getStar());
            }
        }
        return true;
    }
    @Override
    public boolean delete(Model o) {
        return models.remove(o);
    }
    @Override
    public Model  findById(int id) {
        for(Model  m : models){
            if(m.getId() == id)
                return m;
        }
        return null;
    }
    @Override
    public List<Model> findAll() {
        return models;
    }
}


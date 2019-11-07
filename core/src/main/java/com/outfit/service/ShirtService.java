package com.outfit.service;

import com.outfit.domain.Shirt;
import com.outfit.repo.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShirtService {
    @Autowired
    private ShirtRepository repo;

    public List<Shirt> listAll() {
        return repo.findAll();
    }

    public void save(Shirt shirt) {
        repo.save(shirt);
    }

    public Shirt get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<String> getOwnersShirt(int id) {
        return repo.getOwnersShirt(id);
    }

    public List<Object[]> getShirtDetails(int id) {
        return repo.getShirtDetails(id);
    }
}

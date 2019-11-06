package com.outfit.service;

import com.outfit.domain.Jacket;
import com.outfit.repo.JacketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JacketService {
    @Autowired
    private JacketRepository repo;

    public List<Jacket> listAll() {
        return repo.findAll();
    }

    public void save(Jacket jacket) {
        repo.save(jacket);
    }

    public Jacket get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<String> getOwnersJacket(int id) {
        return repo.getOwnersJacket(id);
    }
}

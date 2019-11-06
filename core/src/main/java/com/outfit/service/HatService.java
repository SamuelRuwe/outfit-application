package com.outfit.service;

import com.outfit.domain.Hat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.outfit.repo.HatRepository;

import java.util.List;

@Service
public class HatService {
    @Autowired
    private HatRepository repo;

    public List<Hat> listAll() {
        return repo.findAll();
    }

    public void save(Hat hat) {
        repo.save(hat);
    }

    public Hat get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<String> getOwnersHats(int id) {
        return repo.getOwnersHats(id);
    }
}

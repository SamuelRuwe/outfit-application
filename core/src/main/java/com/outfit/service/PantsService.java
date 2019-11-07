package com.outfit.service;

import com.outfit.domain.Pants;
import com.outfit.repo.PantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantsService {
    @Autowired
    private PantsRepository repo;

    public List<Pants> listAll() {
        return repo.findAll();
    }

    public void save(Pants pants) {
        repo.save(pants);
    }

    public Pants get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<String> getOwnersPants(int id) {
        return repo.getOwnersPants(id);
    }

    public List<Object[]> getPantsDetails(int id) {
        return repo.getPantsDetails(id);
    }
}

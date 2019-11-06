package com.outfit.repo;

import com.outfit.domain.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShirtRepository extends JpaRepository<Shirt, Integer> {

}

package com.outfit.repo;

import com.outfit.domain.Pants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PantsRepository extends JpaRepository<Pants, Integer> {

}

package com.outfit.repo;

import com.outfit.domain.Pants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PantsRepository extends JpaRepository<Pants, Integer> {

    @Query(value = "SELECT color AS color FROM Person JOIN Pants WHERE Person.id = Pants.ownerid AND Person.id = ?1 AND Pants.clean = 1",
            nativeQuery = true)
    public List<String> getOwnersPants(int id);

}

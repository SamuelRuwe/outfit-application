package com.outfit.repo;

import com.outfit.domain.Jacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JacketRepository extends JpaRepository<Jacket, Integer> {

    @Query(value = "SELECT color AS color FROM Person JOIN Jacket WHERE Person.id = Jacket.ownerid AND Person.id = ?1 AND Jacket.clean = 1",
            nativeQuery = true)
    public List<String> getOwnersJacket(int id);

}

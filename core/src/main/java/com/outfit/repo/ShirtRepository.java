package com.outfit.repo;

import com.outfit.domain.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShirtRepository extends JpaRepository<Shirt, Integer> {

    @Query(value = "SELECT color AS color FROM Person JOIN Shirt WHERE Person.id = Shirt.ownerid AND Person.id = ?1 AND Shirt.clean = 1",
            nativeQuery = true)
    public List<String> getOwnersShirt(int id);

    @Query(value = "SELECT username AS username, color AS color FROM Person JOIN Shirt WHERE Person.id = Shirt.ownerid AND Person.id = ?1 AND Shirt.clean = 1",
            nativeQuery = true)
    public List<Object[]> getShirtDetails(int id);

    // make one for long sleeves too? also gotta get temperatures in here eventually

}

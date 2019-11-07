package com.outfit.repo;

import com.outfit.domain.Hat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HatRepository extends JpaRepository<Hat, Integer> {

    @Query(value = "SELECT color AS color FROM Person JOIN Hat WHERE Person.id = Hat.ownerid AND Person.id = ?1 AND Hat.clean = 1",
            nativeQuery = true)
    public List<String> getOwnersHats(int id);

    @Query(value = "SELECT username AS username, color AS color FROM Person JOIN Hat WHERE Person.id = Hat.ownerid AND Person.id = ?1 AND Hat.clean = 1",
            nativeQuery = true)
    public List<Object[]> getHatDetails(int id);
}

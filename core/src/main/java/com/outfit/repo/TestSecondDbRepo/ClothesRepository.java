package com.outfit.repo.TestSecondDbRepo;

import com.outfit.domain.TestSecondDbDomain.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClothesRepository extends JpaRepository<Clothes, Integer> {


    @Query(value = "SELECT id AS id, ownerid AS ownerid, type AS type, color AS color, " +
            "formal AS formal, mintemp AS mintemp, maxtemp AS maxtemp, lastworn AS lastworn, clean AS clean " +
            "FROM Clothes WHERE ownerid = ?1",
            nativeQuery = true)
    public List<Clothes> getOwnedClothes(int id);
}

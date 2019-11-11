package com.outfit.repo;

import com.outfit.domain.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonsRepository extends JpaRepository<Persons, Integer> {

    @Query(value = "SELECT id AS id, username AS username, password AS password, " +
            "firstname AS firstname, lastname AS lastname, email AS email " +
            "FROM Persons",
            nativeQuery = true)
    public Persons getPersonsDetails(int id);
}

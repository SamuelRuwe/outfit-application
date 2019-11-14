package com.outfit.repo;

import com.outfit.domain.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonsRepository extends JpaRepository<Persons, Integer> {

    @Query(value = "SELECT id AS id, username AS username, password AS password, " +
            "firstname AS firstname, lastname AS lastname, email AS email " + "zipcode AS zipcode "
            + "countrycode AS countrycode " + "FROM Persons",
            nativeQuery = true)
    public Persons getPersonsDetails(int id);

    @Query(value = "Select * from Persons WHERE email = ?1",
    nativeQuery = true)
    public Persons getByEmail(String email);
}

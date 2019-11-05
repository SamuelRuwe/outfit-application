package ruwe.samruwe.service;

import outfitcore.com.domain.Hat;
import outfitcore.com.domain.Person;

import java.util.List;

public interface DataService {

    int currentTemp();

    boolean isRaining();

    List<Person> listAllPeople();

    void save(Person person);

    Person getPerson(int id);

    void deletePerson(int id);

    List<Hat> listAllHat();

    void save(Hat hat);

    Hat getHat(int id);

    void deleteHat(int id);
}

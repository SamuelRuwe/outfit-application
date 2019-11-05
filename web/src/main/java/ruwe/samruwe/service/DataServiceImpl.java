package ruwe.samruwe.service;

import outfitcore.com.domain.Hat;
import outfitcore.com.domain.Person;
import outfitcore.com.message.MessageGenerator;
import outfitcore.com.service.HatService;
import outfitcore.com.service.PersonService;
import outfitcore.com.weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    // == fields ==
    private Weather weather;
    private MessageGenerator messageGenerator;
    private PersonService personService;
    private HatService hatService;

    // == constructors ==
    @Autowired
    public DataServiceImpl(Weather weather, MessageGenerator messageGenerator, PersonService personService, HatService hatService) {
        this.weather = weather;
        this.messageGenerator = messageGenerator;
        this.personService = personService;
        this.hatService = hatService;
    }
    // == init ==


    // == public methods ==
    @Override
    public int currentTemp() {
        return weather.getCurrentTemp();
    }

    @Override
    public boolean isRaining() {
        return weather.isRaining();
    }

    @Override
    public List<Person> listAllPeople() {
        List<Person> list = new ArrayList<Person>();
        list = personService.listAll();
        return list;
    }

    @Override
    public void save(Person person) {
        personService.save(person);
    }

    @Override
    public Person getPerson(int id) {
        return personService.get(id);
    }

    @Override
    public void deletePerson(int id) {
        personService.delete(id);
    }

    @Override
    public List<Hat> listAllHat() {
        ArrayList<Hat> list = new ArrayList<Hat>();
        list = (ArrayList)hatService.listAll();
        return list;
    }

    @Override
    public void save(Hat hat) {
        hatService.save(hat);
    }

    @Override
    public Hat getHat(int id) {
        return hatService.get(id);
    }

    @Override
    public void deleteHat(int id) {
        hatService.delete(id);
    }
}

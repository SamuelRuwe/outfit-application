package ruwe.samruwe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import outfitcore.com.domain.Person;
import ruwe.samruwe.service.DataService;

import java.util.List;

@Controller
public class WebController {

    // == fields ==
    private DataService dataService;

    // == constructor ==
    @Autowired
    public WebController(DataService dataService) {
        this.dataService = dataService;
    }

    // == request methods ==

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Person> listPersons = dataService.listAllPeople();
        model.addAttribute("listPersons", listPersons);
        return "index";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");

        Person person = dataService.getPerson(id);
        mav.addObject("person", person);
        return mav;
    }
}

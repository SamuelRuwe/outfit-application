package ruwe.samruwe.controllers;

import ruwe.samruwe.service.DataServiceImpl;
import outfitcore.com.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private DataServiceImpl dataServiceImpl;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Person> listPersons = dataServiceImpl.listAllPeople();
        model.addAttribute("listPersons", listPersons);
        return "index";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");

        Person person = dataServiceImpl.getPerson(id);
        mav.addObject("person", person);
        return mav;
    }
}

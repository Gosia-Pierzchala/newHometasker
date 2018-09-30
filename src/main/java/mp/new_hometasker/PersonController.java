package mp.new_hometasker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersonController {
    private HomeTaskerRepository homeTaskerRepository;

    public PersonController(HomeTaskerRepository homeTaskerRepository) {
        this.homeTaskerRepository = homeTaskerRepository;
    }

    @GetMapping("/users")
    public String peopleList (Model model){
        List<Person> people = homeTaskerRepository.getPeople();
        model.addAttribute("people", people);
        return "users";
    }

    @GetMapping("/dodajosobe")
    public String showAddForm(Model model){
        model.addAttribute("person", new Person());
        return "addPerson";
    }

    @PostMapping("/dodajosobe")
    public String addPerson(Person person){
        homeTaskerRepository.addPerson(person);
        return "redirect:/users";
    }

    @GetMapping("/usunOsobe")
    public String delete(@RequestParam long id) {
        Person person = homeTaskerRepository.findPersonById(id);
        homeTaskerRepository.removePerson(person);
        return "redirect:/users";
    }

    @GetMapping("/edytujOsobe")
    public String edit(@RequestParam long id, Model model) {
        Person person = homeTaskerRepository.findPersonById(id);
        model.addAttribute("person", person);
        return "editPerson";
    }

    @PostMapping("/edytujOsobe")
    public String edit(@RequestParam Long id, Person person) {
        homeTaskerRepository.editPerson(person, id);
        return "redirect:/users";
    }

}

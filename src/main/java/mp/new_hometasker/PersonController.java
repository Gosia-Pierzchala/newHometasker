package mp.new_hometasker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("allPeople", people);
        return "users";
    }

    @GetMapping("/dodajosobe")
    public String showAddForm(Model model){
        model.addAttribute("newPerson", new Person());
        return "dodawanie_osob";
    }

    @PostMapping("/dodajosobe")
    public String addPerson(Person person){
        homeTaskerRepository.addPerson(person);
        return "users";
    }
}

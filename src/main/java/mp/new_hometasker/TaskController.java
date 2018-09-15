package mp.new_hometasker;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    private HomeTaskerRepository homeTaskerRepository;

    public TaskController(HomeTaskerRepository homeTaskerRepository) {
        this.homeTaskerRepository = homeTaskerRepository;
    }

    @GetMapping("/")
    public String taskList(Model model){
        List<Task> tasks = homeTaskerRepository.getTasks();
        model.addAttribute("allTasks", tasks);
        return "homepage";
    }

    @GetMapping("/dodaj")
    public String showAddForm(Model model){
        List<Person> people = homeTaskerRepository.getPeople();
        model.addAttribute("allPeople", people);
        model.addAttribute("newTask", new Task());
        return "dodawanie";
    }

    @PostMapping("/dodaj")
    public String addTask(Task task){
        homeTaskerRepository.addTask(task);
        return "redirect:/";
    }

    @GetMapping("/edytuj")
    public String edit(Model model, @RequestParam (value = "id", required = false, defaultValue = "1") int id){
        Task task = homeTaskerRepository.findById(id);
        model.addAttribute("task", task);
        return "edytowanie";
    }

    @PostMapping("/edytuj")
    public String editTask(Task task, Model model){
        homeTaskerRepository.addTask(task);
        List<Task> tasks = homeTaskerRepository.getTasks();
        model.addAttribute("tasks", tasks);
        return "homepage";
    }
}
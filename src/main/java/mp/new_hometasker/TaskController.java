package mp.new_hometasker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    private TaskAndPeopleRepository taskAndPeopleRepository;

    public TaskController(TaskAndPeopleRepository taskAndPeopleRepository) {
        this.taskAndPeopleRepository = taskAndPeopleRepository;
    }

    @GetMapping("/")
    public String taskList(Model model){
        List<Task> tasks = taskAndPeopleRepository.getAll();
        model.addAttribute("allTasks", tasks);
        return "homepage";
    }

    @GetMapping("/dodaj")
    public String showAddForm(Model model){
        List<Person> people = taskAndPeopleRepository.getPeople();
        model.addAttribute("allPeople", people);
        model.addAttribute("newTask", new Task());
        return "dodawanie";
    }

    @PostMapping("/dodaj")
    public String addTask(Task task){
        taskAndPeopleRepository.addTask(task);
        return "redirect:/";
    }

    @GetMapping("/edytuj")
    public String edit(Model model, @RequestParam String opis) {
        Task task = taskAndPeopleRepository.findByDescription(opis);
        model.addAttribute("task", task);
        return "edytowanie";
    }

    @PostMapping("/edytuj")
    public String editTask(Task task) {
        return "redirect:/";
    }

}
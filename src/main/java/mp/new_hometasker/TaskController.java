package mp.new_hometasker;

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
        model.addAttribute("tasks", tasks);
        return "homepage";
    }

    @GetMapping("/dodajZadanie")
    public String showAddForm(Model model){
        List<Person> people = homeTaskerRepository.getPeople();
        model.addAttribute("people", people);
        model.addAttribute("task", new Task());
        return "addTask";
    }

    @PostMapping("/dodajZadanie")
    public String addTask(Task task){
        homeTaskerRepository.addTask(task);
        return "redirect:/homepage";
    }

    @GetMapping("/usunZadanie")
    public String delete(@RequestParam long id) {
        Task task = homeTaskerRepository.findTaskById(id);
        homeTaskerRepository.removeTask(task);
        return "redirect:/";
    }

    @GetMapping("/edytujZadanie")
    public String edit(@RequestParam long id, Model model) {
        Task task = homeTaskerRepository.findTaskById(id);
        List<Person> people = homeTaskerRepository.getPeople();
        model.addAttribute("task", task);
        model.addAttribute("people", people);
        return "editTask";
    }

    @PostMapping("/edytujZadanie")
    public String edit(@RequestParam Long id, Task task) {
        homeTaskerRepository.editTask(task, id);
        return "redirect:/";
    }

}
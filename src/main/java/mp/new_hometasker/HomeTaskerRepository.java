package mp.new_hometasker;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HomeTaskerRepository {
    private List<Person> people;
    private List<Task> tasks;

    public HomeTaskerRepository(){
    people = new ArrayList<>();
    Person osoba1 = new Person("Janek");
    Person osoba2 = new Person("Zosia");
    Person osoba3 = new Person("Karol");
    people.add(osoba1);
    people.add(osoba2);
    people.add(osoba3);

    tasks = new ArrayList<>();
    tasks.add(new Task(1, "Mycie podłóg", osoba1.getImie(), 3, 2018, 12, 30, 18, 00));
    tasks.add(new Task(2, "Malowanie", osoba2.getImie(), 10, 2020, 9, 30, 19, 00));
    tasks.add(new Task(3, "Wyniesienie śmieci", osoba2.getImie(), 1, 2018, 10, 31, 12, 30));
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public List<Person> getPeople(){
        return people;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public void removePerson(Person person){
        people.remove(person);
    }

    public Task findById(int id){
        for (Task task: tasks){
            if(id == task.getId()){
                return task;
            }
        } return null;
    }

}

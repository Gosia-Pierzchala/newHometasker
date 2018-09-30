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
    Person osoba1 = new Person(1, "Janek");
    Person osoba2 = new Person(2, "Zosia");
    Person osoba3 = new Person(3, "Karol");
    people.add(osoba1);
    people.add(osoba2);
    people.add(osoba3);

    tasks = new ArrayList<>();
    tasks.add(new Task(1, "Mycie podłóg", osoba1, 3, 2018, 12, 30, 18, 00));
    tasks.add(new Task(2, "Malowanie", osoba2, 10, 2020, 9, 30, 19, 00));
    tasks.add(new Task(3, "Wyniesienie śmieci", osoba3, 1, 2018, 10, 31, 12, 30));
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

    public Task findTaskById(long id){
        Task foundTask = new Task();
        for (Task task: tasks){
            if(id == task.getId()){
                foundTask = task;
            }
        } return foundTask;
    }

    public Person findPersonById(long id){
        Person foundPerson = new Person();
        for (Person person: people){
            if(id == person.getId()){
                foundPerson = person;
            }
        } return foundPerson;
    }

    public void editPerson(Person person, long id){
        Person person1 = findPersonById(id);
        person1.setId(person.getId());
        person1.setName(person.getName());
    }

    public Person find(String imie){
        for(Person person: people){
            if(imie.equals(person.getName())){
                return person;
            }
        }
        return null;
    }

}

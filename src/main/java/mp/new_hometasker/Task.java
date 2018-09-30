package mp.new_hometasker;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

public class Task {

    private long id;
    private String opis;
    private Person person;
    private int punkty;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    public Task(){
    }

    public Task(long id, String opis, Person person, int punkty, int rok, int miesiac, int dzien, int godzina, int minuty) {
        this.id = id;
        this.opis = opis;
        this.person = person;
        this.punkty = punkty;
        this.date = LocalDateTime.of(rok, miesiac, dzien, godzina, minuty);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
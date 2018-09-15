package mp.new_hometasker;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    Person person = new Person();

    private int id;
    private String opis;
    private String imie = person.getImie();
    private int punkty;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    public Task(){
    }

    public Task(int id, String opis, String imie, int punkty, int rok, int miesiac, int dzien, int godzina, int minuty) {
        this.id = id;
        this.opis = opis;
        this.imie = imie;
        this.punkty = punkty;
        this.date = LocalDateTime.of(rok, miesiac, dzien, godzina, minuty);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
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



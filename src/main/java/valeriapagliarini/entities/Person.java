package valeriapagliarini.entities;

import jakarta.persistence.*;
import valeriapagliarini.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity

@Table(name = "participants")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birth;
    private Gender gender;


    //manytomany perchè una persona può andare a più eventi e gli eventi possono avere più parteciapnti
    @ManyToMany

    @JoinTable(name = "participations",

            joinColumns = @JoinColumn(name = "person_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "event_id", nullable = false))

    private List<Event> eventsList;

    //costruttore vuoto
    public Person() {
    }

    //costruttore
    public Person(String name, String surname, String email, LocalDate birth, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
    }

    //getter


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //setter

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Event> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<Event> eventsList) {
        this.eventsList = eventsList;
    }

    //tostring


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", gender=" + gender +
                '}';
    }
}

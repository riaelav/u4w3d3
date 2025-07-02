package valeriapagliarini.entities;

import jakarta.persistence.*;
import valeriapagliarini.enums.EventTipe;

import java.time.LocalDate;
import java.util.List;


@Entity

@Table(name = "events")

public class Event {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, length = 100)

    private String title;

    @Column(name = "date")
    private LocalDate dateEvent;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private EventTipe eventTipe;


    @Column(name = "max_number_people")
    private int numberOfPeople;

    @ManyToMany(mappedBy = "eventsList")
    private List<Person> personList;


    //COSTRUTTORE VUOTO OBBLIGATORIO
    public Event() {
    }

    //COSTRUTTORE COMPLETO

    public Event(String title, LocalDate dateEvent, String description, EventTipe eventTipe, int numberOfPeople) {
        this.title = title;
        this.dateEvent = dateEvent;
        this.description = description;
        this.eventTipe = eventTipe;
        this.numberOfPeople = numberOfPeople;
    }

    //GETTER
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(LocalDate dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getDescription() {
        return description;
    }

    //SETTER (SENZA ID)

    public void setDescription(String description) {
        this.description = description;
    }

    public EventTipe getEventTipe() {
        return eventTipe;
    }

    public void setEventTipe(EventTipe eventTipe) {
        this.eventTipe = eventTipe;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateEvent=" + dateEvent +
                ", description='" + description + '\'' +
                ", eventTipe=" + eventTipe +
                ", numberOfPeople=" + numberOfPeople +
                '}';
    }
}

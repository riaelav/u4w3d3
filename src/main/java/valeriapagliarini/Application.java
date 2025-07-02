package valeriapagliarini;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import valeriapagliarini.dao.EventsDAO;
import valeriapagliarini.dao.ParticipantsDao;
import valeriapagliarini.entities.Event;
import valeriapagliarini.entities.Person;
import valeriapagliarini.enums.EventTipe;
import valeriapagliarini.enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d3pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO ed = new EventsDAO(em);
        ParticipantsDao pd = new ParticipantsDao(em);


//LISTA EVENTI
        Event evento1 = new Event("Workshop", LocalDate.of(2025, 8, 5),
                "Corso di aggiornamento professionale", EventTipe.PUBLIC, 100);

        Event evento2 = new Event("Concerto", LocalDate.of(2025, 9, 12),
                "Concerto all'aperto", EventTipe.PUBLIC, 500);

        Event evento3 = new Event("Cena Aziendale", LocalDate.of(2025, 12, 20),
                "Cena di fine anno col team", EventTipe.PRIVATE, 40);

        Event evento4 = new Event("Webinar", LocalDate.of(2025, 11, 2),
                "Seminario online", EventTipe.PUBLIC, 200);

        Event evento5 = new Event("Festa di Compleanno", LocalDate.of(2025, 7, 25),
                "Festa a sorpresa", EventTipe.PRIVATE, 30);


        Event evento6 = new Event("Meeting", LocalDate.of(2025, 7, 10),
                "Riunione", EventTipe.PRIVATE, 50);


        //LISTA PERSONE

        Person p1 = new Person("Alice", "Rossi", "alice.rossi@email.com", LocalDate.of(1990, 5, 14), Gender.FEMALE);
        Person p2 = new Person("Luca", "Bianchi", "luca.bianchi@email.com", LocalDate.of(1985, 11, 2), Gender.MALE);
        Person p3 = new Person("Maria", "Verdi", "maria.verdi@email.com", LocalDate.of(1992, 3, 25), Gender.FEMALE);
        Person p4 = new Person("Marco", "Neri", "marco.neri@email.com", LocalDate.of(1988, 7, 9), Gender.MALE);
        Person p5 = new Person("Giulia", "Russo", "giulia.russo@email.com", LocalDate.of(1995, 1, 30), Gender.FEMALE);
        Person p6 = new Person("Davide", "Conti", "davide.conti@email.com", LocalDate.of(1993, 9, 17), Gender.MALE);

        //devo assegnare ad una persona tot eventi
        Event webinarFromDb = ed.findById(4);
        Event meetingFromDb = ed.findById(6);

        //creo una lista
        List<Event> eventList = new ArrayList<>();

        eventList.add(webinarFromDb);
        eventList.add(meetingFromDb);

        //importo la lista eventi in una persona

        p1.setEventsList(eventList);


        pd.save(p1);

        em.close();
        emf.close();

    }

}

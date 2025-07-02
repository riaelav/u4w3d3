package valeriapagliarini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import valeriapagliarini.entities.Event;

public class EventsDAO {


    //ATTRIBUTO
    private EntityManager entityManager;

    //COSTRUTTORE
    public EventsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //METODO SAVE

    public void save(Event newEvent) {
// chiedo all' entity manager una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //faccio partire la transazione
        transaction.begin();

        //aggiungo l'evento al persistence context
        entityManager.persist(newEvent);

        //chiudo la transazione
        transaction.commit();

        System.out.println("L'evento " + newEvent.getTitle() + " è stato correttamente salvato nel db");
    }

    //METODO FIND
    public Event findById(long id) {
        Event found = entityManager.find(Event.class, id);
        return found;
    }


//METODO DELETE

    public void findByIdAndDelete(long id) {
        Event found = this.findById(id);
        //chiedo una nuova transazione all'entity manager e la faccio iniziare
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //rimuovo lo studente da persistent context
        entityManager.remove(found);

        //chiudo la transazione
        transaction.commit();

        System.out.println("L'evento" + found.getTitle() + "è stato correttamente rimosso dal db");


    }

}





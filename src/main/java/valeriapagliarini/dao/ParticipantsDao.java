package valeriapagliarini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import valeriapagliarini.entities.Person;


public class ParticipantsDao {

    //attributo
    private final EntityManager entityManager;

    //costruttore
    public ParticipantsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Person newPerson) {
        //chiedo di iniziare la transazione
        EntityTransaction transaction = entityManager.getTransaction();
        //la inizio
        transaction.begin();
        entityManager.persist(newPerson);
        //salvo effettivamnete
        transaction.commit();
        System.out.println("Person" + newPerson.getId() + "is correctly saved in db");

    }
}

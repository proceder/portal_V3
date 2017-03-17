/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.logic;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import pl.domain.Player;

/**
 *
 * @author kadam
 */
@Stateless
public class Service implements Serializable {

    private Logger logger;
    private EntityManagerFactory entityManagerFactory;
    ; //alt + shift + l
    private EntityManager entityManager;
//    @PersistenceContext
//    private EntityManager entityManager;
    private FullTextEntityManager fullTextEntityManager;

    public List<Player> allPlayers(String searchKey) {
//        return entityManager.createQuery("select b from Book b").getResultList();
        return searchWord(searchKey);
    }
    
    @PostConstruct
    public void init() {
        logger = Logger.getLogger(Service.class.getName());
        entityManagerFactory = Persistence.createEntityManagerFactory("myP");
        entityManager = entityManagerFactory.createEntityManager();
//        fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//        try {
//            fullTextEntityManager.createIndexer().startAndWait();
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
    }

    public List<Player> searchWord(String searchWord) {
        //alt + shift + l

//        try {
//            fullTextEntityManager.createIndexer().startAndWait();
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        entityManager.getTransaction().begin();
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Player.class).get();

        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onFields("firstName", "lastName", "country")
                .matching(searchWord)
                .createQuery();

        javax.persistence.Query jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, Player.class);

        List<Player> result = jpaQuery.getResultList();
//        System.out.println("num of books: " + result.size());
//        for (Book next : result) {
//            System.out.println("next book: " + next);
//        }

        entityManager.getTransaction().commit();
//        entityManager.close();

        return result;

    }

    public void createPlayer(Player player) {
        logger.info("player info:" + player.getFirstName() + "------------------------------");
        entityManager.getTransaction().begin();
        entityManager.persist(player);
        entityManager.getTransaction().commit();
    }

    public List<Player> allPlayers() {
        return entityManager.createQuery("select p from Player p").getResultList();
    }

    public void update(Player player) {

        if (player != null) {
            System.out.println("updatek: " + player.getFirstName());
            entityManager.getTransaction().begin();
            entityManager.merge(player);
            entityManager.getTransaction().commit();
        } else {
            System.out.println("nie ma takiego gracza");
        }
    }

    public void deleteFromDB(Player playerToDelete) {
        entityManager.getTransaction().begin();
        entityManager.remove(playerToDelete);
        entityManager.getTransaction().commit();

    }

}

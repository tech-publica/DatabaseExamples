package net.bit.databaseExamples.jpa;

import net.bit.databaseExamples.jpa.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MainJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        System.out.println("manager created!");


        em.getTransaction().begin();
      /*
        Agent agent = em.find(Agent.class, 1);

        Project p = new Project(0,"Ric's Bootcamp",
                "one year of full immersion coding",
                LocalDate.of(2020, 01, 10),
                LocalDate.of(2020, 12, 20),
                new BigDecimal(100000), true, agent);

        em.persist(p);


       */
        Area area = em.find(Area.class, 1);
        Project project = em.find(Project.class, 1);
        Course course = new Course(0, "java for dummies", "if you need a description you area a dummy",
                "very long syllabus...", 200, Level.INTRO, new BigDecimal(100),
                area, project);

        em.persist(course);

        em.getTransaction().commit();
        System.out.println("project inserted");
    }
}

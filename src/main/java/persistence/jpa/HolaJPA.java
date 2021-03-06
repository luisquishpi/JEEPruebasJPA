package persistence.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import models.entities.Tema;
import models.entities.Voto;

import org.eclipse.persistence.config.PersistenceUnitProperties;


public class HolaJPA {

	public static void main(String[] args) {
       /* Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);*/
        EntityManager em = Persistence.createEntityManagerFactory("JEEPruebasJPA")
                .createEntityManager();
        
        Tema t1 = new Tema("Tema 1", "Pregunta 1");
        // Create
        em.getTransaction().begin();
        em.persist(t1);
        em.persist(new Tema("Tema 2", "Pregunta 2"));
        em.persist(new Tema("Tema 3", "Pregunta 3"));
        em.getTransaction().commit();
        
        //Creando un voto
        Voto v1 = new Voto();
        v1.setTema(t1);
        v1.setNivelEstudio("Nivel estudiante");
        v1.setValor(9);
        // Create
        em.getTransaction().begin();
        em.persist(v1);
        em.getTransaction().commit();
	}

}

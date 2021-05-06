package semestralka;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Model {
    EntityManagerFactory emf;
    EntityManager em;

    public Model() {
	emf = Persistence.createEntityManagerFactory("semestralka_semestralka_jar_1.0-SNAPSHOTPU");
	em = emf.createEntityManager();
    }
    
    public void addHudebnik(String surname, String name, String birthNumber){
		EntityTransaction et = em.getTransaction();
		et.begin();
		Hudebnik h4 = new Hudebnik();
		h4.setJmeno(surname);
		h4.setPrijmeni(name);
		h4.setRodneCislo(birthNumber);
		em.persist(h4);
		et.commit();
    }
    
    public void addVlastnik(String surname, String name, String birthNumber, int instrumentNumber){
		EntityTransaction et = em.getTransaction();
		et.begin();
		Vlastnik v = new Vlastnik();
		v.setJmeno(surname);
		v.setPrijmeni(name);
		v.setRodneCislo(birthNumber);
		v.setPocetNastroju(instrumentNumber);
		em.persist(v);
		et.commit();
    }
    
    public void removeHudebnik(int id){
	EntityTransaction et = em.getTransaction();
	et.begin();
	Hudebnik h = em.find(Hudebnik.class, id);
	em.remove(h);
	et.commit();
    }
    
    public void removeVlastnik(int id){
	EntityTransaction et = em.getTransaction();
	et.begin();
	Vlastnik v = em.find(Vlastnik.class, id);
	em.remove(v);
	et.commit();
    }
    
    public void updateHudebnik(int id, String newSurname, String newName){
	EntityTransaction et = em.getTransaction();
		et.begin();
		Hudebnik h = em.find(Hudebnik.class, id);
		h.setJmeno(newSurname);
		h.setPrijmeni(newName);
		em.persist(h);
		et.commit();
    }
    
    public void updateVlastnik(int id, String newSurname, String newName, int instrumentNumber){
	EntityTransaction et = em.getTransaction();
		et.begin();
		Vlastnik v = em.find(Vlastnik.class, id);
		v.setJmeno(newSurname);
		v.setPrijmeni(newName);
		v.setPocetNastroju(instrumentNumber);
		em.persist(v);
		et.commit();
    }
    
    public List<Hudebnik> getListOfHudebnik(){
	TypedQuery<Hudebnik> q = em.createQuery("SELECT h FROM Hudebnik AS h",Hudebnik.class);
	List<Hudebnik> l = q.getResultList();
	return l;
    }
    
    public List<Vlastnik> getListOfVlastnik(){
	TypedQuery<Vlastnik> q = em.createQuery("SELECT v FROM Vlastnik AS v",Vlastnik.class);
	List<Vlastnik> l = q.getResultList();
	return l;
    }
}

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
    
    public void addVlastnik(String surname, String name, String birthNumber){//, int instrumentNumber){
		EntityTransaction et = em.getTransaction();
		et.begin();
		Vlastnik v = new Vlastnik();
		v.setJmeno(surname);
		v.setPrijmeni(name);
		v.setRodneCislo(birthNumber);
		//v.setPocetNastroju(instrumentNumber);
		v.setPocetNastroju(0);
		em.persist(v);
		et.commit();
    }
    
    public void addVyrobce(String name, String cityAndCountry){
		EntityTransaction et = em.getTransaction();
		et.begin();
		Vyrobce v = new Vyrobce();
		v.setNazev(name);
		v.setSidlo(cityAndCountry);
		em.persist(v);
		et.commit();
    }
    
    public void addNastroj(String producer, String produceNumber, String name, int price){
		List<Vyrobce> l = getListOfVyrobce();
		boolean ok = false;
		for(Vyrobce v : l){
		    if(v.getNazev().equals(producer)){
			ok = true;
		    }
		}
		if(!ok){
		    throw new IllegalArgumentException("Wrong producer name");
		}
		// handle the correct name
		EntityTransaction et = em.getTransaction();
		et.begin();
		Nastroj n = new Nastroj();
		n.setVyrobce(producer);
		n.setCislo(produceNumber);
		n.setNazev(name);
		n.setCena(price);
		em.persist(n);
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
    
    public void removeVyrobce(int id){
	EntityTransaction et = em.getTransaction();
	et.begin();
	Vyrobce v = em.find(Vyrobce.class, id);
	em.remove(v);
	et.commit();
    }
    
    public void removeNastroj(int id){
	EntityTransaction et = em.getTransaction();
	et.begin();
	Nastroj n = em.find(Nastroj.class, id);
	em.remove(n);
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
    
    public void updateVlastnik(int id, String newSurname, String newName){//, int instrumentNumber){
	EntityTransaction et = em.getTransaction();
		et.begin();
		Vlastnik v = em.find(Vlastnik.class, id);
		v.setJmeno(newSurname);
		v.setPrijmeni(newName);
		//v.setPocetNastroju(instrumentNumber);
		em.persist(v);
		et.commit();
    }
    
    public void updateVyrobce(int id, String cityAndCountry){
	EntityTransaction et = em.getTransaction();
		et.begin();
		Vyrobce v = em.find(Vyrobce.class, id);
		v.setSidlo(cityAndCountry);
		em.persist(v);
		et.commit();
    }
    
    public void updateNastroj(int id, int cost){
	EntityTransaction et = em.getTransaction();
		et.begin();
		Nastroj n = em.find(Nastroj.class, id);
		n.setCena(cost);
		em.persist(n);
		et.commit();
    }
    
    public void addNastrojToVlastnik(int nastrojId, int vlastnikId){
	EntityTransaction et = em.getTransaction();
		et.begin();
		Nastroj n = em.find(Nastroj.class, nastrojId);
		Vlastnik v = em.find(Vlastnik.class, vlastnikId);
		v.addNastroj(n);
		n.addVlastnik(v);
		em.persist(v);
		em.persist(n);
		et.commit();
    }
    
    public void removeNastrojFromVlastnik(int nastrojId, int vlastnikId){
	EntityTransaction et = em.getTransaction();
		et.begin();
		Nastroj n = em.find(Nastroj.class, nastrojId);
		Vlastnik v = em.find(Vlastnik.class, vlastnikId);
		v.removeNastroj(n);
		n.removeVlastnik(v);
		em.persist(v);
		em.persist(n);
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
    
    public List<Vyrobce> getListOfVyrobce(){
	TypedQuery<Vyrobce> q = em.createQuery("SELECT v FROM Vyrobce AS v",Vyrobce.class);
	List<Vyrobce> l = q.getResultList();
	return l;
    }
    
    public List<Nastroj> getListOfNastroj(){
	TypedQuery<Nastroj> q = em.createQuery("SELECT n FROM Nastroj AS n",Nastroj.class);
	List<Nastroj> l = q.getResultList();
	return l;
    }
}

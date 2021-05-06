package semestralka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class NewMain {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("org.postgresql.Driver");
	Connection c = DriverManager.getConnection("jdbc:postgresql://slon.felk.cvut.cz:5432/db21_erneejan","db21_erneejan","Dd9sAU");
	
	View view = new View();
	Model model = new Model();
	Controller controller = new Controller(view, model);
		
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("semestralka_semestralka_jar_1.0-SNAPSHOTPU");
//	EntityManager em = emf.createEntityManager();
//	
//	Hudebnik h1 = em.find(Hudebnik.class, 2);
//	
//	EntityTransaction et = em.getTransaction();
//	et.begin();
//	Vlastnik v1 = new Vlastnik();
//	v1.setJmeno("sdf");
//	v1.setPrijmeni("kjhklso");
//	v1.setRodneCislo("1234567890");
//	v1.setPocetNastroju(12);
//	em.persist(v1);
//	et.commit();
//	
//	TypedQuery<Hudebnik> q2 = em.createQuery("SELECT h FROM Hudebnik AS h",Hudebnik.class);
//	List<Hudebnik> l = q2.getResultList();
//	for (Hudebnik h : l) {
//	    System.out.println(h.getId() + " " + h.getJmeno() + " " + h.getPrijmeni());
//	}
//	
//	TypedQuery<Vlastnik> q3 = em.createQuery("SELECT v FROM Vlastnik AS v",Vlastnik.class);
//	List<Vlastnik> l_v = q3.getResultList();
//	for (Vlastnik v : l_v) {
//	    System.out.println(v.getId_vlastnik()+ " " + v.getJmeno() + " " + v.getPrijmeni() + " " + v.getPocet_nastroju());
//	}
//	
//	et = em.getTransaction();
//	et.begin();
//	Hudebnik h4 = new Hudebnik();
//	h4.setJmeno("sdf");
//	h4.setPrijmeni("ggh");
//	h4.setRodneCislo("1234567890");
//	em.persist(h4);
//	et.commit();

    	
	
//	em.close();
//	emf.close();
    }
    
}

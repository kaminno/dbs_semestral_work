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
    }
    
}

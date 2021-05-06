package semestralka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hudebnik {
    @Id
    @GeneratedValue
    public Integer id_hudebnik;
    private String rodne_cislo;
    private String jmeno;
    private String prijmeni;

    public Hudebnik() {
	id_hudebnik = null;
	rodne_cislo = null;
	jmeno = null;
	prijmeni = null;
    }

    public Integer getId() {
	return id_hudebnik;
    }

    public String getRodneCislo() {
	return rodne_cislo;
    }

    public String getJmeno() {
	return jmeno;
    }

    public String getPrijmeni() {
	return prijmeni;
    }

    public void setRodneCislo(String rodneCislo) {
	this.rodne_cislo = rodneCislo;
    }

    public void setJmeno(String jmeno) {
	this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
	this.prijmeni = prijmeni;
    }

    @Override
    public String toString() {
	return jmeno + " " + prijmeni + " " + rodne_cislo + "\n";
    }
    
}

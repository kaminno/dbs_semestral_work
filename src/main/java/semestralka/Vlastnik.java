package semestralka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vlastnik {
    @Id
    @GeneratedValue
    public Integer id_vlastnik;
    private String jmeno;
    private String prijmeni;
    private String rodne_cislo;
    private Integer pocet_nastroju;

    public Vlastnik() {
    }

    public Integer getIdVlastnik() {
	return id_vlastnik;
    }

    public String getJmeno() {
	return jmeno;
    }

    public String getPrijmeni() {
	return prijmeni;
    }

    public String getRodneCislo() {
	return rodne_cislo;
    }

    public Integer getPocetNastroju() {
	return pocet_nastroju;
    }

    public void setJmeno(String jmeno) {
	this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
	this.prijmeni = prijmeni;
    }

    public void setRodneCislo(String rodne_cislo) {
	this.rodne_cislo = rodne_cislo;
    }

    public void setPocetNastroju(Integer pocet_nastroju) {
	this.pocet_nastroju = pocet_nastroju;
    }
    
    
}

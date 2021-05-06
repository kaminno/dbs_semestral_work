package semestralka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vyrobce {
    @Id
    @GeneratedValue
    public Integer id_vyrobce;
    private String nazev;
    private String sidlo;
    
    public Vyrobce(){
	id_vyrobce = null;
	nazev = null;
	sidlo = null;
    }

    public void setId_vyrobce(Integer id_vyrobce) {
	this.id_vyrobce = id_vyrobce;
    }

    public void setNazev(String nazev) {
	this.nazev = nazev;
    }

    public void setSidlo(String sidlo) {
	this.sidlo = sidlo;
    }

    public Integer getId_vyrobce() {
	return id_vyrobce;
    }

    public String getNazev() {
	return nazev;
    }

    public String getSidlo() {
	return sidlo;
    }
}

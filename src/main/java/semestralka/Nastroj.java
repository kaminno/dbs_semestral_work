package semestralka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nastroj {
    @Id
    @GeneratedValue
    public Integer id_nastroj;
    private String vyrobce;
    private String cislo;
    private String nazev;
    private int cena;

    public Nastroj() {
    }

    public Integer getId_nastroj() {
	return id_nastroj;
    }

    public String getVyrobce() {
	return vyrobce;
    }

    public String getCislo() {
	return cislo;
    }

    public String getNazev() {
	return nazev;
    }

    public int getCena() {
	return cena;
    }

    public void setId_nastroj(Integer id_nastroj) {
	this.id_nastroj = id_nastroj;
    }

    public void setVyrobce(String vyrobce) {
	this.vyrobce = vyrobce;
    }

    public void setCislo(String cislo) {
	this.cislo = cislo;
    }

    public void setNazev(String nazev) {
	this.nazev = nazev;
    }

    public void setCena(int cena) {
	this.cena = cena;
    }

    @Override
    public String toString() {
	return vyrobce + " " + cislo + " " + nazev + " " + cena + "\n";
    }
    
}

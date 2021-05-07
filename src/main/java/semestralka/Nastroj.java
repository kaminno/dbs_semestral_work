package semestralka;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Nastroj {
    @Id
    @GeneratedValue
    public Integer id_nastroj;
    private String vyrobce;
    private String cislo;
    private String nazev;
    private int cena;
    @ManyToMany(targetEntity = Vlastnik.class)
    private LinkedList<Vlastnik> vlastnikList = new LinkedList();

    public Nastroj() {
    }
    
    public void addVlastnik(Vlastnik vlastnik){
	boolean ok = true;
	for(Vlastnik v : vlastnikList){
	    if(v.getIdVlastnik()== vlastnik.getIdVlastnik()){
		ok = false;
		break;
	    }
	}
	if(ok){
	    vlastnikList.add(vlastnik);
	}
    }
    
    public void removeVlastnik(Vlastnik vlastnik){
	for(Vlastnik v : vlastnikList){
	    if(v.getIdVlastnik()== vlastnik.getIdVlastnik()){
		vlastnikList.remove(vlastnik);
		break;
	    }
	}
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

    public LinkedList getVlastnikList() {
	return vlastnikList;
    }

    public void setVlastnikList(LinkedList vlastnikList) {
	this.vlastnikList = vlastnikList;
    }

    @Override
    public String toString() {
	return vyrobce + " " + cislo + " " + nazev + " " + cena + "\n";
    }
    
}

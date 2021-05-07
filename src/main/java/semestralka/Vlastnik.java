package semestralka;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vlastnik {
    @Id
    @GeneratedValue
    public Integer id_vlastnik;
    private String jmeno;
    private String prijmeni;
    private String rodne_cislo;
    private Integer pocet_nastroju;
    @ManyToMany(targetEntity = Nastroj.class)
    private LinkedList<Nastroj> nastrojList = new LinkedList();

    public Vlastnik() {
    }

    public void addNastroj(Nastroj nastroj){
	boolean ok = true;
	for(Nastroj n : nastrojList){
	    if(n.getId_nastroj() == nastroj.getId_nastroj()){
		ok = false;
		break;
	    }
	}
	if(ok){
	    nastrojList.add(nastroj);
	    pocet_nastroju += 1;
	}
    }
    
    public void removeNastroj(Nastroj nastroj){
	for(Nastroj n : nastrojList){
	    if(n.getId_nastroj() == nastroj.getId_nastroj()){
		nastrojList.remove(nastroj);
		pocet_nastroju -= 1;
		break;
	    }
	}
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

    public void setNastrojList(LinkedList nastrojList) {
	this.nastrojList = nastrojList;
    }

    public LinkedList getNastrojList() {
	return nastrojList;
    }

    @Override
    public String toString() {
	return jmeno + " " + prijmeni + " " + rodne_cislo + "\n";// + " " + pocet_nastroju + "\n";
    }
}

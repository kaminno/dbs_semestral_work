package semestralka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
	this.view = view;
	this.model = model;
	setActions();
    }
    
    private void setActions(){
	// set actions to each menu item	
	view.getMenuAddHudebnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// show jdialog and let it to add new hudebnik
		AddHudebnikDialog hd = new AddHudebnikDialog(view, model);
		hd.setVisible(true);
		hd.getBtnCancel().addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	               hd.dispose();
		       hd.setVisible(false);
	            }
	        });
	    }
	  } );
	
	view.getMenuAddVlastnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// show jdialog and let it to add new vlastnik
		AddVlastnikDialog hd = new AddVlastnikDialog(view, model);
		hd.setVisible(true);
		hd.getBtnCancel().addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	               hd.dispose();
		       hd.setVisible(false);
	            }
	        });
	    }
	  } );
	
	view.getMenuAddVyrobce().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// show jdialog and let it to add new vyrobce
		AddVyrobceDialog hd = new AddVyrobceDialog(view, model);
		hd.setVisible(true);
		hd.getBtnCancel().addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	               hd.dispose();
		       hd.setVisible(false);
	            }
	        });
	    }
	  } );
	
	view.getMenuAddNastroj().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// show jdialog and let it to add new nastroj
		AddNastrojDialog nd = new AddNastrojDialog(view, model);
		nd.setVisible(true);
		nd.getBtnCancel().addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	               nd.dispose();
		       nd.setVisible(false);
	            }
	        });
	    }
	  } );
	
	view.getMenuAddNastrojToVlastnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// show jdialog and let it to add new nastroj to vlastnik
		AddNastrojToVlastnikDialog nd = new AddNastrojToVlastnikDialog(view, model);
		nd.setVisible(true);
		nd.getBtnCancel().addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	               nd.dispose();
		       nd.setVisible(false);
	            }
	        });
	    }
	  } );
	
	view.getMenuReadHudebnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// get the data from database and paste them in the table and textarea
		String s = "";
		List<Hudebnik> l = model.getListOfHudebnik();
		
		//
		for(Hudebnik h : l){
		    s += h.getId() + " " + h.getJmeno() + " " + h.getPrijmeni() + " " + h.getRodneCislo() + "\n";
		}
		
		view.getTextArea().setText(s);
		//
		view.getTableModel().setRowCount(0);
		String[] cols = {"Id", "Jméno", "Příjmení", "Rodné číslo"};
		view.getTableModel().setColumnIdentifiers(cols);
		for(Hudebnik h : l){
		    view.getTableModel().addRow(new Object[]{h.getId(), h.getJmeno(), h.getPrijmeni(), h.getRodneCislo()});
		}
		view.currentTableType = EntityType.HUDEBNIK;
		view.repaint();
	    }
	  } );
	
	view.getMenuReadVlastnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// get the data from database and paste them in the table and textarea
		String s = "";
		List<Vlastnik> l = model.getListOfVlastnik();
		for(Vlastnik v : l){
		    s += v.getIdVlastnik()+ " " + v.getJmeno() + " " + v.getPrijmeni() + " " + v.getRodneCislo() + " " + v.getPocetNastroju() + "\n";
		}
		
		view.getTextArea().setText(s);
		
		view.getTableModel().setRowCount(0);
		String[] cols = {"Id", "Jméno", "Příjmení", "Rodné číslo", "Počet nástrojů"};
		view.getTableModel().setColumnIdentifiers(cols);
		for(Vlastnik v : l){
		    view.getTableModel().addRow(new Object[]{v.getIdVlastnik(), v.getJmeno(), v.getPrijmeni(), v.getRodneCislo(), v.getPocetNastroju()});
		}
		view.currentTableType = EntityType.VLASTNIK;
		view.repaint();
	    }
	  } );
	
	view.getMenuReadVyrobce().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// get the data from database and paste them in the table and textarea
		String s = "";
		List<Vyrobce> l = model.getListOfVyrobce();
		for(Vyrobce v : l){
		    s += v.getId_vyrobce() + " " + v.getNazev() + " " + v.getSidlo() + "\n";
		}
		
		view.getTextArea().setText(s);
		
		view.getTableModel().setRowCount(0);
		String[] cols = {"Id", "Název", "Sídlo"};
		view.getTableModel().setColumnIdentifiers(cols);
		for(Vyrobce v : l){
		    view.getTableModel().addRow(new Object[]{v.getId_vyrobce(), v.getNazev(), v.getSidlo()});
		}
		view.currentTableType = EntityType.VYROBCE;
		view.repaint();
	    }
	  } );
	
	view.getMenuReadNastroj().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// get the data from database and paste them in the table and textarea
		String s = "";
		List<Nastroj> l = model.getListOfNastroj();
		for(Nastroj n : l){
		    s += n.getVyrobce() + " " + n.getCislo() + " " + n.getNazev() + " " + n.getCena() + "\n";
		}
		
		view.getTextArea().setText(s);
		
		view.getTableModel().setRowCount(0);
		String[] cols = {"Id", "Výrobce", "Číslo", "Název", "Cena"};
		view.getTableModel().setColumnIdentifiers(cols);
		for(Nastroj n : l){
		    view.getTableModel().addRow(new Object[]{n.getId_nastroj(), n.getVyrobce(), n.getCislo(), n.getNazev(), n.getCena()});
		}
		view.currentTableType = EntityType.NASTROJ;
		view.repaint();
	    }
	  } );
	
	view.getMenuReadNastrojWithVlastnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// get the data from database and paste them in the table and textarea
		String s = "";
		List<Nastroj> l = model.getListOfNastroj();
		for(Nastroj n : l){
		    List<Vlastnik> vl = n.getVlastnikList();
		    String ss = "";
		    for(Vlastnik v : vl){
			ss += v.getJmeno() + " " + v.getPrijmeni() + ", ";
		    }
		    s += n.getVyrobce() + " " + n.getCislo() + " " + n.getNazev() + " " + n.getCena() + " " + ss + "\n";
		}
		
		view.getTextArea().setText(s);
		
		view.getTableModel().setRowCount(0);
		String[] cols = {"Id", "Výrobce", "Číslo", "Název", "Cena", "Vlastníci"};
		view.getTableModel().setColumnIdentifiers(cols);
		for(Nastroj n : l){
		    List<Vlastnik> vl = n.getVlastnikList();
		    String ss = "";
		    for(Vlastnik v : vl){
			ss += v.getJmeno() + " " + v.getPrijmeni() + ", ";
		    }
		    view.getTableModel().addRow(new Object[]{n.getId_nastroj(), n.getVyrobce(), n.getCislo(), n.getNazev(), n.getCena(), ss});
		}
		view.currentTableType = EntityType.NASTROJ;
		view.repaint();
	    }
	  } );
	
	view.getMenuReadVlastnikWithNastroj().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// get the data from database and paste them in the table and textarea
		String s = "";
		List<Vlastnik> l = model.getListOfVlastnik();
		for(Vlastnik v : l){
		    List<Nastroj> nl = v.getNastrojList();
		    String ss = "";
		    for(Nastroj n : nl){
			ss += n.getNazev() + ", ";
		    }
		    s += v.getJmeno() + " " + v.getPrijmeni() + " " + v.getRodneCislo() + " " + v.getPocetNastroju() + " " + ss + "\n";
		}
		
		view.getTextArea().setText(s);
		
		view.getTableModel().setRowCount(0);
		String[] cols = {"Jméno", "Příjmení", "Rodné číslo", "Počet nástrojů", "Nástroje"};
		view.getTableModel().setColumnIdentifiers(cols);
		for(Vlastnik v : l){
		    List<Nastroj> nl = v.getNastrojList();
		    String ss = "";
		    for(Nastroj n : nl){
			ss += n.getNazev() + ", ";
		    }
		    view.getTableModel().addRow(new Object[]{v.getJmeno(), v.getPrijmeni(), v.getRodneCislo(), v.getPocetNastroju(), ss});
		}
		view.currentTableType = EntityType.NASTROJ;
		view.repaint();
	    }
	  } );
	
	view.getMenuRemoveHudebnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// remove the entity from database
		String s = (String)JOptionPane.showInputDialog(
			"Id"
		);
		if(s == null){
		    return;
		}
		int i = -1;
		boolean ok = true;
		// check if the id is really id
		try{
			    i = Integer.parseInt(s);
			    
			}catch (NumberFormatException nfe) {
			    ok = false;
			    JOptionPane.showMessageDialog(view,
                            "Nesprávný formát id",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
			}
		boolean rem = false;
		if(ok){
		    // if the id has an entity in database, remove it
		    List<Hudebnik> l = model.getListOfHudebnik();
		    for(Hudebnik h : l){
			if(h.getId() == i){
			    rem = true;
			    break;
			}
		    }
		    if(rem){
			model.removeHudebnik(i);
		    }
		    else{
			JOptionPane.showMessageDialog(view,
                            "Hudebník se zadaným id neexistuje",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
		    }
		}
	    }
	  } );
	
	view.getMenuRemoveVlastnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// remove the entity from database
		String s = (String)JOptionPane.showInputDialog(
			"Id"
		);
		if(s == null){
		    return;
		}
		int i = -1;
		boolean ok = true;
		// checks if the id is really id
		try{
			    i = Integer.parseInt(s);
			    
			}catch (NumberFormatException nfe) {
			    ok = false;
			    JOptionPane.showMessageDialog(view,
                            "Nesprávný formát id",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
			}
		boolean rem = false;
		if(ok){
		    // if the id has entity in database, remove it
		    List<Vlastnik> l = model.getListOfVlastnik();
		    for(Vlastnik v : l){
			if(v.getIdVlastnik()== i){
			    rem = true;
			    break;
			}
		    }
		    if(rem){
			model.removeVlastnik(i);
		    }
		    else{
			JOptionPane.showMessageDialog(view,
                            "Vlastník se zadaným id neexistuje",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
		    }
		}
	    }
	  } );
	
	view.getMenuRemoveVyrobce().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// remove the entity from database
		String s = (String)JOptionPane.showInputDialog(
			"Id"
		);
		if(s == null){
		    return;
		}
		int i = -1;
		boolean ok = true;
		// check if the id is really id
		try{
			    i = Integer.parseInt(s);
			    
			}catch (NumberFormatException nfe) {
			    ok = false;
			    JOptionPane.showMessageDialog(view,
                            "Nesprávný formát id",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
			}
		boolean rem = false;
		if(ok){
		    // if the id has entity in database, remove it
		    List<Vyrobce> l = model.getListOfVyrobce();
		    for(Vyrobce v : l){
			if(v.getId_vyrobce()== i){
			    rem = true;
			    break;
			}
		    }
		    if(rem){
			model.removeVyrobce(i);
		    }
		    else{
			JOptionPane.showMessageDialog(view,
                            "Výrobce se zadaným id neexistuje",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
		    }
		}
	    }
	  } );
	
	view.getMenuRemoveNastroj().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// remove the entity from database
		String s = (String)JOptionPane.showInputDialog(
			"Id"
		);
		if(s == null){
		    return;
		}
		int i = -1;
		boolean ok = true;
		// check if the id is really id
		try{
			    i = Integer.parseInt(s);
			    
			}catch (NumberFormatException nfe) {
			    ok = false;
			    JOptionPane.showMessageDialog(view,
                            "Nesprávný formát id",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
			}
		boolean rem = false;
		if(ok){
		    // if the id has entity in database, remove it
		    List<Nastroj> l = model.getListOfNastroj();
		    for(Nastroj n : l){
			if(n.getId_nastroj() == i){
			    rem = true;
			    break;
			}
		    }
		    if(rem){
			model.removeNastroj(i);
		    }
		    else{
			JOptionPane.showMessageDialog(view,
                            "Nástroj se zadaným id neexistuje",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
		    }
		}
	    }
	  } );
	
	view.getDeleteRow().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// remove row from table
		if((int)view.table.getSelectedRow() >= 0){
		    // ask the user if he really want to delete the record
		    int id = Integer.parseInt(view.table.getValueAt(view.table.getSelectedRow(), 0).toString());
		    int n = JOptionPane.showConfirmDialog(
			view,
			"Opravdu chcete odstranit záznam?",
			"Odstranit záznam?",
			JOptionPane.YES_NO_OPTION);
		    if(n == 0){
			// if yes, remove the row and the record in database, based on the current entity shown in the table
			if(view.currentTableType == EntityType.HUDEBNIK){
			    model.removeHudebnik(id);
			}
			else if(view.currentTableType == EntityType.VLASTNIK){
			    // removing the nastroj entity from the list
			    Vlastnik v = null;
			    List<Vlastnik> vv = model.getListOfVlastnik();
			    for(Vlastnik vl : vv){
				if(vl.getIdVlastnik() == id){
				    v = vl;
				    break;
				}
			    }
			    List<Nastroj> nl = v.getNastrojList();
			    for(Nastroj na : nl){
				na.removeVlastnik(v);
			    }
			    model.removeVlastnik(id);
			}
			else if(view.currentTableType == EntityType.VYROBCE){
			    model.removeVyrobce(id);
			}
			else if(view.currentTableType == EntityType.NASTROJ){
			    Nastroj na = null;
			    List<Nastroj> nn = model.getListOfNastroj();
			    for(Nastroj nl : nn){
				if(nl.getId_nastroj() == id){
				    na = nl;
				    break;
				}
			    }
			    List<Vlastnik> vl = na.getVlastnikList();
			    for(Vlastnik va : vl){
				va.removeNastroj(na);
			    }
			    model.removeNastroj(id);
			}
			view.tableModel.removeRow(view.table.getSelectedRow());
		    }
		}
		view.table.repaint();
		view.table.clearSelection();
		
	  }} );
	
	view.getUpdateRow().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		// update row and the record in the database
		if((int)view.table.getSelectedRow() >= 0){
		    int id = (int)view.table.getValueAt(view.table.getSelectedRow(), 0);
			if(view.currentTableType == EntityType.HUDEBNIK){
			    UpdateHudebnikDialog uhd = new UpdateHudebnikDialog(view, model, id);
			    uhd.setVisible(true);
			    view.getMenuReadHudebnik().doClick();
			}
			else if(view.currentTableType == EntityType.VLASTNIK){
			    UpdateVlastnikDialog uvd = new UpdateVlastnikDialog(view, model, id);
			    uvd.setVisible(true);
			    view.getMenuReadVlastnik().doClick();
			}
			else if(view.currentTableType == EntityType.VYROBCE){
			    UpdateVyrobceDialog uvd = new UpdateVyrobceDialog(view, model, id);
			    uvd.setVisible(true);
			    view.getMenuReadVyrobce().doClick();
			}
			else if(view.currentTableType == EntityType.NASTROJ){
			    UpdateNastrojDialog und = new UpdateNastrojDialog(view, model, id);
			    und.setVisible(true);
			    view.getMenuReadNastroj().doClick();
			}
		    }
		view.table.repaint();
		view.table.clearSelection();
		
	  }} );
    }
}

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
	view.getBtnAdd().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
	      
	    } 
	  } );
	
	view.getMenuAddHudebnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
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
	
	view.getMenuReadHudebnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
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
	
	view.getMenuRemoveHudebnik().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		String s = (String)JOptionPane.showInputDialog(
			"Id"
		);
		if(s == null){
		    return;
		}
		int i = -1;
		boolean ok = true;
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
		String s = (String)JOptionPane.showInputDialog(
			"Id"
		);
		if(s == null){
		    return;
		}
		int i = -1;
		boolean ok = true;
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
	
	view.getDeleteRow().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
		if((int)view.table.getSelectedRow() >= 0){
		    int id = (int)view.table.getValueAt(view.table.getSelectedRow(), 0);
		    int n = JOptionPane.showConfirmDialog(
			view,
			"Opravdu chcete odstranit záznam?",
			"Odstranit záznam?",
			JOptionPane.YES_NO_OPTION);
		    if(n == 0){
			if(view.currentTableType == EntityType.HUDEBNIK){
			    model.removeHudebnik(id);
			}
			else if(view.currentTableType == EntityType.VLASTNIK){
			    model.removeVlastnik(id);
			}
			view.tableModel.removeRow(view.table.getSelectedRow());
		    }
		}
		view.table.repaint();
		view.table.clearSelection();
		
	  }} );
	
	view.getUpdateRow().addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent e) {
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
		    }
		
		view.table.repaint();
		view.table.clearSelection();
		
	  }} );
    }
}

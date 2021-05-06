package semestralka;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class AddVlastnikDialog extends JDialog{
    private JTextField tfSurName;
    private JTextField tfName;
    private JTextField tfBirthDateNumber;
    private JTextField tfInstrumentNumber;
    private JLabel lbSurName;
    private JLabel lbName;
    private JLabel lbBirthDateNumber;
    private JLabel lbInstrumentNumber;
    private JButton btnAdd;
    private JButton btnCancel;
    private boolean succeeded;
 
    public AddVlastnikDialog(Frame parent, Model model) {
        super(parent, "Přidat vlastníka", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbSurName = new JLabel("Jméno: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbSurName, cs);
 
        tfSurName = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfSurName, cs);
 
        lbName = new JLabel("Příjmení: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbName, cs);
 
        tfName = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(tfName, cs);
	
	lbBirthDateNumber = new JLabel("Rodné číslo: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbBirthDateNumber, cs);
 
        tfBirthDateNumber = new JTextField(20);
        cs.gridx = 2;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(tfBirthDateNumber, cs);
	
	lbInstrumentNumber = new JLabel("Počet nástrojů: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(lbInstrumentNumber, cs);
 
        tfInstrumentNumber = new JTextField(20);
        cs.gridx = 2;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(tfInstrumentNumber, cs);
	
	
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnAdd = new JButton("Přidat");
	btnCancel = new JButton("Zrušit");
	
	btnAdd.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
			String s = tfSurName.getText() + " " + tfName.getText() + " " + tfBirthDateNumber.getText() + " " + tfInstrumentNumber.getText() + "\n";
			List<Vlastnik> vlastnici = model.getListOfVlastnik();
			boolean ok = true;
			for(Vlastnik v : vlastnici){
			    if(v.toString().equals(s)){
				ok = false;
				JOptionPane.showMessageDialog(AddVlastnikDialog.this,
                            "Záznam již existuje",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
				dispose();
			    }
			}
			
			
			try{
			    long i = Long.parseLong(tfBirthDateNumber.getText());
			    if(tfBirthDateNumber.getText().length() != 10){
				ok = false;
				JOptionPane.showMessageDialog(AddVlastnikDialog.this,
				"Špatná délka rodného čísla",
				"Špatná data",
				JOptionPane.WARNING_MESSAGE);
				    dispose();
			    }
			    try{
				long j = Long.parseLong(tfInstrumentNumber.getText());
				if(Integer.parseInt(tfInstrumentNumber.getText()) <= 0){
				    ok = false;
				JOptionPane.showMessageDialog(AddVlastnikDialog.this,
				"Počet nástrojů není kladné číslo",
				"Špatná data",
				JOptionPane.WARNING_MESSAGE);
				    dispose();
				}
			    }
			    catch(NumberFormatException nfe){
				ok = false;
				JOptionPane.showMessageDialog(AddVlastnikDialog.this,
				"Počet nástrojů není celé číslo",
				"Špatná data",
				JOptionPane.WARNING_MESSAGE);
				    dispose();
			    }
			}catch (NumberFormatException nfe) {
			    ok = false;
			    JOptionPane.showMessageDialog(AddVlastnikDialog.this,
                            "Nesprávný formát rodného čísla",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
				dispose();
			}
			if(ok){
			    
	               model.addVlastnik(tfSurName.getText(), tfName.getText(), tfBirthDateNumber.getText(), Integer.parseInt(tfInstrumentNumber.getText()));
		       JOptionPane.showMessageDialog(AddVlastnikDialog.this,
                            "Ok",
                            "Záznam úspěšně přidán",
                            JOptionPane.INFORMATION_MESSAGE);
				dispose();
			    
		       dispose();
			}
	            }
	        });
	btnCancel.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
		       dispose();
	            }
	        });

        JPanel bp = new JPanel();
        bp.add(btnAdd);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
 
    public String getUsername() {
        return tfSurName.getText().trim();
    }

    public JTextField getTfSurName() {
	return tfSurName;
    }

    public JTextField getTfName() {
	return tfName;
    }

    public JTextField getTfBirthDateNumber() {
	return tfBirthDateNumber;
    }

    public JLabel getLbSurName() {
	return lbSurName;
    }

    public JLabel getLbName() {
	return lbName;
    }

    public JLabel getLbBirthDateNumber() {
	return lbBirthDateNumber;
    }

    public JButton getBtnAdd() {
	return btnAdd;
    }

    public JButton getBtnCancel() {
	return btnCancel;
    }

    public void setTfSurName(JTextField tfSurName) {
	this.tfSurName = tfSurName;
    }

    public void setTfName(JTextField tfName) {
	this.tfName = tfName;
    }

    public void setTfBirthDateNumber(JTextField tfBirthDateNumber) {
	this.tfBirthDateNumber = tfBirthDateNumber;
    }

    public void setLbSurName(JLabel lbSurName) {
	this.lbSurName = lbSurName;
    }

    public void setLbName(JLabel lbName) {
	this.lbName = lbName;
    }

    public void setLbBirthDateNumber(JLabel lbBirthDateNumber) {
	this.lbBirthDateNumber = lbBirthDateNumber;
    }

    public void setBtnAdd(JButton btnAdd) {
	this.btnAdd = btnAdd;
    }

    public void setBtnCancel(JButton btnCancel) {
	this.btnCancel = btnCancel;
    }

    public void setSucceeded(boolean succeeded) {
	this.succeeded = succeeded;
    }
    
    public boolean isSucceeded() {
        return succeeded;
    }
}

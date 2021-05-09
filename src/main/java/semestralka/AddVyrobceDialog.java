package semestralka;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AddVyrobceDialog extends JDialog{
    // jdialog to get values from user to store them into the database
    private JTextField tfName;
    private JTextField tfCityAndCountry;
    private JLabel lbName;
    private JLabel lbCityAndCountry;
    private JButton btnAdd;
    private JButton btnCancel;
 
    public AddVyrobceDialog(Frame parent, Model model) {
        super(parent, "Přidat výrobce", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
	// prepare the dialog view
        lbName = new JLabel("Jméno: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbName, cs);
 
        tfName = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfName, cs);
 
        lbCityAndCountry = new JLabel("Sídlo: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbCityAndCountry, cs);
 
        tfCityAndCountry = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(tfCityAndCountry, cs);
	
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnAdd = new JButton("Přidat");
	btnCancel = new JButton("Zrušit");
	
	btnAdd.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
			// check if the entity with got values exists or not
			String s = tfName.getText() + " " + tfCityAndCountry.getText() + "\n";
			List<Vyrobce> vyrobci = model.getListOfVyrobce();
			boolean ok = true;
			for(Vyrobce v : vyrobci){
			    if(v.toString().equals(s)){
				ok = false;
				JOptionPane.showMessageDialog(AddVyrobceDialog.this,
                            "Záznam již existuje",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
				dispose();
			    }
			}
			
			if(!tfName.getText().equals("") && !tfCityAndCountry.getText().equals("")){
			    ok = true;
			}
			
			if(ok){
			    // create new entity and add it to the database
			    model.addVyrobce(tfName.getText(), tfCityAndCountry.getText());
			    JOptionPane.showMessageDialog(AddVyrobceDialog.this,
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

    public JTextField getTfName() {
	return tfName;
    }

    public JTextField getTfCityAndCountry() {
	return tfCityAndCountry;
    }

    public JLabel getLbName() {
	return lbName;
    }

    public JLabel getLbCityAndCountry() {
	return lbCityAndCountry;
    }

    public JButton getBtnAdd() {
	return btnAdd;
    }

    public JButton getBtnCancel() {
	return btnCancel;
    }
}

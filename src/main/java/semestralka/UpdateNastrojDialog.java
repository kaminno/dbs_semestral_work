package semestralka;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class UpdateNastrojDialog extends JDialog{
    private JTextField tfCost;
    private JLabel lbCost;
    private JButton btnAdd;
    private JButton btnCancel;
    private int idToUpdate;
 
    public UpdateNastrojDialog(Frame parent, Model model, int id) {
        super(parent, "Aktualizovat nástroj", true);
        //
	idToUpdate = id;
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbCost = new JLabel("Nová cena: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbCost, cs);
 
        tfCost = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfCost, cs);
	
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnAdd = new JButton("Aktualizovat");
	btnCancel = new JButton("Zrušit");
	
	btnAdd.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
			//model.updateVyrobce(idToUpdate, tfCityAndCountry.getText());
			try{
			    model.updateNastroj(idToUpdate, Integer.parseUnsignedInt(tfCost.getText()));
			}
			catch(NumberFormatException nfe){
			    JOptionPane.showMessageDialog(parent,
                            "Špatný formát ceny!",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
				dispose();
			}
			dispose();
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

    public JTextField getTfCost() {
	return tfCost;
    }

    public JLabel getLbCost() {
	return lbCost;
    }

    public JButton getBtnAdd() {
	return btnAdd;
    }

    public JButton getBtnCancel() {
	return btnCancel;
    }

    public int getIdToUpdate() {
	return idToUpdate;
    }
    
}

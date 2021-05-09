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

public class UpdateVyrobceDialog extends JDialog{
    private JTextField tfCityAndCountry;
    private JLabel lbCityAndCountry;
    private JButton btnAdd;
    private JButton btnCancel;
    private int idToUpdate;
 
    public UpdateVyrobceDialog(Frame parent, Model model, int id) {
        super(parent, "Aktualizovat výrobce", true);
        // create dialog form to get values from user
	idToUpdate = id;
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbCityAndCountry = new JLabel("Sídlo: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbCityAndCountry, cs);
 
        tfCityAndCountry = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfCityAndCountry, cs);
	
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnAdd = new JButton("Aktualizovat");
	btnCancel = new JButton("Zrušit");
	
	btnAdd.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
			// call update method. If fails, show the warning dialog
			model.updateVyrobce(idToUpdate, tfCityAndCountry.getText());
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
}

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

public class UpdateVlastnikDialog extends JDialog{
    private JTextField tfSurName;
    private JTextField tfName;
    private JTextField tfInstrumentNumber;
    private JLabel lbSurName;
    private JLabel lbName;
    private JLabel lbInstrumentNumber;
    private JButton btnAdd;
    private JButton btnCancel;
    private int idToUpdate;
 
    public UpdateVlastnikDialog(Frame parent, Model model, int id) {
        super(parent, "Aktualizovat vlastníka", true);
        //
	idToUpdate = id;
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
	
//	lbInstrumentNumber = new JLabel("Počet nástrojů: ");
//        cs.gridx = 0;
//        cs.gridy = 2;
//        cs.gridwidth = 1;
//        panel.add(lbInstrumentNumber, cs);
// 
//        tfInstrumentNumber = new JTextField(20);
//        cs.gridx = 1;
//        cs.gridy = 2;
//        cs.gridwidth = 2;
//        panel.add(tfInstrumentNumber, cs);
	
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnAdd = new JButton("Aktualizovat");
	btnCancel = new JButton("Zrušit");
	
	btnAdd.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
			try{
			    model.updateVlastnik(idToUpdate, tfSurName.getText(), tfName.getText());//, Integer.parseUnsignedInt(tfInstrumentNumber.getText()));
			}
			catch(NumberFormatException nfe){
			    JOptionPane.showMessageDialog(parent,
                            "Nesprávný formát počtu nástrojů",
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

    public JTextField getTfSurName() {
	return tfSurName;
    }

    public JTextField getTfName() {
	return tfName;
    }

    public JTextField getTfInstrumentNumber() {
	return tfInstrumentNumber;
    }

    public JLabel getLbSurName() {
	return lbSurName;
    }

    public JLabel getLbName() {
	return lbName;
    }

    public JLabel getLbInstrumentNumber() {
	return lbInstrumentNumber;
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

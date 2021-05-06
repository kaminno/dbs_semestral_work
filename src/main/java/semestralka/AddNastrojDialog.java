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

public class AddNastrojDialog extends JDialog{
    private JTextField tfProducer;
    private JTextField tfCode;
    private JTextField tfName;
    private JTextField tfCost;
    private JLabel lbProducer;
    private JLabel lbCode;
    private JLabel lbName;
    private JLabel lbCost;
    private JButton btnAdd;
    private JButton btnCancel;
 
    public AddNastrojDialog(Frame parent, Model model) {
        super(parent, "Přidat nástroj", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbProducer = new JLabel("Výrobce: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbProducer, cs);
 
        tfProducer = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfProducer, cs);
 
        lbCode = new JLabel("Číslo: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbCode, cs);
 
        tfCode = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(tfCode, cs);
	
	lbName = new JLabel("Název: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbName, cs);
 
        tfName = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(tfName, cs);
	
	lbCost = new JLabel("Cena: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(lbCost, cs);
 
        tfCost = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(tfCost, cs);
	
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnAdd = new JButton("Přidat");
	btnCancel = new JButton("Zrušit");
	
	btnAdd.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
			String s = tfProducer.getText() + " " + tfCode.getText() + " " + tfName.getText() + " " + tfCost.getText() + "\n";
			List<Nastroj> nastroje = model.getListOfNastroj();
			boolean ok = true;
			for(Nastroj n : nastroje){
			    if(n.toString().equals(s)){
				ok = false;
				JOptionPane.showMessageDialog(AddNastrojDialog.this,
                            "Záznam již existuje",
                            "Špatná data",
                            JOptionPane.WARNING_MESSAGE);
				dispose();
			    }
			}
			
			if(ok){
			    try{
				model.addNastroj(tfProducer.getText(), tfCode.getText(), tfName.getText(), Integer.parseUnsignedInt(tfCost.getText()));
				JOptionPane.showMessageDialog(AddNastrojDialog.this,
				    "Ok",
				    "Záznam úspěšně přidán",
				    JOptionPane.INFORMATION_MESSAGE);
					dispose();

			        dispose();
			    }catch(IllegalArgumentException iae){
				JOptionPane.showMessageDialog(AddNastrojDialog.this,
				"Špatná data",
				"Špatná data",
				JOptionPane.WARNING_MESSAGE);
				    dispose();
			    }
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

    public JTextField getTfProducer() {
	return tfProducer;
    }

    public JTextField getTfCode() {
	return tfCode;
    }

    public JTextField getTfName() {
	return tfName;
    }

    public JTextField getTfCost() {
	return tfCost;
    }

    public JLabel getLbProducer() {
	return lbProducer;
    }

    public JLabel getLbCode() {
	return lbCode;
    }

    public JLabel getLbName() {
	return lbName;
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
    
}

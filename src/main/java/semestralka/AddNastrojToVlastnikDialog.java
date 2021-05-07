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

public class AddNastrojToVlastnikDialog extends JDialog{
    private JTextField tfInstrumentId;
    private JTextField tfOwnerId;
    private JLabel lbInstrumentId;
    private JLabel lbOwnerId;
    private JButton btnAdd;
    private JButton btnCancel;
 
    public AddNastrojToVlastnikDialog(Frame parent, Model model) {
        super(parent, "Přidat vlastníka", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbInstrumentId = new JLabel("Id nástroje: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbInstrumentId, cs);
 
        tfInstrumentId = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfInstrumentId, cs);
 
        lbOwnerId = new JLabel("Id vlastníka: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbOwnerId, cs);
 
        tfOwnerId = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(tfOwnerId, cs);
	
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnAdd = new JButton("Přidat");
	btnCancel = new JButton("Zrušit");
	
	btnAdd.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
			List<Vlastnik> vlastnici = model.getListOfVlastnik();
			boolean ok_v = false;
			boolean ok_n = false;
			try{
			    for(Vlastnik v : vlastnici){
				if(v.getIdVlastnik() == Integer.parseInt(tfOwnerId.getText())){
				    ok_v = true;
				    break;
				}
			    }
			    List<Nastroj> nastroje = model.getListOfNastroj();

			    for(Nastroj n : nastroje){
				if(n.getId_nastroj()== Integer.parseInt(tfInstrumentId.getText())){
				    ok_n = true;
				    break;
				}
			    }
			}catch(NumberFormatException nfe){
			    JOptionPane.showMessageDialog(AddNastrojToVlastnikDialog.this,
                            "Špatné id: " + tfInstrumentId.getText() + " " + tfOwnerId.getText(),
                            "Chyba",
                            JOptionPane.INFORMATION_MESSAGE);
				dispose();
			    
			    dispose();
			}
			
			
			if(ok_v && ok_n){
			    
	               model.addNastrojToVlastnik(Integer.parseInt(tfInstrumentId.getText()), Integer.parseInt(tfOwnerId.getText()));
		       JOptionPane.showMessageDialog(AddNastrojToVlastnikDialog.this,
                            "Ok",
                            "Záznam úspěšně přidán",
                            JOptionPane.INFORMATION_MESSAGE);
				dispose();
			    
		       dispose();
			}
			else{
			     JOptionPane.showMessageDialog(AddNastrojToVlastnikDialog.this,
                            "Špatné id: " + tfInstrumentId.getText() + " " + tfOwnerId.getText(),
                            "Chyba",
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

    public JTextField getTfInstrumentId() {
	return tfInstrumentId;
    }

    public JTextField getTfOwnerId() {
	return tfOwnerId;
    }

    public JLabel getLbInstrumentId() {
	return lbInstrumentId;
    }

    public JLabel getLbOwnerId() {
	return lbOwnerId;
    }

    public JButton getBtnAdd() {
	return btnAdd;
    }

    public JButton getBtnCancel() {
	return btnCancel;
    }
    
}

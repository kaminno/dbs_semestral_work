package semestralka;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class View extends JFrame{
    Container pane;
    JPanel topPanel;
    JMenuBar menu;
    JTable table;
    JScrollPane scrollPane;
    
    JPanel topPanel2;
    
    DefaultTableModel tableModel;
    
    JPopupMenu rowPopupMenu;
    JMenuItem deleteRow;
    JMenuItem updateRow;
    
    JMenu menuAdd;
    JMenu menuRead;
    JMenu menuRemove;
    JMenu menuUpdate;
    JMenuItem menuAddHudebnik;
    JMenuItem menuAddVlastnik;
    JMenuItem menuReadHudebnik;
    JMenuItem menuReadVlastnik;
    JMenuItem menuRemoveHudebnik;
    JMenuItem menuRemoveVlastnik;
    JMenuItem menuUpdateHudebnik;
    JMenuItem menuUpdateVlastnik;
  
    BorderLayout borderLayout;
    JTextArea textArea;
    JButton btnAdd;
    
    EntityType currentTableType = null;

    public View() throws HeadlessException {
	setSize(1200, 800);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	init();
    }
    
    private void init(){
	pane = getContentPane();
	topPanel = new JPanel();
	borderLayout = new BorderLayout();
	pane.setLayout(borderLayout);
	
	initMenu();
	
	setJMenuBar(menu);
	
	
	textArea = new JTextArea();
	//textArea.setAutoscrolls(true);
	textArea.setEditable(false);
	textArea.setSize(200, 200);
	
	btnAdd = new JButton("Add");
	
	topPanel2 = new JPanel();
	topPanel2.setBackground(Color.blue);
	topPanel2.setPreferredSize(new Dimension(100, 50));
	topPanel2.setVisible(false);
	pane.add(topPanel2, BorderLayout.NORTH);
	
	topPanel.add(btnAdd);
	topPanel.setBackground(Color.red);
	//btnAdd.setVisible(false);
	topPanel.setPreferredSize(new Dimension(100, 50));
	topPanel.setVisible(false);
	pane.add(topPanel, BorderLayout.NORTH);
	pane.add(textArea, BorderLayout.SOUTH);
	textArea.setText("text");
	
	tableModel = new DefaultTableModel();
	table = new JTable(tableModel);
	table.setDefaultEditor(Object.class, null);
	scrollPane = new JScrollPane(table);
	
	rowPopupMenu = new JPopupMenu();
	deleteRow = new JMenuItem("Odstranit");
	rowPopupMenu.add(deleteRow);
	updateRow = new JMenuItem("Upravit");
	rowPopupMenu.add(updateRow);
	
	table.setComponentPopupMenu(rowPopupMenu);
	pane.add(scrollPane, BorderLayout.CENTER);
	
    }
    
    private void initMenu(){
	menu = new JMenuBar();
	
	menuAdd = new JMenu("Přidat");
	menuAddHudebnik = new JMenuItem("Přidat hudebníka");
	menuAdd.add(menuAddHudebnik);
	menuAddVlastnik = new JMenuItem("Přidat vlastníka");
	menuAdd.add(menuAddVlastnik);
	menu.add(menuAdd);
	
	menuRead = new JMenu("Vypsat");
	menuReadHudebnik = new JMenuItem("Vypsat hudebníky");
	menuRead.add(menuReadHudebnik);
	menuReadVlastnik = new JMenuItem("Vypsat vlastníky");
	menuRead.add(menuReadVlastnik);
	menu.add(menuRead);
	
//	menuUpdate = new JMenu("Upravit");
//	menuUpdateHudebnik = new JMenuItem("Upravit hudebníka");
//	menuUpdate.add(menuUpdateHudebnik);
//	menuUpdateVlastnik = new JMenuItem("Upravit vlastníka");
//	menuUpdate.add(menuUpdateVlastnik);
//	menu.add(menuUpdate);
	
	menuRemove = new JMenu("Odstranit");
	menuRemoveHudebnik = new JMenuItem("Odebrat hudebníka");
	menuRemove.add(menuRemoveHudebnik);
	menuRemoveVlastnik = new JMenuItem("Odebrat vlastníka");
	menuRemove.add(menuRemoveVlastnik);
	menu.add(menuRemove);
    }

    public JMenu getMenuRead() {
	return menuRead;
    }

    public JMenuItem getMenuReadHudebnik() {
	return menuReadHudebnik;
    }

    public JMenuBar getMenu() {
	return menu;
    }

    public JMenu getMenuAdd() {
	return menuAdd;
    }

    public JMenuItem getMenuAddHudebnik() {
	return menuAddHudebnik;
    }

    public JPanel getTopPanel() {
	return topPanel;
    }

    public JTextArea getTextArea() {
	return textArea;
    }

    public JButton getBtnAdd() {
	return btnAdd;
    }

    public Container getPane() {
	return pane;
    }

    public BorderLayout getBorderLayout() {
	return borderLayout;
    }
    
    public JPanel getTopPanel2() {
	return topPanel2;
    }

    public JMenuItem getMenuAddVlastnik() {
	return menuAddVlastnik;
    }
    
    public JMenuItem getMenuReadVlastnik() {
	return menuReadVlastnik;
    }

    public JMenu getMenuRemove() {
	return menuRemove;
    }

    public JMenu getMenuUpdate() {
	return menuUpdate;
    }

    public JMenuItem getMenuRemoveHudebnik() {
	return menuRemoveHudebnik;
    }

    public JMenuItem getMenuRemoveVlastnik() {
	return menuRemoveVlastnik;
    }

    public JMenuItem getMenuUpdateHudebnik() {
	return menuUpdateHudebnik;
    }

    public JMenuItem getMenuUpdateVlastnik() {
	return menuUpdateVlastnik;
    }

    public JTable getTable() {
	return table;
    }

    public JScrollPane getScrollPane() {
	return scrollPane;
    }

    public DefaultTableModel getTableModel() {
	return tableModel;
    }

    public JPopupMenu getRowPopupMenu() {
	return rowPopupMenu;
    }

    public JMenuItem getDeleteRow() {
	return deleteRow;
    }

    public JMenuItem getUpdateRow() {
	return updateRow;
    }

    public EntityType getCurrentTableType() {
	return currentTableType;
    }
    
}

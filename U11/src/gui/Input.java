package gui;

import java.awt.Dimension;

import javax.management.relation.RoleStatus;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import matrix.Matrix;

import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input implements ActionListener {

	private JFrame frameIn ;
	private JTable table;
	private JButton btnNew , btnFinish;
	private Object[][] data ;
	private Object[] col ;
	private int Rows,Columns;
	private int matrixNummer;
	DefaultTableModel mod ;
    Set<Character> pressed = new HashSet<Character>();

	public Input(int a ,int Rows, int Columns) {
		matrixNummer = a;
		this.Rows = Rows;
		this.Columns = Columns;
		run();
	}
	private void run(){
		
		Dimension Framesize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = Framesize.width, y = Framesize.height;
		int size = 50;
		frameIn = new JFrame();
		frameIn.getContentPane().setLayout(null);
		
		 col =new Object[Columns];
		for(int i = 0 ; i < col.length ; i ++)
			col[i] = "C" + Integer.toString(i);
		
		
		data = new Object[Rows][Columns];
		
		for(int i = 0 ;i< Rows ; i++)
			for(int j = 0 ; j < Columns; j++)
				data[i][j] = "";
		
		mod = new DefaultTableModel(data, col);
		table = new JTable(mod);
		
		DefaultCellEditor singleclick = new DefaultCellEditor(new JTextField());
	    singleclick.setClickCountToStart(1);
		
		for (int i = 0; i < Columns; i++) {
	        table.setDefaultEditor(table.getColumnClass(i), singleclick);
	    }
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Arial", Font.PLAIN, 18));
		table.setBounds(15, 16, size*Columns,size*Rows);
		for(int i = 0 ; i < col.length ; i ++)
			table.getColumnModel().getColumn(i).setPreferredWidth(size);
		table.setRowHeight(size);
		frameIn.getContentPane().add(table);
		
		btnFinish = new JButton("Finish");
		btnFinish.addActionListener(this);
		btnFinish.setBounds(size*Columns + 50 ,20 ,100, 50);
		frameIn.getContentPane().add(btnFinish);
		
		btnNew = new JButton("New");
		btnNew.addActionListener(this);
		btnNew.setBounds( size*Columns +50, 80  + 50,100, 50);
		frameIn.getContentPane().add(btnNew);
		
		table.getModel().addTableModelListener(new TableModelListener() {
			   @Override
			   public void tableChanged(TableModelEvent e) {
				  data[e.getFirstRow()][e.getColumn()] = table.getModel().getValueAt(e.getFirstRow(), e.getColumn());
			   }
			});
		
		frameIn.setResizable(false);
		frameIn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameIn.setBounds((x- size*Columns+200)/2,(y-size*Rows + 50)/2,size*Columns+200, size*Rows + 150 );
		frameIn.setVisible(true);
		
		MainFrame.window.getFrame().setVisible(false);
	}

	private void rerun(){
		mod.setDataVector(data, col);
		table.setModel(mod);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnFinish){
			MainFrame.window.add(data, matrixNummer);
			if(table.isEditing())
				table.getCellEditor().stopCellEditing();
			MainFrame.window.getFrame().setVisible(true);
			frameIn.setVisible(false);
		}
		else if(e.getSource() == btnNew){
			for(int i = 0 ;i< Rows ; i++)
				for(int j = 0 ; j < Columns; j++)
					data[i][j] = "";
			rerun();
		}
	}
}

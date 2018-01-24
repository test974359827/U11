package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Output {
	private JFrame frameOut ;
	private JTable table;
	private Object[] col ;
	private int Rows,Columns;
	
	DefaultTableModel mod ;
	
	public Output(Object[][] data) {
		Columns = data[0].length;
		Rows = data.length;
		Dimension Framesize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = Framesize.width, y = Framesize.height;
		int size = 50;
		frameOut = new JFrame();
		frameOut.getContentPane().setLayout(null);
		
		 col =new Object[Columns];
			for(int i = 0 ; i < col.length ; i ++)
				col[i] = "C" + Integer.toString(i);
			
		mod = new DefaultTableModel(data, col);
		table = new JTable(mod);
		
		for(int i = 0 ; i < col.length ; i ++)
			table.getColumnModel().getColumn(i).setPreferredWidth(size);
//		for(int i = 0 ; i < Rows ; i ++)
			table.setRowHeight(size);
			
			table.setFont(new Font("Arial", Font.PLAIN, 18));
		table.setBounds(15, 16, size*Columns,size*Rows);
		frameOut.getContentPane().add(table);
		frameOut.setResizable(false);
		frameOut.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOut.setBounds((x- size*Columns+200)/2,(y-size*Rows + 50)/2,size*Columns+200, size*Rows + 150 );
		frameOut.setVisible(true);
	}
}

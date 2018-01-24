package gui;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.jar.Attributes.Name;

import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainFrame implements KeyListener,ActionListener  {

	private JFrame frame;
	private JPanel panel_Input;
	private JButton btnAddFirst,btnAddSecond,btnNeu,btnRechnen;
	private JRadioButton rdbtnTransponse,rdbtnAddiotion, rdbtnMultiplikation,rdbtnMaxOrMin,rdbtnResize;
	private JTextField txtR1,txtC1,txtC2,txtR2;
	private JLabel label_1,label_2,lblRowsCount,lblRows,lblSecondMatrix,lblFirstMatrix;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension Framesize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = Framesize.width, y = Framesize.height;
		
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		panel.setBounds(10, 11, 124, 202);
		frame.getContentPane().add(panel);
		
		panel_Input = new JPanel();
		panel_Input.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_Input.setLayout(null);
		panel_Input.setBounds(144, 11, 295, 202);
		frame.getContentPane().add(panel_Input);
		
		rdbtnAddiotion = new JRadioButton("Addiotion");
		rdbtnAddiotion.addActionListener(this);
		rdbtnAddiotion.setBounds(6, 7, 109, 23);
		rdbtnAddiotion.addKeyListener(this);
		rdbtnAddiotion.setSelected(true);
		panel.add(rdbtnAddiotion);
		
		rdbtnMultiplikation = new JRadioButton("Multiplikation");
		rdbtnMultiplikation.addActionListener(this);
		rdbtnMultiplikation.setBounds(6, 47, 109, 23);
		rdbtnMultiplikation.addKeyListener(this);
		panel.add(rdbtnMultiplikation);
		
		rdbtnTransponse = new JRadioButton("Transponse");
		rdbtnTransponse.addActionListener(this);
		rdbtnTransponse.setBounds(6, 87, 109, 23);
		rdbtnTransponse.addKeyListener(this);
		panel.add(rdbtnTransponse);
		
		rdbtnResize = new JRadioButton("Resize");
		rdbtnResize.addActionListener(this);
		rdbtnResize.setBounds(6, 127, 109, 23);
		rdbtnResize.addKeyListener(this);
		panel.add(rdbtnResize);
		
		rdbtnMaxOrMin = new JRadioButton("Max or Min");
		rdbtnMaxOrMin.addActionListener(this);
		rdbtnMaxOrMin.setBounds(6, 167, 109, 23);
		rdbtnMaxOrMin.addKeyListener(this);
		panel.add(rdbtnMaxOrMin);
		
		ButtonGroup rdbG = new ButtonGroup();
		rdbG.add(rdbtnAddiotion);
		rdbG.add(rdbtnMultiplikation);
		rdbG.add(rdbtnTransponse);
		rdbG.add(rdbtnResize);
		rdbG.add(rdbtnMaxOrMin);
		
		btnRechnen = new JButton("Rechnen");
		btnRechnen.setBounds(449, 11, 89, 45);
		btnRechnen.addKeyListener(this);
		btnRechnen.addActionListener(this);
		frame.getContentPane().add(btnRechnen);
		
		btnNeu = new JButton("Neu");
		btnNeu.setBounds(449, 63, 89, 45);
		btnNeu.addKeyListener(this);
		btnNeu.addActionListener(this);
		frame.getContentPane().add(btnNeu);

		Panel();
		
		frame.setBounds(x/3, y/3, 568, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void addPanel(){
		
		
	}
	
	public void Panel(){
		
		
		String lblString = "Matrix" , btnMatrix = "Add";
		
		lblSecondMatrix = new JLabel("Second Matrix");
		lblSecondMatrix.setBounds(10, 106, 200, 23);
		panel_Input.add(lblSecondMatrix);
		
		btnAddSecond = new JButton(btnMatrix);
		btnAddSecond.setBounds(196, 128, 89, 46);
		btnAddSecond.addActionListener(this);
		panel_Input.add(btnAddSecond);
		
		label_1 = new JLabel("Rows count :");
		label_1.setBounds(24, 132, 68, 14);
		panel_Input.add(label_1);
		
		label_2 = new JLabel("Columnss count :");
		label_2.setBounds(10, 160, 82, 14);
		panel_Input.add(label_2);
		
		txtC2 = new JTextField();
		txtC2.setColumns(10);
		txtC2.setBounds(102, 157, 86, 20);
		panel_Input.add(txtC2);
		
		txtR2 = new JTextField();
		txtR2.setColumns(10);
		txtR2.setBounds(102, 129, 86, 20);
		panel_Input.add(txtR2);
		
		lblFirstMatrix = new JLabel(lblString);
		lblFirstMatrix.setBounds(10, 10, 200, 23);
		panel_Input.add(lblFirstMatrix);
		
		lblRows = new JLabel("Rows count :");
		lblRows.setBounds(20, 35, 68, 14);
		panel_Input.add(lblRows);
		
		lblRowsCount = new JLabel("Columnss count :");
		lblRowsCount.setBounds(6, 63, 82, 14);
		panel_Input.add(lblRowsCount);
		
		txtR1 = new JTextField();
		txtR1.setBounds(98, 32, 86, 20);
		panel_Input.add(txtR1);
		txtR1.setColumns(10);
		
		txtC1 = new JTextField();
		txtC1.setColumns(10);
		txtC1.setBounds(98, 60, 86, 20);
		panel_Input.add(txtC1);
		
		btnAddFirst = new JButton(btnMatrix);
		btnAddFirst.addActionListener(this);
		btnAddFirst.setBounds(196, 31, 89, 46);
		panel_Input.add(btnAddFirst);
		
		
	}
	
	public void change(boolean ob){
		if(!ob){
			lblSecondMatrix.hide();
			btnAddSecond.hide();
			label_1.hide();
			label_2.hide();
			txtC2.hide();
			txtR2.hide();
		}
		else{
			lblSecondMatrix.show();
			btnAddSecond.show();
			label_1.show();
			label_2.show();
			txtC2.show();
			txtR2.show();
		}
	}
	
	public void mulPanel(){
		
	}

	public void tPanel(){
		
	}

	public void momPanel(){
		
	}

	public void resizePanel(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRechnen)
			System.exit(0);//TODO
		else if(e.getSource() == btnNeu)
			System.exit(0);//TODO
		else if(e.getSource() == btnAddFirst)
			System.out.println(1);
		else if(e.getSource() == btnAddSecond)
			System.out.println(1);
		else if(e.getSource() == rdbtnAddiotion)
			change(true);
		else if(e.getSource() == rdbtnMultiplikation)
			change(true);
		else if(e.getSource() == rdbtnTransponse)
			change(false);
		else if(e.getSource() == rdbtnResize)
			change(false);
		else if(e.getSource() == rdbtnMaxOrMin)
			change(false);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'a' )
			addPanel();
		else if(e.getKeyChar() == 'm' )
			mulPanel();
		else if(e.getKeyChar() == 't' )
			tPanel();
		else if(e.getKeyChar() == 'w' )
			momPanel();
		else if(e.getKeyChar() == 'r' )
			resizePanel();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	
}

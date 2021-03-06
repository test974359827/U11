package gui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import matrix.*;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTextField;


/**
 * @author 			Shayan		 Davari fard
 * @author   Mohammadrahim  	 Masoumi
 * @author 			 Arian 		 Tashakkornojehdehi
 * 
 * @version 1
 */
public class MainFrame  implements ActionListener  {

	/**
	 *  Frame for Graphic Interface
	 */
	private JFrame frame;
	
	/**
	 *  f�r Panels in Frame
	 */
	private JPanel panel_Input,panel_2;
	
	/**
	 *  f�r Buttons in Frame and Panels
	 */
	private JButton btnAddFirst,btnAddSecond,btnNeu,btnRechnen;
	
	/**
	 * 	F�r Auswahl der Action 
	 */
	private JRadioButton rdbtnMax,rdbtnMin,rdbtnTransponse,rdbtnAddiotion, rdbtnMultiplikation,rdbtnMaxOrMin,rdbtnResize;
	
	/**
	 *  F�r Texte Eingaben 
	 */
	private JTextField txtR1,txtC1,txtC2,txtR2;
	
	/**
	 * F�r Labels
	 */
	private JLabel label_1,label_2,lblRowsCount,lblRows,lblSecondMatrix,lblFirstMatrix;
	
	/**
	 * 	Instanz f�r Main Frame 
	 */
	public static MainFrame window;
	
	/**
	 * 	SpecherPlatz F�r Matrix 1 und 2 von OutPut Klasse
	 */
	private Object[][] I2 ,I1;
	
	/**
	 * 	f�r GP von RadioButton
	 */
	private ButtonGroup rdbG , RdbF;
	
	/**
	 *  F�r gedruckte Tasten
	 */
	private final Set<Character> pressed = new HashSet<Character>();

	/**
	 * F�r Ergebbnis 
	 */
	private Matrix<Float> mat;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainFrame();
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
	@SuppressWarnings("deprecation")
	private void initialize() {
		Dimension Framesize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = Framesize.width, y = Framesize.height;
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		panel.setBounds(20, 20, 170, 310);
		frame.getContentPane().add(panel);
		
		panel_Input = new JPanel();
		panel_Input.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_Input.setLayout(null);
		panel_Input.setBounds(200, 20, 420, 310);
		frame.getContentPane().add(panel_Input);
		
		rdbtnAddiotion = new JRadioButton("Addiotion");
		rdbtnAddiotion.setFont(new Font("Arial", Font.PLAIN, 18));
		rdbtnAddiotion.addActionListener(this);
		rdbtnAddiotion.setBounds(10, 5, 144, 60);
		rdbtnAddiotion.setSelected(true);
		panel.add(rdbtnAddiotion);
		
		rdbtnMultiplikation = new JRadioButton("Multiplikation");
		rdbtnMultiplikation.setFont(new Font("Arial", Font.PLAIN, 18));
		rdbtnMultiplikation.addActionListener(this);
		rdbtnMultiplikation.setBounds(10, 65, 144, 60);
		panel.add(rdbtnMultiplikation);
		
		rdbtnTransponse = new JRadioButton("Transponse");
		rdbtnTransponse.setFont(new Font("Arial", Font.PLAIN, 18));
		rdbtnTransponse.addActionListener(this);
		rdbtnTransponse.setBounds(10, 125, 144, 60);
		panel.add(rdbtnTransponse);
		
		rdbtnResize = new JRadioButton("Resize");
		rdbtnResize.setFont(new Font("Arial", Font.PLAIN, 18));
		rdbtnResize.addActionListener(this);
		rdbtnResize.setBounds(10, 185, 144, 60);
		panel.add(rdbtnResize);
		
		rdbtnMaxOrMin = new JRadioButton("Max or Min");
		rdbtnMaxOrMin.setFont(new Font("Arial", Font.PLAIN, 18));
		rdbtnMaxOrMin.addActionListener(this);
		rdbtnMaxOrMin.setBounds(10, 245, 144, 60);
		panel.add(rdbtnMaxOrMin);
		
		rdbG = new ButtonGroup();
		rdbG.add(rdbtnAddiotion);
		rdbG.add(rdbtnMultiplikation);
		rdbG.add(rdbtnTransponse);
		rdbG.add(rdbtnResize);
		rdbG.add(rdbtnMaxOrMin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(630, 20, 120, 310);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(null);
		frame.getContentPane().add(panel_1);
		
		btnRechnen = new JButton("Rechnen");
		btnRechnen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRechnen.setSize(100, 60);
		btnRechnen.setLocation(10, 10);
		panel_1.add(btnRechnen);
		
		btnNeu = new JButton("Neu");
		btnNeu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNeu.setSize(100, 60);
		btnNeu.setLocation(10, 80);
		panel_1.add(btnNeu);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 770, 360);
		frame.getContentPane().add(panel_2);
		btnNeu.addActionListener(this);
		btnRechnen.addActionListener(this);

		String lblString = "Matrix" , btnMatrix = "Add";
		String lblR = "Rows count :" , lblC = "Columns count :";
		lblSecondMatrix = new JLabel("Second Matrix");
		lblSecondMatrix.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSecondMatrix.setBounds(15, 173, 200, 23);
		panel_Input.add(lblSecondMatrix);
		
		btnAddSecond = new JButton(btnMatrix);
		btnAddSecond.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAddSecond.setBounds(316, 200, 89, 59);
		btnAddSecond.addActionListener(this);
		panel_Input.add(btnAddSecond);
		
		btnAddFirst = new JButton(btnMatrix);
		btnAddFirst.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAddFirst.addActionListener(this);
		btnAddFirst.setBounds(316, 55, 89, 59);
		panel_Input.add(btnAddFirst);
		
		label_1 = new JLabel(lblR);
		label_1.setFont(new Font("Arial", Font.PLAIN, 18));
		label_1.setBounds(50, 212, 114, 14);
		panel_Input.add(label_1);
		
		label_2 = new JLabel(lblC);
		label_2.setFont(new Font("Arial", Font.PLAIN, 18));
		label_2.setBounds(35, 245, 153, 14);
		panel_Input.add(label_2);
		
		lblFirstMatrix = new JLabel(lblString);
		lblFirstMatrix.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFirstMatrix.setBounds(15, 16, 200, 23);
		panel_Input.add(lblFirstMatrix);
		
		lblRows = new JLabel("Rows count :");
		lblRows.setFont(new Font("Arial", Font.PLAIN, 18));
		lblRows.setBounds(50, 62, 118, 14);
		panel_Input.add(lblRows);
		
		lblRowsCount = new JLabel("Columnss count :");
		lblRowsCount.setFont(new Font("Arial", Font.PLAIN, 18));
		lblRowsCount.setBounds(35, 92, 153, 14);
		panel_Input.add(lblRowsCount);
		
		txtC2 = new JTextField();
		txtC2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtOP(txtC2,e);
			}
		});
		txtC2.setFont(new Font("Arial", Font.PLAIN, 18));
		txtC2.setColumns(10);
		txtC2.setBounds(179, 239, 100, 25);
		panel_Input.add(txtC2);
		
		txtR2 = new JTextField();
		txtR2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
					txtOP(txtR2,e);
			}
		});
		txtR2.setFont(new Font("Arial", Font.PLAIN, 18));
		txtR2.setColumns(10);
		txtR2.setBounds(179, 206, 100, 25);
		panel_Input.add(txtR2);
		
		txtR1 = new JTextField();
		txtR1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtOP(txtR1,e);
			}
		});
		txtR1.setFont(new Font("Arial", Font.PLAIN, 18));
		txtR1.setBounds(183, 55, 100, 25);
		panel_Input.add(txtR1);
		txtR1.setColumns(10);
		
		txtC1 = new JTextField();
		txtC1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtOP(txtC1,e);
			}
		});
		txtC1.setFont(new Font("Arial", Font.PLAIN, 18));
		txtC1.setColumns(10);
		txtC1.setBounds(183, 89, 100, 25);
		panel_Input.add(txtC1);
		
		rdbtnMin = new JRadioButton("Min");
		rdbtnMin.setBounds(118, 146, 80, 29);
		rdbtnMin.setSelected(true);
		panel_Input.add(rdbtnMin);
		
		rdbtnMax = new JRadioButton("Max");
		rdbtnMax.setBounds(225, 146, 155, 29);
		panel_Input.add(rdbtnMax);
		
		RdbF = new ButtonGroup();
		RdbF.add(rdbtnMin);
		RdbF.add(rdbtnMax);
		
		rdbtnMax.hide();
		rdbtnMin.hide();
		
		frame.setBounds((x-776)/2, (y-391)/2, 776, 391);
		frame.setVisible(true);
	}
	
	
	

	/**
	 * F�r Rechnen 
	 */
	public void rechnen(){
		Matrix<Float> mat1 = new Matrix<>(I1.length,I1[0].length, new FloatArithmetic());
		
		for(int i = 0 ;i< I1.length ; i++){
			for(int j = 0 ;j< I1[i].length ; j++){
				mat1.setCell(i, j, (float)ObjectToFloat(I1[i][j]));
			}
		}
		Matrix<Float> mat2 = null ;

		if(rdbtnAddiotion.isSelected()){
			mat2 = new Matrix<>(I2.length,I2[0].length, new FloatArithmetic());
			for(int i = 0 ;i< I2.length ; i++){
				for(int j = 0 ;j< I2[i].length ; j++){
					mat2.setCell(i, j, (float)ObjectToFloat(I2[i][j]));
				}
			}
			if(mat1.getRows() == mat2.getRows() && mat1.getColumns() == mat2.getColumns()){
				mat = new Matrix<Float>(I1.length,I1[0].length, new FloatArithmetic());
				mat = mat1.add(mat2);}
			else
				JOptionPane.showMessageDialog(null, "Error : passen Rows mit einander oder Columns mit einander nicht");
		}
		
		else if(rdbtnMultiplikation.isSelected()){
			mat2 = new Matrix<>(I2.length,I2[0].length, new FloatArithmetic());
			for(int i = 0 ;i< I2.length ; i++){
				for(int j = 0 ;j< I2[i].length ; j++){
					mat2.setCell(i, j, (float)ObjectToFloat(I2[i][j]));
				}
			}
			if(mat1.getColumns() == mat2.getRows()){
			mat = new Matrix<Float>(I1.length,I1[0].length, new FloatArithmetic());
			mat = mat1.mul(mat2);}
			else
				JOptionPane.showMessageDialog(null, "Error : passen Rows von erstem Matrix mit Columns von zweitem Matrix nicht");
		}
		
		
		else if(rdbtnTransponse.isSelected()){
			mat = mat1.transpose();
		}
		
		else if(rdbtnMaxOrMin.isSelected()){
			if(rdbtnMax.isSelected())
				mat = mat1.getMinMax(false);
			else if (rdbtnMin.isSelected())
				mat = mat1.getMinMax(true);
		}
		else if(rdbtnResize.isSelected()){
				mat = mat1.resize(Integer.parseInt(txtR2.getText()), Integer.parseInt(txtC2.getText()));
		}
		
		new Output(MatrixToObject(mat1) , 0);
		if(mat2 != null) new Output(MatrixToObject(mat2) ,1);
		if(mat != null) new Output(MatrixToObject(mat) , 2);
	}
	
	
	/**
	 * f�r Umwandeln von Matrix ins Objekt[][]
	 * 
	 * @param a als Matrix<Float>
	 * @return  temp als Obkect[][] 
	 */
	public Object[][] MatrixToObject(Matrix<Float> a ){
		Object[][] temp = new Object[a.getRows()][a.getColumns()] ;
		for(int i = 0 ;i< a.getRows() ; i++)
			for(int j = 0 ;j< a.getColumns() ; j++){
				temp[i][j] = a.getCell(i, j);
			}
		return temp;
	}
	
	/**
	 * 	f�r Umwandeln von Object in Float
	 * 
	 * @param obj als Object
	 * @return temp als Float
	 */
	private Float ObjectToFloat(Object obj){
		float temp;
		try {
			temp = Float.parseFloat((String)obj);
		} catch (Exception e) {
			temp = 0;
		}
		return temp;
	}

	
	/*
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRechnen)
			rechnen();//TODO
		else if(e.getSource() == btnNeu)
			System.exit(0);//TODO
		else if(e.getSource() == btnAddFirst){
			try {
				Input  M1 = new Input(1,Integer.parseInt(txtR1.getText()), Integer.parseInt(txtC1.getText()));
				I1 = new Object[Integer.parseInt(txtR1.getText())][Integer.parseInt(txtC1.getText())];

			} catch (Exception e2) {
				MSG("Bitte geben Sie eine Zahl ein");
			}
		}
		else if(e.getSource() == btnAddSecond){
			try {
				Input M2 = new Input(2,Integer.parseInt(txtR2.getText()), Integer.parseInt(txtC2.getText()));
				I2 = new Object[Integer.parseInt(txtR2.getText())][Integer.parseInt(txtC2.getText())];

			} catch (Exception e2) {
				MSG("Bitte geben Sie eine Zahl ein");
			}
		}
		else if(e.getSource() == rdbtnAddiotion)
			change(true);
		else if(e.getSource() == rdbtnMultiplikation)
			change(true);
		else if(e.getSource() == rdbtnTransponse)
			change(false);
		else if(e.getSource() == rdbtnResize)
			change2();
		else if(e.getSource() == rdbtnMaxOrMin)
			change3();
	}

	/**
	 *  F�r Hiden oder zeigen den Teilen des Frames abh�ngig von RadioButthon
	 *  
	 * @param ob als Boolean 
	 */
	@SuppressWarnings("deprecation")
	public void change(boolean ob){
		String lblR = "Rows count :" , lblC = "Columns count :";
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
			label_1.setText(lblR);
			label_2.setText(lblC);
			label_1.show();
			label_2.show();
			txtC2.show();
			txtR2.show();
		}
		rdbtnMax.hide();
		rdbtnMin.hide();
	}
	
	/**
	 *  F�r Hiden oder zeigen den Teilen des Frames abh�ngig von RadioButthon
	 */
	@SuppressWarnings("deprecation")
	private void change2() {
		String lblR = "sub Rows :" , lblC = "sub Columns :";
		lblSecondMatrix.hide();
		btnAddSecond.hide();
		label_1.setText(lblR);
		label_2.setText(lblC);
		label_1.show();
		label_2.show();
		txtC2.show();
		txtR2.show();
		rdbtnMax.hide();
		rdbtnMin.hide();
	}
	
	/**
	 *  F�r Hiden oder zeigen den teilen des Frames abh�ngig von RadioButthon
	 */
	@SuppressWarnings("deprecation")
	private void change3() {
		rdbtnMax.show();
		rdbtnMin.show();
		lblSecondMatrix.hide();
		btnAddSecond.hide();
		label_1.hide();
		label_2.hide();
		txtC2.hide();
		txtR2.hide();
	}
	
	/**
	 * F�r TextBox
	 * 
	 * @param TF als JTextField
	 * @param e als KeyEvent
	 */
	private void txtOP(JTextField TF , KeyEvent e){
		pressed.clear();
		pressed.add(e.getKeyChar());
		if(((int)e.getKeyChar() < 43 || (int)e.getKeyChar() > 57) &&
				e.getKeyCode() != KeyEvent.VK_BACK_SPACE &&
				e.getKeyCode() != KeyEvent.VK_ENTER
				){
			try{
				
				String txt = TF.getText();
				char[] c = txt.toCharArray();
				boolean Ja = true;
				String txt2 = new String(c,0,c.length-1+pressed.size());
				TF.setText(txt2);
				int a = 0;
				while( Ja){
					try {
						int a1 = Integer.parseInt(TF.getText());
						Ja = false;
					} catch (Exception e2) {
						a++;
						txt2 = new String(c,0,c.length-a);
						TF.setText(txt2);
					}
				}
			}
			catch (Exception e2){
				TF.setText("");
			}
		}
	}
	
	
	/**
	 * Diese Methode zeigt die Nachrichten in dem GUI an. 
	 * @param a 
	 * 		a enth�lt die Nachricht als String 
	 */
	public void MSG(String a){
		JOptionPane.showMessageDialog(null,a);
	}
	
	/**
	 * getter f�r frame
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	public void add(Object[][] a , int m){
		if(m == 1 )
			I1 = a;
		else if (m == 2 )
			I2 = a;
	}
}

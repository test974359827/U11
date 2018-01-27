package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * @author 			Shayan		 Davari fard
 * @author   Mohammadrahim  	 Masoumi
 * @author 			 Arian 		 Tashakkornojehdehi
 * 
 * @version 1
 */
public class Matrix<T extends Comparable<T>> {
	/**
	 * private Atribut als Arithmetic<T> f¸r das Durchf¸hren von arithmetischen Operationen
	 */
	private Arithmetic<T> arithmetic= null ;
	/**
	 * Private ATribute als LinkedList<LinkedList<t>> enth‰lt die Daten der Matrix und  
	 * repr‰sentiert die‰uﬂere LinkedList die Reihen und die innere LinkedList die Spalten der Matrix
	 */
	private LinkedList<LinkedList<T>> data =new LinkedList<LinkedList<T>>() ; 
	/**
	 *  private Atribute f¸r Speichern der aktuellen Anzahl der Reihen der Matrix
	 */
	private int rows = 0 ; 
	/**
	 * private Atribute f¸r Speichern der aktuellen Anzahl der Spalten der Matrix
	 */
	private int columns = 0 ; 

	
	/**
	 * Konstruktur 
	 * 
	 * @param rows
	 * @param columns
	 * @param arithmetic
	 */
	public Matrix (int rows , int columns , Arithmetic<T> arithmetic){
		this.rows = rows;
		this.columns= columns;
		this.arithmetic = arithmetic;
		
		// Anfangswert ( Alle Zellen = 0 )			
		for(int i = 0 ;i< rows ; i++){
			LinkedList<T> temp = new LinkedList<T>();
			for(int j = 0 ;j< columns ; j++)
				temp.add(arithmetic.zero());
			data.add(temp);
		}
	}
	
	/**
	 * Getter f�r Rows 
	 * 
	 * @return rows als int
	 */
	public int getRows(){
		return data.size();
	}
	
	/**
	 * Getter f�r Columns 
	 * 
	 * @return columns als int
	 */
	public int getColumns(){
		return data.getFirst().size();
	}
	
	
	/**
	 * Getter : gibt den Wert der Zelle zur�ck
	 * 
	 * @param row
	 * @param column
	 * @return gibt den Wert der Zelle zur�ck als T 
	 */
	public T getCell(int row, int column){
		return data.get(row).get(column); 
	}
	
	/**
	 * Setter  f�r gew�nschte Zelle
	 * @param row
	 * @param column
	 * @param Value
	 */
	public void setCell(int row, int col,T Value ){
		LinkedList<T> RowData;
		RowData = data.get(row);
		
		if(RowData.size() <= col)
			RowData.add(Value);
		else
			RowData.set(col, Value);
		
		data.set(row, RowData);

	}
	
	/**
	 * add :gibt das Ergebnis der Addition mit other(@param) zur�ck 
	 * 
	 * @param other
	 * @return ein Matrix<T>
	 */
	public Matrix<T> add(Matrix<T> other){
		Matrix<T> aMatrix = new Matrix<T>(this.getRows(),this.getColumns(),arithmetic);
		
		
		if(sameSize(other)){
			for(int i = 0 ; i < this.getRows() ; i++){
				for(int j = 0 ; j < this.getColumns() ; j++)
				aMatrix.setCell(i, j, arithmetic.add(this.getCell(i, j), other.getCell(i, j)));
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Error: muss gleiche Gro�e haben");
		return aMatrix;
	}
	
	/**
	 * mul : die gibt das Ergebnis der Multiplikation mit other(@param) zur¸ck
	 * 
	 * @param other als Matrix<T>
	 * @return ein Matrix<T>
	 */
	public Matrix<T> mul(Matrix<T> other){
		
		Matrix<T> mMatrix = new Matrix<T>(this.getRows(),other.getColumns(),arithmetic);
		
//		
		if(obMul(other)){
			for(int i = 0 ;i< rows ; i++){
				for(int j = 0 ;j< other.getColumns() ; j++){
					Matrix<T> mTemp = new Matrix<T>(1,1,arithmetic);
					for(int x = 0 ; x < other.getRows() ; x++)
						mTemp.setCell(0, 0, arithmetic.add(mMatrix.getCell(i, j), arithmetic.mul(this.getCell(i, x), other.getCell(x, j))));
					mMatrix.setCell(i, j, mTemp.getCell(0, 0));
				}
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Error: muss Columns von 1 mit Rows von 2 gleich sein");
		
		return mMatrix;
	}
	
	/**
	 * transpose : Diese bildet die transponierte Matrix zur aktuellen Matrix und gibt diese zur¸ck
	 * 
	 * @return ein Matrix<T>
	 */
	public Matrix<T> transpose(){
		Matrix<T> tMatrix = new Matrix<T>(this.getColumns(),this.getRows(),arithmetic) ;
		for(int i = 0 ; i < this.getRows() ; i++){
			for(int j = 0 ; j < this.getColumns() ; j++){
				tMatrix.setCell(j, i, data.get(i).get(j));
			
			}
		}
		return tMatrix;
	}
	
	/**
	 * getMinMax : gibt entweder den grˆﬂten oder den kleinsten Wert der Matrix zur�ck. 
	 * Ist der Boolean min(@param) true soll der kleinste Wert der Matrix zur¸ckgegeben werden
	 * 
	 * @param min als Boolean
	 * @return ein Matrix<T>
	 */
	public Matrix<T> getMinMax(boolean min){
		List<T> temp = new ArrayList<T>();
		for(int i = 0 ; i < this.getRows() ; i++){
			for(int j = 0 ; j < this.getColumns() ; j++)
				temp.add(this.getCell(i, j));
		}
		Collections.sort(temp);
		Matrix<T> tempMatrix = new Matrix<T>(1,1,arithmetic);
		if(min)
			tempMatrix.setCell(0, 0, temp.get(0));
		else
			tempMatrix.setCell(0, 0, temp.get(temp.size()-1));
		return tempMatrix;
	}

	/**
	 * resize : die gibt eine neue Matrix mit entsprechend ver‰nderter Grˆﬂe zur¸ck
	 * 
	 * @param rows als int
	 * @param columns als int
	 * @return ein Matrix<T>
	 */
	public Matrix<T> resize(int rows, int columns){
		if(this.rows + rows <= 0)
			return null;
		if(this.columns + columns <= 0)
			return null;
		Matrix<T> rMatrix = new Matrix<T>(this.rows + rows,this.columns + columns,arithmetic);
		
		for(int i = 0 ; i < this.rows + rows ; i++){
			for(int j = 0 ; j < this.columns + columns ; j++){
				if(this.rows > i && this.columns > j)
					rMatrix.setCell(i, j, this.getCell(i, j));
				else
					rMatrix.setCell(i, j, arithmetic.zero());
			}
		}
		return rMatrix;
	}
	
	
	/**
	 * 	es �berpr�ft, ob Rows von diese Matrix und von �bergabe zusammen und auch Columns von diese Matrix und von �bergabe zusammen gleich sind oder nicht 
	 * @param b
	 * @return boolean 
	 */
	public boolean sameSize(Matrix<T> b){
		return (getRows() == b.getRows() && getColumns() == b.getColumns());
	}
	
	/**
	 *  es �berpr�ft, ob Columns von diese Matrix mit Rows von �ber gabe gleich sind oder nicht
	 * @param b
	 * @return
	 */
	public boolean obMul(Matrix<T> b){
		return (getColumns() == b.getRows());
	}
}

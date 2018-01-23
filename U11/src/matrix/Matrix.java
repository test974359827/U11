package matrix;

import java.util.LinkedList;

/**
 * 
 *  @author Shayan 			Davari Fard
 *	@author Mohamadrahim    Masumi
 * @param <T>
 */
public class Matrix<T extends Comparable<T>> {
	/**
	 * private Atribut als Arithmetic<T> f�r das Durchf�hren von arithmetischen Operationen
	 */
	private Arithmetic<T> arithmetic= null ;
	/**
	 * Private ATribute als LinkedList<LinkedList<t>> enth�lt die Daten der Matrix und  
	 * repr�sentiert die�u�ere LinkedList die Reihen und die innere LinkedList die Spalten der Matrix
	 */
	private LinkedList<LinkedList<T>> data = null ; 
	/**
	 *  private Atribute f�r Speichern der aktuellen Anzahl der Reihen der Matrix
	 */
	private int rows = 0 ; 
	/**
	 * private Atribute f�r Speichern der aktuellen Anzahl der Spalten der Matrix
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
		//TODO
	}
	
	/**
	 * Getter f�r Rows 
	 * 
	 * @return rows als int
	 */
	public int getRows(){
		return rows;
	}
	
	/**
	 * Getter f�r Columns 
	 * 
	 * @return columns als int
	 */
	public int getColumns(){
		return columns; 
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
	 * Setter 
	 * @param row
	 * @param column
	 * @param Value
	 */
	public void setCell(int row, int column,T Value ){
		LinkedList<T> RowData =data.get(row);
		RowData.set(column, Value);
		data.set(row, RowData);
	}
	
	/**
	 * add :gibt das Ergebnis der Addition mit other(@param) zur�ck 
	 * 
	 * @param other
	 * @return
	 */
	public Matrix<T> add(Matrix<T> other){
		
		return null;
	}
	
	/**
	 * mul : die gibt das Ergebnis der Multiplikation mit other(@param) zur�ck
	 * 
	 * @param other
	 * @return
	 */
	public Matrix<T> mul(Matrix<T> other){
		
		return null;
	}
	
	/**
	 * transpose : Diese bildet die transponierte Matrix zur aktuellen Matrix und gibt diese zur�ck
	 * 
	 * @return
	 */
	public Matrix<T> transpose(){
		
		return null;
	}
	
	/**
	 * getMinMax : gibt entweder den gr��ten oder den kleinsten Wert der Matrix zur�ck. 
	 * Ist der Boolean min(@param) true soll der kleinste Wert der Matrix zur�ckgegeben werden
	 * 
	 * @param min
	 * @return
	 */
	public Matrix<T> getMinMax(boolean min){
		
		return null;
	}

	/**
	 * resize : die gibt eine neue Matrix mit entsprechend ver�nderter Gr��e zur�ck
	 * 
	 * @param rows
	 * @param columns
	 * @return
	 */
	public Matrix<T> resize(int rows, int columns){
		
		return null;
	}
}

















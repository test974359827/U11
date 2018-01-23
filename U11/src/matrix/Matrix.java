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
		return data.get(row).get(column); //TODO
	}
	
	/**
	 * Setter 
	 * @param row
	 * @param column
	 * @param Value
	 */
	public void setCell(int row, int column,T Value ){
		LinkedList<LinkedList<T>> TempDate = null ; 
		for(int i = 0 ; i < data.g)
		}
	
}

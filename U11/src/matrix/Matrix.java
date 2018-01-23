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
	 * private Atribut als Arithmetic<T> für das Durchführen von arithmetischen Operationen
	 */
	private Arithmetic<T> arithmetic= null ;
	/**
	 * Private ATribute als LinkedList<LinkedList<t>> enthält die Daten der Matrix und  
	 * repräsentiert dieäußere LinkedList die Reihen und die innere LinkedList die Spalten der Matrix
	 */
	private LinkedList<LinkedList<T>> data = null ; 
	/**
	 *  private Atribute für Speichern der aktuellen Anzahl der Reihen der Matrix
	 */
	private int rows = 0 ; 
	/**
	 * private Atribute für Speichern der aktuellen Anzahl der Spalten der Matrix
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
	 * Getter für Rows 
	 * 
	 * @return rows als int
	 */
	public int getRows(){
		return rows;
	}
	
	/**
	 * Getter für Columns 
	 * 
	 * @return columns als int
	 */
	public int getColumns(){
		return columns; 
	}
	
	/**
	 * Getter : gibt den Wert der Zelle zurück
	 * 
	 * @param row
	 * @param column
	 * @return gibt den Wert der Zelle zurück als T 
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

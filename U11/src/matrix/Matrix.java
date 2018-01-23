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
	 * add :gibt das Ergebnis der Addition mit other(@param) zurück 
	 * 
	 * @param other
	 * @return
	 */
	public Matrix<T> add(Matrix<T> other){
		
		return null;
	}
	
	/**
	 * mul : die gibt das Ergebnis der Multiplikation mit other(@param) zurück
	 * 
	 * @param other
	 * @return
	 */
	public Matrix<T> mul(Matrix<T> other){
		
		return null;
	}
	
	/**
	 * transpose : Diese bildet die transponierte Matrix zur aktuellen Matrix und gibt diese zurück
	 * 
	 * @return
	 */
	public Matrix<T> transpose(){
		
		return null;
	}
	
	/**
	 * getMinMax : gibt entweder den größten oder den kleinsten Wert der Matrix zurück. 
	 * Ist der Boolean min(@param) true soll der kleinste Wert der Matrix zurückgegeben werden
	 * 
	 * @param min
	 * @return
	 */
	public Matrix<T> getMinMax(boolean min){
		
		return null;
	}

	/**
	 * resize : die gibt eine neue Matrix mit entsprechend veränderter Größe zurück
	 * 
	 * @param rows
	 * @param columns
	 * @return
	 */
	public Matrix<T> resize(int rows, int columns){
		
		return null;
	}
}

















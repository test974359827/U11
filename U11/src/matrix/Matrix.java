package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
	}
	
	/**
	 * Getter f¸r Rows 
	 * 
	 * @return rows als int
	 */
	public int getRows(){
		return rows;
	}
	
	/**
	 * Getter f¸r Columns 
	 * 
	 * @return columns als int
	 */
	public int getColumns(){
		return columns;
	}
	
	/**
	 * Getter : gibt den Wert der Zelle zur¸ck
	 * 
	 * @param row
	 * @param column
	 * @return gibt den Wert der Zelle zur¸ck als T 
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
	public void setCell(int row, int col,T Value ){
		if(data.size() == 0){
			LinkedList<T> temp = new LinkedList<T>();
			for(int i = 0 ;i< rows ; i++){
				for(int j = 0 ;j< columns ; j++)
					temp.add(arithmetic.zero());
				data.add(new LinkedList<T>());
			}
		}
		
		LinkedList<T> RowData;
		RowData = data.get(row);
		
		if(RowData.size() <= col)
			RowData.add(Value);
		else
			RowData.set(col, Value);
		
		data.set(row, RowData);

	}
	
	/**
	 * add :gibt das Ergebnis der Addition mit other(@param) zur¸ck 
	 * 
	 * @param other
	 * @return
	 */
	public Matrix<T> add(Matrix<T> other){
		Matrix<T> aMatrix = new Matrix<T>(this.getRows(),this.getColumns(),arithmetic);
		if(sameSize(this, other)){
			for(int i = 0 ; i < this.getRows() ; i++){
				for(int j = 0 ; j < this.getColumns() ; j++)
				aMatrix.setCell(i, j, arithmetic.add(this.getCell(i, j), other.getCell(i, j)));
			}
		}
		return aMatrix;
	}
	
	/**
	 * mul : die gibt das Ergebnis der Multiplikation mit other(@param) zur¸ck
	 * 
	 * @param other
	 * @return
	 */
	public Matrix<T> mul(Matrix<T> other){
		Matrix<T> mMatrix = new Matrix<T>(this.getRows(),other.getColumns(),arithmetic);
		if(obMul(this, other)){
			for(int i = 0 ; i < this.getRows() ; i++){
				for(int j = 0 ; j < other.getColumns() ; j++){
					mMatrix.setCell(i, j, arithmetic.zero());
					for(int x = 0 ; x < other.getRows() ; x++)
						mMatrix.setCell(i, j, arithmetic.add(mMatrix.getCell(i, j), arithmetic.mul(this.getCell(i, x), other.getCell(x, j))));
				}
			}
		}
		
		return mMatrix;
	}
	
	/**
	 * transpose : Diese bildet die transponierte Matrix zur aktuellen Matrix und gibt diese zur¸ck
	 * 
	 * @return
	 */
	public Matrix<T> transpose(){
		System.out.println(this.getColumns());
		Matrix<T> tMatrix = new Matrix<T>(this.getColumns(),this.getRows(),arithmetic) ;
		for(int i = 0 ; i < this.getRows() ; i++){
			for(int j = 0 ; j < this.getColumns() ; j++){
			System.out.println("i : "+ i + " j " + j + "       "+tMatrix.getRows());
				tMatrix.setCell(j, i, data.get(j).get(i));
				System.out.println("ok");
			
			}
		}
		return tMatrix;
	}
	
	/**
	 * getMinMax : gibt entweder den grˆﬂten oder den kleinsten Wert der Matrix zur¸ck. 
	 * Ist der Boolean min(@param) true soll der kleinste Wert der Matrix zur¸ckgegeben werden
	 * 
	 * @param min
	 * @return
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
	 * @param rows
	 * @param columns
	 * @return
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
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean sameSize(Matrix<T> a,Matrix<T> b){
		return (a.getRows() == b.getRows() && a.getColumns() == b.getColumns());
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean obMul(Matrix<T> a,Matrix<T> b){
		return (a.getColumns() == b.getRows());
	}
}

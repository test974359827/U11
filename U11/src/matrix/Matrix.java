package matrix;

import java.util.LinkedList;

public class Matrix<T extends Comparable<T>> {
	/**
	 * private Atribut als Arithmetic<T> f�r das Durchf�hren von arithmetischen Operationen
	 */
	private Arithmetic<T> arithmetic= null ;
	/**
	 * Private ATribute als LinkedList<LinkedList<t>> enth�lt die Daten der Matrix und  repr�sentiert die�u�ere LinkedList die Reihen und die innere LinkedList die Spalten der Matrix
													//
	 */
	private LinkedList<LinkedList<T>> data = null ; 
	/**
	 * 
	 */
	private int rows = 0 ; 
	/**
	 * 
	 */
	private int columns = 0 ; 

}

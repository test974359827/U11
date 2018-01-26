package matrix;
/**
 * @author       Shayan     Davari fard
 * @author   Mohammadrahim     Masoumi
 * @author        Arian      Tashakkornojehdehi
 * 
 * @version 1
 */

import static org.junit.Assert.assertEquals;

import org.junit.Assert.*;
import org.junit.Test;

public class TestStudent {

	Matrix<Integer> matrix1;
	Matrix<Integer> matrix2;
	Matrix<Integer> matrix3;
	Matrix<Integer> matrix4= new Matrix<Integer>(3, 5, new IntegerArithmetic());
	Matrix<Integer> matrix5= new Matrix<Integer>(5, 3, new IntegerArithmetic());
	Matrix<Integer> matrix6= new Matrix<Integer>(3, 1, new IntegerArithmetic());

	
	@Test
	public void MatrixTest(){
		
		Matrix<Integer> matrix1= new Matrix<Integer>(3, 10, new IntegerArithmetic());
		Matrix<Integer> matrix2= new Matrix<Integer>(4, 1, new IntegerArithmetic());
		
		assertEquals(3, matrix1.getRows());
		assertEquals(10, matrix1.getColumns());
		assertEquals(4, matrix2.getRows());
		assertEquals(1, matrix2.getColumns());
		

	}
	
	@Test
	public void getCellTest() {
		
		Matrix<Integer> matrix1= new Matrix<Integer>(10, 5, new IntegerArithmetic());
		
		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				assertEquals(new Integer(0), matrix1.getCell(i,j));
		

		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				matrix1.setCell(i, j, i + j);
		
		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				assertEquals(new Integer(i+j), matrix1.getCell(i,j));
		
	}
	
	@Test
    public void setCellTest() {
		
		Matrix<Integer> matrix1= new Matrix<Integer>(10, 5, new IntegerArithmetic());
		
		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				assertEquals(new Integer(0), matrix1.getCell(i,j));
		

		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				matrix1.setCell(i, j, i + j);
		
		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				assertEquals(new Integer(i+j), matrix1.getCell(i,j));
	}
    
	@Test
    public void addTest() {
		Matrix<Integer> matrix1= new Matrix<Integer>(3, 10, new IntegerArithmetic());
		Matrix<Integer> matrix2= new Matrix<Integer>(3, 10, new IntegerArithmetic());
		Matrix<Integer> matrix3= new Matrix<Integer>(4, 1, new IntegerArithmetic());;
		
		assertEquals(false, matrix1.sameSize(matrix3));
		assertEquals(false, matrix2.sameSize(matrix3));
		assertEquals(true, matrix1.sameSize(matrix2));
		
		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				matrix1.setCell(i, j, (i + j)*2  );
		
		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				matrix2.setCell(i, j, i);
		
		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				assertEquals(new Integer(3*i + j * 2), matrix1.add(matrix2).getCell(i,j));
		
	}
	
	@Test
    public void mulTest() {
    	
		Matrix<Integer> matrix1= new Matrix<Integer>(3, 3, new IntegerArithmetic());
		Matrix<Integer> matrix2= new Matrix<Integer>(3, 2, new IntegerArithmetic());
		Matrix<Integer> matrix3= new Matrix<Integer>(1, 4, new IntegerArithmetic());;
		
		assertEquals(false, matrix1.obMul(matrix3));
		assertEquals(false, matrix2.obMul(matrix3));
		assertEquals(true, matrix1.obMul(matrix2));
		
		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				matrix1.setCell(i, j, i  );
		
		for(int i= 0 ; i < matrix2.getRows() ;i++)
			for(int j= 0 ; j < matrix2.getColumns() ;j++)
				matrix2.setCell(i, j, 2);
 		
		
		Matrix<Integer> matrix4= new Matrix<Integer>(3, 2, new IntegerArithmetic());
		matrix4 = matrix1.mul(matrix2);
		for(int i= 0 ; i < matrix4.getRows() ;i++)
			for(int j= 0 ; j < matrix4.getColumns() ;j++)
				assertEquals(new Integer(i*2), matrix4.getCell(i,j));
		
		
	}
	
	@Test
    public void transposeTest() {
		
		
		Matrix<Integer> matrix1= new Matrix<Integer>(40, 40, new IntegerArithmetic());
		Matrix<Integer> matrix2;

		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				matrix1.setCell(i, j, i + j );
		
		matrix2 = matrix1.transpose();
 		
		for(int i= 0 ; i < matrix2.getRows() ;i++)
			for(int j= 0 ; j < matrix2.getColumns() ;j++)
				assertEquals(new Integer(i+j), matrix2.getCell(j,i));
    	
    	
    }
	
	@Test
    public void getMinMaxTest() {
		Matrix<Integer> matrix1= new Matrix<Integer>(3, 10, new IntegerArithmetic());

		for(int i= 1 ; i <= matrix1.getRows() ;i++)
			for(int j= 1 ; j <= matrix1.getColumns() ;j++)
				matrix1.setCell(i-1, j-1, i + j);

		assertEquals(new Integer(matrix1.getRows()+matrix1.getColumns() ), matrix1.getMinMax(false).getCell(0, 0));
		assertEquals(new Integer(2), matrix1.getMinMax(true).getCell(0, 0));

			

    	
    }
    
	
	@Test
    public void resizeTest() {
		
		Matrix<Integer> matrix1= new Matrix<Integer>(40, 140, new IntegerArithmetic());
		Matrix<Integer> matrix2;

		for(int i= 0 ; i < matrix1.getRows() ;i++)
			for(int j= 0 ; j < matrix1.getColumns() ;j++)
				matrix1.setCell(i, j, i + j );
		
		matrix2 = matrix1.resize(-10, -100);
 		
		assertEquals(30, matrix2.getRows());
		assertEquals(40, matrix2.getColumns());
		matrix2 = matrix2.resize(-1, 15);
		assertEquals(29, matrix2.getRows());
		assertEquals(55, matrix2.getColumns());
    }
	
}
	
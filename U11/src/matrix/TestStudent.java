package matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Assert.*;
import org.junit.Test;

public class TestStudent {

	Matrix<Integer> matrix1= new Matrix<Integer>(2, 2, new IntegerArithmetic());
	Matrix<Integer> matrix2= new Matrix<Integer>(2, 2, new IntegerArithmetic());
	Matrix<Integer> matrix3= new Matrix<Integer>(2, 2, new IntegerArithmetic());

	
	
	
	
	
	@Test
	public void MatrixTest(){
		
		Matrix<Integer> mat1= new Matrix<Integer>(2, 2, new IntegerArithmetic());
		Matrix<Integer> mat2= new Matrix<Integer>(2, 2, new IntegerArithmetic());

		assertEquals(mat1, mat2);

		matrix1.setCell(0, 0,1 );
		matrix1.setCell(0, 1,2 );
		matrix1.setCell(1, 0,3 );
		matrix1.setCell(1, 1,4 );
		
		
		

	}
	
	@Test
	public void getCellTest() {
		
		matrix1.setCell(0, 0,1 );
		matrix1.setCell(0, 1,2 );
		matrix1.setCell(1, 0,3 );
		matrix1.setCell(1, 1,4 );
		assertEquals(new Integer(1), matrix1.getCell(0,0));
		assertEquals(new Integer(4), matrix1.getCell(1,1));
		
		
	}
	
	@Test
    public void setCellTest() {
		matrix1.setCell(0, 0,1 );
		matrix1.setCell(0, 1,2 );
		matrix1.setCell(1, 0,3 );
		matrix1.setCell(1, 1,4 );
    	
    	assertEquals( new Integer(4), matrix1.getCell(1,1));
	}
    
	@Test
    public void addTest() {
    	    matrix1.setCell(0, 0,1 );
		matrix1.setCell(0, 1,2 );
		matrix1.setCell(1, 0,3 );
		matrix1.setCell(1, 1,4 );
		
		matrix2.setCell(0, 0,4 );
		matrix2.setCell(0, 1,3 );
		matrix2.setCell(1, 0,1 );
		matrix2.setCell(1, 1,0 );
		
		matrix3.setCell(0, 0, 5);
		matrix3.setCell(0, 1, 5);
		matrix3.setCell(1, 0, 4);
		matrix3.setCell(1, 1, 4);

		assertEquals(matrix3, matrix1.add(matrix2));
    	
    	
		
	}
	
	@Test
    public void mulTest() {
    	
    	matrix1.setCell(0, 0,1 );
 		matrix1.setCell(0, 1,2 );
 		matrix1.setCell(1, 0,3 );
 		matrix1.setCell(1, 1,4 );
 		
 		matrix2.setCell(0, 0,4 );
 		matrix2.setCell(0, 1,3 );
 		matrix2.setCell(1, 0,1 );
 		matrix2.setCell(1, 1,0 );
 		
 		matrix3.setCell(0, 0, 5);
 		matrix3.setCell(0, 1, 5);
 		matrix3.setCell(1, 0, 4);
 		matrix3.setCell(1, 1, 4);
	}
	
	@Test
    public void transposeTest() {
    	
    	
    }
	
	@Test
    public void getMinMaxTest() {
    	
    	
    }
    
	
	@Test
    public void resizeTest() {
    	
    	
    }
	
}
	
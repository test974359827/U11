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

	Matrix<Integer> matrix1= new Matrix<Integer>(2, 2, new IntegerArithmetic());
	Matrix<Integer> matrix2= new Matrix<Integer>(2, 2, new IntegerArithmetic());
	Matrix<Integer> matrix3= new Matrix<Integer>(2, 2, new IntegerArithmetic());
	Matrix<Integer> matrix4= new Matrix<Integer>(2, 3, new IntegerArithmetic());
	Matrix<Integer> matrix5= new Matrix<Integer>(3, 2, new IntegerArithmetic());
	Matrix<Integer> matrix6= new Matrix<Integer>(3, 1, new IntegerArithmetic());



	
	
	
	
	
	@Test
	public void MatrixTest(){
		
		

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
 		
 		matrix3.setCell(0, 0, 6);
 		matrix3.setCell(0, 1, 3);
 		matrix3.setCell(1, 0, 16);
 		matrix3.setCell(1, 1, 9);
 		
		assertEquals(matrix3, matrix1.mul(matrix2));

	}
	
	@Test
    public void transposeTest() {
		matrix4.setCell(0, 0,1 );
 		matrix4.setCell(0, 1,2 );
 		matrix4.setCell(0, 2,2 );
 		matrix4.setCell(1, 0,3 );
 		matrix4.setCell(1, 1,4 );
 		matrix4.setCell(1, 1,5 );
 		
		matrix5.setCell(0, 0,1 );
 		matrix5.setCell(0, 1,3 );
 		matrix5.setCell(1, 0,2 );
 		matrix5.setCell(1, 1,4 );
 		matrix5.setCell(2, 0,2 );
 		matrix5.setCell(2, 1,5 );
 		
 		
		assertEquals(matrix5, matrix4.transpose());

    	
    	
    }
	
	@Test
    public void getMinMaxTest() {
		
		    matrix1.setCell(0, 0,1 );
			matrix1.setCell(0, 1,2 );
			matrix1.setCell(1, 0,3 );
			matrix1.setCell(1, 1,4 );
		
			assertEquals(new Integer(4), matrix1.getMinMax(false));
			assertEquals(new Integer(1), matrix1.getMinMax(true));

			

    	
    }
    
	
	@Test
    public void resizeTest() {
		
		    matrix1.setCell(0, 0,1 );
			matrix1.setCell(0, 1,2 );
			matrix1.setCell(1, 0,3 );
			matrix1.setCell(1, 1,4 );
			
		//	matrix6= matrix1.resize(1, -1);
			matrix6.setCell(0, 0,1);
			matrix1.setCell(1, 0,3 );
			matrix1.setCell(2, 0,0 );
    	
			assertEquals(matrix6, matrix1.resize(1, -1));

			
    }
	
}
	
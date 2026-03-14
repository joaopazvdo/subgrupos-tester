package operacao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OperacaoMatrizesTest {

	@Test
	void testOperadorEqualsMultiplicacaoTrue() {
		OperacaoMatrizes om = OperacaoMatrizes.MULTIPLICACAO;
		assertTrue(om.operadorEquals("*"));
	}
	
	@Test
	void testOperadorEqualsMultiplicacaoFalse() {
		OperacaoMatrizes om = OperacaoMatrizes.MULTIPLICACAO;
		assertFalse(om.operadorEquals("+"));
	}
	
	@Test
	void testOperadorEqualsAdicaoTrue() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		assertTrue(om.operadorEquals("+"));
	}
	
	@Test
	void testOperadorEqualsAdicaoFalse() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		assertFalse(om.operadorEquals("*"));
	}

	@Test
	void testGetIdentidadeMultiplicao() {
		OperacaoMatrizes om = OperacaoMatrizes.MULTIPLICACAO;
		Double[][] elemento = {{3.0, 1.0}, 
							   {2.0, 3.0}};
		Double[][] res = {{1.0, 0.0}, 
						 {0.0, 1.0}};
		assertArrayEquals(res, om.getIdentidade(elemento));
	}
	
	@Test
	void testGetIdentidadeAdicao() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		Double[][] elemento = {{3.0, 1.0}, 
				   		      {2.0, 3.0}};
		Double[][] res = {{0.0, 0.0}, 
				 		 {0.0, 0.0}};
		assertEquals(res, om.getIdentidade(elemento));
	}
	
	@Test
	void testFazMultiplicacao() {
		OperacaoMatrizes om = OperacaoMatrizes.MULTIPLICACAO;
		Double[][] v1 = {
	            {1.5, 2.0},
	            {3.0, 4.5}
	        };

	     Double[][] v2 = {
	            {5.0, 1.0},
	            {2.0, 3.0}
	        };
	     
	     Double[][] res = {{11.5, 7.5}, 
	                       {24.0, 16.5}};
	     assertArrayEquals(res, om.faz(v1, v2));
	}
	
	
	//Falta fazer
	@Test
	void testFazAdicao() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		double v1 = 1.1;
		double v2 = 1.5;
		assertEquals(v1 + v2, om.faz(v1, v2));
	}

	@Test
	void testVerificaTamMatrizez() {
		fail("Not yet implemented");
	}

	@Test
	void testVerificaMatrizQuadrada() {
		
	}
}

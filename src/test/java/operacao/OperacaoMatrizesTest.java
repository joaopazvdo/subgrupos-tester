package operacao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	void testGetIdentidadeMultiplicaoComOperacao() {
		OperacaoMatrizes om = OperacaoMatrizes.MULTIPLICACAO;
		Double[][] elemento = {{3.0, 1.0}, 
							   {2.0, 3.0}};
		Double[][] identidade = om.getIdentidade(elemento);
		assertArrayEquals(elemento, om.faz(elemento, identidade));
	}
	
	@Test
	void testGetIdentidadeAdicao() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		Double[][] elemento = {{3.0, 1.0}, 
				   		      {2.0, 3.0}};
		Double[][] res = {{0.0, 0.0}, 
				 		 {0.0, 0.0}};
		assertArrayEquals(res, om.getIdentidade(elemento));
	}
	
	@Test
	void testGetIdentidadeAdicaoComOperacao() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		Double[][] elemento = {{3.0, 1.0}, 
				   		      {2.0, 3.0}};
		Double[][] identidade = om.getIdentidade(elemento);
		assertArrayEquals(elemento, om.faz(elemento, identidade));
	}
	
	@Test
	void testFazMultiplicacao() {
		OperacaoMatrizes om = OperacaoMatrizes.MULTIPLICACAO;
		Double[][] v1 = {{1.5, 2.0},
	                     {3.0, 4.5}
	        };

	     Double[][] v2 = {{5.0, 1.0},
	    		 		  {2.0, 3.0}
	        };
	     
	     Double[][] res = {{11.5, 7.5}, 
	                       {24.0, 16.5}};
	     assertArrayEquals(res, om.faz(v1, v2));
	}
	
	@Test
	void testFazMultiplicacaoMudaOrdemOperadores() {
		OperacaoMatrizes om = OperacaoMatrizes.MULTIPLICACAO;
		Double[][] v1 = {
	            {1.5, 2.0},
	            {3.0, 4.5}
	        };

	     Double[][] v2 = {
	            {5.0, 1.0},
	            {2.0, 3.0}
	        };
	     
	     Double[][] res = {{10.5, 14.5}, 
	                       {12.0, 17.5}};
	     
	     assertArrayEquals(res, om.faz(v2, v1));
	}
	
	
	@Test
	void testFazAdicao() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		Double[][] v1 = {
	            {1.5, 2.0},
	            {3.0, 4.5}
	        };

	     Double[][] v2 = {
	            {5.0, 1.0},
	            {2.0, 3.0}
	        };
	     Double[][] res = {
	    		 	{6.5, 3.0},
	    		 	{5.0, 7.5}
	     };
	     assertArrayEquals(res, om.faz(v1, v2));
	}
	
	@Test
	void testFazAdicaoMatrizSemColunas() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		Double[][] v1 = {
	            {1.5, 2.0},
	            {3.0, 4.5}
	        };

	     Double[][] v2 = {
	            {},
	            {}
	        };
	     assertThrows(NullPointerException.class, () -> {om.faz(v1, v2);});
	}
	
	@Test
	void testFazAdicaoMatrizSemLinhas() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		Double[][] v1 = {
	            {1.5, 2.0},
	            {3.0, 4.5}
	        };

	     Double[][] v2 = {
	        };
	     assertThrows(ArrayIndexOutOfBoundsException.class, () -> {om.faz(v1, v2);});
	}
	
	@Test
	void testFazAdicaoTrocaOrdem() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		Double[][] v1 = {
	            {1.5, 2.0},
	            {3.0, 4.5}
	        };

	     Double[][] v2 = {
	            {5.0, 1.0},
	            {2.0, 3.0}
	        };
	     
	     Double[][] res = {
	    		 	{6.5, 3.0},
	    		 	{5.0, 7.5}
	     };
	     assertArrayEquals(res, om.faz(v2, v1));
	}

	@Test
	void testVerificaTamMatrizez() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		Double[][] v1 = {
	            {1.5, 2.0},
	            {3.0, 4.5}
	        };

	     Double[][] v2 = {
	            {5.0, 1.0},
	        };
	     
	     assertThrows(IllegalArgumentException.class, () -> {om.verificaTamMatrizez(v1, v2);});
	}

	@Test
	void testVerificaMatrizQuadrada() {
		OperacaoMatrizes om = OperacaoMatrizes.SOMA;
		 Double[][] v1 = {
		            {5.0, 1.0},
		        };
		     
		 assertThrows(IllegalArgumentException.class, () -> {om.verificaMatrizQuadrada(v1);});
	}
}

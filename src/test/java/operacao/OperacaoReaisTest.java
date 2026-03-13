package operacao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OperacaoReaisTest {

	@Test
	void testOperadorEqualsMultiplicacaoTrue() {
		OperacaoReais or = OperacaoReais.MULTIPLICACAO;
		assertTrue(or.operadorEquals("*"));
	}
	
	@Test
	void testOperadorEqualsMultiplicacaoFalse() {
		OperacaoReais or = OperacaoReais.MULTIPLICACAO;
		assertFalse(or.operadorEquals("+"));
	}
	
	@Test
	void testOperadorEqualsAdicaoTrue() {
		OperacaoReais or = OperacaoReais.SOMA;
		assertTrue(or.operadorEquals("+"));
	}
	
	@Test
	void testOperadorEqualsAdicaoFalse() {
		OperacaoReais or = OperacaoReais.SOMA;
		assertFalse(or.operadorEquals("*"));
	}

	@Test
	void testGetIdentidadeMultiplicao() {
		OperacaoReais or = OperacaoReais.MULTIPLICACAO;
		assertEquals(1, or.getIdentidade(null));
	}
	
	@Test
	void testGetIdentidadeAdicao() {
		OperacaoReais or = OperacaoReais.SOMA;
		assertEquals(0, or.getIdentidade(null));
	}
	
	@Test
	void testFazMultiplicacao() {
		OperacaoReais or = OperacaoReais.MULTIPLICACAO;
		double v1 = 1.1;
		double v2 = 1.5;
		assertEquals(v1 * v2, or.faz(v1, v2));
	}
	
	@Test
	void testFazAdicao() {
		OperacaoReais or = OperacaoReais.SOMA;
		double v1 = 1.1;
		double v2 = 1.5;
		assertEquals(v1 + v2, or.faz(v1, v2));
	}

}

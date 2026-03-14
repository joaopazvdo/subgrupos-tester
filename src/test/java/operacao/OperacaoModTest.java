package operacao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperacaoModTest {

	@Test
	void testGetIdentidadeMultiplicaco() {
		OperacaoMod om = OperacaoMod.MULTIPLICACAO;
		int elem = 4;
		int mod = 6;
		String e = elem + " mod " + mod;
		assertEquals("1 mod " + mod, om.getIdentidade(e));
	}
	
	@Test
	void testGetIdentidadeMultiplicacoComOperacao() {
		OperacaoMod om = OperacaoMod.MULTIPLICACAO;
		int elem = 4;
		int mod = 6;
		String e = elem + " mod " + mod;
		String identidade = om.getIdentidade(e);
		assertEquals(e, om.faz(e, identidade));
	}
	
	@Test
	void testGetIdentidadeAdicao() {
		OperacaoMod om = OperacaoMod.SOMA;
		int elem = 4;
		int mod = 6;
		String e = elem + " mod " + mod;
		assertEquals("0 mod " + mod, om.getIdentidade(e));
	}
	
	@Test
	void testGetIdentidadeAdicaoComOperacao() {
		OperacaoMod om = OperacaoMod.SOMA;
		int elem = 4;
		int mod = 6;
		String e = elem + " mod " + mod;
		String identidade = om.getIdentidade(e);
		assertEquals(e, om.faz(e, identidade));
	}

	@Test
	void testOperadorEqualsMultiplicacaoTrue() {
		OperacaoMod or = OperacaoMod.MULTIPLICACAO;
		assertTrue(or.operadorEquals("*"));
	}
	
	@Test
	void testOperadorEqualsMultiplicacaoFalse() {
		OperacaoMod or = OperacaoMod.MULTIPLICACAO;
		assertFalse(or.operadorEquals("+"));
	}
	
	@Test
	void testOperadorEqualsAdicaoTrue() {
		OperacaoMod or = OperacaoMod.SOMA;
		assertTrue(or.operadorEquals("+"));
	}
	
	@Test
	void testOperadorEqualsAdicaoFalse() {
		OperacaoMod or = OperacaoMod.SOMA;
		assertFalse(or.operadorEquals("*"));
	}
	
	@Test
	void testFazAdicao() {
		OperacaoMod or = OperacaoMod.SOMA;

		int elem1 = 4;
		int elem2 = 2;
		int mod = 6;
		
		String e1 = elem1 + " mod " + mod;
		String e2 = elem2 + " mod " + mod;
		
		String res = (elem1 + elem2) % mod + " mod " + mod;

		assertEquals(res, or.faz(e1, e2));
	}
	
	@Test
	void testFazMultiplicacao() {
		OperacaoMod or = OperacaoMod.MULTIPLICACAO;

		int elem1 = 4;
		int elem2 = 2;
		int mod = 6;
		
		String e1 = elem1 + " mod " + mod;
		String e2 = elem2 + " mod " + mod;
		
		String res = (elem1 * elem2) % mod + " mod " + mod;

		assertEquals(res, or.faz(e1, e2));
	}
}

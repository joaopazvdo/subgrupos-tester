package operacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class OperacaoBinarioTest {

	@Test
	void testoperadorEqualsMultiplicacaoTrue() {
		OperacaoBinario ob = OperacaoBinario.MULTIPLICACAO;
		assertTrue(ob.operadorEquals("*"));
	}
	
	@Test
	void testoperadorEqualsMultiplicacaoFalse() {
		OperacaoBinario ob = OperacaoBinario.MULTIPLICACAO;
		assertFalse(ob.operadorEquals("+"));
	}
	
	@Test
	void testoperadorEqualsAdicaoTrue() {
		OperacaoBinario ob = OperacaoBinario.SOMA;
		assertTrue(ob.operadorEquals("+"));
	}
	
	@Test
	void testoperadorEqualsAdicaoFalse() {
		OperacaoBinario ob = OperacaoBinario.SOMA;
		assertFalse(ob.operadorEquals("*"));
	}

	@Test
	void testGetIdentidadeMultiplicao() {
		OperacaoBinario ob = OperacaoBinario.MULTIPLICACAO;
		assertEquals(0b1, ob.getIdentidade(null));
	}
	
	@Test
	void testGetIdentidadeAdicao() {
		OperacaoBinario ob = OperacaoBinario.SOMA;
		assertEquals(0b0, ob.getIdentidade(null));
	}
	
	@Test
	void testFazMultiplicacaoOverflow() {
		OperacaoBinario ob = OperacaoBinario.MULTIPLICACAO;
		Integer v1 = 0b11;
		Integer v2 = 0b10;
		assertEquals(0b110, ob.faz(v1, v2));
	}
	
	@Test
	void testFazMultiplicacao() {
		OperacaoBinario ob = OperacaoBinario.MULTIPLICACAO;
		Integer v1 = 0b1;
		Integer v2 = 0b0;
		assertEquals(0b0, ob.faz(v1, v2));
	}
	
	@Test
	void testFazAdicaoOverflow() {
		OperacaoBinario ob = OperacaoBinario.SOMA;
		Integer v1 = 0b11;
		Integer v2 = 0b10;
		assertEquals(0b101, ob.faz(v1, v2));
	}
	
	@Test
	void testFazAdicao() {
		OperacaoBinario ob = OperacaoBinario.SOMA;
		Integer v1 = 0b1;
		Integer v2 = 0b0;
		assertEquals(0b1, ob.faz(v1, v2));
	}
}

package conversor;

import conversor.Conversor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

public class ConversorTest {

    private Conversor conversor;

    @BeforeEach
    public void setUp() {
        conversor = new Conversor();
    }

    @Test
    public void testMatrizCaminhoFeliz() {
        String input = "{1, 2}, {3, 4}";
        HashSet<Double[][]> resultado = conversor.paraConjuntoMatriz(input);
        assertEquals(1, resultado.size());
        Double[][] matriz = resultado.iterator().next();
        assertEquals(1.0, matriz[0][0]);
        assertEquals(4.0, matriz[1][1]);
    }

    @Test
    public void testMatrizSemChavesRetornaVazio() {
        String input = "1, 2, 3, 4"; 
        HashSet<Double[][]> resultado = conversor.paraConjuntoMatriz(input);
        Double[][] matriz = resultado.iterator().next();
        assertEquals(0, matriz.length); 
    }

    @Test
    public void testMatrizComLetrasLancaExcecao() {
        String input = "{1, a}";
        assertThrows(NumberFormatException.class, () -> conversor.paraConjuntoMatriz(input));
    }

    @Test
    public void testMatrizNulaLancaExcecao() {
        assertThrows(NullPointerException.class, () -> conversor.paraConjuntoMatriz(null));
    }

    @Test
    public void testMatrizComEspacosExtras() {
        String input = "{  1 ,   2  } , { 3 , 4}";
        HashSet<Double[][]> resultado = conversor.paraConjuntoMatriz(input);
        Double[][] matriz = resultado.iterator().next();
        assertEquals(1.0, matriz[0][0]);
        assertEquals(2.0, matriz[0][1]);
    }

    @Test
    public void testNumericoCaminhoFeliz() {
        String input = "1.5, 2, 3.8";
        HashSet<Double> resultado = conversor.paraConjuntoNumerico(input);
        assertTrue(resultado.contains(1.5) && resultado.contains(2.0) && resultado.contains(3.8));
    }

    @Test
    public void testNumericoComEspacosExtras() {
        String input = "  10 ,  20   , 30  ";
        HashSet<Double> resultado = conversor.paraConjuntoNumerico(input);
        assertTrue(resultado.contains(10.0));
    }

    @Test
    public void testNumericoLetrasLancaExcecao() {
        String input = "1, 2, B";
        assertThrows(NumberFormatException.class, () -> conversor.paraConjuntoNumerico(input));
    }

    @Test
    public void testNumericoStringVaziaLancaExcecao() {
        String input = "";
        assertThrows(NumberFormatException.class, () -> conversor.paraConjuntoNumerico(input));
    }

    @Test
    public void testNumericoNuloLancaExcecao() {
        assertThrows(NullPointerException.class, () -> conversor.paraConjuntoNumerico(null));
    }

    @Test
    public void testBinarioCaminhoFeliz() {
        String input = "000 001 010";
        HashSet<String> resultado = conversor.paraConjuntoBinario(input);
        assertTrue(resultado.contains("000") && resultado.contains("010"));
        assertEquals(3, resultado.size());
    }

    @Test
    public void testBinarioApenasUmElemento() {
        String input = "111";
        HashSet<String> resultado = conversor.paraConjuntoBinario(input);
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains("111"));
    }

    @Test
    public void testBinarioEspacosDuplosGeraVazio() {
        String input = "000  001"; 
        HashSet<String> resultado = conversor.paraConjuntoBinario(input);
        assertTrue(resultado.contains("")); 
    }

    @Test
    public void testBinarioNuloLancaExcecao() {
        assertThrows(NullPointerException.class, () -> conversor.paraConjuntoBinario(null));
    }

    @Test
    public void testBinarioMantemZerosEsquerda() {
        String input = "01 10 00";
        HashSet<String> resultado = conversor.paraConjuntoBinario(input);
        assertTrue(resultado.contains("01"));
    }

    @Test
    public void testModCaminhoFeliz() {
        String input = "4";
        HashSet<Integer> resultado = conversor.paraConjuntoMod(input);
        assertEquals(4, resultado.size());
        assertTrue(resultado.contains(0) && resultado.contains(3));
    }

    @Test
    public void testModZeroRetornaVazio() {
        String input = "0";
        HashSet<Integer> resultado = conversor.paraConjuntoMod(input);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testModNegativoRetornaVazio() {
        String input = "-5";
        HashSet<Integer> resultado = conversor.paraConjuntoMod(input);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testModNuloLancaExcecao() {
        assertThrows(NullPointerException.class, () -> conversor.paraConjuntoMod(null));
    }

    @Test
    public void testModLetraLancaExcecao() {
        String input = "Z";
        assertThrows(NumberFormatException.class, () -> conversor.paraConjuntoMod(input));
    }
}
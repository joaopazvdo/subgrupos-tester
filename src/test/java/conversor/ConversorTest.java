/**
 * @author jose-kauan-pereira00(José Kauan Pereira)
 * */

package conversor;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

public class ConversorTest {

    private boolean contemMatriz(HashSet<Double[][]> conjunto, Double[][] matrizEsperada) {
        for (Double[][] matriz : conjunto) {
            if (Arrays.deepEquals(matriz, matrizEsperada)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testParaConjuntoMatriz_MatrizSimples2x2() {
        String input = "[[1.0, 2.0], [3.0, 4.0]]";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        Double[][] esperado = {{1.0, 2.0}, {3.0, 4.0}};
        
        assertEquals(1, resultado.size());
        assertTrue(contemMatriz(resultado, esperado));
    }

    @Test
    public void testParaConjuntoMatriz_MultiplasMatrizes() {
        String input = "[[1.0]], [[2.0, 3.0]]";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        
        assertEquals(2, resultado.size());
        assertTrue(contemMatriz(resultado, new Double[][]{{1.0}}));
        assertTrue(contemMatriz(resultado, new Double[][]{{2.0, 3.0}}));
    }

    @Test
    public void testParaConjuntoMatriz_EspacamentoIrregular() {
        String input = "  [[  1.0 ,   2.0 ] , [ 3.0  , 4.0 ]]  ";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        Double[][] esperado = {{1.0, 2.0}, {3.0, 4.0}};
        
        assertTrue(contemMatriz(resultado, esperado));
    }

    @Test
    public void testParaConjuntoMatriz_MatrizComNegativosEDecimais() {
        String input = "[[-1.5, 0.5], [2.75, -3.14]]";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        Double[][] esperado = {{-1.5, 0.5}, {2.75, -3.14}};
        
        assertTrue(contemMatriz(resultado, esperado));
    }

    @Test
    public void testParaConjuntoMatriz_StringVaziaSemMatch() {
        String input = "Nao tem matriz aqui";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testParaConjuntoMatriz_MatrizAssimetrica() {
        String input = "[[1.0, 2.0, 3.0], [4.0]]";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        Double[][] esperado = {{1.0, 2.0, 3.0}, {4.0}};
        
        assertTrue(contemMatriz(resultado, esperado));
    }

    @Test
    public void testParaConjuntoMatriz_MatrizUnicoElemento() {
        String input = "[[42.0]]";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        Double[][] esperado = {{42.0}};
        
        assertTrue(contemMatriz(resultado, esperado));
    }

    @Test
    public void testParaConjuntoNumerico_NumerosSimples() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1.0, 2.0, 3.0");
        assertTrue(resultado.containsAll(Arrays.asList(1.0, 2.0, 3.0)));
        assertEquals(3, resultado.size());
    }

    @Test
    public void testParaConjuntoNumerico_ComInteiros() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1, 2, 3");
        assertTrue(resultado.containsAll(Arrays.asList(1.0, 2.0, 3.0)));
    }

    @Test
    public void testParaConjuntoNumerico_NumerosNegativos() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("-1.5, -2.0, 3.1");
        assertTrue(resultado.containsAll(Arrays.asList(-1.5, -2.0, 3.1)));
    }

    @Test
    public void testParaConjuntoNumerico_EspacosExtras() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("  1.5  ,  2.5,   3.5  ");
        assertTrue(resultado.containsAll(Arrays.asList(1.5, 2.5, 3.5)));
    }

    @Test
    public void testParaConjuntoNumerico_ElementosDuplicados() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1.0, 1.0, 2.0");
        assertEquals(2, resultado.size());
        assertTrue(resultado.containsAll(Arrays.asList(1.0, 2.0)));
    }

    @Test
    public void testParaConjuntoNumerico_UnicoElemento() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("42.42");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(42.42));
    }

    @Test
    public void testParaConjuntoNumerico_NotacaoCientifica() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1e3, 2e-2");
        assertTrue(resultado.containsAll(Arrays.asList(1000.0, 0.02)));
    }

    @Test
    public void testParaConjuntoBinario_Simples() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("10 11 100");
        assertTrue(resultado.containsAll(Arrays.asList(2, 3, 4)));
    }

    @Test
    public void testParaConjuntoBinario_ZerosAEsquerda() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("001 010 011");
        assertTrue(resultado.containsAll(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testParaConjuntoBinario_ApenasZeros() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("000 0000 0");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(0));
    }

    @Test
    public void testParaConjuntoBinario_ValoresGrandes() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("11111111 10000000");
        assertTrue(resultado.containsAll(Arrays.asList(255, 128)));
    }

    @Test
    public void testParaConjuntoBinario_UnicoElemento() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("101010");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(42));
    }

    @Test
    public void testParaConjuntoBinario_Duplicados() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("11 11 11");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(3));
    }

    @Test
    public void testParaConjuntoMod_Simples() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[0, 1, 2] 3");
        assertTrue(resultado.containsAll(Arrays.asList("0 mod 3", "1 mod 3", "2 mod 3")));
    }

    @Test
    public void testParaConjuntoMod_NumerosMaioresQueMod() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[5, 6, 7] 4");
        assertTrue(resultado.containsAll(Arrays.asList("1 mod 4", "2 mod 4", "3 mod 4")));
    }

    @Test
    public void testParaConjuntoMod_NumerosNegativos() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[-1, -2] 3");
        assertTrue(resultado.containsAll(Arrays.asList("2 mod 3", "1 mod 3")));
    }


    @Test
    public void testParaConjuntoMod_DuplicadosColisoes() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[1, 4, 7] 3");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains("1 mod 3"));
    }

    @Test
    public void testParaConjuntoMod_UnicoElemento() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[10] 7");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains("3 mod 7"));
    }

    @Test
    public void testParaConjuntoMod_ModZeroOuUm() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[5, 10, 15] 1");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains("0 mod 1"));
    }
}
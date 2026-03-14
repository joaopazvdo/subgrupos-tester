package conversor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConversorTest {

    @Test
    public void testParaConjuntoMatriz_Matriz2x2_Padrao() {
        String input = "{1.0, 2.0}, {3.0, 4.0}";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        
        assertEquals(1, resultado.size());
        Double[][] matriz = resultado.iterator().next();
        Double[][] esperado = {{1.0, 2.0}, {3.0, 4.0}};
        assertTrue(Arrays.deepEquals(esperado, matriz));
    }

    @Test
    public void testParaConjuntoMatriz_ApenasUmaLinha() {
        String input = "{5.5, 6.6, 7.7}";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        
        Double[][] matriz = resultado.iterator().next();
        Double[][] esperado = {{5.5, 6.6, 7.7}};
        assertTrue(Arrays.deepEquals(esperado, matriz));
    }

    @Test
    public void testParaConjuntoMatriz_ComEspacosExtras() {
        String input = "{  1.0 , 2.0 } , { 3.0 }";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        
        Double[][] matriz = resultado.iterator().next();
        Double[][] esperado = {{1.0, 2.0}, {3.0}};
        assertTrue(Arrays.deepEquals(esperado, matriz));
    }

    @Test
    public void testParaConjuntoMatriz_NumerosNegativos() {
        String input = "{-1.5, -2.5}, {3.0, -4.0}";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        
        Double[][] matriz = resultado.iterator().next();
        Double[][] esperado = {{-1.5, -2.5}, {3.0, -4.0}};
        assertTrue(Arrays.deepEquals(esperado, matriz));
    }

    @Test
    public void testParaConjuntoMatriz_MatrizIrregular_TamanhosDiferentes() {
        String input = "{1.0}, {2.0, 3.0, 4.0}";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        
        Double[][] matriz = resultado.iterator().next();
        Double[][] esperado = {{1.0}, {2.0, 3.0, 4.0}};
        assertTrue(Arrays.deepEquals(esperado, matriz));
    }

    @Test
    public void testParaConjuntoMatriz_InteirosConvertidosParaDouble() {
        String input = "{1, 2}, {3, 4}";
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        
        Double[][] matriz = resultado.iterator().next();
        Double[][] esperado = {{1.0, 2.0}, {3.0, 4.0}};
        assertTrue(Arrays.deepEquals(esperado, matriz));
    }

    @Test
    public void testParaConjuntoMatriz_SemChaves_IgnoraERetornaVazio() {
        String input = "1.0, 2.0, 3.0"; 
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz(input);
        
        Double[][] matriz = resultado.iterator().next();
        Double[][] esperado = new Double[0][0];
        assertTrue(Arrays.deepEquals(esperado, matriz));
    }


    @Test
    public void testParaConjuntoNumerico_PositivosPadrao() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1.5, 2.5, 3.5");
        assertEquals(Set.of(1.5, 2.5, 3.5), resultado);
    }

    @Test
    public void testParaConjuntoNumerico_Inteiros() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("10, 20, 30");
        assertEquals(Set.of(10.0, 20.0, 30.0), resultado);
    }

    @Test
    public void testParaConjuntoNumerico_Negativos() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("-1.5, -2.5");
        assertEquals(Set.of(-1.5, -2.5), resultado);
    }

    @Test
    public void testParaConjuntoNumerico_ComEspacosExtras() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("  1.1 ,  2.2 , 3.3  ");
        assertEquals(Set.of(1.1, 2.2, 3.3), resultado);
    }

    @Test
    public void testParaConjuntoNumerico_RemocaoDeDuplicatas() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1.0, 1.0, 2.0, 2.0");
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(1.0) && resultado.contains(2.0));
    }

    @Test
    public void testParaConjuntoNumerico_ApenasUmNumero() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("42.42");
        assertEquals(Set.of(42.42), resultado);
    }

    @Test
    public void testParaConjuntoNumerico_NotacaoCientifica() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1e2, 2.5e-1");
        assertEquals(Set.of(100.0, 0.25), resultado);
    }

    @Test
    public void testParaConjuntoBinario_Padrao() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("10 11 100");
        assertEquals(Set.of(2, 3, 4), resultado);
    }

    @Test
    public void testParaConjuntoBinario_ComZerosAEsquerda() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("0001 010");
        assertEquals(Set.of(1, 2), resultado);
    }

    @Test
    public void testParaConjuntoBinario_RemocaoDeDuplicatas() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("11 11 10");
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(3) && resultado.contains(2));
    }

    @Test
    public void testParaConjuntoBinario_ApenasZero() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("0 00 000");
        assertEquals(Set.of(0), resultado);
    }

    @Test
    public void testParaConjuntoBinario_UmNumero() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("1010");
        assertEquals(Set.of(10), resultado);
    }

    @Test
    public void testParaConjuntoBinario_NumeroLongo() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("11111111");
        assertEquals(Set.of(255), resultado);
    }

    @Test
    public void testParaConjuntoBinario_ZerosEUnsMisturados() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("1 0 1 0");
        assertEquals(Set.of(1, 0), resultado);
    }

    @Test
    public void testParaConjuntoMod_ApenasUmNumero() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("6");
        assertEquals(Set.of("0 mod 6", "1 mod 6", "2 mod 6", "3 mod 6", "4 mod 6", "5 mod 6"), resultado);
    }

    @Test
    public void testParaConjuntoMod_ComLetrasIgnoradas() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("z4");
        assertEquals(Set.of("0 mod 4", "1 mod 4", "2 mod 4", "3 mod 4"), resultado);
    }

    @Test
    public void testParaConjuntoMod_MultiplosNumeros() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("2 e 3");
        assertEquals(Set.of("0 mod 2", "1 mod 2", "0 mod 3", "1 mod 3", "2 mod 3"), resultado);
    }

    @Test
    public void testParaConjuntoMod_Duplicatas() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("3 e 3");
        assertEquals(Set.of("0 mod 3", "1 mod 3", "2 mod 3"), resultado);
    }

    @Test
    public void testParaConjuntoMod_NumeroUm() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("1");
        assertEquals(Set.of("0 mod 1"), resultado);
    }

    @Test
    public void testParaConjuntoMod_Zero_RetornaVazio() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("0");
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testParaConjuntoMod_SemNumeros_RetornaVazio() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("abc");
        assertTrue(resultado.isEmpty());
    }
    
    @Test
    public void testParaConjuntoMod_SeparadoPorSimbolos() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("3-2");
        assertEquals(Set.of("0 mod 3", "1 mod 3", "2 mod 3", "0 mod 2", "1 mod 2"), resultado);
    }
}
package conversor;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class ConversorTest {

    @Test
    void testeMatrizNormal2x2() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("[[1.0, 2.0], [3.0, 4.0]]");
        assertEquals(1, resultado.size());
        Double[][] matriz = resultado.iterator().next();
        assertArrayEquals(new Double[]{1.0, 2.0}, matriz[0]);
        assertArrayEquals(new Double[]{3.0, 4.0}, matriz[1]);
    }

    @Test
    void testeMatrizInteirosComoDouble() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("[[1, 2], [3, 4]]");
        Double[][] matriz = resultado.iterator().next();
        assertArrayEquals(new Double[]{1.0, 2.0}, matriz[0]);
    }

    @Test
    void testeMatrizComNumerosNegativos() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("[[-1.5, 2.5], [3.0, -4.0]]");
        Double[][] matriz = resultado.iterator().next();
        assertArrayEquals(new Double[]{-1.5, 2.5}, matriz[0]);
        assertArrayEquals(new Double[]{3.0, -4.0}, matriz[1]);
    }

    @Test
    void testeMatrizIrregular() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("[[1, 2, 3], [4]]");
        Double[][] matriz = resultado.iterator().next();
        assertEquals(3, matriz[0].length);
        assertEquals(1, matriz[1].length);
    }

    @Test
    void testeMatriz1x1() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("[[42.42]]");
        Double[][] matriz = resultado.iterator().next();
        assertEquals(1, matriz.length);
        assertEquals(42.42, matriz[0][0]);
    }

    @Test
    void testeMatrizComMuitosEspacos() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("[ [  1.5 , 2.5 ] , [ 3.5 , 4.5 ] ]");
        Double[][] matriz = resultado.iterator().next();
        assertArrayEquals(new Double[]{1.5, 2.5}, matriz[0]);
    }

    @Test
    void testeMatrizRetangular3x2() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("[[1, 2], [3, 4], [5, 6]]");
        Double[][] matriz = resultado.iterator().next();
        assertEquals(3, matriz.length);
        assertArrayEquals(new Double[]{5.0, 6.0}, matriz[2]);
    }

    @Test
    void testeNumericoNormal() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1.5, 2.5, 3.5");
        assertTrue(resultado.containsAll(Set.of(1.5, 2.5, 3.5)));
        assertEquals(3, resultado.size());
    }

    @Test
    void testeNumericoSemEspacos() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1.1,2.2,3.3");
        assertTrue(resultado.containsAll(Set.of(1.1, 2.2, 3.3)));
    }

    @Test
    void testeNumericoRemocaoDuplicatas() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1.0, 1.0, 2.0, 2.0, 3.0");
        assertEquals(3, resultado.size());
        assertTrue(resultado.contains(1.0));
    }

    @Test
    void testeNumericoApenasUmNumero() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("42.0");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(42.0));
    }

    @Test
    void testeNumericoComNegativos() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("-1.5, 2.0, -3.14");
        assertTrue(resultado.containsAll(Set.of(-1.5, 2.0, -3.14)));
    }

    @Test
    void testeNumericoInteiros() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("1, 2, 30");
        assertTrue(resultado.containsAll(Set.of(1.0, 2.0, 30.0)));
    }

    @Test
    void testeNumericoEspacosExtremos() {
        HashSet<Double> resultado = Conversor.paraConjuntoNumerico("   10.5  ,  20.5   ");
        assertTrue(resultado.containsAll(Set.of(10.5, 20.5)));
    }

    @Test
    void testeBinarioNormal() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("000 001 010");
        assertTrue(resultado.containsAll(Set.of(0, 1, 2)));
    }

    @Test
    void testeBinarioValoresAltos() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("1111 1010 1100");
        assertTrue(resultado.containsAll(Set.of(15, 10, 12)));
    }

    @Test
    void testeBinarioRemocaoDuplicatas() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("00 000 0000 11");
        assertEquals(2, resultado.size());
        assertTrue(resultado.containsAll(Set.of(0, 3)));
    }

    @Test
    void testeBinarioUnicoValor() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("101010");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(42));
    }

    @Test
    void testeBinarioApenasZeros() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("0 0 0");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(0));
    }

    @Test
    void testeBinarioBitsIsolados() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario("1 0 1");
        assertEquals(2, resultado.size());
        assertTrue(resultado.containsAll(Set.of(0, 1)));
    }

    @Test
    void testeBinarioStringComUmEspacoNoInicioEFim() {
        HashSet<Integer> resultado = Conversor.paraConjuntoBinario(" 110 011 ");
        assertTrue(resultado.containsAll(Set.of(6, 3)));
    }

    @Test
    void testeModNormal() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[0, 1, 2, 3, 4, 5] 6");
        assertEquals(6, resultado.size());
        assertTrue(resultado.contains("5 mod 6"));
    }

    @Test
    void testeModComNumerosMaioresQueOModulo() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[7, 10, 12] 5");
        assertTrue(resultado.containsAll(Set.of("2 mod 5", "0 mod 5")));
        assertEquals(2, resultado.size());
    }

    @Test
    void testeModComNumerosNegativos() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[-1, -2] 5");
        assertTrue(resultado.containsAll(Set.of("4 mod 5", "3 mod 5")));
    }

    @Test
    void testeModUnicoElemento() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[15] 4");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains("3 mod 4"));
    }

    @Test
    void testeModComMuitoEspacamento() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[  1 ,  2  ]    3 ");
        assertTrue(resultado.containsAll(Set.of("1 mod 3", "2 mod 3")));
    }

    @Test
    void testeModModuloUm() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[5, 10, 15] 1");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains("0 mod 1"));
    }

    @Test
    void testeModComDuplicatasIntencionais() {
        HashSet<String> resultado = Conversor.paraConjuntoMod("[2, 2, 2] 3");
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains("2 mod 3"));
    }
}
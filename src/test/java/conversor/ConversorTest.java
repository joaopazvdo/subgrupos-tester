/**
 * @author jose-kauan-pereira00(José Kauan Pereira)
 * */
 
package conversor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

public class ConversorTest {

    @Test
    public void testParaConjuntoMatriz1() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("{1, 2, 3}");
        Double[][] matriz = resultado.iterator().next();
        assertArrayEquals(new Double[]{1.0, 2.0, 3.0}, matriz[0]);
    }

    @Test
    public void testParaConjuntoMatriz2() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("{1, 2}, {3, 4}");
        Double[][] matriz = resultado.iterator().next();
        assertArrayEquals(new Double[]{1.0, 2.0}, matriz[0]);
        assertArrayEquals(new Double[]{3.0, 4.0}, matriz[1]);
    }

    @Test
    public void testParaConjuntoMatriz3() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("{-1.5, -2.5}");
        Double[][] matriz = resultado.iterator().next();
        assertArrayEquals(new Double[]{-1.5, -2.5}, matriz[0]);
    }

    @Test
    public void testParaConjuntoMatriz4() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("{0}");
        Double[][] matriz = resultado.iterator().next();
        assertArrayEquals(new Double[]{0.0}, matriz[0]);
    }

    @Test
    public void testParaConjuntoMatriz5() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("{ 10 , 20 }");
        Double[][] matriz = resultado.iterator().next();
        assertArrayEquals(new Double[]{10.0, 20.0}, matriz[0]);
    }

    @Test
    public void testParaConjuntoMatriz6() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("{1, 2, 3}, {4, 5}");
        Double[][] matriz = resultado.iterator().next();
        assertArrayEquals(new Double[]{1.0, 2.0, 3.0}, matriz[0]);
        assertArrayEquals(new Double[]{4.0, 5.0}, matriz[1]);
    }

    @Test
    public void testParaConjuntoMatriz7() {
        HashSet<Double[][]> resultado = Conversor.paraConjuntoMatriz("{10.5, 20.1}, {30.9, 40.2}, {50.5, 60.6}");
        Double[][] matriz = resultado.iterator().next();
        assertEquals(3, matriz.length);
        assertArrayEquals(new Double[]{50.5, 60.6}, matriz[2]);
    }

    @Test
    public void testParaConjuntoNumerico1() {
        assertEquals(Set.of(1.0, 2.0, 3.0), Conversor.paraConjuntoNumerico("1, 2, 3"));
    }

    @Test
    public void testParaConjuntoNumerico2() {
        assertEquals(Set.of(1.5, 2.5), Conversor.paraConjuntoNumerico("1.5, 2.5"));
    }

    @Test
    public void testParaConjuntoNumerico3() {
        assertEquals(Set.of(-1.0, -2.0), Conversor.paraConjuntoNumerico("-1, -2"));
    }

    @Test
    public void testParaConjuntoNumerico4() {
        assertEquals(Set.of(42.0), Conversor.paraConjuntoNumerico("42"));
    }

    @Test
    public void testParaConjuntoNumerico5() {
        assertEquals(Set.of(1.0, 2.0), Conversor.paraConjuntoNumerico("1, 1, 2, 2"));
    }

    @Test
    public void testParaConjuntoNumerico6() {
        assertEquals(Set.of(0.0), Conversor.paraConjuntoNumerico("0, 0, 0"));
    }

    @Test
    public void testParaConjuntoNumerico7() {
        assertEquals(Set.of(10.0, 20.0, 30.0), Conversor.paraConjuntoNumerico(" 10 , 20 , 30 "));
    }

    @Test
    public void testParaConjuntoBinario1() {
        assertEquals(Set.of(0, 1, 2), Conversor.paraConjuntoBinario("000 001 010"));
    }

    @Test
    public void testParaConjuntoBinario2() {
        assertEquals(Set.of(10), Conversor.paraConjuntoBinario("1010"));
    }

    @Test
    public void testParaConjuntoBinario3() {
        assertEquals(Set.of(3), Conversor.paraConjuntoBinario("11 11 11"));
    }

    @Test
    public void testParaConjuntoBinario4() {
        assertEquals(Set.of(0), Conversor.paraConjuntoBinario("0 00 000"));
    }

    @Test
    public void testParaConjuntoBinario5() {
        assertEquals(Set.of(255), Conversor.paraConjuntoBinario("11111111"));
    }

    @Test
    public void testParaConjuntoBinario6() {
        assertEquals(Set.of(1, 2, 4, 8), Conversor.paraConjuntoBinario("1 10 100 1000"));
    }

    @Test
    public void testParaConjuntoBinario7() {
        assertEquals(Set.of(5, 7), Conversor.paraConjuntoBinario("101 111"));
    }

    @Test
    public void testParaConjuntoMod1() {
        assertEquals(Set.of("0 mod 3", "1 mod 3", "2 mod 3"), Conversor.paraConjuntoMod("[0, 1, 2] 3"));
    }

    @Test
    public void testParaConjuntoMod2() {
        assertEquals(Set.of("1 mod 3", "2 mod 3"), Conversor.paraConjuntoMod("[4, 5] 3"));
    }

    @Test
    public void testParaConjuntoMod3() {
        assertEquals(Set.of("1 mod 3"), Conversor.paraConjuntoMod("[1, 4, 7] 3"));
    }

    @Test
    public void testParaConjuntoMod4() {
        assertEquals(Set.of("0 mod 2"), Conversor.paraConjuntoMod("[0, 2, 4, 6] 2"));
    }

    @Test
    public void testParaConjuntoMod5() {
        assertEquals(Set.of("5 mod 10", "3 mod 10"), Conversor.paraConjuntoMod("[15, 23] 10"));
    }

    @Test
    public void testParaConjuntoMod6() {
        assertEquals(Set.of("0 mod 5"), Conversor.paraConjuntoMod("[5] 5"));
    }

    @Test
    public void testParaConjuntoMod7() {
        assertEquals(Set.of("1 mod 4", "2 mod 4", "3 mod 4"), Conversor.paraConjuntoMod("[ 1 , 2 , 3 ] 4"));
    }
}
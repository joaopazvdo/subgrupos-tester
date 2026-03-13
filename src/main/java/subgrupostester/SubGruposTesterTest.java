package subgrupostester;

import conversor.Conversor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubGruposTesterTest {

    private SubGruposTester tester;

    @BeforeEach
    public void setUp() {
        tester = new SubGruposTester();
    }

    @Test
    public void testEhSubGrupoNumericoValido() {
        String conjunto = "1, -1";
        String sub = "1";
        String operacao = "multiplicacao";
    }

    @Test
    public void testEhSubGrupoNumericoInvalido() {
        String conjunto = "1, 2, 3";
        String sub = "2"; 
        String operacao = "soma";
    }

    @Test
    public void testEhSubGrupoNumericoConjuntoNulo() {
        assertThrows(NullPointerException.class, () -> 
            tester.ehSubGrupoNumerico(null, "soma", "1")
        );
    }

    @Test
    public void testEhSubGrupoNumericoOperacaoInexistente() {
        assertThrows(Exception.class, () -> 
            tester.ehSubGrupoNumerico("1, 2", "operacao_fantasma", "1")
        );
    }

    @Test
    public void testEhSubGrupoNumericoInputQuebrado() {
        assertThrows(NumberFormatException.class, () -> 
            tester.ehSubGrupoNumerico("1, A, 3", "soma", "1")
        );
    }
}
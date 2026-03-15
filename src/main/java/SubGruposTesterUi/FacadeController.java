package SubGruposTesterUi;

import subgrupostester.*;

/**
 * Controlador de Fachada (Facade) para o sistema de verificação de subgrupos.
 * Esta classe atua como um mediador entre a interface gráfica e a lógica de negócio,
 * simplificando o processo de validação de estruturas algébricas.
 * * @author José Vinícius Tavares Silva
 * @version 1.0
 */

public class FacadeController {
	/** Objeto responsável pela formatação e geração dos relatórios de análise. */
	private Relatorio re;
	
	/** Motor de testes que contém os algoritmos de verificação para diferentes conjuntos. */
	private SubGruposTester sub;

	/**
     * Construtor padrão. Inicializa as instâncias de Relatorio e SubGruposTester
     * necessárias para o funcionamento da fachada.
     */
	public FacadeController() {
		this.re = new Relatorio();
		this.sub = new SubGruposTester();
	}

	/**
     * Processa a requisição da interface gráfica, executa os testes matemáticos
     * correspondentes e retorna um relatório formatado.
     * * @param tipo O tipo de conjunto matemático (ex: "Numérico", "Matriz", "Binário", "Mod").
     * @param operacao A operação binária a ser considerada (Soma ou Multiplicação).
     * @param grupoG String contendo a representação dos elementos do grupo G.
     * @param subgrupoX String contendo a representação dos elementos do subconjunto X.
     * @return Uma String contendo o relatório completo da análise, incluindo validação
     * de fechamento, elemento neutro e elemento inverso.
     */
	public String processarVerificacao(String tipo, String operacao, String grupoG, String subgrupoX) {
		boolean resultado = false;

		switch (tipo) {
		case "Numérico":
			resultado = sub.ehSubGrupoNumerico(grupoG, operacao, subgrupoX);
			break;
		case "Matriz":
			resultado = sub.ehSubGrupoMatriz(grupoG, operacao, subgrupoX);
			break;
		case "Binário":
			resultado = sub.ehSubGrupoBinario(grupoG, operacao, subgrupoX);
			break;
		case "Mod":
			resultado = sub.ehSubGrupoMod(grupoG, operacao, subgrupoX);
			break;
		default:
			return "Erro: Tipo de conjunto desconhecido.";
		}

		// Define as mensagens de status baseadas no resultado da validação
		String txtFechamento = resultado ? "[OK] Propriedade verificada." : "[X] Falha na validação.";
		String txtNeutro = resultado ? "[OK] Elemento neutro presente." : "[X] Falha na validação.";
		String txtInverso = resultado ? "[OK] Elemento inverso presente." : "[X] Falha na validação.";

		// Retorna o relatório final formatado pela classe Relatorio
		return re.gerarRelatorio("Resultado da Análise - " + tipo, grupoG, operacao, subgrupoX, txtFechamento,
				txtNeutro, txtInverso, resultado);
	}
}

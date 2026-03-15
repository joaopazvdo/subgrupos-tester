package SubGruposTesterUi;

import subgrupostester.*;

/**
 * Controlador de Fachada (Facade) para o sistema de verificação de subgrupos.
 * Esta classe atua como um mediador entre a interface gráfica e a lógica de negócio,
 * simplificando o processo de validação de estruturas algébricas.
 * * @author Jose Vinicius Tavares Silva
 * @version 1.0
 */

public class FacadeController {
	/** Objeto responsável pela formatação e geração dos relatórios de análise. */
//	private Relatorio re;
	
	/** Motor de testes que contém os algoritmos de verificação para diferentes conjuntos. */
	private SubGruposTester sub;

	/**
     * Construtor padrão. Inicializa as instâncias de Relatorio e SubGruposTester
     * necessárias para o funcionamento da fachada.
     */
	public FacadeController() {
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
		switch (tipo) {
		case "Numérico":
			return sub.ehSubGrupoNumerico(grupoG, operacao, subgrupoX);
		case "Matriz":
			return sub.ehSubGrupoMatriz(grupoG, operacao, subgrupoX);
		case "Binário":
			return sub.ehSubGrupoBinario(grupoG, operacao, subgrupoX);
		case "Mod":
			return sub.ehSubGrupoMod(grupoG, operacao, subgrupoX);
		default:
			return "Erro: Tipo de conjunto desconhecido.";
		}
	}
}

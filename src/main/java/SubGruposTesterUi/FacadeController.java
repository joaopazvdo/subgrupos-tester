package SubGruposTesterUi;

import subgrupostester.*;

public class FacadeController {
	private Relatorio re;
	private SubGruposTester sub;

	public FacadeController() {
		this.re = new Relatorio();
		this.sub = new SubGruposTester();
	}

	/**
	 * Processa a requisição da UI e retorna o relatório formatado.
	 */
	public String processarVerificacao(String tipo, String operacao, String grupoG, String subgrupoX) {
		boolean resultado = false;

		// Direciona para o método correto do SubGruposTester com base no tipo
		// selecionado na UI

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

		
		String txtFechamento = resultado ? "[OK] Propriedade verificada." : "[X] Falha na validação.";
		String txtNeutro = resultado ? "[OK] Elemento neutro presente." : "[X] Falha na validação.";
		String txtInverso = resultado ? "[OK] Elemento inverso presente." : "[X] Falha na validação.";

		return re.gerarRelatorio("Resultado da Análise - " + tipo, grupoG, operacao, subgrupoX, txtFechamento,
				txtNeutro, txtInverso, resultado);
	}
}

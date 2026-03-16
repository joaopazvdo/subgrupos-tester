package subgrupostester;

import grupo.SubGrupo;

/**
 * Classe responsável por gerar e formatar os relatórios de teste.
 * 
 * @author henriquejesusglc
 */
public class Relatorio<T> {
	
	private SubGrupo<T> subGrupo;
	
	/**
	 * Construtor padrão da classe.
	 */
	public Relatorio(SubGrupo<T> subGrupo) {
		this.subGrupo = subGrupo;
	}

	/**
	 * Gera um relatório formatado em caixa com detalhes dos testes.
	 */
	public String gerarRelatorio() {


		String textoBruto = 
				"RESULTADO DA ANÁLISE\n" +
				"-".repeat("RESULTADO DA ANÁLISE".length()) + "\n" +
				"Conjunto Original: " + subGrupo.getConjunto().toString() + "\n" +
				"Subconjunto      : " + subGrupo.getSubconjunto().toString() + "\n" +
				corpo();
				

		String[] linhas = textoBruto.split("\n");

		int tamanhoMaximo = 0;
		for (String linha : linhas) {
			if (linha.length() > tamanhoMaximo) {
				tamanhoMaximo = linha.length();
			}
		}

		String linhaHorizontal = "+" + "-".repeat(tamanhoMaximo + 2) + "+\n";
		String relatorioFinal = linhaHorizontal;
		for (String linha : linhas) {
			int espacosFaltando = tamanhoMaximo - linha.length();
			String espacos = " ".repeat(espacosFaltando);
			relatorioFinal += "| " + linha + espacos + " |\n";
		}

		relatorioFinal += linhaHorizontal;
		return relatorioFinal;
	}
	
	/**
	 * Gera um relatório formatado em caixa com detalhes dos testes.
	 */
	public String gerarRelatorio(String conjuntoOriginal, String subConjunto) {


		String textoBruto = 
				"RESULTADO DA ANÁLISE\n" +
				"-".repeat("RESULTADO DA ANÁLISE".length()) + "\n" +
				"Conjunto Original: " + conjuntoOriginal + "\n" +
				"Subconjunto      : " + subConjunto + "\n" +
				corpo();
				

		String[] linhas = textoBruto.split("\n");

		int tamanhoMaximo = 0;
		for (String linha : linhas) {
			if (linha.length() > tamanhoMaximo) {
				tamanhoMaximo = linha.length();
			}
		}

		String linhaHorizontal = "+" + "-".repeat(tamanhoMaximo + 2) + "+\n";
		String relatorioFinal = linhaHorizontal;
		for (String linha : linhas) {
			int espacosFaltando = tamanhoMaximo - linha.length();
			String espacos = " ".repeat(espacosFaltando);
			relatorioFinal += "| " + linha + espacos + " |\n";
		}

		relatorioFinal += linhaHorizontal;
		return relatorioFinal;
	}
	
	private String corpo() {
		return "Operação         : " + subGrupo.getOperador() + "\n" +
				"\n" +
				"Etapas de Validação grupo original:\n" +
				testeFechamento() + "\n" +
				testeIdentidade() + "\n" +
				testeInverso() + "\n" +
				testeAssocitividade() + "\n" +
				(subGrupo.ehGrupo() ? "=> CONCLUSÃO: É um grupo válido!" : "=> CONCLUSÃO: NÃO é um grupo.") +
				"\n\n" +
				"Etapas de Validação subgrupo:\n" +
				testeEhSubConjunto() + "\n" +
				testeSubFechamento() + "\n" +
				testeSubIdentidade() + "\n" +
				testeSubInverso() + "\n" +
				"\n" +
				(subGrupo.ehSubGrupo() ? "=> CONCLUSÃO: É um subgrupo válido!" : "=> CONCLUSÃO: NÃO é um subgrupo.");
	}
	
	private String testeSubFechamento() {
		String retorno = "Propriedade de fechamento: ";
		if (subGrupo.subEhFechado()) {
			return retorno + "[OK] Propriedade verificada.";
		} else {
			return retorno + "[X] Propriedade não atendida.";
		}
	}
	
	private String testeSubIdentidade() {
		String retorno = "Propriedade do elemento identidade: ";
		if (subGrupo.subTemIdentidade()) {
			return retorno + "[OK] Propriedade verificada.";
		} else {
			return retorno + "[X] Propriedade não atendida.";
		}
	}
	
	private String testeSubInverso() {
		String retorno = "Propriedade do elemento inverso: ";
		if (subGrupo.subTemInverso()) {
			return retorno + "[OK] Propriedade verificada.";
		} else {
			return retorno + "[X] Propriedade não atendida.";
		}
	}
	
	private String testeEhSubConjunto() {
		String retorno = "É realmente um subconjunto? ";
		if (subGrupo.ehSubConjunto()) {
			return retorno + "[OK] verificado.";
		} else {
			return retorno + "[X] não atendida.";
		}
	}
	
	private String testeFechamento() {
		String retorno = "Propriedade de fechamento: ";
		if (subGrupo.ehFechado()) {
			return retorno + "[OK] Propriedade verificada.";
		} else {
			return retorno + "[X] Propriedade não atendida.";
		}
	}
	
	private String testeIdentidade() {
		String retorno = "Propriedade do elemento identidade: ";
		if (subGrupo.temIdentidade()) {
			return retorno + "[OK] Propriedade verificada.";
		} else {
			return retorno + "[X] Propriedade não atendida.";
		}
	}
	
	private String testeInverso() {
		String retorno = "Propriedade do elemento inverso: ";
		if (subGrupo.temInverso()) {
			return retorno + "[OK] Propriedade verificada.";
		} else {
			return retorno + "[X] Propriedade não atendida.";
		}
	}
	
	private String testeAssocitividade() {
		String retorno = "Propriedade da associatividade: ";
		if (subGrupo.ehAssociativo()) {
			return retorno + "[OK] Propriedade verificada.";
		} else {
			return retorno + "[X] Propriedade não atendida.";
		}
	}
}
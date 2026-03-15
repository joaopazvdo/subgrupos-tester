package subgrupostester;

/**
 * Classe responsável por gerar e formatar os relatórios de teste.
 */
public class Relatorio {

	/**
	 * Construtor padrão da classe.
	 */
	public Relatorio() {
	}

	/**
	 * Gera um relatório formatado em caixa com detalhes dos testes.
	 */
	public String gerarRelatorio(String titulo, String conjOriginal, String operacao, String subConj, 
            String testeFechamento, String testeNeutro, String testeInverso, boolean ehSubGrupo) {

		String textoBruto = 
				titulo + "\n" +
						"-".repeat(titulo.length()) + "\n" +
						"Conjunto Original: " + conjOriginal + "\n" +
						"Subconjunto      : " + subConj + "\n" +
						"Operação         : " + operacao + "\n" +
						"\n" +
						"Etapas de Validação:\n" +
						testeFechamento + "\n" +
						testeNeutro + "\n" +
						testeInverso + "\n" +
						"\n" +
						(ehSubGrupo ? "=> CONCLUSÃO: É um subgrupo válido!" : "=> CONCLUSÃO: NÃO é um subgrupo.");

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
}
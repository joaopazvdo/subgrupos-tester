package subgrupostester;

import conversor.Conversor;
import java.util.*;

/**
 * Classe responsável por testar e formatar os resultados de subgrupos.
 */

public class SubGruposTester {
	private Conversor conversor = new Conversor();
	/**
	 * Construtor padrão da classe.
	 */
	public SubGruposTester(){
	}
	/**
	 * Realiza o teste de subgrupo para conjuntos numéricos.
	 */
	public String ehSubGrupoNumerico(String conjuntoOriginal, String operacao, 
		String subConjunto){
		HashSet<Double> conjunto = conversor.paraConjuntoNumerico(conjuntoOriginal);
		HashSet<Double> subConj = conversor.paraConjuntoNumerico(subConjunto);
		Operacao op = OperacaoController.getOperacaoNumerica(operacao);
		SubGrupo SubGrupo = new SubGrupo(conjunto, op, subConj);

		return gerarRelatorio(
				"Resultado Teste de Subgrupo", 
				conjuntoOriginal, 
				operacao, 
				subConjunto, 
				subGrupo.testarFechamento(),       //Cada etapa retorna as Strings de cada etapa
				subGrupo.testarElementoNeutro(),
				subGrupo.testarElementoInverso(),
				subGrupo.ehSubGrupo()             // O final é boolean
			);
		
	}
	/**
	 * Realiza o teste de subgrupo para conjuntos de matrizes.
	 */
	public String ehSubGrupoMatriz(String conjuntoOriginal, String operacao,
	 String subConjunto){

		HashSet<Double[][]> conjunto = conversor.paraConjuntoMatriz(conjuntoOriginal);
		HashSet<Double[][]> subConj = conversor.paraConjuntoMatriz(subConjunto);
		Operacao op = OperacaoController.getOperacaoMatriz(operacao);

		SubGrupo SubGrupo = new SubGrupo(conjunto, op, subConj);

		return gerarRelatorio(
				"Resultado Teste de Subgrupo", 
				conjuntoOriginal, 
				operacao, 
				subConjunto, 
				subGrupo.testarFechamento(),       
				subGrupo.testarElementoNeutro(),
				subGrupo.testarElementoInverso(),
				subGrupo.ehSubGrupo()             
			);

	}

	/**
	 * Realiza o teste de subgrupo para conjuntos binários.
	 */
	public String ehSubGrupoBinario(String conjuntoOriginal, String operacao,
	 String subConjunto){

	 	HashSet<String> conjunto = conversor.paraConjuntoBinario(conjuntoOriginal);
		HashSet<String> subConj = conversor.paraConjuntoBinario(subConjunto);
		Operacao op = OperacaoController.getOperacaoBinaria(operacao);

		SubGrupo SubGrupo = new SubGrupo(conjunto, op, subConj);

		return gerarRelatorio(
				"Resultado Teste de Subgrupo", 
				conjuntoOriginal, 
				operacao, 
				subConjunto, 
				subGrupo.testarFechamento(),       
				subGrupo.testarElementoNeutro(),
				subGrupo.testarElementoInverso(),
				subGrupo.ehSubGrupo()             
			);

	}
	/**
	 * Realiza o teste de subgrupo para classes de congruência (Mod).
	 */
	public String ehSubGrupoMod(String conjuntoOriginal, String operacao,
	 String subConjunto){

	 	HashSet<Integer> conjunto = conversor.paraConjuntoMod(conjuntoOriginal);
		HashSet<Integer> subConj = conversor.paraConjuntoMod(subConjunto);
		Operacao op = OperacaoController.getOperacaoClasseCongruencia(operacao);

		SubGrupo SubGrupo = new SubGrupo(conjunto, op, subConj);


		return gerarRelatorio(
				"Resultado Teste de Subgrupo", 
				conjuntoOriginal, 
				operacao, 
				subConjunto, 
				subGrupo.testarFechamento(),       
				subGrupo.testarElementoNeutro(),
				subGrupo.testarElementoInverso(),
				subGrupo.ehSubGrupo()             
			);
	}
	/**
	 * Gera um relatório formatado em caixa com os detalhes dos testes.
	 */
	private String gerarRelatorio(String titulo, String conjOriginal, String operacao, String subConj, 
            String testeFechamento, String testeNeutro, String testeInverso, boolean ehSubGrupo) {

		//Monta o texto separando as linhas 
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

		//Separa o texto 
		String[] linhas = textoBruto.split("\n");

		//Descobre tamanho da caixa
		int tamanhoMaximo = 0;
		for (String linha : linhas) {
			if (linha.length() > tamanhoMaximo) {
				tamanhoMaximo = linha.length();
			}
		}

		//Faz a caixa da formatação
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

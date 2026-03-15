package subgrupostester;

import conversor.Conversor;
import java.util.HashSet;

/**
 * Classe responsável por testar os resultados de subgrupos e acionar o relatório.
 */
public class SubGruposTester {
	private Conversor conversor = new Conversor();
	private Relatorio relatorio = new Relatorio(); 
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
		SubGrupo subGrupo = new SubGrupo(conjunto, op, subConj);
		return relatorio.gerarRelatorio(
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
	 * Realiza o teste de subgrupo para conjuntos de matrizes.
	 */
	public String ehSubGrupoMatriz(String conjuntoOriginal, String operacao,
	 String subConjunto){

		HashSet<Double[][]> conjunto = conversor.paraConjuntoMatriz(conjuntoOriginal);
		HashSet<Double[][]> subConj = conversor.paraConjuntoMatriz(subConjunto);
		Operacao op = OperacaoController.getOperacaoMatriz(operacao);

		SubGrupo subGrupo = new SubGrupo(conjunto, op, subConj);

		return relatorio.gerarRelatorio(
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

		SubGrupo subGrupo = new SubGrupo(conjunto, op, subConj);

		return relatorio.gerarRelatorio(
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

		SubGrupo subGrupo = new SubGrupo(conjunto, op, subConj);

		return relatorio.gerarRelatorio(
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
}
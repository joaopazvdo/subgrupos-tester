 package subgrupostester;

import conversor.Conversor;
import grupo.SubGrupo;
import operacao.Operacao;
import operacao.OperacaoController;

import java.util.HashSet;

/**
 * Controlador do sistema testador de subgrupos.
 * 
 * @author jose-kauan-pereira00(José Kauan Pereira)
 * */
public class SubGruposTester {
	public SubGruposTester(){
	}

//	public boolean ehSubGrupoNumerico(String conjuntoOriginal, String operacao, 
//		String subConjunto){
	public String ehSubGrupoNumerico(String conjuntoOriginal, String operacao, 
			String subConjunto){
		HashSet<Double> conjunto = Conversor.paraConjuntoNumerico(conjuntoOriginal);
		HashSet<Double> subConj = Conversor.paraConjuntoNumerico(subConjunto);
		Operacao<Double> op = OperacaoController.getOperacaoNumerica(operacao);

		SubGrupo<Double> subGrupo = new SubGrupo<>(conjunto, op, subConj);

//		return subGrupo.ehSubGrupo();
		Relatorio<Double> relatorio = new Relatorio<>(subGrupo);
		return relatorio.gerarRelatorio();
	}

//	public boolean ehSubGrupoMatriz(String conjuntoOriginal, String operacao,
//	 String subConjunto){
	public String ehSubGrupoMatriz(String conjuntoOriginal, String operacao,
			 String subConjunto){

		HashSet<Double[][]> conjunto = Conversor.paraConjuntoMatriz(conjuntoOriginal);
		HashSet<Double[][]> subConj = Conversor.paraConjuntoMatriz(subConjunto);
		Operacao<Double[][]> op = OperacaoController.getOperacaoMatriz(operacao);

		SubGrupo<Double[][]> subGrupo = new SubGrupo<>(conjunto, op, subConj);

		Relatorio<Double[][]> relatorio = new Relatorio<>(subGrupo);
//		return subGrupo.ehSubGrupo();
		return relatorio.gerarRelatorio();

	}


//	public boolean ehSubGrupoBinario(String conjuntoOriginal, String operacao,
//	 String subConjunto){
	public String ehSubGrupoBinario(String conjuntoOriginal, String operacao,
			 String subConjunto){

	 	HashSet<Integer> conjunto = Conversor.paraConjuntoBinario(conjuntoOriginal);
		HashSet<Integer> subConj = Conversor.paraConjuntoBinario(subConjunto);
		Operacao<Integer> op = OperacaoController.getOperacaoBinaria(operacao);

		SubGrupo<Integer> subGrupo = new SubGrupo<>(conjunto, op, subConj);

//		return subGrupo.ehSubGrupo();
		Relatorio<Integer> relatorio = new Relatorio<Integer>(subGrupo);
		return relatorio.gerarRelatorio();
	}

//	public boolean ehSubGrupoMod(String conjuntoOriginal, String operacao,
//	 String subConjunto){
	public String ehSubGrupoMod(String conjuntoOriginal, String operacao,
			 String subConjunto){

	 	HashSet<String> conjunto = Conversor.paraConjuntoMod(conjuntoOriginal);
		HashSet<String> subConj = Conversor.paraConjuntoMod(subConjunto);
		Operacao<String> op = OperacaoController.getOperacaoMod(operacao);

		SubGrupo<String> subGrupo = new SubGrupo<>(conjunto, op, subConj);

//		return subGrupo.ehSubGrupo();
		Relatorio<String> relatorio = new Relatorio<String>(subGrupo);
		return relatorio.gerarRelatorio();
	}
}

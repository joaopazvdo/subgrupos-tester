package grupo;

import java.util.*;
import operacao.Operacao;

/**
 * Classe que verifica se um conjunto e uma operação formam um Grupo.
 * * @param <T> Tipo dos elementos (ex: Integer, String).
 * @author Marcos_Vinicius
 */
public class Grupo<T> {
	
	private Set<T> conjunto;
	private Operacao<T> op;
	private T identidade;
	
	/**
	 * Cria um novo verificador de grupo.
	 * @param conjunto O Set de elementos.
	 * @param op A operação a ser testada.
	 */
	public Grupo(Set<T> conjunto, Operacao<T> op) {
		this.conjunto = conjunto;
		this.op = op;
		this.identidade = null;
	}
	
	/**
	 * Verifica todas as propriedades obrigatórias de um Grupo.
	 * @return true se passar em todos os testes.
	 */
	public boolean ehGrupo() {
		return (ehFechado() && temIdentidade() && temInverso() && ehAssociativo());
	}
	
	/**
	 * Testa a associatividade: (a * b) * c == a * (b * c).
	 */
	public boolean ehAssociativo() {
		for (T a : conjunto) {
			for (T b : conjunto) {
				for (T c : conjunto) {
					T res1 = op.faz(op.faz(a, b), c);
					T res2 = op.faz(a, op.faz(b, c));
					if (!res1.equals(res2)) return false;
				}
			}
		}
		return true;
	}

	/**
	 * Verifica se o resultado da operação sempre permanece dentro do conjunto.
	 */
	public boolean ehFechado(){
		for (T x : conjunto) {
			for (T y : conjunto) {
				T resultado = op.faz(x, y);
				if (!conjunto.contains(resultado)) return false;
			}
		}
		return true;
	}
	
	/**
	 * Procura um elemento neutro 'e' tal que: a * e = e * a = a.
	 */
	public boolean temIdentidade(){
		for (T e : conjunto) {
			boolean ehIdentidade = true;
			for (T a : conjunto) {
				if (!op.faz(a, e).equals(a) || !op.faz(e, a).equals(a)) {
					ehIdentidade = false;
					break;
				}
			}
			if (ehIdentidade) {
				this.identidade = e;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Verifica se cada elemento 'a' possui um par 'b' que resulta na identidade.
	 */
	public boolean temInverso(){
		if (this.identidade == null && !temIdentidade()) return false;

		for (T a : conjunto) {
			boolean achouInverso = false;
			for (T b : conjunto) {
				if (op.faz(a, b).equals(identidade) && op.faz(b, a).equals(identidade)) {
					achouInverso = true;
					break;
				}
			}
			if (!achouInverso) return false;
		}
		return true;
	}
	
	public Set<T> getConjunto() { 
		return conjunto;
	}
	
	public Operacao<T> getOperacao() { 
		return op; 
	
	}
	public T getIdentidade() { 
		return identidade; 
	}
}
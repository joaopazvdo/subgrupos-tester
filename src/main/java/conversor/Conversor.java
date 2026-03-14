package conversor;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;

public class Conversor {

	public Conversor(){

	}

    /**
     * Método responsavel por trnasformar uma String no formato:
     * s = 
     * "n1, n2, n3",
     * "n4, n5, n6",
     * "n7, n8, n9"
     * em uma matriz de Double, que sera armazenada em um hashSet.
     * */
	public HashSet<Double[][]> paraConjuntoMatriz(String conjuto){
		List<Double[]> linhasTemporarias = new ArrayList<>();

        Pattern padrao = Pattern.compile("\\{([^}]+)\\}");
        Matcher buscador = padrao.matcher(conjuto);

        while (buscador.find()) {
            String conteudoLinha = buscador.group(1);

            String[] numerosEmTexto = conteudoLinha.split(",");
            Double[] linhaAtual = new Double[numerosEmTexto.length];

            for (int i = 0; i < numerosEmTexto.length; i++) {
                linhaAtual[i] = Double.parseDouble(numerosEmTexto[i].trim());
            }

            linhasTemporarias.add(linhaAtual);
        }

        Double[][] matrizFinal = linhasTemporarias.toArray(new Double[0][0]);

        HashSet<Double[][]> conjunto = new HashSet<>();

        conjunto.add(matrizFinal);

        return conjunto;
	}

    /**
     * Metodo responsavel por pegar uma String no formato:
     * s = "n1, n2, n3, n4, n5"
     * e trasforma-la em um hashSet com esses números
     * */
    public HashSet<Double> paraConjuntoNumerico(String conjunto){
        HashSet<Double> conj = new HashSet<>();

        String[] numeros = conjunto.split(",");

        for(String parte: numeros){
            Double num = Double.valueOf(parte.trim());
            conj.add(num);
        }

        return conj;
    }


    /**
     * Metodo responsavel por pegar uma String no formato:
     * s = "000 000 000"
     * e retornar "000" "000" "000"
     * */
    public HashSet<String> paraConjuntoBinario(String conjunto){
        HashSet<String> conj = new HashSet<>();

        String[] numeros = conjunto.split(" ");

        for(String parte: numeros){
            String num = parte.trim();
            conj.add(num);
        }
        return conj;
    }

    /**
     * Metodo reponsavel por pegar um String no formato:
     * z6 = "6"
     * e retornar um hasSet de todos os numero de 0  a z6 - 1
     * */
    public HashSet<Integer> paraConjuntoMod(String conjunto){
        int z = Integer.parseInt(conjunto.trim());
        HashSet<Integer> conj = new HashSet<>();

        for(int i = 0; i < z; i++){
            conj.add(i);
        }

        return conj;
    }
}

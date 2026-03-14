package conversor;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;

public class Conversor {

    /**
     * Método responsavel por trnasformar uma String no formato:
     * s = 
     * "n1, n2, n3",
     * "n4, n5, n6",
     * "n7, n8, n9"
     * em uma matriz de Double, que sera armazenada em um hashSet.
     * */
	public static HashSet<Double[][]> paraConjuntoMatriz(String conjuto){
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
    public static HashSet<Double> paraConjuntoNumerico(String conjunto){
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
     * e retornar [000, 000, 000]
     * */
    public static HashSet<Integer> paraConjuntoBinario(String conjunto){
        HashSet<Integer> conj = new HashSet<>();

        String[] numeros = conjunto.split(" ");

        for(String parte: numeros){
            Integer num = Integer.parseInt(parte.trim(), 2);
            conj.add(num);
        }
        return conj;
    }

    /**
     * Metodo reponsavel por pegar um String no formato:
     * z6 = "6"
     * e retornar um hasSet com as string "0 mod 6" , "1 mod 6", assim sussecivamente...
     * */
    public static HashSet<String> paraConjuntoMod(String conjunto){
        HashSet<String> conj = new HashSet<>();

        int[] numeros = Arrays.stream(conjunto.split("\\D+")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < numeros.length; i++){
            int numNoArray = numeros[i];

            for(int j = 0; j < numNoArray; j++){

                int num  = j % numNoArray;

                String mod = String.format("%d mod %d", num, numNoArray);

                conj.add(mod);
            }
        }

        return conj;
    }
}

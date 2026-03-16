/**
 * @author jose-kauan-pereira00(José Kauan Pereira)
 * */

package conversor;

import java.util.List;
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
        HashSet<Double[][]> conj = new HashSet<>();

        conjuto = conjuto.replaceAll("\\s+", "");

        conjuto = conjuto.substring(2, conjuto.length() -2);

        String[] linhas = conjuto.split("\\],\\[");

        Double[][] matriz = new Double[linhas.length][];

        for(int i = 0; i < linhas.length;i++){
            String[] colunas = linhas[i].split(",");
            matriz[i] = new Double[colunas.length];

            for(int j =0; j <colunas.length; j++){
                matriz[i][j] = Double.valueOf(colunas[j]);
            }
        }

        conj.add(matriz);

        return conj;
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

        String[] numeros = conjunto.trim().split(" ");

        for(String parte: numeros){
            Integer num = Integer.parseInt(parte.trim(), 2);
            conj.add(num);
        }
        return conj;
    }

    /**
     * Metodo reponsavel por pegar um String no formato:
     * z6 = [0, 1, 2, 3, 4,5] 6
     * e retornar um hasSet com as string "0 mod 6" , "1 mod 6", assim sussecivamente...
     * */
    public static HashSet<String> paraConjuntoMod(String conjunto){
        HashSet<String> conj = new HashSet<>();

        int fechamento = conjunto.indexOf("]");

        String numeroTexto = conjunto.substring(fechamento + 1).trim();

        int mod = Integer.parseInt(numeroTexto);

        String arrayString = conjunto.substring(1, fechamento);

        String[] partes = arrayString.split(",");

        for(int i = 0; i < partes.length; i++){
            int numero = Integer.parseInt(partes[i].trim());
            int numMod = Math.floorMod(numero, mod);
            String modulo = String.format("%d mod %d",numMod, mod);
            conj.add(modulo);
        }

        return conj;
    }
}

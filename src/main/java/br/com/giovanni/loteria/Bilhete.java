package br.com.giovanni.loteria;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Bilhete {
    private int[] numerosEscolhidos;
    private int[] realizarSorteio;
    private String nome;

    public Bilhete(int[] numerosEscolhidos, int[] realizarSorteio, String nome){
        this.numerosEscolhidos = numerosEscolhidos;
        this.realizarSorteio = realizarSorteio;
        this.nome = nome;
    }

    public Bilhete(){};

    public boolean jaFoi(int[] array, int numero, int tamanhoLista){
        for(int i = 0; i < tamanhoLista; i++){
            if(array[i] == numero){
                return true;
            }
        }
        return false;
    }

    public int contadorAcertos(){
        int acertos = 0;
        for(int numeroEscolhido:numerosEscolhidos){
            for(int numeroSorteado:realizarSorteio){
                if(numeroEscolhido == numeroSorteado){
                    acertos++;
                }
            }
        }
        return acertos;
    }

    public int[] realizarSorteio(){
        Random random = new Random();
        realizarSorteio = new int[6];
        int numero = 0;

        for(int i =0; i < realizarSorteio.length; i++) {
            do {
                numero = random.nextInt(60) + 1;
            } while (jaFoi(realizarSorteio, numero, i));
            realizarSorteio[i] = numero;
        }
        Arrays.sort(realizarSorteio);
        return realizarSorteio;
    }

    public void exibirResultado(){
        int acertos = contadorAcertos();
        Arrays.sort(numerosEscolhidos);
        Set<Integer> set = new HashSet<>();
        Set<Integer> numerosIguais = new HashSet<>();

        for(int num:numerosEscolhidos){
            set.add(num);
        }

        for(int num:realizarSorteio){
            if(set.contains(num)){
                numerosIguais.add(num);
            }
        }

        System.out.printf("""
                -------------------------------------------
                Bilhete do %s
                Números escolhidos: %s
                Números sorteados: %s
                Você teve um total de %d %s
                Números acertados: %s
                """, nome, Arrays.toString(numerosEscolhidos), Arrays.toString(realizarSorteio), acertos, acertos == 1 ? "acerto":"acertos", numerosIguais.toString());
    }
}


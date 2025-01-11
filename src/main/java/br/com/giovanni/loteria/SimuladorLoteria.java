package br.com.giovanni.loteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SimuladorLoteria {
    public static void loteria() {
        Scanner leitor = new Scanner(System.in);
        ArrayList<Bilhete> listaBilhete = new ArrayList<>();
        var nomeJogador = new NomeJogador();
        var bilhete = new Bilhete();

        int[] numerosSorteados = bilhete.realizarSorteio();

        while(true) {
            System.out.println("Digite o nome do dono do bilhete: ");
            String nome = nomeJogador.jogador(leitor);

            System.out.println("Digite 6 números para seu bilhete (entre 1 e 60): ");
            int[] numerosEscolhidos = new int[6];

            for (int i = 0; i < numerosEscolhidos.length; i++) {
                boolean numeroValido = false;

                while (!numeroValido) {
                    System.out.printf("""
                            Digite seu número %d:
                            """, (i + 1));
                    int numero = leitor.nextInt();

                    if (numero > 60) {
                        System.out.println("Número não pode ser maior que 60");
                    } else if (numero < 1) {
                        System.out.println("Número não pode ser menor que 1");
                    } else if (bilhete.jaFoi(numerosEscolhidos, numero, i)) {
                        System.out.println("Número já escolhido");
                    } else {
                        numerosEscolhidos[i] = numero;
                        numeroValido = true;
                    }
                }
            }
            Bilhete bilhete1 = new Bilhete(numerosEscolhidos, numerosSorteados, nome);
            listaBilhete.add(bilhete1);

            System.out.println("Deseja registrar outro bilhete? (s/n)");
            String opcao = leitor.next();

            if (opcao.equalsIgnoreCase("n")) {
                break;
            }
        }
            System.out.println("Realizando sorteio...");
            for(Bilhete bilhete1:listaBilhete){
                bilhete1.exibirResultado();
            }
            leitor.close();
        }
    }


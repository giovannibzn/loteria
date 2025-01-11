package br.com.giovanni.loteria;

import java.util.Scanner;

public class NomeJogador {
    public String jogador(Scanner scanner){
        String nome = "";

        while(nome.isBlank()){
            nome = scanner.nextLine();
        }

        String[] partes = nome.split(" ");
        StringBuilder builder = new StringBuilder();

        for(String parte:partes){
            builder.append(parte.substring(0, 1).toUpperCase().trim());
            builder.append(parte.substring(1).toLowerCase().trim());
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}

package br.com.capgemini.q2;

import java.util.Scanner;

public class Questao2 {

	public static void main(String[] args) {
        System.out.println("Insiria a senha com no mínimo 6 caracteres: ");
        Scanner in = new Scanner( System.in );

        StrongPass strongPass = new StrongPass(in.nextLine()); 
        System.out.println("Saída: ");
        
        if(strongPass.isStrongEnough()) {
        	System.out.println("Senha valida.");
        }
        
        in.close();
	}
}

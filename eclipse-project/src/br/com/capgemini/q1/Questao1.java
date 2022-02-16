package br.com.capgemini.q1;

import java.util.Scanner;

public class Questao1 {
	public static void main(String[] args) {
	    int n = 0;
	    char space = ' ';
	    char asterisk = '*';
	    
        System.out.println("Insiria valor de n: ");
        Scanner in = new Scanner( System.in );
        n = Integer.parseInt(in.nextLine());
	    
        System.out.println("Saída: ");
	    int aux = n;   
	    while(aux > 0){
	        for(int i = 0; i < n; i++){
	            if(i < aux - 1){
	            	System.out.print(space);
	            }else{
	            	System.out.print(asterisk);
	            }
	        }
	        System.out.println("");
	        aux--;
	    }
	    
	    in.close();
	}
}

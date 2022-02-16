package br.com.capgemini.q3;

import java.util.ArrayList;
import java.util.Scanner;

public class Questao3 {
    static final int MAX = 256;
    
    static boolean bCompare(char array1[], char array2[]) {
        for (int i = 0; i < MAX; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
 
    static void findAnagrams(String txt) {
    	ArrayList<String> outStrs = new ArrayList<>();
    	
    	for(int patternI = 0; patternI < txt.length(); patternI++) {
        	for(int patternJ = 0; patternJ < txt.length(); patternJ++) {
        		if(patternI > patternJ || patternI == patternJ) {
        			continue;
        		}
        		
	    		String pat = txt.substring(patternI, patternJ);
	    		int count = 0;
	    		
		    	ArrayList<int[]> positions = new ArrayList<int[]>();
		    	
		        int M = pat.length();
		        int N = txt.length();
		 
		        char[] countP = new char[MAX];
		        char[] countTW = new char[MAX];
		        for (int i = 0; i < M; i++) {
		            (countP[pat.charAt(i)])++;
		            (countTW[txt.charAt(i)])++;
		        }

		        for (int i = M; i < N; i++) {
		            if (bCompare(countP, countTW)) {
		                int test[] = new int[M];
		                for(int x = 0; x < M; x++) {
		                	test[x] = (i - M) + x;
		                }
		                
		                positions.add(test);
		                count++;
		            }
		             
		            (countTW[txt.charAt(i)])++;
		            countTW[txt.charAt(i-M)]--;
		        }
		 
		        if (bCompare(countP, countTW)) {
		        	int test[];
	                if(count > 0 && positions.get(0).length == 1) {
	                	test = new int[1];
	                	test[0] = (N - M);
	                }else {
		                test = new int[2];
		                test[0] = (N - M);
		                test[1] = N-1;
	                }
	                
	                positions.add(test);
	                count++;
		        }
		        
		        if(count == 2) {
		        	String outAux = "";
			        
		        	if(positions.get(0).length == positions.get(1).length) {
		        	
			        	outAux += "Encontrado: [";
				        for(int i = 0; i < positions.size(); i++) { 	
				        	for(int j = 0; j < positions.get(i).length; j++) {
				        		outAux += txt.charAt(positions.get(i)[j]);
				        	}
				        	if(i != positions.size() - 1) {
				        		outAux += ", ";
				        	}      	
				        }
				        outAux += "]";
				        if(!outStrs.contains(outAux)) {
				        	outStrs.add(outAux);
				        }
		        	}
		        }
	    	}
    	}
    	
    	for(String str : outStrs) {
    		System.out.println(str);
    	}
    	System.out.println("Quantidade de pares: " + outStrs.size());
    }
	
	public static void main(String[] args) {
		System.out.println("Primeiro Exemplo:");
        findAnagrams("ifailuhkqq");

        System.out.println("\nSegundo Exemplo:");
        findAnagrams("ovo");
        
        System.out.println("\nInsira uma palavra:");
        Scanner in = new Scanner(System.in);
        findAnagrams(in.nextLine());
        
        in.close();
	}
}

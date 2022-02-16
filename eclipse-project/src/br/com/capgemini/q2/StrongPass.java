package br.com.capgemini.q2;

public class StrongPass {
	private String password;
	public static int MINIMUM_PASS_CHAR = 6;
	public static String SPECIAL_CHARS = "!@#$%^&*()-+";
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	private boolean isEnoughCharacters(int minimum) {
		return (getPassword().length() >= minimum);
	}
	
	private boolean isEnoughDigits() {
		for(int i = 0; i < getPassword().length(); i++) {
			if(getPassword().charAt(i) >= '0' && getPassword().charAt(i) <= '9') {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isEnoughUpper() {
		for(int i = 0; i < getPassword().length(); i++) {
			if(getPassword().charAt(i) >= 'A' && getPassword().charAt(i) <= 'Z') {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isEnoughLower() {
		for(int i = 0; i < getPassword().length(); i++) {
			if(getPassword().charAt(i) >= 'a' && getPassword().charAt(i) <= 'z') {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isEnoughSpecialChar() {
		for(int i = 0; i < getPassword().length(); i++) {
			for(int j = 0; j < SPECIAL_CHARS.length(); j++) {
				if(getPassword().charAt(i) == SPECIAL_CHARS.charAt(j)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isStrongEnough() {
		boolean aux = true;
		
		if(!isEnoughCharacters(MINIMUM_PASS_CHAR)) {
			System.out.println("Necessário inserir mais " + (MINIMUM_PASS_CHAR - getPassword().length()) + " caracteres.");
			aux = false;
		}
		
		if(!isEnoughDigits()) {
			System.out.println("Necessário ter ao menos 1 digito.");
			aux = false;
		}
		
		if(!isEnoughUpper()) {
			System.out.println("Necessário ter ao menos 1 letra maiuscula.");
			aux = false;
		}
		
		if(!isEnoughLower()) {
			System.out.println("Necessário ter ao menos 1 letra miniscula.");
			aux = false;
		}
		
		if(!isEnoughSpecialChar()) {
			System.out.println("Necessário ter ao menos 1 caracter especial.");
			aux = false;
		}
		
		return aux;
	}
	
	StrongPass(String password){
		setPassword(password);
	}
}

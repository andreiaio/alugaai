package br.com.trocagroup.util;

import java.util.regex.*;

public class Utils {
	public static final Pattern VALID_FULL_NAME_REGEX = 
		    Pattern.compile("^[\\p{L} .'-]+$");
	
	public static final Pattern VALID_CEP_REGEX = 
		    Pattern.compile("^\\d{8}$");
	
	public static final Pattern VALID_CPF_REGEX = 
		    Pattern.compile("(?!(\\d)\\1{10})\\d{11}");
	
	public static final Pattern VALID_EMAIL_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static boolean validate(String stringToValidade,Pattern pattern) {
        Matcher matcher = pattern.matcher(stringToValidade);
        return matcher.find();
	}
}

package com.desafio.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	
	public static BigDecimal formatarValor(String valor) {
		Pattern pat = Pattern.compile("R\\$[\\t ]*((\\d{1,3}\\.?)+(,\\d{2}))");
	    Matcher mat = pat.matcher(valor);
	    String valorFormatado = "";
	    
	    if (mat.find( )) {
	    	valorFormatado = mat.group(1);
	    }
	    
	    if(!valorFormatado.equals("") || valorFormatado != null) {
	    	valorFormatado = valorFormatado.replace(".","");
	    	valorFormatado = valorFormatado.replace(",",".");
	    	
	    	return new BigDecimal(valorFormatado);
	    }
		
		return BigDecimal.ZERO;
	}
	

}

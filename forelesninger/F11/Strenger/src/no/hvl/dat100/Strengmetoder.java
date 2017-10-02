package no.hvl.dat100;

public class Strengmetoder {
	
	 public static boolean erPalindrom(String t){
   	  
	  		t = t.toLowerCase();
	  		
	  		int v = 0;
	  		int h = t.length() - 1;
	  		boolean palindrom = true;
	  		
	  		while (palindrom && (v < h)){
	  			palindrom = (t.charAt(v) == t.charAt(h));
	  			v++;
	  			h--;
	  		}
	  		
	  		return palindrom;
	      }
	      
	      public static void delOpp(String t, String delestreng){

	  		String[] res = t.split(delestreng);
	  		
	  		for (String s : res){
	  			System.out.println(s);
	  		}
	      }
	      
	      public static void skrivMidten(String s){
	    	  // Antar strengen har minst ett tegn
	    	  
	    	  String svar = "";
	    	  int lengde = s.length();
	    	  if (lengde % 2 == 0){//partall
	    		  int start = lengde / 2 - 1;
	    		  svar = s.substring(start, start + 2);
	    	  } else { // oddetall
	    		  if (lengde == 1){
	    			  svar = s;
	    		  } else {
	    			  int start = lengde / 2 - 1;
	    			  svar = s.substring(start, start + 3);
	    		  } 		  
	    	  }
	    	  
	    	  System.out.println(svar);
	      }

}

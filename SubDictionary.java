package Dictionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SubDictionary {
	//eleminate characters 
		public static String evaluateChar(String s) {
			//start array 
	        char[] c = s.toCharArray();
	        //Apply restrictions on text
	        if (c[c.length - 1] == '.' || c[c.length - 1] == ':' || c[c.length - 1] == ',' || c[c.length - 1] == '?'|| c[c.length - 1] == ';' || c[c.length - 1] == '!')
	        	return s.substring(0, s.length() - 1);
	        else if (c.length > 2 && c[c.length - 2] == '\'')
	        	return s.substring(0, s.length() - 2);
	        else if (c.length == 1)
	        	return (null);
	        else
	        	return s;
		}
	  
		/**
		 * checkNumbersRules()
		 * @param r
		 * @return
		 */
		public static boolean checkNumbersRules(String r) {
	        char[] c = r.toCharArray();
	        int i = 0;
	        //check if the character has a number in its value
	        while(i < c.length){
	        	if (Character.isDigit(c[i]))
	                return true;
	        	i++;
	        } return false;
	    }
		
		
		//create array list
	    public static void createArrayList(ArrayList<String> list, Scanner input) {
	        for(String r = input.next().toUpperCase();input.hasNext(); r = evaluateChar(r)) {
	            if (r != null && !list.contains(r) && !checkNumbersRules(r))
	                list.add(r);
	        }
	    }
	   
	    /**
	     * printOut() arrayList
	     * @param arr
	     * @param p
	     */
	    public static void printOut(ArrayList<String> arr, PrintWriter p) {
	        p.println("\n The document produced this sub-dictionary, which has "+arr.size()+" entries.\n");
	        //A loop to print the arrayList
	        int i=0;
	        while(i <arr.size()-1) { 
	            if (i == 0) 
	                p.println("\n " + arr.get(0).charAt(0));
	                p.println("==");
	                p.println(arr.get(0));
	            
	            if (i > 0) 
	                p.println(arr.get(i));
	                if (arr.get(i).charAt(0)!= arr.get(i+1).charAt(0)) 
	                    p.println("\n" + arr.get(i+1).charAt(0));
	                    p.println("==");
	           
	            i++;        
	        }
	        p.print(arr.get(arr.size()-1));
	    }
	    
	    
	    
	    public static void write(ArrayList<String> arrList, PrintWriter p) {
	        p.println("The document produced this sub-dictionary, which has "+arrList.size()+" entries.");
	        
	        for (int i = 0; i < arrList.size() - 1; i++) {
	            if (i == 0) {
	                p.println("\n" + arrList.get(0).charAt(0));
	                p.println("==");
	                p.println(arrList.get(0));
	            }
	            
	            if (i > 0) {
	                p.println(arrList.get(i));
	                if (arrList.get(i).charAt(0) != arrList.get(i + 1).charAt(0)) {
	                    p.println("\n" + arrList.get(i + 1).charAt(0));
	                    p.println("==");
	                }
	            }
	        } p.print(arrList.get(arrList.size()-1));
	    }
	    
	    
	    
	    
	    //  main method 
		public static void main(String[] args) {
			String fileName = "PersonOfTheCentury.txt";
			Scanner sc = null;
			try {
				sc = new Scanner(new FileInputStream(fileName));
			} catch (FileNotFoundException e) {
				System.out.println("File" + fileName + " could not be opened/found. Please check your directory.");
				System.exit(0);
			}
			ArrayList<String> arr = new ArrayList<String>();
			createArrayList(arr, sc);
			arr.sort(null);

			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileOutputStream("Subdictionary.txt"));

				write(arr, pw);
				pw.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			}

	}

}

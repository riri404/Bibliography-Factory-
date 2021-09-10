/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  *  Assignment 3
  *  Comp 249 summer 2020
  *  ID# 40116096
  *  due 16 August 
  * @author Rama Alrifai
  *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  */

package CellPhone;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

class CellListUtilization extends CellList {

	public static void main(String[] args) throws IOException{
		//create at least 2 empty lists from CellList
		CellList list1=new CellList();
	    CellList list2=new CellList();
	    Scanner input=null;
	    try{
	    	input=new Scanner(new FileInputStream("Cell_Info.txt"));
	    	String start=" ";
	    	String line=input.nextLine();
    		Scanner StartScanner=new Scanner(line);
    
	    	while(input.hasNextLine()){
	    		start +=line;
			    line=input.nextLine();
	    		//as long as Cell_Info.txt has a nest line
	    		long serialNum=StartScanner.nextLong();
	    		String brand=StartScanner.next();
	    		double price=StartScanner.nextDouble();
	    		int year=StartScanner.nextInt();
	    		
	    		CellPhone displayCell=new CellPhone(serialNum,brand,price,year);
	    		if(!list1.contains(serialNum) || !list2.contains(serialNum)){
	    			list1.addToStart(displayCell);
	    			list2.addToStart(displayCell);
	    		}
	    		StartScanner.close();
	         }
	    	
	    	System.out.println(start);
	    	input.close();
	        }catch(FileNotFoundException e){
	            System.out.println("The File you are looking for is not found!");
	            System.exit(0);
	        }
	    
	    
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("   Enter a serial number that you want to search:    ");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    
	  /**
	   * prompt the user to search serial number in the list + print the searched serial number
	   */
	    input=new Scanner(System.in);
	    System.out.println(input);
	    
	    /**
	     * testing addToStart()
	     */
	    System.out.println("\n Testing the addToStart(): ");
	    CellPhone cell=new CellPhone(3890909,"Samsung",857.28,2015);
	    list1.addToStart(cell);
	    
	    /**
	     * Show the contents of the list just initialized list 
	     * show the contents inside the list
	     */
	    System.out.println("\n Showing contents: ");
	    list1.showContents();
	    
	    
	    /**
	     * Testing the insertAtIndex() 
	     * test if index is 0
	     * test if index is any index
	     * display final list
	     */
	    System.out.println("\n Testing the insertAtIndex():");
        System.out.println("-Testing if the index was any number (general case):");
        list1.insertAtIndex(cell, 5);
        
        System.out.println("-Testing if index is 0 (special case):");
        list1.insertAtIndex(cell, 0);
        
        System.out.println("Display final contents of list: ");
        list1.showContents();
	    
        
	    
        /**
         * Testing the deleteFromIndex()
         * test if index was 0
         * trst if index was any number 
         * display final list
         */
        System.out.println("\n \n Testing of deleteFromIndex method: ");
        System.out.println("-Test if index is negative: ");
        list1.deleteFromIndex(-1);
        
        System.out.println("-Testing if the index was any number (general case):");
        list1.deleteFromIndex(5);
        
        System.out.println("-Testing if index is 0 (special case):");
        list1.deleteFromIndex(0);
        
        System.out.println("Display final contents of list:");
        list1.showContents();
        
        
        input=new Scanner(System.in);
        char ans=input.next().toUpperCase().charAt(0);
        CellList list = null;
        do{
        	input=new Scanner(System.in);
            System.out.println("\n Please enter a serial number that you want to search:");
            long next=input.nextLong();
            list.contains(next);
        	System.out.println("\n Enter a serial number that you want to search:");
            ans=input.next().toUpperCase().charAt(0);
        	
        }while(ans=='Y'); 
           


	}

}

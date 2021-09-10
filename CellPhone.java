/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *  Assignment 3
	 *  Comp 249 summer 2020
	 *  ID# 40116096
	 *  due 9 August 
	 * @author Rama Alrifai
	 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */

//create seperate package for cellphone
package CellPhone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class CellPhone implements Cloneable{
		private long serialNum;
		private String brand;
		private int year;
		private double price;
		
		/**
		 * Default constructor
		 */
		public CellPhone() {
			serialNum=0;
			brand=" ";
			year=0;
			price=0.0;
		}
		
		/**
		 * param construstor
		 * @param string 
		 * @param serialNum
		 * @param brand
		 * @param year
		 * @param price
		 */
		public CellPhone(long s, String br, double price2, int yer) {
			this.serialNum = s;
			this.brand = br;
			this.price = price2;
			this.year = yer;
		}

		/**
		 * copy constructor
		 * @param c
		 * @param n
		 */
		public CellPhone(CellPhone c, long n) {
			this.serialNum=n;
			this.brand= c.brand;
			this.price=c.price;
			this.year=c.year;
		}
		
		/**
		 * String toString()
		 */
		@Override
		public String toString() {
			return "CellPhone [serialNum=" + serialNum + ", brand=" + brand + ", year=" + year + ", price=" + price
					+ "]";
		}

		/**
		 * equals()
		 * @param Object 
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CellPhone other = (CellPhone) obj;
			return Objects.equals(brand, other.brand)
					&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
					&& serialNum == other.serialNum && year == other.year;
		}

		/**
		 * CellPhone clone()
		 */
		public CellPhone clone(){
			Scanner input=new Scanner(System.in);
			System.out.println("\n Please enter the new serial number: ");
			long serial=input.nextLong();
			if(this.serialNum==serial){
				System.out.println("\n The serial number that you entered is same as the previous one, please enter a different number.");
				clone();
				input.close();
			}
			return new CellPhone(this,serial);
		    }
		  
		  
		/**\
		 * 
		 * @return serialNum
		 */
		public long getSerialNum() {
			return serialNum;
		}
		/**
		 * 
		 * @param serialNum
		 */
		public void setSerialNum(long serialNum) {
			this.serialNum = serialNum;
		}

		/**
		 * 
		 * @return brand
		 */
		public String getBrand() {
			return brand;
		}
		/**
		 * 
		 * @param brand
		 */
		public void setBrand(String brand) {
			this.brand = brand;
		}

		/**
		 * 
		 * @return year
		 */
		public int getYear() {
			return year;
		}
		/**
		 * 
		 * @param year
		 */
		public void setYear(int year) {
			this.year = year;
		}

		/**
		 * 
		 * @return price
		 */
		public double getPrice() {
			return price;
		}
		/**
		 * 
		 * @param price
		 */
		public void setPrice(double price) {
			this.price = price;
		}

		
	public static void main(String[] args) throws IOException {
		try {
			BufferedReader fileReader=new BufferedReader(new FileReader("Cell_Info.txt"));
		
		    String start=" ";
		    String line= fileReader.readLine();
		    Scanner startLine= new Scanner(line);
		    while(line!= null) {
			     start +=line;
			     line=fileReader.readLine();
			    
			     } startLine.close();
		    fileReader.close();
		System.out.println(start);
		}catch(FileNotFoundException e) {
			System.out.println("File Cell_Info.txt not found!");;
		}

	}

}

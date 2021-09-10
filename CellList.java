package CellPhone;

import java.util.NoSuchElementException;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  *  Assignment 3
  *  Comp 249 summer 2020
  *  ID# 40116096
  *  due 16 August 
  * @author Rama Alrifai
  *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  */


public class CellList implements Cloneable{
	
	/**
	 * Inner class
	 */
	public class CellNode implements Cloneable{
		private CellPhone cell;
		private CellNode cellN;
		
		/**
		 * Default Constructor
		 */
		public CellNode() {
			cell=null;
			cellN=null;
		}

		
		/**
		 * param Constructor
		 * @param cell
		 * @param cellN
		 */
		public CellNode(CellPhone c, CellNode cn) {
			this.cell = c;
			this.cellN = cn;
		}
		
		/**
		 * Copy constructor
		 * @param cnd
		 */
		public CellNode(CellNode cnd) {
			this.cell=cnd.cell;
			this.cellN=cnd.cellN;
		}
		
		/**
		 * @return the cell
		 */
		public CellPhone getCell() {
			return cell;
		}

		/**
		 * @param cell the cell to set
		 */
		public void setCell(CellPhone cell) {
			this.cell = cell;
		}

		/**
		 * @return the cellN
		 */
		public CellNode getCellN() {
			return cellN;
		}

		/**
		 * @param cellN the cellN to set
		 */
		public void setCellN(CellNode cellN) {
			this.cellN = cellN;
		}
	
		/**
		 * Clone()
		 */
		public CellNode clone() {
			return new CellNode(this);
		}
		
	}

	/**
	 * Declaring variables
	 */
	private CellNode head;
	private int size;
	
	/**
	 * Default constructor
	 */
	public CellList() {
		head=null;
		size=0;
	}
	
	/**
	 * copy constructor
	 * @param cellObj
	 */
	public CellList(CellList cellObj) {
		if(cellObj.head==null)
		  head=null;
		else { 
		  CellNode node1,node2;
		  node1=cellObj.head;
		  node1=node1.cellN;
		  node2=this.head=new CellNode(node1.cell,null);
		  while(node1!=null) {
			  node1=node1.cellN;
			  node2=node2.cellN=new CellNode(node1.cell,null);
		  }
		}
		this.size=cellObj.size;
	}
	
	/**
	 * addToStart() create node obj then put it at the top of the list 
	 * =head
	 * @param cell_phone
	 */
	public void addToStart(CellPhone cell_phone) {
		head= new CellNode(cell_phone,head);
	}
	
	/**
	 * insertAtIndex() create CellPhone object and int n which represent the index. 
	 * If the index is not valid the method must throw a NoSuchElementException and terminate the program .
	 * If the index is valid, then the method creates a node with the passed CellPhone object and inserts this node at the given index.
	 * @param c1
	 * @param n
	 */
	public void insertAtIndex(CellPhone phone, int n) {
		try {
			if(n<0 || n>this.size-1) 
				throw new NoSuchElementException();
			
		}catch (NoSuchElementException e) {
			System.out.println("Index is Out of Bounds!");
			System.exit(0);
		}
		if(n==0)
			addToStart(phone);
		else {
		    CellNode first = head;
		    int i=0;
		    while(i<(n-1)) {
		    	first=first.cellN;
		    }
		    first.cellN= new CellNode(phone,first.cellN); 
		}
	}

	/**
	 * deleteFromIndex() if the index is not valid, 
	 * the method must throw a NoSuchElementException and terminate the program;
	 * Otherwise; the node pointed by that index is deleted from the list.
	 * @param ind =index
	 */
	public void deleteFromIndex(int n) {
		try {
			if(n<0 || n< this.size-1)
				throw new NoSuchElementException();
		}catch(NoSuchElementException e) {
			System.out.println("Index is Out of Bounds!");
			System.exit(0);
		}
		if(n==0)
			deleteFromStart();
		else {
			CellNode deleted= head;
			int i=0;
			while(i<n-1) {
				deleted=deleted.cellN;
				i++;
			}deleted.cellN=deleted.cellN.cellN;
			size--;
			deleted=null;
		    
			}
		}
	
	/**
	 * deleteFromStart(), which deletes the first node in the list,the one pointed by head.
	 */
	public void deleteFromStart(){
		if(head==null)
			return;

		head=head.cellN;
	    size--;
	 }
	
	/**
	 * replaceAtIndex(), which accepts CellPhone Object and an int n that represent the index.
	 * If the index is not valid, the method simply returns;
	 * otherwise, the object in the node at the passed index is to be replaced by the passed object
	 * @param phone
	 * @param n
	 */
	public void replaceAtIndex(CellPhone phone, int n) {
		if(n<0 || n<this.size-1)
			return;
		else {
			CellNode index=head;
		    int i=0;
		    while(i<n) {
		    	index=index.cellN;
		    	i++;
		    }
		    index.cell=phone;
		}
	}
	
	/**
	 * find(), which accepts long representing a serial number.The method then searches the list for a node with a cell phone with that serial number.
	 * if found, then the method returns a pointer to that node where the object is found; otherwise, the method returns null.
	 * The method must keep track of count
	 * @param serialNum
	 * @return
	 */
	public CellNode find(Long serialNum) {
		CellNode node=head;
		int count=1;
		while(node!= null) { 
			if(node.cell.getSerialNum()== serialNum) {
				System.out.println("The Cellphone is at index : "+count);
		        return node;
		        }
		    else{
		    	node=node.cellN;
			    count++; //Always increment the count
		    }
		}
		return node;	
	}
	
	/**
	 * contains() accepts long serialNum the method returns true if an object with a serial number is in the list.
	 * otherwise, the method returns false. 
	 * @param serialNum
	 * @return
	 */
	public boolean contains(long serialNum) {
		for(CellNode inList=head; inList!=null;inList=inList.cellN) {
			if(inList.cell.getSerialNum()==serialNum)
				System.out.println("Object with same serial number is found.");
				return true;
		}
		System.out.println("Object doesn't have the same serial number");
		return false;
	}

	/**
	 * showContents() which displays the contents of the list
	 */
	public void showContents() {
		System.out.println("\n The cuurent size of the List is :"+size);
		System.out.println("Here are the content of the List: ");
		System.out.println("=================================================================");
		
		CellNode show=head;
		while(show!=null) {
			System.out.println(show.cell.toString()+ "----->");
			show=show.cellN;
		if(head==null) 
			System.out.println("The List is empty.");
		
		}
		System.out.println("X");
		
	}
	
	/**
	 * CellList clone()
	 */
	public CellList clone() {
		return new CellList(this);
	}
	
	/**
	 * hashCode()	
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + size;
		return result;
	}

	/**
	 * equals(),which accepts a cellList obj The method returns true if the two lists contain similar objects;
	 * otherwise, the method returns false
	 * @param obj
	 */
	public boolean equals(CellList obj) {
		if (this == obj){
			return true;
		}
		if (!(obj instanceof CellList)) {
			return false;
		}
		CellList other = (CellList) obj;
		if (head == null) {
			if (other.head != null) {
				return false;
			}
		} else if (!head.equals(other.head)) {
			return false;
		}
		if (size != other.size) {
			return false;
		}
		return true;
	}


}

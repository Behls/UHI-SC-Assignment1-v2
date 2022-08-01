/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

public class UnorderedLinkedListPriorityQueue<T> implements PriorityQueue<T> {
	
	 private Node<T> head;
	   
	   public UnorderedLinkedListPriorityQueue(){
	      head = null;
	   }
	   
	   
	   @Override 
	   public void add(T item, int priority) throws StringIndexOutOfBoundsException{
	       
	       Node createdNode = new Node(item,priority);
	       Node currentNode = (head);

	       
	       if(head == null){
	           head = createdNode;
	           return;
	           
	       } while(currentNode.getNext() != null) {
	    	   
	    	   currentNode = currentNode.getNext();	   
	    	   
	       }
	       
	       currentNode.setNext(createdNode);
	   }
	   
	   @Override
	   public T head() throws QueueUnderflowException {
	       if(isEmpty()){
	           throw new QueueUnderflowException();
	       }else{
	           
	    	   Node currentNode = head;
	    	   
	    	   int max = head.getPriority();
	        	
	        	PriorityItem biggestItem = head;
	        
	        	
	        	while(currentNode.getNext() != null) {
	        		
	        		currentNode = currentNode.getNext();
	        	
	        		if(currentNode.getPriority() > max) {
	        			
	        			max = currentNode.getPriority();
	        			biggestItem = currentNode;
	        			
	        			
	        		}		
	        	}
	        	
	        	return (T) biggestItem.getItem();
	       }
	   }
	   
	   

	   @Override
	   public void remove() throws QueueUnderflowException {
	       
	       Node currentNode = head;  	   
    	   int max = head.getPriority();
        	
        	PriorityItem biggestItem = head;
        
        	
        	while(currentNode.getNext() != null) {
        		
        		currentNode = currentNode.getNext();
        	
        		if(currentNode.getPriority() > max) {
        			
        			max = currentNode.getPriority();
        			biggestItem = currentNode;
        			
        			
        		}		
        	}
        	
        	currentNode = head;  
        	if(currentNode == biggestItem) {
	    	   if (currentNode.getNext() !=null) {
	    		   head = head.getNext();
	    	   }
	    	   else {
	    		   head = null;
	    	   }
	       }
	           
	       while(currentNode.getNext() != null) {
	    	   
	    	   if(currentNode.getNext().getNext() != null && currentNode.getNext() == biggestItem ) {
	    		   
	    		   currentNode.setNext(currentNode.getNext().getNext());
	    		   break;
	    		   
	    	   }else if(currentNode.getNext() == biggestItem){
	    		   System.out.print("removing last element");
	    		   currentNode.setNext(null);
	    		   break;
	    	   }else {
	    		   currentNode = currentNode.getNext();
	    		 
	    	   }
	    	   
	       }
	      
	       
	   }
	   

	   @Override
	   public boolean isEmpty() {
	       return this.head == null;
	   }

	   @Override
	   public String toString() {
		   
		   Node currentNode = (head);
		   String message = "";
		   
		   
		   if(head != null){
			   
			   message+= "[( " +head.getItem()+ " , "+head.getPriority()+ " )";
			   
			   while(currentNode.getNext() != null) {
				  
				   currentNode = currentNode.getNext();
				   message += "( " +currentNode.getItem()+ " , "+currentNode.getPriority()+ " )";
			
			   }
		   
		   }
		  
	       return message;
	   }

}
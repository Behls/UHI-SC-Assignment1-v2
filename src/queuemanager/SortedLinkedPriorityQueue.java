/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

/**
*
* @author Alanna Zimbehl - 19016467
* @param <T> can be of any type                        
*/
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T>{
   
   private Node<T> head;
   
   public SortedLinkedPriorityQueue(){
      head = null;
   }
   
   
   @Override 
   public void add(T item, int priority) throws StringIndexOutOfBoundsException{
       
       Node createdNode = new Node(item,priority);
       Node currentNode = (head);
       
       Boolean ifInsert = false;
       
       if(head == null){
           head = createdNode;
           return;
           
       } while(currentNode.getNext() != null) {
    	   
    	   if(currentNode.getNext().getPriority() < createdNode.getPriority()) {		   
    		   
    		   createdNode.setNext(currentNode.getNext());
    		   currentNode.setNext(createdNode);
    		   
    		   ifInsert = true;
    		   
    		   break;
    		  
    	   }
    	   
    	   currentNode = currentNode.getNext();
    	   
    	   
       }
       
       if (ifInsert == false) {
    	   
    	   currentNode.setNext(createdNode);
    	   
       }
      
   }
   
   @Override
   public T head() throws QueueUnderflowException {
       if(isEmpty()){
           throw new QueueUnderflowException();
       }else{
           return (T) head.getItem();
       }
   }
   
   

   @Override
   public void remove() throws QueueUnderflowException {
       Node temp = head;
       (head) = head.getNext();
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

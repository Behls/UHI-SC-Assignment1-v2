/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

/**
*
* @param <T>
* @alanna Zimbehl - 19016467
*/

public class Node<T> extends PriorityItem<T>{
   
   /**
contains the person and the priority fields/data for person object within the node
*/
	
//   next field for bridge of next node
   private Node next;
   

    public Node(T item, int priority){
    	super(item, priority);
   }           

   public Node getNext() {
       return next;
   }

   public void setNext(Node next) {
       this.next = next;
   }
   
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

public class UnorderedArray<T> implements PriorityQueue<T> {

    /**
     * Where the data is actually stored.
     */
    private final PriorityItem[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    
//    stores the current index value
    
    private int currentIndex = 0;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public UnorderedArray(int size) {
        storage = new PriorityItem[size];
        System.out.println(storage);
        capacity = size;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
        	
        	int max = Integer.MIN_VALUE;
        	
        	PriorityItem biggestItem = new PriorityItem(null,0);
        	
        	for( int i = 0; i < currentIndex; i++) {
        		
        		if(((PriorityItem<T>) storage[i]).getPriority() > max) {
        			
        			max = ((PriorityItem<T>) storage[i]).getPriority(); 
        			biggestItem = (PriorityItem<T>) storage[i];
        			
        		}		
        	}
        	
        	
            return (T) biggestItem.getItem();
        }
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        
         if(currentIndex <= capacity) {
        	 storage[currentIndex] = new PriorityItem<>(item, priority);
        	 currentIndex +=1;
         }
    }
    
    

    @Override
    
    public void remove() throws QueueUnderflowException {
    	
    	int removedIndex = 0;
    	
        if (isEmpty()) {
            throw new QueueUnderflowException();
        
        } else {
        	
        	int max = Integer.MIN_VALUE;
        	
        	PriorityItem toRemove = new PriorityItem(null,0);
        	
        	for( int i = 0; i < currentIndex; i++) {
        		
        		if(((PriorityItem<T>) storage[i]).getPriority() > max) {
        			
        			max = ((PriorityItem<T>) storage[i]).getPriority(); 
        			toRemove = (PriorityItem<T>) storage[i];
        			
        		}		
        	}
        	
        	for( int i = 0; i < storage.length; i++) {
        		
        		if(storage[i] == toRemove) {
        			
        			storage[i] = null;	
        			
        			removedIndex = i;
        			break;
        		}
        					
        	}
        	
        	for ( int i = removedIndex; i<currentIndex; i++) {
        		
        		storage[i] = storage[i+1]; 
        		
        		
        	}
        	
        	currentIndex -=1;
            
        }
       
        
    }

    @Override
    public boolean isEmpty() {
        return currentIndex < 0;
    }
    

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= currentIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
	
}

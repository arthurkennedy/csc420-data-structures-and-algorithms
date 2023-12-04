/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandomList;

import java.util.ArrayList;

/**
 *
 * @author arthu
 * @param <E>
 */

class Node<E> {
    E element;
    Node<E> next;
    
    public Node(E o) {
        element = o;
    }
}

public class RandomList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if(tail == null){
            tail = head;
        }
    }
    
    public void addLast(E e){
        if(tail == null){
            head = tail = new Node<>(e);
        }else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }
    
    public void add(int index, E e){
        if(index == 0) {
            addFirst(e);
        }else if(index >= size) {
            addLast(e);
        }else {
            Node<E> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }
    
    public E removeFirst(){
        if(size == 0){
            return null;
        }else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if(head == null){
                tail = null;
            }
            
            return temp.element;
        }
    }
    
    public E removeLast(){
        if(size == 0){
            return null;
        }else if(size == 1){
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }else {
            Node<E> current = head;
            for(int i = 0; i < size-2; i++){
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }
    
    public E remove(int index){
        if(index < 0 || index >= size){
            return null;
        }else if(index == 0){
            return removeFirst();
        }else if(index == size-1){
            return removeLast();
        }else {
            Node<E> previous = head;
            for(int i = 1; i < index; i++){
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }
    
    //add an element of type E to the list at a random location
    public void randomAdd(E e){
        int randomInt = (int) (Math.random() * (size-1));
        add(randomInt, e);
    }
    
    //remove a random element of type E (and return that element)
    public E randomRemove(){
        int randomInt = (int) (Math.random() * (size-1));
        
        return remove(randomInt);
        
        
    }
    
    //get an element E as specified location
    public E get(int index){
        
        if(index > 0 && index <= size){
            Node<E> current = head;
            for(int i = 1; i < index; i++){
                current = current.next;
            }
            
            return current.element;
        }
        return null;
    }
    
    //return a random element of type E
    public E randomGet(){
        int randomInt = (int) (Math.random() * (size-1));
        return get(randomInt);
    }
    
    //print the list of elements in the list in the order that they are in the list (from Headto Tail)
    public void printList(){
        System.out.println("Displaying List using element's default toString() method");
        Node<E> current = head;
        int count = 1;
        while(current != null){
            System.out.println(count+ "> " + current.element);
            current = current.next;
            count++;
        }
    }
    
    // print the list of elements in the list in reverse order (from Tail to Head
    public void printReverseList(){
        System.out.println("Displaying Reverse List using element's default toString() method");
       
        int count = size;
        while(count > 0){
            System.out.println(count+ "> " + get(count));
            count--;
        }
    }
   
    
    
}

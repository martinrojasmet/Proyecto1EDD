/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class ListProducts {
    private NodeProduct head;
    private int length;

    public ListProducts (NodeProduct head) {
        this.head = head;
        if (head != null) {
            this.length = 1;
        } else {
            this.length = 0;
        }       
    }

    public void setHead(NodeProduct head) {
        this.head = head;
    }

    public NodeProduct getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }
    
    public void insertStart(Product element){
        NodeProduct node = new NodeProduct(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            node.setNext(getHead());
            setHead(node);
        }
        length++;
    }
    
    public void insertEnd(Product element) {
        NodeProduct node = new NodeProduct(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            NodeProduct pointer = getHead();
            while (pointer.getNext() != null) {
               pointer = pointer.getNext();
            }
        pointer.setNext(node);
        length++;
        }
        }
        
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    public void printList() {
        NodeProduct pointer = getHead();
        if (isEmpty()) {
            System.out.println("La lista esta vacia");} else {
        while (pointer.getNext() != null) {
            System.out.println(pointer.getElement());
            pointer = pointer.getNext();
        }
        System.out.println(pointer.getElement());
        }
    }
    
    public void deleteFirst() {
        NodeProduct pointer = getHead();
        if (!isEmpty()) {
            setHead(pointer.getNext());
            pointer.setNext(null);
        }
    length--;
    }
    
    public void deleteLast() {
        NodeProduct pointer = getHead();
        if (!isEmpty()) {
            while (pointer.getNext().getNext() != null) {
                pointer = pointer.getNext();
            }
        pointer.setNext(null);
        }
    length--;
    }
    
}

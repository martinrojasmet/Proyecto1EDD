/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class List {
    private Node head;
    private int length;

    public List(Node head) {
        this.head = head;
        if (head != null) {
            this.length = 1;
        } else {
            this.length = 0;
        }       
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }
    
    public void insertStart(int element){
        Node node = new Node(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            node.setNext(getHead());
            setHead(node);
        }
        length++;
    }
    
    public void insertEnd(int element) {
        Node node = new Node(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            Node pointer = getHead();
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
        Node pointer = getHead();
        if (isEmpty()) {
            System.out.println("La lista esta vacia");} else {
        while (pointer.getNext() != null) {
            System.out.println(pointer.getElement());
            pointer = pointer.getNext();
        }
        System.out.println(pointer.getElement());
        }
    }
    
    public Integer getElementIndex(int pos){
            if (isEmpty()) {
                return null;
            } else {
                Node pointer = getHead();
                int cont = 0;
                while (cont < pos && pointer.getNext() != null) {
                    pointer = pointer.getNext();
                    cont++;
                }
                if (cont == pos) {
                    return pointer.getElement();
                } else {
                    return null;
                }
            }
        }
    
    public void deleteFirst() {
        Node pointer = getHead();
        if (!isEmpty()) {
            setHead(pointer.getNext());
            pointer.setNext(null);
        }
    length--;
    }
    
    public void deleteLast() {
        Node pointer = getHead();
        if (!isEmpty()) {
            while (pointer.getNext().getNext() != null) {
                pointer = pointer.getNext();
            }
        pointer.setNext(null);
        }
    length--;
    }
    
    public void deleteElementIndex(int pos) {
        if (!isEmpty()) {
            Node pointer = getHead();
            int index = 0;
            if (pos == 0) {
                deleteFirst();
            } else {
            while (index < (pos - 1) && pointer.getNext() != null) {
                pointer = pointer.getNext();
                index++;
            }
            Node temp = pointer.getNext();
            pointer.setNext(pointer.getNext().getNext());
            temp.setNext(null);
            length--;
            }
        }
    }
}


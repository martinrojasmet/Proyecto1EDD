/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class Node {
    private Object element;
    private Node next;

    public Node(Object element) {
        this.next = null;
        this.element = element;
    }

    /**
     * @return the element
     */
    public Object getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(Object element) {
        this.element = element;
    }

    /**
     * @return the next
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    } 
}
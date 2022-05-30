/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class NodeProduct {
    private Product element;
    private NodeProduct next;

    public NodeProduct (Product element) {
        this.next = null;
        this.element = element;
    }

    /**
     * @return the element
     */
    public Product getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(Product element) {
        this.element = element;
    }

    /**
     * @return the next
     */
    public NodeProduct getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodeProduct next) {
        this.next = next;
    }
    
}

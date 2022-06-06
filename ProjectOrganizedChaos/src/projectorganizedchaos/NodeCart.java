/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class NodeCart {
    private ProductCart element;
    private NodeCart next;

    public NodeCart (ProductCart element) {
        this.next = null;
        this.element = element;
    }

    /**
     * @return the element
     */
    public ProductCart getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(ProductCart element) {
        this.element = element;
    }

    /**
     * @return the next
     */
    public NodeCart getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodeCart next) {
        this.next = next;
    }
    
}

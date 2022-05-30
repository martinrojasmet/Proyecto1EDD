/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class NodeWarehouse {
    private Warehouse element;
    private NodeWarehouse next;

    public NodeWarehouse(Warehouse element) {
        this.next = null;
        this.element = element;
    }

    /**
     * @return the element
     */
    public Warehouse getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(Warehouse element) {
        this.element = element;
    }

    /**
     * @return the next
     */
    public NodeWarehouse getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodeWarehouse next) {
        this.next = next;
    } 
}

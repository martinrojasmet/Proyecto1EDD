/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class NodeVertex {
    private String[] element;
    private NodeVertex next;

    public NodeVertex(String[] element) {
        this.next = null;
        this.element = element;
    }

    /**
     * @return the element
     */
    public String[] getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(String[] element) {
        this.element = element;
    }

    /**
     * @return the next
     */
    public NodeVertex getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodeVertex next) {
        this.next = next;
    } 
}
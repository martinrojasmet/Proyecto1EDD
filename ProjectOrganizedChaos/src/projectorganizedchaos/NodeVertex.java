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
    private Vertex element;
    private NodeVertex next;

    public NodeVertex(Vertex element) {
        this.next = null;
        this.element = element;
    }

    /**
     * @return the element
     */
    public Vertex getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(Vertex element) {
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

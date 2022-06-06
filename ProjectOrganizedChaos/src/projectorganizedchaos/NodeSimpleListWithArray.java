/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
<<<<<<< Updated upstream
public class NodeSimpleListWithArray<T> {
    private T data;
    private int next;

    public NodeSimpleListWithArray(T data) {
=======
public class NodeSimpleListWithArray {
    private String data;
    private int next;

    public NodeSimpleListWithArray(String data) {
>>>>>>> Stashed changes
        this.data = data;
        this.next = -1;
    }

    /**
     * @return the data
     */
<<<<<<< Updated upstream
    public T getData() {
=======
    public String getData() {
>>>>>>> Stashed changes
        return data;
    }

    /**
     * @param data the data to set
     */
<<<<<<< Updated upstream
    public void setData(T data) {
=======
    public void setData(String data) {
>>>>>>> Stashed changes
        this.data = data;
    }

    /**
     * @return the next
     */
    public int getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(int next) {
        this.next = next;
    }
    
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes

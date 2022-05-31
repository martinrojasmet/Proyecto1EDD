/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class SimpleListWithArray<T> {
    private int first;
    private int last;
    private int size;
    public NodeSimpleListWithArray[] array;

    public SimpleListWithArray(int max) {
        this.first = this.last = -1;
        this.size = 0;
        this.array = new NodeSimpleListWithArray[max];
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
    
    public boolean isEmpty() {
        return first == -1;
    }
    
    public boolean isFull() {
        return size == this.array.length;
    }
    
    public void empty() {
        this.first = this.last = -1;
        this.size = 0;
        this.array = new NodeSimpleListWithArray[this.array.length];
    }
    
    public int getValue(int x){
        int p = 0;
        if (this.isEmpty()){
            return -1;
        }
        if (x > this.array.length){
            System.out.println("El indice es mayor que la longitud de la lista");
        }
        else{
        for (int i = 0; i < this.array.length; i++) {
            if(i == x){
                p = (Integer) this.array[i].getData();
            }  
        }
        return p;
    }
    return p;
    }
    
    public int searchEmptySlot() {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    public void addAtTheStart(int x) {
        if (!this.isFull()) {
            NodeSimpleListWithArray node = new NodeSimpleListWithArray(x);
            int position = this.searchEmptySlot();
            this.array[position] = node;
            if (this.isEmpty()) {
                this.first = this.last = position;
            } else {
                this.array[position].setNext(this.first);
                this.first = position;
            }
            this.size++;
        }
    }
    
    public void addAtTheEnd(int x) {
        if (!this.isFull()) {
            NodeSimpleListWithArray node = new NodeSimpleListWithArray(x);
            int position = this.searchEmptySlot();
            this.array[position] = node;
            if (this.isEmpty()) {
                this.first = this.last = position;
            } else {
                this.array[this.last].setNext(position);
                this.last = position;
            }
            this.size++;
        }
    }
    
    public void insertOrdered(int x) {
        if (!this.isFull()) {
            if (this.isEmpty()) {
                addAtTheStart(x);
            } else if (String.valueOf(x).compareToIgnoreCase(String.valueOf(this.array[this.first].getData())) <= 0) {
                addAtTheStart(x);
            } else if (String.valueOf(x).compareToIgnoreCase(String.valueOf(this.array[this.last].getData())) >= 0) {
                addAtTheEnd(x);
            } else {
                int previous = this.first;
                int current = this.array[this.first].getNext();
                while (String.valueOf(x).compareToIgnoreCase(String.valueOf(this.array[current].getData())) > 0) {
                    previous = current;
                    current = this.array[current].getNext();
                }
                NodeSimpleListWithArray node = new NodeSimpleListWithArray(x);
                int position = this.searchEmptySlot();
                this.array[position] = node;
                this.array[previous].setNext(position);
                this.array[position].setNext(current);
            }
        }
    }
    
    public void printList() {
        String list = "";
        int position = this.first;
        while(position != -1) {
            list += this.array[position].getData() + "->";
            position = this.array[position].getNext();
        }
        System.out.println(list + "//");
    }
    
    public int getLength(){
        return size;
    }
}

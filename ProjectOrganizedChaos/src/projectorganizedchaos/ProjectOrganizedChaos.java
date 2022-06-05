
package projectorganizedchaos;
import ventana.OrderWindow;


public class ProjectOrganizedChaos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GlobalVariables global = new GlobalVariables();
        Functions functions = new Functions();
        String w = functions.readText();
        ListWarehouse list = functions.createObjects(w);
        global.setListWarehouse(list);
        global.setTempListProducts(list.getListOfProducts());
        OrderWindow OW = new OrderWindow();
        OW.setVisible(true);
        
        /**
        NodeWarehouse pointer = list.getHead();
        while (pointer.getNext() != null) {
            ListProducts a = pointer.getElement().listOfProducts;
            NodeProduct pointer1 = a.getHead();
            System.out.println(pointer.getElement().name);
            while (pointer1.getNext() != null) {
                System.out.println(pointer1.getElement().name + " " + pointer1.getElement().quantitiy);
                pointer1 = pointer1.getNext();
            }
            System.out.println(pointer1.getElement().name + " " + pointer1.getElement().quantitiy);
            NodeOfArrays l = pointer.getElement().links.getHead();
            while (l.getNext() != null) {
                System.out.println(l.getElement()[0]+l.getElement()[1]);
                l = l.getNext();
            }
            System.out.println(l.getElement()[0]+l.getElement()[1]);
            l = l.getNext();
            System.out.println("");
            pointer = pointer.getNext();
        }
        
        ListProducts a = pointer.getElement().listOfProducts;
            NodeProduct pointer1 = a.getHead();
            System.out.println(pointer.getElement().name);
            while (pointer1.getNext() != null) {
                System.out.println(pointer1.getElement().name + " " + pointer1.getElement().quantitiy);
                NodeOfArrays l = pointer.getElement().links.getHead();
            while (l.getNext() != null) {
                System.out.println(l.getElement()[0]+l.getElement()[1]);
                l = l.getNext();
            }
            System.out.println(l.getElement()[0]+l.getElement()[1]);
            l = l.getNext();
                pointer1 = pointer1.getNext();
            }
            System.out.println(pointer1.getElement().name + " " + pointer1.getElement().quantitiy);
            System.out.println("");
            pointer = pointer.getNext();
            */
        AdjacencyMatrix graph = new AdjacencyMatrix(list.getLength());
        NodeWarehouse pointer5 = list.getHead();
        int[][] matriz = new int[list.getLength()][list.getLength()];
        SimpleListWithArray list1 = new SimpleListWithArray(list.getLength());
        while (pointer5 != null){
            graph.addVertax(pointer5.getElement().name);
            System.out.println(pointer5.getElement().name);
            list1.addAtTheEnd(pointer5.getElement().name);
            pointer5 = pointer5.getNext();
        }
        
        NodeWarehouse pointer2 = list.getHead();
            while (pointer2 != null) {
            NodeOfArrays l = pointer2.getElement().links.getHead();
                System.out.println(pointer2.getElement().getName());
            while (l.getNext() != null) {
                 int index1 = -1;
                 int index2 = -1;
                for (int i = 0; i < list1.getLength(); i++) {
                    if (pointer2.getElement().getName().equals(list1.array[i].getData())) {
                        index1 = i;
                    }
                }
                for (int i = 0; i < list.getLength(); i++) {
                    if (l.getElement()[0].equals(list1.array[i].getData())) {
                        index2 = i;
                    }
                }  
                graph.addEdges(index1, index2, Integer.parseInt(l.getElement()[1]));
                System.out.println(l.getElement()[0]+l.getElement()[1]);                             
                l = l.getNext();
                    }
                int index1 = -1;
                int index2 = -1;
                for (int i = 0; i < list1.getLength(); i++) {
                    if (pointer2.getElement().getName().equals(list1.array[i].getData())) {
                        index1 = i;
                    }
                }
                for (int i = 0; i < list.getLength(); i++) {
                    if (l.getElement()[0].equals(list1.array[i].getData())) {
                        index2 = i;
                    }
                }   
                graph.addEdges(index1, index2, Integer.parseInt(l.getElement()[1]));
                System.out.println(l.getElement()[0]+l.getElement()[1]);
                System.out.println("");
                pointer2 = pointer2.getNext();
                }
        /////////////////////////////////////
        graph.printMatrix(graph.returnEdges());
        graph.dijkStra(0);
        List lista1 = graph.tipoRecorrido("DFS");
        List lista2 = graph.tipoRecorrido("BFS");

        List listaVertices = new List(null);
        
        Node aux = lista1.getHead();
        while(aux!= null){
            for (int i = 0; i < list1.getLength() ; i++) {
                if (aux.getElement().equals(list1.getIndex(list1.getValue(i)))) {
                listaVertices.insertEnd(list1.getValue(i));
                aux = aux.getNext();
                lista1.deleteFirst();   
            }
            }
        }
        listaVertices.printList();
        
        NodeWarehouse pointerWarehouse = list.getHead();
        Node pointerWay = listaVertices.getHead();
        String result = "";
        while (pointerWay != null) {
            while (pointerWarehouse != null) {
                if (pointerWarehouse.getElement().getName().equals(pointerWay.getElement())) {
                    result += "Almacen: " + pointerWarehouse.getElement().getName();
                    result += "\n" + pointerWarehouse.getElement().getListOfProducts().printList();

                }
                pointerWarehouse = pointerWarehouse.getNext();
            }
            pointerWarehouse = list.getHead();
            pointerWay = pointerWay.getNext();
        }
        System.out.println(result);
        
            functions.writeText(list);

    }
    
}


package projectorganizedchaos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class ProjectOrganizedChaos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
<<<<<<< Updated upstream
        Functions eew = new Functions();
        String w = eew.readText();
        ListWarehouse list = eew.createObjects(w);
        NodeWarehouse pointer = list.getHead();
        while (pointer.getNext() != null) {
            String a = pointer.getElement().name;
            System.out.println(a);
            pointer = pointer.getNext();
        }
=======
//        SimpleListWithArray list = readTextFile();
//        list.printList();
          AdjacencyMatrix graph = new AdjacencyMatrix(6);
            graph.addVertax(1);
            graph.addVertax(2);
            graph.addVertax(3);
            graph.addVertax(4);
            graph.addVertax(5);


            graph.addEdges(0,1,10);
            graph.addEdges(0,2,2);
            graph.addEdges(2,1,1);
            graph.addEdges(2,4,7);
            graph.addEdges(1,4,1);
            graph.addEdges(4,3,3);

            
            graph.dijkStra(0);
>>>>>>> Stashed changes

    }
    
}

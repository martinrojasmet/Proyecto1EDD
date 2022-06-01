
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

//        SimpleListWithArray list = readTextFile();
//        list.printList();
          AdjacencyMatrix graph = new AdjacencyMatrix(100);
            graph.addVertax("A");
            graph.addVertax("B");
            graph.addVertax("C");
            graph.addVertax("D");
            graph.addVertax("E");


            graph.addEdges(0,1,10);
            graph.addEdges(0,2,20);
            graph.addEdges(1,2,5);
            graph.addEdges(1,3,8);
            graph.addEdges(2,3,4);
            graph.addEdges(2,4,13);
            graph.addEdges(3,4,3);
            graph.addEdges(4,0,25);

            
            graph.dijkStra(0);


    }
    
}

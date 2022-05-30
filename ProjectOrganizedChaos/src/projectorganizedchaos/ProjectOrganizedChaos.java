
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
=======
<<<<<<< HEAD
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
>>>>>>> Stashed changes
//        SimpleListWithArray list = readTextFile();
//        list.printList();

        
<<<<<<< Updated upstream
=======
>>>>>>> 6a8056a43eb99216c3581886d5d6823e860aaa78
>>>>>>> Stashed changes
    }
    
}

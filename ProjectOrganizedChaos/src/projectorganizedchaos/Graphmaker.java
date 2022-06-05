/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectorganizedchaos;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Graphmaker {
    
    
    public Graph graphmaker(){
        System.setProperty("org.graphstream.ui", "swing");
	

        String start;
        String end;
        String weight;

	Graph graph;
        graph = new SingleGraph("Warehouse Graph");
        ListWarehouse list = GlobalVariables.getListWarehouse();
        NodeWarehouse pointer = list.getHead();
        
        while(pointer.getNext() != null){
            graph.addNode(pointer.getElement().getName());
            pointer = pointer.getNext();
        }
        pointer = list.getHead();
        NodeOfArrays pointer2 = pointer.getElement().getLinks().getHead();
        while(pointer.getNext() != null){
            
            while(pointer2.getNext() != null){
                
                start = pointer.getElement().getName();
                end = pointer2.getElement()[0];
                weight = pointer2.getElement()[1];
                
                graph.addEdge(start + end, start , end).setAttribute("lenght", weight);
                
                pointer2 = pointer2.getNext();
            }
        pointer = pointer.getNext();
        }
        
        return graph;           
 }
}


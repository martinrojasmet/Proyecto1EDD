/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectorganizedchaos;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

public class Graphmaker {
    
    
    public static void graphmaker(){
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
                
                graph.addEdge(start + end, start , end).setAttribute("weight", weight);
                
                pointer2 = pointer2.getNext();
            }
        pointer = pointer.getNext();
        }
        
        displayGraph(graph);           
 }
    
    public static void displayGraph (Graph g){
        System.setProperty("org.graphstream.ui", "swing");
                g.nodes().forEach(n -> n.setAttribute("label", n.getId()));
                g.edges().forEach(e -> e.setAttribute("label", "" + (int) e.getNumber("weigth")));                
                for (org.graphstream.graph.Node node: g)
                    node.setAttribute("ui.label", node.getId());
                for (org.graphstream.graph.Node node: g)
                    node.setAttribute("ui.style", "fill-color: white");
                for (org.graphstream.graph.Node node: g)
                    node.setAttribute("ui.style", "text-alignment: under");
                for (org.graphstream.graph.Node node: g)
                    node.setAttribute("ui.style", "text-style: bold");
                for (org.graphstream.graph.Node edge: g)
                    edge.setAttribute("ui.style", "fill-color: white");
                g.setAttribute("ui.quality",4);
            g.display();
   
        }
    }







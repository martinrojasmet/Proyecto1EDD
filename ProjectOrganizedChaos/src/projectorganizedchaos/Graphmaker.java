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
	

        String start;
        String end;
        String weight;
        String nodename;

	Graph graph;
        graph = new SingleGraph("Warehouse Graph");
        ListWarehouse list = GlobalVariables.getListWarehouse();
        NodeWarehouse pointer = list.getHead();
        nodename = pointer.getElement().getName();
        
        while(pointer != null){
            graph.addNode(nodename);
            
            pointer = pointer.getNext();
            if (pointer != null){
                nodename = pointer.getElement().getName();
            }
        }
        for (org.graphstream.graph.Node node : graph)
	System.out.println(node.getId());
        
        pointer = list.getHead();
        NodeOfArrays pointer2 = pointer.getElement().getLinks().getHead();
        while(pointer != null){
            
            while(pointer2 != null){
                
                start = pointer.getElement().getName();
                end = pointer2.getElement()[0];
                weight = pointer2.getElement()[1];
                
                graph.addEdge(start + end, start , end).setAttribute("weight",Integer.parseInt(weight));
                
                pointer2 = pointer2.getNext();
            }
        pointer = pointer.getNext();
        if (pointer != null){
               pointer2 = pointer.getElement().getLinks().getHead();
            }
        }
        graph.edges().forEach(e -> {
	System.out.println(e.getId());});

        
        displayGraph(graph);           
 }
    
    public static void displayGraph (Graph g){
        System.setProperty("org.graphstream.ui", "swing");
                g.nodes().forEach(n -> n.setAttribute("label", n.getId()));
                g.edges().forEach(e -> e.setAttribute("label", "" + (int) e.getNumber("weigth")));                
                for (org.graphstream.graph.Node node: g)
                    node.setAttribute("ui.label", node.getId());
                for (org.graphstream.graph.Node node: g)
                    node.setAttribute("ui.style", "fill-color: white;"+"text-style: bold;");
                g.edges().forEach(e -> {
                e.setAttribute("ui.style", "arrow-shape: arrow;");});
                g.edges().forEach(e -> {
                e.setAttribute("ui.label", e.getNumber("weight"));});
                g.setAttribute("ui.quality",4);
            g.display();
   
        }
    
     private static final String styleSheet ="node {"
	+ "shape: box;"
	+ "stroke-mode: plain;"
	+ "text-style: bold;"
	+ "stroke-color: black"
	+ "text-alignment: under;"
	+ "size: 20px, 20px;"
        + "}"
        + "edge {"
        + "fill-color: black;"
	+ "text-alignment: above;"
        + "arrow-shape: arrow;"
	+ "size: 20px, 20px;" 
        + "}"
         ;   
    }







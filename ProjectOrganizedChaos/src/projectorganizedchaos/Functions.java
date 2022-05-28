/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
public class Functions {
    
    public String readText() {
        String line;
        String Text = "";
        String path = "test\\amazon.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        Text += line + "\n";
                    }
                }
                br.close();
            }
        } catch (Exception ex){
            return "";
        } 
        return Text;
    }
    
    public void createObjects (String Text) {
        
        if (!"".equals(Text)) {
            
            String[] TextLineSplit = Text.split("\n");
            
            
            int index = 0;
            while (!TextLineSplit[index].equals("Rutas;") && index < TextLineSplit.length) {
                index++;
            }
            int indexRoute = index;
            
            
            String[] WarehouseStringList = new String[indexRoute-1];
            for (int i = 1; i < indexRoute; i++) {
                String result = TextLineSplit[i];
                WarehouseStringList[i-1] = result;
            }
            
            index = 0;
            String[] VertexStringList = new String[Text.length()-indexRoute+1];
            for (int i = indexRoute+1; i < Text.length(); i++) {
                String result = TextLineSplit[i];
                VertexStringList[index] = result;
                index++;
            }
            
            index = 0;
            List warehouseList = new List(null);
            while (index < WarehouseStringList.length) {
                boolean isWarehouse = WarehouseStringList[index].startsWith("Almacen");
                if (isWarehouse) {
                    char WarehouseLetter = WarehouseStringList[index].charAt(8);
                    index++;
                    List listProducts = new List(null);
                    
                    while (!WarehouseStringList[index].substring(WarehouseStringList[index].length()-1).equals(";")) {
                        String[] ProductArray = WarehouseStringList[index].split(",");
                        String ProductName = ProductArray[0];
                        String ProductQuantity = ProductArray[1];
                        Product product = new Product(ProductName, Integer.parseInt(ProductQuantity));
                        listProducts.insertEnd(product);
                        index++;
                    }
                    
                    WarehouseStringList[index] = WarehouseStringList[index].replace(";","");
                    String[] ProductArray = WarehouseStringList[index].split(",");
                    String ProductName = ProductArray[0];
                    String ProductQuantity = ProductArray[1];
                    Product product = new Product(ProductName, Integer.parseInt(ProductQuantity));
                    listProducts.insertEnd(product);
                    
                    Warehouse wa = new Warehouse(WarehouseLetter, listProducts);
                    warehouseList.insertEnd(wa);
                } 
                
            }
            
            index = indexRoute+1;
            ListVertex vertexList = new ListVertex(null);
            NodeVertex vertexInList = null;
            while (index < VertexStringList.length) {
                String[] VertexArray = VertexStringList[index].split(",");
                String vertexName = VertexArray[0];
                String link = VertexArray[1];
                String size = VertexArray[2];
                
                boolean vertexExists = false;
                NodeVertex pointer = vertexList.getHead();
                while (pointer.getNext() != null) {
                    if (pointer.getElement().name.equals(vertexName)) {
                        vertexExists = true;
                        vertexInList = pointer;
                    }
                }          
                
                Vertex vertex = new Vertex(vertexName);
                String[] linkArray = new String[2];
                linkArray[0] = link;
                linkArray[1] = size;
                
                if (vertexExists) {
                    pointer = vertexList.getHead();
                    while (pointer.getNext() != null && pointer != vertexInList) {
                        pointer = pointer.getNext();
                }
                pointer.getElement().links.insertEnd(linkArray);
                } else {
                    vertex.links.insertEnd(linkArray);
                    vertexList.insertEnd(vertex);
                }
                
            }
            
        }
        
    }
}

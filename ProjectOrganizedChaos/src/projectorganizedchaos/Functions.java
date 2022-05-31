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
                return Text;
            }
        } catch (Exception ex){
            return "";
        } 
        return Text;
    }
    
    public ListWarehouse createObjects (String Text) {
        
        if (!"".equals(Text)) {
            
            String[] TextLineSplit = Text.split("\n");
            
            
            int index = 0;
            while (!TextLineSplit[index].equals("Rutas;") && index < TextLineSplit.length) {
                index++;
            }
            int indexRoute = index;
            
            index = 0;
            String[] WarehouseStringList = new String[indexRoute-1];
            for (int i = 1; i < indexRoute; i++) {
                String result = TextLineSplit[i];
                WarehouseStringList[index] = result;
                index++;
            }
            
            
            int lengthVertexArray = TextLineSplit.length - (indexRoute+1);
            index = 0;
            String[] VertexStringList = new String[(lengthVertexArray)];
            for (int i = indexRoute+1; i < TextLineSplit.length; i++) {
                String result = TextLineSplit[i];
                VertexStringList[index] = result;
                index++;
            }
            
            index = 0;
            ListWarehouse warehouseList = new ListWarehouse(null);
            while (index < WarehouseStringList.length) {
                boolean isWarehouse = WarehouseStringList[index].startsWith("Almacen ");
                if (isWarehouse) {
                    String WarehouseLetter = String.valueOf(WarehouseStringList[index].charAt(8));
                    index++;
                    
                    ListProducts listProducts = new ListProducts(null);
                    
                    while (!WarehouseStringList[index].substring(WarehouseStringList[index].length()-1).equals(";")) {
                        String[] ProductArray = WarehouseStringList[index].split(",");
                        String ProductName = ProductArray[0];
                        String ProductQuantity = ProductArray[1];
                        Product product = new Product(ProductName, Integer.parseInt(ProductQuantity));
                        listProducts.insertEnd(product);
                        System.out.println(ProductName);
                        System.out.println(ProductQuantity);
                        index++;
                    }
  
                    WarehouseStringList[index] = WarehouseStringList[index].replace(";","");
                    String[] ProductArray = WarehouseStringList[index].split(",");
                    String ProductName = ProductArray[0];
                    String ProductQuantity = ProductArray[1];
                    Product product1 = new Product(ProductName, Integer.parseInt(ProductQuantity));
                    listProducts.insertEnd(product1);
                                            System.out.println(ProductName);
                        System.out.println(ProductQuantity);
                    
                        
                    NodeProduct node = listProducts.getHead();
                    while (node.getNext() != null) {
                        System.out.println(node.getElement().name);
                        node = node.getNext();
                    }
                    
                    Warehouse wa = new Warehouse(WarehouseLetter, listProducts);
                    warehouseList.insertEnd(wa);
                }
            index++;  
            }
            
            index = 0;
            while (index < VertexStringList.length) {
                String[] VertexArray = VertexStringList[index].split(",");
                String vertexName = VertexArray[0];
                String link = VertexArray[1];
                String size = VertexArray[2];
                        
                String[] linkArray = new String[2];
                linkArray[0] = link;
                linkArray[1] = size;
                
                NodeWarehouse pointer = warehouseList.getHead();
                while (pointer.getNext() != null && !pointer.getElement().name.equals(vertexName)) {
                    pointer = pointer.getNext();
                }
                pointer.getElement().links.insertEnd(linkArray);
                index++;
                }

                return warehouseList;
            }
          return null;
        }
        
    }

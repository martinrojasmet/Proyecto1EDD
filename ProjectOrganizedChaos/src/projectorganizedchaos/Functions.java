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
    
    public void readText() {
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
            if (!"".equals(Text)) {
                String[] TextLineSplit = Text.split("\n");
                int index = 0;
                int indexWarehouse = index + 1;
                
                while (TextLineSplit[index] != "Rutas;" && index < TextLineSplit.length) {
                    index++;
                }
                
                int indexRoute = index;
                String[] WarehouseStringList = new String[index-2];
                
                for (int i = 1; i < index; i++) {
                    String result = TextLineSplit[i];
                    WarehouseStringList[i-1] = result;
                }
                
                int index2 = 1;
                
                while (index2 < WarehouseStringList.length) {
                    boolean isWarehouse = WarehouseStringList[index2].startsWith("Almacen");
                    if (isWarehouse) {
                        char WarehouseLetter = WarehouseStringList[index2].charAt(8);
                        index2 += 1;
                        while (!WarehouseStringList[index2].substring(WarehouseStringList[index2].length() -1).equals(";")) {
                            String[] ProductList = WarehouseStringList[index2].split(",");
                            String ProductName = ProductList[0];
                            String ProductQuantity = ProductList[1];
                            index2++;
                        }
                    WarehouseStringList[index2] = WarehouseStringList[index2].replace(";","");
                    String[] ProductList = WarehouseStringList[index2].split(",");
                    String ProductName = ProductList[0];
                    String ProductQuantity = ProductList[1];
                    index2++;
                    }
                }
        }
            
           JOptionPane.showMessageDialog(null, "Lectura exitosa");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al leer");
        } 
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class Objects {
    
    public class Product {
        String name;
        int quantitiy;

        public Product(String name, int quantitiy) {
            this.name = name;
            this.quantitiy = quantitiy;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantitiy() {
            return quantitiy;
        }

        public void setQuantitiy(int quantitiy) {
            this.quantitiy = quantitiy;
        }
        
    }
    
    public class Warehouse() {
        String name;
        List listOfProducts;

        public Warehouse(String name, List listOfProducts) {
            this.name = name;
            this.listOfProducts = listOfProducts;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List getListOfProducts() {
            return listOfProducts;
        }

        public void setListOfProducts(List listOfProducts) {
            this.listOfProducts = listOfProducts;
        }
        
    }
    
}

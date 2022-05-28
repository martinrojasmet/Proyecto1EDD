/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class Warehouse {
    char name;
    List listOfProducts;

    public Warehouse(char name, List listOfProducts) {
        this.name = name;
        this.listOfProducts = listOfProducts;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public List getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

}


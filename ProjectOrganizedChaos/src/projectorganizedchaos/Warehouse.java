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
    ListProducts listOfProducts;
    ListOfArrays links;
    String name;

    public Warehouse(String name, ListProducts listOfProducts) {
        this.name = name;
        this.listOfProducts = listOfProducts;
        this.links = new ListOfArrays(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListProducts getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(ListProducts listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public ListOfArrays getLinks() {
        return links;
    }

    public void setLinks(ListOfArrays links) {
        this.links = links;
    }

}


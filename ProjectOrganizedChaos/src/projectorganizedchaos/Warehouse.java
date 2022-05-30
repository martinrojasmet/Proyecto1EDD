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
<<<<<<< Updated upstream
 Warehouse(char name, List listOfProducts) {
=======
<<<<<<< HEAD
=======
 Warehouse(char name, List listOfProducts) {
>>>>>>> 6a8056a43eb99216c3581886d5d6823e860aaa78
>>>>>>> Stashed changes
    String name;
    List listOfProducts;
    ListOfArrays links;

    public Warehouse(String name, List listOfProducts) {
        this.name = name;
        this.listOfProducts = listOfProducts;
        this.links = new ListOfArrays(null);
    }

<<<<<<< Updated upstream

=======
<<<<<<< HEAD
=======

>>>>>>> 6a8056a43eb99216c3581886d5d6823e860aaa78
>>>>>>> Stashed changes
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

    public ListOfArrays getLinks() {
        return links;
    }

    public void setLinks(ListOfArrays links) {
        this.links = links;
    }

}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class ProductCart {
    String name;
    int quantitiy;
    int quantityFirstwarehouse = 0;
    boolean wasAvaInSecondWa = false;

    public boolean isWasAvaInSecondWa() {
        return wasAvaInSecondWa;
    }

    public void setWasAvaInSecondWa(boolean wasAvaInSecondWa) {
        this.wasAvaInSecondWa = wasAvaInSecondWa;
    }
    

    public int getQuantityFirstwarehouse() {
        return quantityFirstwarehouse;
    }

    public void setQuantityFirstwarehouse(int quantityFirstwarehouse) {
        this.quantityFirstwarehouse = quantityFirstwarehouse;
    }

    public ProductCart(String name, int quantitiy) {
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

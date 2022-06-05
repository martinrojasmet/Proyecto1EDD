/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectorganizedchaos;

/**
 *
 * @author marti
 */
public class GlobalVariables {
    private static ListWarehouse listWarehouse = new ListWarehouse(null);
    private static ListProducts tempListProducts = new ListProducts(null);
    private static String LetterOfWarehouseBuy = null;

    public static String getLetterOfWarehouseBuy() {
        return LetterOfWarehouseBuy;
    }

    public static void setLetterOfWarehouseBuy(String LetterOfWarehouseBuy) {
        GlobalVariables.LetterOfWarehouseBuy = LetterOfWarehouseBuy;
    }

    public static ListWarehouse getListWarehouse() {
        return listWarehouse;
    }

    public static void setListWarehouse(ListWarehouse listWarehouse) {
        GlobalVariables.listWarehouse = listWarehouse;
    }

    public static ListProducts getTempListProducts() {
        return tempListProducts;
    }

    public static void setTempListProducts(ListProducts tempListProducts) {
        GlobalVariables.tempListProducts = tempListProducts;
    }
    
    
    }



package projectorganizedchaos;


public class ProjectOrganizedChaos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Functions eew = new Functions();
        String w = eew.readText();
        ListWarehouse list = eew.createObjects(w);
        NodeWarehouse pointer = list.getHead();
        while (pointer.getNext() != null) {
            ListProducts a = pointer.getElement().listOfProducts;
            System.out.println(a.getLength());
            NodeProduct pointer1 = a.getHead();
            System.out.println(pointer.getElement().name);
            while (pointer1.getNext() != null) {
                System.out.println("hola");
                System.out.println(pointer1.getElement().name);
                pointer1 = pointer1.getNext();
            }
            System.out.println("");
            pointer = pointer.getNext();
        }

    }
    
}

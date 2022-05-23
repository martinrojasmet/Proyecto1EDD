
package projectorganizedchaos;
import java.io.IOException;

public class AdjacencyMatrix {
    private boolean directed; // Indica si es dirigido o no.
    private int maxNodes; // Tamaño máximo de la tabla.
    private int numVertex; // Número de vértices del grafo.
    private boolean matrixAdy [ ] [ ]; // Matriz de adyacencias del grafo.
    
    public void GraphMA (int n, boolean d) {
        directed = d;
        maxNodes = n;
        numVertex = 0;
        matrixAdy = new boolean[n][n]; //dudassss aquiiiiiiiii
    }
    
    public void insertarArista (int i, int j) {
        matrixAdy [i] [j] = true;
        if (!directed)
        matrixAdy [j] [i] = matrixAdy [i] [j];
    }
    
    public void eliminarArista (int i, int j) {
        matrixAdy [i] [j] = false;
        if (!directed)
        matrixAdy [j] [i] = false;
}
    
    public void insertarVertice(int n){
        /** Inserta un vértice en el grafo siempre que no se supere el número máximo
        de nodos permitidos **/
        if ( n > maxNodes - numVertex )
            System.out.println ("Error, se supera el número de nodos máximo");
            else {
                for (int i=0; i < numVertex + n; i++) {
                    for (int j = numVertex; j < numVertex + n; j++)
                        matrixAdy [i] [j] = matrixAdy [j] [i] = false;
            }
            numVertex = numVertex + n;
            }
    }
    
    public void eliminarVertice(int n){
        /** Elimina un vértice del grafo **/
    }
    
    public int gradoIn(int j) {
        int gIn = 0;
        for (int i = 0; i < numVertex; i++) //recorrido por filas
            if (matrixAdy [i] [j])
        gIn++; //manteniendo la posición de la columna en [j]
        return gIn;
    }
    
    public int gradoOut(int i) {
        int gOut = 0;
        for (int j= 0; j < numVertex; j++)
            if (matrixAdy [i][j])
        gOut++; // manteniendo la posición de la fila en [i]
        return gOut;
    }
    
    public int incidencia (int i) {
    if (!directed)
        return gradoIn (i);
    else return gradoIn (i) + gradoOut (i);
    }
    
    public int tamano() {
    int tm = 0;
    for (int i = 0; i < numVertex; i++)
        for (int j=0; j < numVertex; j++)
            if (matrixAdy [i] [j])
                tm++;
    if (directed)
        return tm;
    else return tm/2;
    }
    
    public boolean esDirigido () { //aqui tambien hay algo raro
        boolean dir = true;
        for (int i = 0; i < numVertex; i++)
            for (int j = 0; j < numVertex; j++)
                if (matrixAdy [i] [j] != matrixAdy [j] [i])
                dir = false;
        return dir;
    }
    
    public void imprimirTabla () {
    System.out.println ("La matriz contiene " + numVertex + " vértices: \n");
    for (int i = 0; i < numVertex; i++) {
        for (int j = 0; j < numVertex; j++) {
            if (matrixAdy [i] [j])
                System.out.print ("1 ");
            else System.out.print ("0 ");
            }
        }
    }
}

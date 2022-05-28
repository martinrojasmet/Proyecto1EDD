
package projectorganizedchaos;

public class AdjacencyMatrix {
    private boolean directed; // Indica si es dirigido o no.
    private int numVertex; // Número de vértices del grafo.
    private boolean matrixAdj [ ] [ ]; // Matriz de adyacencias del grafo.
    
    public void AdjacencyMatrix (int n, boolean d) {
        this.directed = d;
        this.numVertex = 0;
        this.matrixAdj = new boolean[n][n]; //dudassss aquiiiiiiiii
    }
    
    public void addLink (int i, int j) {
        matrixAdj [i] [j] = true;
        if (!directed)
        matrixAdj [j] [i] = matrixAdj [i] [j];
    }
    
    public void deleteLink (int i, int j) {
        matrixAdj [i] [j] = false;
        if (!directed)
        matrixAdj [j] [i] = false;
}
    
    public void addVertex (int n){
        /** Inserta un vértice en el grafo siempre que no se supere el número máximo
        de nodos permitidos **/

        for (int i=0; i < numVertex + n; i++) {
            for (int j = numVertex; j < numVertex + n; j++)
                matrixAdj [i] [j] = matrixAdj [j] [i] = false;
        }
    numVertex = numVertex + n;
    }
    
    public void deleteVertex (int x){
        /** Elimina un vértice del grafo **/
        if (x > numVertex) {
            System.out.println("Vertice supera el numero de nodos maximos!");         
        }
        else {
            int i;
 
        // Se elimina el vertice
        while (x < numVertex) {
 
            // cambiando las filas a la izquierda
            for (i = 0; i < numVertex; ++i) {
                matrixAdj[i][x] = matrixAdj[i][x + 1];
            }
 
            // cambiando las columnas hacia arriba
            for (i = 0; i < numVertex; ++i) {
                matrixAdj[x][i] = matrixAdj[x + 1][i];
            }
            x++;
            }
 
        // disminuyendo el numero de vertices
        numVertex = numVertex - 1;
        }
    }
    
    public int gradeIn(int j) {
        int gIn = 0;
        for (int i = 0; i < numVertex; i++) //recorrido por filas
            if (matrixAdj [i] [j])
        gIn++; //manteniendo la posición de la columna en [j]
        return gIn;
    }
    
    public int gradeOut(int i) {
        int gOut = 0;
        for (int j= 0; j < numVertex; j++)
            if (matrixAdj [i][j])
        gOut++; // manteniendo la posición de la fila en [i]
        return gOut;
    }
    
    public int getIncidence (int i) {
    if (!directed)
        return gradeIn (i);
    else return gradeIn (i) + gradeOut (i);
    }
    
    public int getSize () {
    int tm = 0;
    for (int i = 0; i < numVertex; i++)
        for (int j=0; j < numVertex; j++)
            if (matrixAdj [i] [j])
                tm++;
    if (directed)
        return tm;
    else return tm/2;
    }
    
    public boolean isDirected () { //aqui tambien hay algo raro
        boolean dir = true;
        for (int i = 0; i < numVertex; i++)
            for (int j = 0; j < numVertex; j++)
                if (matrixAdj [i] [j] != matrixAdj [j] [i])
                dir = false;
        return dir;
    }
    
    public void printTable () {
    System.out.println ("La matriz contiene " + numVertex + " vértices: \n");
    for (int i = 0; i < numVertex; i++) {
        for (int j = 0; j < numVertex; j++) {
            if (matrixAdj [i] [j])
                System.out.print ("1 ");
            else System.out.print ("0 ");
            }
        }
    }
}

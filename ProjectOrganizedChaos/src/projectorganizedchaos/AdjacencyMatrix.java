
package projectorganizedchaos;

public class AdjacencyMatrix {
<<<<<<< Updated upstream
    private boolean directed; // Indica si es dirigido o no.
    private int numVertex; // Número de vértices del grafo.
    private boolean matrixAdj [ ] [ ]; // Matriz de adyacencias del grafo.
    
    public void AdjacencyMatrix (int n, boolean d) {
        this.directed = d;
        this.numVertex = 0;
        this.matrixAdj = new boolean[n][n]; //dudassss aquiiiiiiiii
=======
    private int n;
    private int numberOfEdges;
    private double[] distance;
    private String[] path;
    private SimpleListWithArray<String> Vertax;
    private static int[][] edges;
    private boolean[] isVisited;
    
    public AdjacencyMatrix(int n){
        this.n = n;
        numberOfEdges=0;
        Vertax = new SimpleListWithArray<>(n);
        edges  = new int[n][n];
        isVisited = new boolean[n+1];
        distance = new double[n];
        for (int i = 0; i <n ; i++) {
            distance[i] = Double.POSITIVE_INFINITY;
        }

        path = new String[n];
        for (int i = 0; i <n ; i++) {
            path[i] = "";
        }
>>>>>>> Stashed changes
    }


    
<<<<<<< Updated upstream
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
=======
    // Obtener el número de vértices
    public  int GetSizeOfGraph(SimpleListWithArray<String> Vertax){
        return Vertax.getLength();
    }
    // Agregar vértice
    public  void addVertax(int x){
        
        Vertax.addAtTheEnd(x);
    }
    // Obtiene el primer vértice adyacente del vértice especificado
    public int getFirstCO(int index){
        for (int i = 0; i <Vertax.getLength(); i++) {
            if (edges[index][i]>0) return i;
        }
        return n;
    }
    // Obtiene los vértices adyacentes secuenciales del vértice especificado
    public int getNextCO(int index,int firstCO){
        for (int i =firstCO+1 ; i <Vertax.getLength() ; i++) {
            if (edges[index][i]>0) return i;
        }
        return n;
    }
    // Agregar borde
    public  void addEdges(int e1,int e2 , int weight){
        edges[e1][e2] = weight;
        //edges[e2][e1] = weight;
        numberOfEdges++;
    }
    // Obtener el número de aristas
    public int getNumberOfEdges(){
        return numberOfEdges;
    }

    public void dijkStra(int index ){

        // CO son las coordenadas necesarias para la iteración, headIndex es el vértice inicial de cada DIJKSTRA


        int CO;
        int headIndex = index;
        //
        // Establece la distancia desde el punto inicial al punto inicial, naturalmente 0
        distance[index]=0;


        // Luego haz lo siguiente para cada vértice
        // 1. Establece este vértice en conocido, no te preocupes por la distancia y la ruta de este punto, porque ha sido diseñado antes
        // 2. Encuentra cada vértice adyacente de este vértice. Para un vértice desconocido, compare la distancia alcanzada a lo largo de este vértice con su distancia original, si es menor que la distancia original, actualice la distancia y actualice la ruta
        // 3. Después de establecer este vértice, use la función indexGet para encontrar el vértice con la distancia más pequeña entre los vértices desconocidos actuales, y utilícelo como el siguiente vértice para realizar el paso 2

        while (!isVisited[headIndex]){

            // CO es la primera CO que no ha sido visitada
            CO = getFirstCO(headIndex);
            while(isVisited[CO]){
                CO = getNextCO(headIndex,CO);
            }

            // Si el vértice headIndex no tiene vértices adyacentes que no hayan sido visitados, la coordenada del vértice se obtiene como n, lo que indica que es el último nodo desconocido, y solo necesita establecerse como conocido
            if (CO==n) {
                isVisited[headIndex]=true;
                //System.out.println("Coordinate not found ");
            }
            // Ejecuta el paso 2 para todos los vértices adyacentes a través de un bucle
            else {
                while (!isVisited[CO]&&CO<n) {
                    isVisited[headIndex]=true;
                    double currentDis = distance[headIndex]+edges[headIndex][CO];
                    if (currentDis<distance[CO]) {
                        distance[CO] = currentDis;

                        path[CO] = path[headIndex]+" "+Vertax.getValue(headIndex);
                    }

                    CO = getNextCO(headIndex, CO);

                }
            }

            headIndex = indexGet(distance,isVisited);


        }
        for (int i = 0; i <Vertax.getLength() ; i++) {
            path[i] = path[i]+" "+Vertax.getValue(i);
        }
        System.out.println("Iniciar nodo:"+Vertax.getValue(index));
        for (int i = 0; i <Vertax.getLength() ; i++) {
            System.out.println(Vertax.getValue(i)+"   "+distance[i]+"   "+path[i]);
        }


    }
    // Devuelve el siguiente vértice requerido a través de la matriz de distancia y la matriz de acceso dadas
    public int indexGet(double[] distance, boolean[] isVisited){
        int j=0;
        double mindis=Double.POSITIVE_INFINITY;
        for (int i = 0; i < distance.length; i++) {
            if (!isVisited[i]){
                if(distance[i]<mindis){
                    mindis=distance[i];
                    j=i;
                }
>>>>>>> Stashed changes
            }
        }
        return j;
    }
}

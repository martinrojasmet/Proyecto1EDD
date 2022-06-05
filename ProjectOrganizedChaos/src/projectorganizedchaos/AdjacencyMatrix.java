
package projectorganizedchaos;

public class AdjacencyMatrix {
    private int n;
    private int numberOfEdges;
    private double[] distance;
    private String[] path;
    private SimpleListWithArray Vertax;
    private int[][] edges;
    private boolean[] isVisited;
    private boolean[][] matrizAdy;
    
    public AdjacencyMatrix(int n){
        this.n = n;
        numberOfEdges=0;
        Vertax = new SimpleListWithArray(n);
        edges  = new int[n][n];
        isVisited = new boolean[n+1];
        distance = new double[n];
        matrizAdy = new boolean[n][n];
        for (int i = 0; i <n ; i++) {
            distance[i] = Double.POSITIVE_INFINITY;
        }

        path = new String[n];
        for (int i = 0; i <n ; i++) {
            path[i] = "";
        }

    }
    // Imprimir lista de adyacencia

    // Obtener el número de vértices
    public  int GetSizeOfGraph(SimpleListWithArray Vertax){
        return Vertax.getLength();
    }
    // Agregar vértice
    public  void addVertax(String x){
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
        matrizAdy[e1][e2] = true;
        edges[e1][e2] = weight;
        //edges[e2][e1] = weight;
        numberOfEdges++;
    }
    // Obtener el número de aristas
    public int getNumberOfEdges(){
        return numberOfEdges;
    }
    
    public int[][] returnEdges(){
        return edges;
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
            }
        }
        return j;
    }
    
    public void printMatrix(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int col = 0; col < matrix1.length; col++) {
                System.out.printf("%4d", matrix1[col]);
            }
            System.out.println();
        }
    }
    
    public List recorridoAnchura(int i, boolean[] isVisited){
        List lista1 = new List(null);
        lista1.insertEnd(0);
        Cola<Integer> cola = new Cola<>();
        cola.encolar(i);
        while(!cola.estaVacio()){
            int nodo = cola.getCabeza();
            cola.desencolar();
            isVisited[nodo] = true;
            for (int j = 0; j < this.Vertax.getLength(); j++) {
                Integer peso2 = this.edges[nodo][j];           
                if (peso2 != 0 && !isVisited[j] && !cola.existe(j)) {
                    cola.encolar(j);
                    lista1.insertEnd(j);
                   
                }
            }
        }
        return lista1;  
    }
    
    public List recorridoProfundidad(int i, boolean[] isVisited, List lista1){
        Cola<Integer> cola = new Cola<>();
        isVisited[i] = true;
        for (int j = 0; j < this.Vertax.getLength(); j++) {
            if (this.edges[i][j] != 0 && !isVisited[j]) {
                lista1.insertEnd(j);
                cola.encolar(i);
                recorridoProfundidad(j, isVisited, lista1);
                }
            }
        return lista1;
    }
    
    public List tipoRecorrido(String tipoRecorrido){
        List lista1 = new List(null);
        isVisited = new boolean[this.Vertax.getLength()];
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                if (tipoRecorrido.equals("DFS")) {
                    lista1 = recorridoAnchura(i, isVisited);
                }else{
                    List lista2 = new List(null);
                    lista2.insertEnd(0);
                    lista1 = recorridoProfundidad(i, isVisited, lista2);
                    
                }
            }
        }
        return lista1;
        
    }
}

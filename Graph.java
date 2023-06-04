package GraphFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;



public class Graph {

    int verticesNo, edgeNo; //vertices number and edges number
    boolean isDigraph; // is the graph is directed or not
    int weight;

    public static LinkedList<Vertex> vertices; // Linked list represent the list of vertices of a graph 

    //---------------------------------------------------
    public void make_graph(int verticesNum, int edgenum) {// REQ2 

        Vertex v, u;
        vertices = new LinkedList<>();
        verticesNo = 0;

        for (Integer i = 0; i < verticesNum; i++) {
            vertices.add(creatVertex(i.toString(), false)); //randomly initilize the vertices and their labels
            verticesNo++;
        }

//          This line is just for testing 
//         System.out.println("Vertices size inside make graph: "+vertices.size());
//         System.out.println("The vertixes are: ");
//         for (int n=0; n<vertices.size(); n++)
//         {
//            System.out.println( vertices.get(n).getLabel());
//         }
         
        Random random = new Random();

        for (int i = 0; i < verticesNum - 1; i++) {
            weight = random.nextInt(25) + 1;
//             int w = weight; //watcher
            v = vertices.get(i); //get a vertex
            u = vertices.get((i + 1)); // get the next vertex
            addEdge(v, u, weight);  // make an edge between them

        }
        // here I think there is a problem

        for (int i = 0; i < verticesNum; i++) {
            for (int j = i + 1; j < i; j++) {
                if (random.nextDouble() < (double) edgenum / (verticesNum * (verticesNum - 1) / 2)) {
                    Vertex a = vertices.get(i);
                    Vertex b = vertices.get(j);
                    weight = random.nextInt(25) + 1;
                    addEdge(a, b, weight);
                }
            }

            /*  for (int i = 0; i <edgenum-verticesNum+1; i++) {
           
           weight = (int)(Math.random()*100); // randomly select the weight 
           
            // now we will connect the vertices randomly by creating an edge between them
            int random_vertex1 = random.nextInt(verticesNum);
            int random_vertex2 = random.nextInt(verticesNum); 
            
            v= vertices.get(random_vertex1);
            u= vertices.get(random_vertex2);
           
            if (isConnected(v,u)) // use method isConnected to check whether the two vertices has already an edge 
                i--; // if the two vertices are connectes repeat the iteration 

           // else if (random_vertex1==random_vertex2) // check whether the two vertices are equal so it doesnt refer to itself 
             //   i--; // if the two vertices are the same repeat the iteration 
          
            else
            {
            addEdge(v, u,weight); // else add an edge between them 
            }*/
            //}
            //Random random = new Random(); // to pick a random vertix
            /*  int a, b;
        boolean isConnected;
        for (int i = 0; i < (edgenum - verticesNum + 1); i++) {
            
            a = random.nextInt(verticesNum); // pick random source of the edge
            b = random.nextInt(verticesNum); // pick random distenation of the edge

           vertex srcVertex = vertices.get(a);
           vertex desVertex = vertices.get(b);
            // is there an edge between them?
            isConnected = isConnected(srcVertex, desVertex);
            if (srcVertex == desVertex || isConnected) {
                i--; // do not count this iteration
                continue; // generate another pairs
            }

            // no edge between these vertices
            // add an edge
              weight = (int)((Math.random()*100)+1);
            addEdge(srcVertex, desVertex,weight);

        }*/
            // ----------------------------------------
            // the next lines are not included in the project 
            /*     System.out.println("The generated random graph :");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(i + " -> { ");
  
            LinkedList<Edge> list = vertices.get(i).getAdjList();
  
            if (list.isEmpty())
                System.out.print(" No adjacent vertices ");
            else {
                int size = list.size();
                for (int j = 0; j < size; j++) {
  
                    System.out.print(list.get(j).getTarget().getLabel());
                    if (j < size - 1)
                        System.out.print(" , ");
                }
            }
  
            System.out.println("}");
        }*/
            // the previous lines are not included in the project
            // ----------------------------------------
        }
    }

    //-------------
    public boolean isConnected(Vertex sourceVertex, Vertex targetVertex) { // a method to check whether two vertices has an edge 

        for (int i = 0; i < vertices.size(); i++) { // iterate over all vertices

            for (int j = 0; j < vertices.get(i).getAdjList().size(); j++) { // iterate over the adjency list of a specific vertex

                // Check whether the vertices has an edge
                if ((vertices.get(i).getAdjList().get(j).getSource().getLabel().equals(sourceVertex.getLabel()) && vertices.get(i).getAdjList().get(j).getTarget().getLabel().equals(targetVertex.getLabel()))
                        || (vertices.get(i).getAdjList().get(j).getSource().getLabel().equals(targetVertex.getLabel()) && vertices.get(i).getAdjList().get(j).getTarget().getLabel().equals(sourceVertex.getLabel()))) {
                    return true; //there is an edge and they are connected
                }
            }
        }

        return false; // no edges! 
    }
    //-------------
    //----------------------------------------------------

    //----------------------------------------------------
    public void readGraphFromFile(File graphFile) throws FileNotFoundException {
        vertices = new LinkedList<>();
        Office vertex1 = null;
        Office vertex2 = null;
        Scanner input = new Scanner(graphFile);

        input.next(); // read Digraph statement
        isDigraph = input.nextInt() != 0; // This statement will check whether the graph is drected or undirected

        int verticesNum = input.nextInt(); // This line will read the number of vertices
        int edgeNum = input.nextInt(); // This line will read the number of edges

        /*
    The next for loop will do the following: 
    1. First it will check whether the vertices read from the file are exist in the vertices list or not 
    2. If the vertex is not exist it will add it to the list and store it in vertex1 or vertex2 variables
    3. If the vertex is already exist it will assign to the vertex1 or vertex2 variable immediatly 
    4. It will creat edge between the vertices
    
         */
        for (int i = 0; i < edgeNum; i++) //this loop will iterate over all vertices and edges
        {
            String verLabel1 = input.next(); // read the first vertex from file
            String verLabel2 = input.next(); // read the secon vertex from file 

            if (!isExist(verLabel1)) // check if the vertex is exist in vertices list 
            {
                vertex1 = (Office) creatVertex(verLabel1, false); // if it is not exist creat a vertex
                vertices.add(vertex1); // add the vertex to vertices list 
                verticesNo++;
            } else // if the vertex is already exist just get it 
            {
                for (int j = 0; j < vertices.size(); j++) {

                    if (vertices.get(j).getLabel().equals(verLabel1)) {

                        vertex1 = (Office) vertices.get(j);
                    }
                }
            }

            if (!isExist(verLabel2)) {
                vertex2 = (Office) creatVertex(verLabel2, false); // if it is not exist creat a vertex
                vertices.add(vertex2); // add the vertex to vertices list 
                verticesNo++;
            } else // if the vertex is already exist just get it 
            {
                for (int j = 0; j < vertices.size(); j++) {
                    if (vertices.get(j).getLabel().equals(verLabel2)) {
                        vertex2 = (Office) vertices.get(j);
                    }
                }
            }

            weight = input.nextInt(); // randomly select a weight
            addEdge(vertex1, vertex2, weight); // add the edge between the vertices

        }

        // the next lines are not included in the project 
        System.out.println("The graph generated from file :");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).getLabel() + " -> { ");

            LinkedList<Edge> list = vertices.get(i).getAdjList();

            if (list.isEmpty()) {
                System.out.print(" No adjacent vertices ");
            } else {
                int size = list.size();
                for (int j = 0; j < size; j++) {

                    System.out.print(list.get(j).getTarget().getLabel());
                    if (j < size - 1) {
                        System.out.print(" , ");
                    }
                }
            }

            System.out.println("}");
        }
    }
    // the previous lines are not included in the project
    //----------------------------------------------------

    public boolean isExist(String vertexLabel) // this method will check whether a certin vertex is exist in the vertices list or not
    {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getLabel().equals(vertexLabel)) {
                return true;
            }
        }
        return false;
    }
    //----------------------------------------------------

    public void addEdge(Vertex v, Vertex u, int w) {  // this method is to add an edge between to vertices

        if (isDigraph == false) // in the case the graph is not directed 
        {
            // intialize src to des edge, add it to the list

            v.getAdjList().add(creatEdge(v, u, weight));
            // for tracing
//            System.out.println(u.getLabel() + "-->" + v.getLabel() + " = " + w);

            // intialize des to src edge, add it to the list
            u.getAdjList().add(creatEdge(u, v, weight));
//            System.out.println(u.getLabel() + "-->" + v.getLabel() + " = " + w);

            edgeNo += 2;// increments edge number by 2 if it is undirected graph

        } else // in the case the graph is directed
        {
            // intialize src to des edge, add it to the list

            v.getAdjList().add(creatEdge(v, u, weight));

            edgeNo++; // increments edge number by 1 in case it is a directd graph

        }
    }

    public Vertex creatVertex(String label, boolean isVisited) {
        return null;
    }

    public Edge creatEdge(Vertex source, Vertex target, int weight) {
        return null;
    }

    public void clearVerticesList() {
        vertices.clear();
        vertices.clear();
        verticesNo = 0;
    }

    public int getEdgeNo() {
        return edgeNo;
    }

}
//-----------------


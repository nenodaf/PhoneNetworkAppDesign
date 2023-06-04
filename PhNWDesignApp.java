/*
CPCS-324 Project, Part1 
Nawal Daftardar 2105630 
Atheer Alshehri 2105551
Yara Basager 2105735
Yasmeen Alhadrami 2107611

*/

package phonenetworkapp;

import GraphFramework.Graph;
import GraphFramework.KruskalAlg;
import GraphFramework.MHPrimAlg;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhNWDesignApp {

    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner input = new Scanner(System.in);
       
        // define  BluePrintsGraph object for read from file graph and for random graph
        BluePrintsGraph graph1 = new BluePrintsGraph();
        BluePrintsGraph graph2 = new BluePrintsGraph();

        File graphFile = new File("graphFile.txt");
        // send graph for prim algorithm and print the result
        graph1.readGraphFromFile(graphFile);
        MHPrimAlg prim = new MHPrimAlg(graph1);
        prim.primMST(graph1);
        prim.displayResultingMST();
        
        // send graph for Kruskal algorithm and print the result
        KruskalAlg mintree_kruskal = new KruskalAlg(graph1);
        mintree_kruskal.kruskal(graph1);
        mintree_kruskal.displayResultingMST();

   // to clear all vericies before send the graph to make random graph
        for (int i = 0; i < Graph.vertices.size(); i++) {
            Graph.vertices.get(i).getAdjList().clear();
        }
        Graph.vertices.clear();
         System.out.println("For random graph choose from 1 to 6 : ");
        int cases = input.nextInt();

        
        // using swithc for generation random graph by specific number for both edges and verticies
        // calculating the run time and display the result for both prim and kruskal algorithm

        switch (cases) {
            case 1 :    {
                    graph2.make_graph(1000,10000);
                   MHPrimAlg randPrim = new MHPrimAlg(graph2);
                    long start = System.currentTimeMillis();
                    randPrim.primMST(graph2);
                    long end =System.currentTimeMillis();
                   long total = end - start;
                    System.out.println("");
                    randPrim.displayResultingMST();
                    /////////////////////////////////////
                    KruskalAlg randKrus = new KruskalAlg(graph2);
                    long start1 = System.currentTimeMillis();
                    randKrus.kruskal(graph2);
                    long end1 = System.currentTimeMillis();
                    randKrus.displayResultingMST();
                    long total1 = end1 - start1;
                    System.out.println("");
                    System.out.println("the total run time for PRIM ALGORITHM : " + total);
                    System.out.println("");
                    System.out.println("the total run time for KRUSKAL ALGORITHM : " + total1);
                     break;
                }
            case 2 :                {
                    graph2.make_graph(1000, 15000);
                   MHPrimAlg randPrim = new MHPrimAlg(graph2);
                    long start = System.currentTimeMillis();
                    randPrim.primMST(graph2);
                    long end = System.currentTimeMillis();
                    long total = end - start;
                    System.out.println("");
                    randPrim.displayResultingMST();
                    /////////////////////////////////////
                    KruskalAlg randKrus = new KruskalAlg();
                    long start1 = System.currentTimeMillis();
                    randKrus.kruskal(graph2);
                    long end1 = System.currentTimeMillis();
                    randKrus.displayResultingMST();
                    long total1 = end1 - start1;
                    System.out.println("");
                    System.out.println("the total run time for PRIM ALGORITHM : " + total);
                    System.out.println("");
                    System.out.println("the total run time for KRUSKAL ALGORITHM : " + total1);
                     break;
                }
            case 3 :                {
                    graph2.make_graph(1000, 25000);
                    MHPrimAlg randPrim = new MHPrimAlg(graph2);
                    long start = System.currentTimeMillis();
                    randPrim.primMST(graph2);
                    long end = System.currentTimeMillis();
                    long total = end - start;
                    System.out.println("");
                    randPrim.displayResultingMST();
                    /////////////////////////////////////
                    KruskalAlg randKrus = new KruskalAlg();
                    long start1 = System.currentTimeMillis();
                    randKrus.kruskal(graph2);
                    long end1 = System.currentTimeMillis();
                    randKrus.displayResultingMST();
                    long total1 = end1 - start1;
                    System.out.println("");
                    System.out.println("the total run time for PRIM ALGORITHM : " + total);
                    System.out.println("");
                    System.out.println("the total run time for KRUSKAL ALGORITHM : " + total1);
                     break;
                }
            case 4:                 {
                    graph2.make_graph(5000, 15000);
                    MHPrimAlg randPrim = new MHPrimAlg(graph2);
                    long start = System.currentTimeMillis();
                    randPrim.primMST(graph2);
                    long end = System.currentTimeMillis();
                    long total = end - start;
                    System.out.println("");
                    randPrim.displayResultingMST();
                    /////////////////////////////////////
                    KruskalAlg randKrus = new KruskalAlg();
                    long start1 = System.currentTimeMillis();
                    randKrus.kruskal(graph2);
                    long end1 = System.currentTimeMillis();
                    randKrus.displayResultingMST();
                    long total1 = end1 - start1;
                    System.out.println("");
                    System.out.println("the total run time for PRIM ALGORITHM : " + total);
                    System.out.println("");
                    System.out.println("the total run time for KRUSKAL ALGORITHM : " + total1);
                     break;
                }
            case 5 :               {
                    graph2.make_graph(5000, 25000);
                    MHPrimAlg randPrim = new MHPrimAlg(graph2);
                    long start = System.currentTimeMillis();
                    randPrim.primMST(graph2);
                    long end = System.currentTimeMillis();
                    long total = end - start;
                    System.out.println("");
                    randPrim.displayResultingMST();
                    /////////////////////////////////////
                    KruskalAlg randKrus = new KruskalAlg();
                    long start1 = System.currentTimeMillis();
                    randKrus.kruskal(graph2);
                    long end1 = System.currentTimeMillis();
                    randKrus.displayResultingMST();
                    long total1 = end1 - start1;
                    System.out.println("");
                    System.out.println("the total run time for PRIM ALGORITHM : " + total);
                    System.out.println("");
                    System.out.println("the total run time for KRUSKAL ALGORITHM : " + total1);
                     break;
                }
            case 6 :                {
                    graph2.make_graph(10000, 15000);
                   MHPrimAlg randPrim = new MHPrimAlg(graph2);
                    long start = System.currentTimeMillis();
                    randPrim.primMST(graph2);
                    long end = System.currentTimeMillis();
                    long total = end - start;
                    System.out.println("");
                    randPrim.displayResultingMST();
                    /////////////////////////////////////
                    KruskalAlg randKrus = new KruskalAlg();
                    long start1 = System.currentTimeMillis();
                    randKrus.kruskal(graph2);
                    long end1 = System.currentTimeMillis();
                    randKrus.displayResultingMST();
                    long total1 = end1 - start1;
                    System.out.println("");
                    System.out.println("the total run time for PRIM ALGORITHM : " + total);
                    System.out.println("");
                    System.out.println("the total run time for KRUSKAL ALGORITHM : " + total1);
                     break;
                }
            case 7:                {
                    graph2.make_graph(10000, 25000);
                   MHPrimAlg randPrim = new MHPrimAlg(graph2);
                    long start = System.currentTimeMillis();
                    randPrim.primMST(graph2);
                    long end = System.currentTimeMillis();
                    long total = end - start;
                    System.out.println("");
                    randPrim.displayResultingMST();
                    /////////////////////////////////////
                    KruskalAlg randKrus = new KruskalAlg();
                    long start1 = System.currentTimeMillis();
                    randKrus.kruskal(graph2);
                   long end1 = System.currentTimeMillis();
                    randKrus.displayResultingMST();
                    long total1 = end1 - start1;
                    System.out.println("");
                    System.out.println("the total run time for PRIM ALGORITHM : " + total);
                    System.out.println("");
                    System.out.println("the total run time for KRUSKAL ALGORITHM : " + total1);
                    break;
                }
            default : {
            }
        }
        System.out.println(" Done ");
    }

}


package GraphFramework;
import java.util.LinkedList;


public abstract class MSTAlgorithm extends Graph {

     public LinkedList<Edge> MSTResultList = new LinkedList<>(); //list of objects that stores the parent of the vertex and the weight needed by the MST algorithm

    
    
     
     public abstract void displayResultingMST();
     // should be implemented by the subclasses polymorphic functions


     public LinkedList<Edge> getMSTResultList(){
        return MSTResultList;
    }
}
    





package GraphFramework;

/**
 *
 * @author Nawal
 */
public class Line extends Edge {
    // class attributes 
    int Lline;
    //Constructor
    public Line(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
        Lline = weight*5; 

    }
    
    // display information method 
    public void dispalyInfo(Line ed){
        System.out.println(" : line length: " + ed.Lline );
        
    }
    

  
    
   
    
}

    
   
    

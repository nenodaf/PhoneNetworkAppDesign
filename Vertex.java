
package GraphFramework;

import java.util.LinkedList;


public class Vertex  {
    // define the fields
      String label;
      boolean isVisited;
      static LinkedList<Edge> adjList = new LinkedList<>();
      Vertex parent; 
      
    public Vertex(String label,boolean isVisited){
        this.label = label;
    }
    
    // getters and setters
    public  String getLabel(){
        return label;
    }
    public void setLabel(String label){
        this.label=label;
        
    }
     
     public boolean getisVisted(){
        return isVisited;
      }

      public void setIsVisited(boolean isVisited){
        this.isVisited=isVisited;
    }

    public LinkedList<Edge> getAdjList (){
        
        return adjList;
       
    } 
    

    public Vertex getParent()
    {
        return parent; 
    }
    
    public void setParent(Vertex parent)
    {
        this.parent = parent; 
    }
    

    
      // display information method 
    public void dispalyInfo(Vertex ver){
        System.out.print("Office No. " + ver.getLabel());
      }

 
}

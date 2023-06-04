
package GraphFramework;

public class Office extends Vertex  {
    //Constructor
    public Office(String label, boolean isVisited) {
        super(label, isVisited);
    }

  
    // alternativly set the correct value within the relevant constructor
      public String setLabel()
    {
        setLabel("O"+getLabel());
        return getLabel();
    }
   
    // display information method 
    public void dispalyInfo(){
    System.out.println("The vertex label: "+setLabel()+"\n is the vertex visited?"+isVisited);
      }
    
}
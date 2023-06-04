
package phonenetworkapp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Line;
import GraphFramework.Office;
import GraphFramework.Vertex;

/**
 *
 * @author Nawal
 */
public class BluePrintsGraph extends Graph{

    @Override
    public Vertex creatVertex(String label, boolean isVisited)
   {
    return new Office(label, isVisited);
   }
      
    @Override
      public Edge creatEdge(Vertex source, Vertex target, int weight)
    {
    return new Line(source, target, weight);
    }
      
}
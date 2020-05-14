import java.util.Scanner;
import java.util.ArrayList;

public class PartOne {
    public static void main(String[] args) {
        // User input of Graph
        
        while ( true ) {
            Graph g = new Graph();
            System.out.print("\nDo you need a page graph to be input: ");
            Scanner inpt = new Scanner(System.in);
            String choice = inpt.nextLine();
            if ( choice.equals("Y") || choice.equals("y") || choice.equals("Yes") || choice.equals("yes") ) {
                System.out.print("\nEnter Number of pages: ");
                Scanner s = new Scanner(System.in);
                int vertex = s.nextInt();
                g.setVertex(vertex);
                g.createGraphAdjList();
                System.out.print("\nEnter number of page links: ");
                Scanner pglnk = new Scanner(System.in);
                int pglnks = pglnk.nextInt();
                for ( int i = 1; i <= pglnks; i++ ) {
                    System.out.print("\nPage link " + i + " from page: ");
                    Scanner st = new Scanner(System.in);
                    int start = st.nextInt();
                    System.out.print("\nPage link " + i + " to page: ");
                    Scanner ed = new Scanner(System.in);
                    int end = ed.nextInt();
                    // g.addNewEdge(new Edge(start, end));
                    g.addEdge(start, end);
                }
                System.out.print("\nDamping Factor: ");
                Scanner df = new Scanner(System.in);
                double dampFact = df.nextDouble();
                System.out.print("\nError limit: ");
                double errLimit = df.nextDouble();
                System.out.print("\nIteration Limit: ");
                int itLimit = df.nextInt();
        
                // g.createGraphMatrix();
                // g.printGraphMatrix();
                // ArrayList<Double> pgList = g.calculatePageRank(g.getEdgeList(), errLimit, dampFact, itLimit);
                ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), errLimit, dampFact, itLimit);
                if ( pgList != null ) {
                    // g.printGraphMatrix();
                    g.printGraph();
                    System.out.print("Result : [");
                    String res = "";
                    for ( int i = 0; i < pgList.size(); i++ ) {
                        res += pgList.get(i) + ", ";
                    }
                    System.out.print(res.substring(0, res.length() - 2));
                    System.out.print("]");
                } else {
                    System.out.println("No solution as iteration limit exceeded!");
                }
            } else {
                System.out.println("Bye!");
                break;
            }
        }
        

        // Fixed Input of Graph 
        // Graph g = new Graph();
        // int vertex = 5;
        // g.setVertex(5);
        // g.addNewEdge(new Edge(1,4));
        // g.addNewEdge(new Edge(4,2));
        // g.addNewEdge(new Edge(2,5));
        // g.addNewEdge(new Edge(3,5));
        // g.addNewEdge(new Edge(3,1));
        // g.addNewEdge(new Edge(3,4));

        // g.createGraphMatrix();
        // g.printGraphMatrix();
        
    }
}
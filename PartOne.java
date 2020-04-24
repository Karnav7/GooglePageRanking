import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) {
        System.out.println("Enter Number of Vertices for Graph:");
        Scanner s = new Scanner(System.in);
        int vertex = s.nextInt();
        Graph g = new Graph();
        g.setVertex(vertex);
        System.out.println("Enter edges for graph: (press 0 to stop adding edges)");
        int startVertex = 0; int endVertex = 0; int count = 0;
        int check = ( vertex * (vertex - 1 ) ) / 2;
        while ( true ) {
            if ( count == check )
                break;
            System.out.println("Enter Start Vertex: ");
            Scanner s1 = new Scanner(System.in);
            startVertex = s1.nextInt();
            if ( startVertex == 0 )
                break;
            System.out.println("Enter End Vertex: ");
            Scanner s2 = new Scanner(System.in);
            endVertex = s2.nextInt();
            if ( endVertex == 0 ) 
                break;
            g.addNewEdge(new Edge(startVertex, endVertex));
            count++;
        }
        g.createGraphMatrix();
        g.printGraphMatrix();
    }
}
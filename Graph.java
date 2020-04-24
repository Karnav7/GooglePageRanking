import java.util.ArrayList;

public class Graph {
    private int vertex = 5;
    private int[][] G = new int[vertex+1][vertex+1];
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();

    public void setVertex(int v) {
        this.vertex = v;
    }

    public int getVertex() {
        return this.vertex;
    }

    public void addNewEdge(Edge e) {
        this.edgeList.add(e);
    }

    public ArrayList<Edge> getEdgeList() {
        return this.edgeList;
    }

    public void createGraphMatrix() {
        for(int i = 0; i < this.edgeList.size(); i++) {

            Edge currentEdge = this.edgeList.get(i);
            int startVertex = currentEdge.startVertex;
            int endVertex = currentEdge.endVertex;
            this.G[startVertex][endVertex] = 1;
        }
    }

    public int[][] getGraphMatrix() {
        return this.G;
    }

    public void printGraphMatrix() {
        System.out.println("Graph Matrix: ");
        for ( int i = 1; i <= getVertex(); i++ ) {
            for ( int j = 1; j <= getVertex(); j++ ) {
                
                System.out.print(getGraphMatrix()[i][j] + " ");
            }
            System.out.println();
        }
    }

    // public static void main(String[] args) {
    //     int vertex = 5;
    //     int[][] G = new int[vertex+1][vertex+1];
    //     ArrayList<Edge> edgeList = new ArrayList<Edge>();
    //     edgeList.add(new Edge(1,4));
    //     edgeList.add(new Edge(4,2));
    //     edgeList.add(new Edge(2,5));
    //     edgeList.add(new Edge(3,5));
    //     edgeList.add(new Edge(3,1));
    //     edgeList.add(new Edge(3,4));

    //     for(int i = 0; i < edgeList.size(); i++) {
    //         Edge currentEdge = edgeList.get(i);
    //         int startVertex = currentEdge.startVertex;
    //         int endVertex = currentEdge.endVertex;
    //         G[startVertex][endVertex] = 1;
    //     }

    //     for ( int i = 1; i <= vertex; i++ ) {
    //         for ( int j = 1; j <= vertex; j++ ) {
    //             System.out.print(G[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
}
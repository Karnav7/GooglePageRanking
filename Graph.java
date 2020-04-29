import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
        // value = value * 1000;
        // value = Math.round(value);
        // return value / 1000;
    }

    private ArrayList<Integer> getIncomingVertexList(int v) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for ( int i = 0; i < this.edgeList.size(); i++ ) {
            if ( this.edgeList.get(i).endVertex == v ) {
                list.add(this.edgeList.get(i).startVertex);
            }
        }
        return list;
    }

    public ArrayList<Double> calculatePageRank(ArrayList<Edge> edgelist, int error, double df, int il) {
        createGraphMatrix();
        int[][] matrix = getGraphMatrix();
        int N = getVertex();
        System.out.println("no of vertices: " + N);
        double initialPR = 1.0 / N; int count;
        ArrayList<Double> oldPRList = new ArrayList<Double>(N+1);
        ArrayList<Double> newPRList = new ArrayList<Double>(N+1); 
        for ( int i = 1; i <= N; i++ ) {
            oldPRList.add(round(initialPR, 4));
            newPRList.add(round(initialPR, 4));
        }

        for( int x = 0; x < il; x++ ) {
            LinkedHashMap<Integer, Integer> incomingLinkCount = new LinkedHashMap<Integer, Integer>(N + 1);
            LinkedHashMap<Integer, Integer> outLinkCount = new LinkedHashMap<Integer, Integer>(N + 1);
            for ( int i = 1; i <= N; i++ ) {
                count = 0;
                int count1 = 0;
                for ( int j = 1; j <= N; j++ ) {
                    if ( matrix[j][i] == 1 ) {      // For incoming links
                        count += 1;
                    }
                    if ( matrix[i][j] == 1 ) {
                        count1 += 1;
                    }
                }
                incomingLinkCount.put(i, count);
                outLinkCount.put(i, count1);
            }
            // Set<Map.Entry<Integer, Integer>> set = incomingLinkCount.entrySet();
            // System.out.println("incoming List: ");
            // for ( Map.Entry<Integer, Integer> me:set ) {
            //     System.out.println(me.getKey() + "-->" + me.getValue());
            // }
            Set<Map.Entry<Integer, Integer>> set1 = outLinkCount.entrySet();
            System.out.println("out List: ");
            for ( Map.Entry<Integer, Integer> me:set1 ) {
                System.out.println(me.getKey() + "-->" + me.getValue());
            }
    
            for ( int k = 1; k <= N; k++ ) {
                double sumIncomingPR = 0.0; double pr = 0.0;
                ArrayList<Integer> temp = getIncomingVertexList(k);
                System.out.print("\nIncoming vertices of vertex " + k + ": ");
                if ( temp.size() > 0 ) {
                    for ( int i = 0; i < temp.size(); i++ ) { 
                        System.out.print(temp.get(i) + " ");
                        int inpt1 = temp.get(i) - 1; int inpt2 = temp.get(i);
                        sumIncomingPR += (oldPRList.get(inpt1) / outLinkCount.get(inpt2));
                    }
                }
                pr = ((1.0 - df) / N) + df * sumIncomingPR;
                System.out.println("pr of " + k + ": " + pr);
                newPRList.set(k - 1, round(pr, 4)); 
            }
            System.out.println("Iteratin no: " + x);
            int check = 0;
            if ( x > 1 ) {
                for( int i = 0; i < newPRList.size(); i++ ) {
                    if ( newPRList.get(i) - oldPRList.get(i) == error ) {
                        check++;
                    }
    
                    if ( check == newPRList.size() ) {
                        System.out.println("yo");
                        return newPRList;
                    }
                }
            }
    
            System.out.println("\nNew PR list: ");
            for ( int i = 0; i < newPRList.size(); i++ ) {
                System.out.println("vertex " + i + 1 + "-->" + newPRList.get(i));
                oldPRList.set(i, newPRList.get(i));
            }
            
            
        }
        

        return null;
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
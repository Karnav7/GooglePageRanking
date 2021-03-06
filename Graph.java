import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
    private int vertex;
    private int[][] G;
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();
    private LinkedList<Integer> adjList[];

    public Graph() {
        this.adjList = null;
        this.vertex = 0;
    }

    public void setVertex(int v) {
        this.vertex = v;
        this.G = new int[vertex+1][vertex+1];
        
    }

    public int getVertex() {
        return this.vertex;
    }

    public void addNewEdge(Edge e) {
        // if ( !this.edgeList.contains(e) )
        this.edgeList.add(e);
    }

    public void addEdge( int start, int end ) {
        this.adjList[start].addFirst(end);
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

    public void createGraphAdjList() {
        this.adjList = new LinkedList[this.vertex + 1];
        for (int i = 1; i <= vertex ; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int[][] getGraphMatrix() {
        return this.G;
    }

    public LinkedList<Integer>[] getAdjList() {
        return this.adjList;
    }

    public void printGraphMatrix() {
        System.out.println("Matrix reopresentation of graph: ");
        System.out.print("x");
        for ( int i = 1; i <= getVertex(); i++ )
            System.out.print(" " + i);

        System.out.println();
        for ( int i = 1; i <= getVertex(); i++ ) {
            System.out.print(i + " ");
            for ( int j = 1; j <= getVertex(); j++ ) {
                
                System.out.print(getGraphMatrix()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printGraph(){
        for (int i = 1; i <= getVertex() ; i++) {
            if( this.adjList[i].size() > 0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < this.adjList[i].size(); j++) {
                    System.out.print(this.adjList[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    private static double round(double value, int places) {
        // System.out.println("value: " + value + " places: " + places);
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

    private ArrayList<Integer> getIncomingVertexListAdj(int v) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for ( int i = 1; i < this.adjList.length; i++ ) {
            for ( int j = 0; j < this.adjList[i].size(); j++ ) {
                if ( this.adjList[i].get(j) == v ) {
                    list.add(i);
                }
            }
        }
        // for ( int i = 1; i < this.adjList.length; i++ ) {
            
        //     for ( int j = 1; j < this.adjList.length; j++ ) {
                
        //             for ( int k = 0; k < this.adjList[j].size(); k++ ) {
        //                 if ( this.adjList[j].get(k) == v ) {
        //                     list.add(j);
        //                 }
        //             }
                
        //     }
            
        // }
        return list;
    }

    public ArrayList<Double> calculatePageRankAdj(LinkedList<Integer>[] g, double error, double df, int il ) {
        int N = getVertex();
        double initialPR = 1.0 / N; int count;
        ArrayList<Double> oldPRList = new ArrayList<Double>(N+1);
        ArrayList<Double> newPRList = new ArrayList<Double>(N+1); 
        for ( int i = 1; i <= N; i++ ) {
            oldPRList.add(round(initialPR, 4));
            newPRList.add(round(initialPR, 4));
        }

        for( int x = 0; x < il; x++ ) {
            // System.out.println("Iteration: " + x);
            LinkedHashMap<Integer, Integer> incomingLinkCount = new LinkedHashMap<Integer, Integer>(N + 1);
            LinkedHashMap<Integer, Integer> outLinkCount = new LinkedHashMap<Integer, Integer>(N + 1);
            count = 0;
            for ( int i = 1; i < g.length; i++ ) {
                outLinkCount.put(i, g[i].size());
            }

            for ( int i = 1; i < g.length; i++ ) {
                count = 0;
                for ( int j = 1; j < g.length; j++ ) {
                    if ( g[j].size() > 0 ) {
                        for ( int k = 0; k < g[j].size(); k++ ) {
                            if ( g[j].get(k) == i ) {
                                count++;
                            }
                        }
                    }
                }
                incomingLinkCount.put(i, count);
            }

            for ( int k = 1; k <= N; k++ ) {
                double sumIncomingPR = 0.0; double pr = 0.0;
                ArrayList<Integer> temp = getIncomingVertexListAdj(k);
                // System.out.print("\nIncomingList: " + temp);
                // System.out.print("\nIncoming vertices of vertex " + k + ": ");
                if ( temp.size() > 0 ) {
                    for ( int i = 0; i < temp.size(); i++ ) { 
                        // System.out.print(temp.get(i) + " ");
                        int inpt1 = temp.get(i) - 1; int inpt2 = temp.get(i);
                        // System.out.print(", input1 " + inpt1 + " ,input2 " + inpt2 + " ");
                        // System.out.print("\noutlink: " + outLinkCount);
                        sumIncomingPR += (oldPRList.get(inpt1) / outLinkCount.get(inpt2));
                    }
                }
                // System.out.println("sum: " + sumIncomingPR);
                pr = ((1.0 - df) / N) + df * sumIncomingPR;
                // System.out.println("pr of " + k + ": " + pr);
                newPRList.set(k - 1, round(pr, 4)); 
            }

            int check = 0;
            if ( x > 1 ) {
                for( int i = 0; i < newPRList.size(); i++ ) {
                    if ( Math.abs(newPRList.get(i) - oldPRList.get(i)) <= error ) {
                        check++;
                    }
    
                    if ( check == newPRList.size() ) {
                        // System.out.println("yo"+ x);
                        return newPRList;
                    }
                }
            }
    
            // System.out.println("\nNew PR list: ");
            for ( int i = 0; i < newPRList.size(); i++ ) {
                // System.out.println("vertex " + i + 1 + "-->" + newPRList.get(i));
                oldPRList.set(i, newPRList.get(i));
            }
        }

        return null;
    }

    public ArrayList<Double> calculatePageRank(ArrayList<Edge> edgelist, double error, double df, int il) {
        createGraphMatrix();
        int[][] matrix = getGraphMatrix();
        int N = getVertex();
        // System.out.println("no of vertices: " + N);
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

            // Set<Map.Entry<Integer, Integer>> set1 = outLinkCount.entrySet();
            // System.out.println("out List: ");
            // for ( Map.Entry<Integer, Integer> me:set1 ) {
            //     System.out.println(me.getKey() + "-->" + me.getValue());
            // }
    
            for ( int k = 1; k <= N; k++ ) {
                double sumIncomingPR = 0.0; double pr = 0.0;
                ArrayList<Integer> temp = getIncomingVertexList(k);
                // System.out.print("\nIncoming vertices of vertex " + k + ": ");
                if ( temp.size() > 0 ) {
                    for ( int i = 0; i < temp.size(); i++ ) { 
                        // System.out.print(temp.get(i) + " ");
                        int inpt1 = temp.get(i) - 1; int inpt2 = temp.get(i);
                        sumIncomingPR += (oldPRList.get(inpt1) / outLinkCount.get(inpt2));
                    }
                }
                pr = ((1.0 - df) / N) + df * sumIncomingPR;
                // System.out.println("pr of " + k + ": " + pr);
                newPRList.set(k - 1, round(pr, 4)); 
            }
            // System.out.println("Iteratin no: " + x);
            int check = 0;
            if ( x > 1 ) {
                for( int i = 0; i < newPRList.size(); i++ ) {
                    if ( Math.abs(newPRList.get(i) - oldPRList.get(i)) <= error ) {
                        check++;
                    }
    
                    if ( check == newPRList.size() ) {
                        // System.out.println("yo"+ x);
                        return newPRList;
                    }
                }
            }
    
            // System.out.println("\nNew PR list: ");
            for ( int i = 0; i < newPRList.size(); i++ ) {
                // System.out.println("vertex " + i + 1 + "-->" + newPRList.get(i));
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
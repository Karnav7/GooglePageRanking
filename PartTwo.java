import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PartTwo {

    private static ArrayList<Boolean> randList = new ArrayList<Boolean>();

    private static void initializeList(int size) {
        randList = new ArrayList<Boolean>(size);
        for ( int i = 0; i < size; i++ ) {
            randList.add(false);
        }
    }

    private static void setList(ArrayList<Boolean> list) {
        randList = list;
    }

    private static ArrayList<Boolean> getList() {
        return randList;
    }

    private static int getUniqueRandomNo(int low, int high) {
        int size = high - low;
        initializeList(size);
        ArrayList<Boolean> list = getList();
        Random r = new Random();
        
        while ( true ) {
            int rand = r.nextInt(high - low) + low;
            if ( list.get(rand - 1) == false ) {
                list.set(rand - 1, true);
                setList(list);
                return rand;
            }
        }
    }

    private static int getRandomNo(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

    public static void main(String[] args) {
        int avgTime1 = 0;
        int vertex = 100;
        for ( int k = 0; k < 50; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            for ( int i = 0; i < getRandomNo(50, 2*vertex); i++ ) {
                int start = getUniqueRandomNo(1, vertex + 1);
                int end = getUniqueRandomNo(1, vertex + 1);
                g.addNewEdge(new Edge(start, end));
            }
            ArrayList<Double> pgList = g.calculatePageRank(g.getEdgeList(), 0.75, 0.85, 1000);
            if ( pgList != null ) {
                // System.out.print("Result : [");
                // String res = "";
                // for ( int i = 0; i < pgList.size(); i++ ) {
                //     res += pgList.get(i) + ", ";
                // }
                // System.out.print(res.substring(0, res.length() - 2));
                // System.out.print("]");
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }
        System.out.println("\nAverage time of 100 pages: " + avgTime1 / 50 + " milli seconds.");

        avgTime1 = 0;
        vertex = 500;
        for ( int k = 0; k < 50; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            for ( int i = 0; i < getRandomNo(200, 2*vertex); i++ ) {
                int start = getUniqueRandomNo(1, vertex + 1);
                int end = getUniqueRandomNo(1, vertex + 1);
                g.addNewEdge(new Edge(start, end));
            }
            ArrayList<Double> pgList = g.calculatePageRank(g.getEdgeList(), 0.75, 0.85, 1000);
            if ( pgList != null ) {
                // System.out.print("Result : [");
                // String res = "";
                // for ( int i = 0; i < pgList.size(); i++ ) {
                //     res += pgList.get(i) + ", ";
                // }
                // System.out.print(res.substring(0, res.length() - 2));
                // System.out.print("]");
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }

        System.out.println("\nAverage time of 500 pages: " + avgTime1 / 50 + " milli seconds.");

        avgTime1 = 0;
        vertex = 1000;
        for ( int k = 0; k < 50; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            for ( int i = 0; i < getRandomNo(650, 2*vertex); i++ ) {
                int start = getUniqueRandomNo(1, vertex + 1);
                int end = getUniqueRandomNo(1, vertex + 1);
                g.addNewEdge(new Edge(start, end));
            }
            ArrayList<Double> pgList = g.calculatePageRank(g.getEdgeList(), 0.75, 0.85, 1000);
            if ( pgList != null ) {
                // System.out.print("Result : [");
                // String res = "";
                // for ( int i = 0; i < pgList.size(); i++ ) {
                //     res += pgList.get(i) + ", ";
                // }
                // System.out.print(res.substring(0, res.length() - 2));
                // System.out.print("]");
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }

        System.out.println("\nAverage time of 1000 pages: " + avgTime1 / 50 + " milli seconds.");

        avgTime1 = 0;
        vertex = 2000;
        for ( int k = 0; k < 50; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            for ( int i = 0; i < getRandomNo(1400, 2*vertex); i++ ) {
                int start = getUniqueRandomNo(1, vertex + 1);
                int end = getUniqueRandomNo(1, vertex + 1);
                g.addNewEdge(new Edge(start, end));
            }
            ArrayList<Double> pgList = g.calculatePageRank(g.getEdgeList(), 0.75, 0.85, 1000);
            if ( pgList != null ) {
                // System.out.print("Result : [");
                // String res = "";
                // for ( int i = 0; i < pgList.size(); i++ ) {
                //     res += pgList.get(i) + ", ";
                // }
                // System.out.print(res.substring(0, res.length() - 2));
                // System.out.print("]");
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }

        System.out.println("\nAverage time of 2000 pages: " + avgTime1 / 50 + " milli seconds.");

        avgTime1 = 0;
        vertex = 5000;
        for ( int k = 0; k < 50; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            for ( int i = 0; i < getRandomNo(4500, 2*vertex); i++ ) {
                int start = getUniqueRandomNo(1, vertex + 1);
                int end = getUniqueRandomNo(1, vertex + 1);
                g.addNewEdge(new Edge(start, end));
            }
            ArrayList<Double> pgList = g.calculatePageRank(g.getEdgeList(), 0.75, 0.85, 1000);
            if ( pgList != null ) {
                // System.out.print("Result : [");
                // String res = "";
                // for ( int i = 0; i < pgList.size(); i++ ) {
                //     res += pgList.get(i) + ", ";
                // }
                // System.out.print(res.substring(0, res.length() - 2));
                // System.out.print("]");
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }

        System.out.println("\nAverage time of 5000 pages: " + avgTime1 / 50 + " milli seconds.");

        avgTime1 = 0;
        vertex = 10000;
        for ( int k = 0; k < 50; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            for ( int i = 0; i < getRandomNo(11000, 2*vertex); i++ ) {
                int start = getUniqueRandomNo(1, vertex + 1);
                int end = getUniqueRandomNo(1, vertex + 1);
                g.addNewEdge(new Edge(start, end));
            }
            ArrayList<Double> pgList = g.calculatePageRank(g.getEdgeList(), 0.75, 0.85, 1000);
            if ( pgList != null ) {
                // System.out.print("Result : [");
                // String res = "";
                // for ( int i = 0; i < pgList.size(); i++ ) {
                //     res += pgList.get(i) + ", ";
                // }
                // System.out.print(res.substring(0, res.length() - 2));
                // System.out.print("]");
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }

        System.out.println("\nAverage time of 10000 pages: " + avgTime1 / 50 + " milli seconds.");
    }
}
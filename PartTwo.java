import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
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

    private static boolean flipCoin() {
        Random r = new Random();
        if (r.nextInt(2) == 1 ) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int avgTime1 = 0;
        int vertex = 100;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            // for ( int i = 0; i < getRandomNo(50, 2*vertex); i++ ) {
            //     int start = getUniqueRandomNo(1, vertex + 1);
            //     int end = getUniqueRandomNo(1, vertex + 1);
            //     // g.addNewEdge(new Edge(start, end));
            //     g.addEdge(start, end);
            // }
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.02 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            
            // g.printGraph();
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.50, 0.85, 1000);
            if ( pgList != null ) {
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }
        System.out.println("\nAverage time of 100 pages and outdegree 20%: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 100;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            // for ( int i = 0; i < getRandomNo(50, 2*vertex); i++ ) {
            //     int start = getUniqueRandomNo(1, vertex + 1);
            //     int end = getUniqueRandomNo(1, vertex + 1);
            //     // g.addNewEdge(new Edge(start, end));
            //     g.addEdge(start, end);
            // }
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.04 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            // g.printGraph();
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.50, 0.85, 1000);
            if ( pgList != null ) {
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }
        System.out.println("\nAverage time of 100 pages and outdegree 40%: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 100;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            // for ( int i = 0; i < getRandomNo(50, 2*vertex); i++ ) {
            //     int start = getUniqueRandomNo(1, vertex + 1);
            //     int end = getUniqueRandomNo(1, vertex + 1);
            //     // g.addNewEdge(new Edge(start, end));
            //     g.addEdge(start, end);
            // }
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.06 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.50, 0.85, 1000);
            if ( pgList != null ) {
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }
        System.out.println("\nAverage time of 100 pages and outdegree 60%: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 100;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            // for ( int i = 0; i < getRandomNo(50, 2*vertex); i++ ) {
            //     int start = getUniqueRandomNo(1, vertex + 1);
            //     int end = getUniqueRandomNo(1, vertex + 1);
            //     // g.addNewEdge(new Edge(start, end));
            //     g.addEdge(start, end);
            // }
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.08 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.50, 0.85, 1000);
            if ( pgList != null ) {
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }
        System.out.println("\nAverage time of 100 pages and outdegree 80%: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 100;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            // for ( int i = 0; i < getRandomNo(50, 2*vertex); i++ ) {
            //     int start = getUniqueRandomNo(1, vertex + 1);
            //     int end = getUniqueRandomNo(1, vertex + 1);
            //     // g.addNewEdge(new Edge(start, end));
            //     g.addEdge(start, end);
            // }
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.09 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.50, 0.85, 1000);
            if ( pgList != null ) {
                LocalDateTime endTime = LocalDateTime.now();
                timeDiff = Duration.between(startTime, endTime).toMillis();
                avgTime1 += timeDiff;
            } else {
                // System.out.println("No solution as iteration limit exceeded!");
            }
        }
        System.out.println("\nAverage time of 100 pages and outdegree 90%: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 500;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.02 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.50, 0.85, 1000);
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

        System.out.println("\nAverage time of 500 pages and outdegree 20%: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 500;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.04 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.50, 0.85, 1000);
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

        System.out.println("\nAverage time of 500 pages and outdegree 40%: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 500;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.06 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.50, 0.85, 1000);
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

        System.out.println("\nAverage time of 500 pages and outdegree 60%: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 500;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.08 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.50, 0.85, 1000);
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

        System.out.println("\nAverage time of 500 pages and outdegree 80%: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 500;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.09 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.50, 0.85, 1000);
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

        System.out.println("\nAverage time of 500 pages and outdegree 90%: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 1000;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.02 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 1000 pages and 20% outdegree: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 1000;
        for ( int k = 0; k < 10; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.04 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 1000 pages and 40% outdegree: " + avgTime1 / 10 + " milli seconds.");

        avgTime1 = 0;
        vertex = 1000;
        for ( int k = 0; k < 5; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.06 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 1000 pages and 60% outdegree: " + avgTime1 / 5 + " milli seconds.");

        avgTime1 = 0;
        vertex = 1000;
        for ( int k = 0; k < 5; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.08 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 1000 pages and 80% outdegree: " + avgTime1 / 5 + " milli seconds.");

        avgTime1 = 0;
        vertex = 1000;
        for ( int k = 0; k < 5; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.09 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 1000 pages and 90% outdegree: " + avgTime1 / 5 + " milli seconds.");

        avgTime1 = 0;
        vertex = 2000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.01 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 2000 pages and outdegree 20%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 2000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.02 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 2000 pages and outdegree 40%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 2000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.03 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 2000 pages and outdegree 60%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 2000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.04 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 2000 pages and outdegree 80%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 2000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.05 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 2000 pages and outdegree 90%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 5000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.01 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 5000 pages and outdegree 20%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 5000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.012 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 5000 pages and outdegree 40%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 5000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.014 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 5000 pages and outdegree 60%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 5000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.016 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 5000 pages and outdegree 80%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 5000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.02 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }
            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 5000 pages and outdegree 90%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 10000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.01 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }

            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 10000 pages and outdegree 20%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 10000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.016 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }

            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 10000 pages and outdegree 40%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 10000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.014 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }

            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 10000 pages and outdegree 30%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 10000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.012 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }

            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 10000 pages and outdegree 80%: " + avgTime1 / 2 + " milli seconds.");

        avgTime1 = 0;
        vertex = 10000;
        for ( int k = 0; k < 2; k++ ) {
            LocalDateTime startTime = LocalDateTime.now();
            Long timeDiff;
            Graph g = new Graph();
            
            g.setVertex(vertex);
            g.createGraphAdjList();
            LinkedList<Integer>[] list15 = g.getAdjList();
            while ( true ) {
                if ( flipCoin() == true ) {
                    int start = getUniqueRandomNo(1, vertex + 1);
                    int end = getUniqueRandomNo(1, vertex + 1);
                    g.addEdge(start, end);
                }
                boolean stop = false;
                for ( int i = 1; i < list15.length; i++ ) {
                    int outDegree = (int)(0.02 * vertex);
                    if ( list15[i].size() > outDegree ) {
                        stop = true;
                        break;
                    }
                }
                if ( stop == true ) {
                    break;
                }
            }

            ArrayList<Double> pgList = g.calculatePageRankAdj(g.getAdjList(), 0.80, 0.85, 1000);
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

        System.out.println("\nAverage time of 10000 pages and outdegree 90%: " + avgTime1 / 2 + " milli seconds.");
    }
}


// for ( int i = 0; i < getRandomNo(11000, 2*vertex); i++ ) {
//     int start = getUniqueRandomNo(1, vertex + 1);
//     int end = getUniqueRandomNo(1, vertex + 1);
//     // g.addNewEdge(new Edge(start, end));
//     g.addEdge(start, end);
// }
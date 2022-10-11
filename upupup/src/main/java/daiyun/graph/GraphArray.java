package daiyun.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author godai
 * @date 2021/8/1 16:01
 * @description
 */
public class GraphArray {

    List<String> vertexList;
    int[][] array;
    int edgeSize;

    public GraphArray(int N) {
        vertexList = new ArrayList<>(N);
        array = new int[N][N];
        edgeSize = 0;
    }

    public void addVertex(String node) {
        vertexList.add(node);
    }

    public int getVertexIndex(String node) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).equals(node)) {
                return i;
            }
        }
        return -1;
    }

    public int getVertexSize() {
        return vertexList.size();
    }

    public void addEdge(String A, String B, int weight) {
        int a = getVertexIndex(A);
        int b = getVertexIndex(B);
        addEdge(a, b, weight);
    }

    public void addEdge(int a, int b, int weight) {
        if (a < 0 || b < 0) {
            return;
        }
        edgeSize++;
        array[a][b] = weight;
    }

    public int getEdgeWeight(String A, String B) {
        int a = getVertexIndex(A);
        int b = getVertexIndex(B);
        return getEdgeWeight(a, b);
    }

    public int getEdgeWeight(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        return array[a][b];
    }

    public int getEdgeSize() {
        return edgeSize;
    }

    public static void main(String[] args) {
        GraphArray graph = new GraphArray(9);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 1);

        System.out.println(graph.getVertexSize());
        System.out.println(graph.getEdgeSize());
        System.out.println();
    }
}

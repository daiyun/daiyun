package daiyun.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author godai
 * @date 2021/8/1 16:16
 * @description
 */
public class GraphList {

    Map<String, Vertex> map;

    public GraphList() {
        map = new HashMap<>();
    }

    public Vertex addVertex(String node) {
        if (!map.containsKey(node)) {
            map.put(node, new Vertex(node));
        }
        return map.get(node);
    }

    public Vertex getVertex(String node) {
        return map.get(node);
    }

    public Edge addEdge(String A, String B, int weight) {

        // 保证边的两个节点存在，不存在则添加
        Vertex vertex = addVertex(A);

        Vertex vertexTo = addVertex(B);

        // 构建该条边
        Edge edge = new Edge(vertexTo, weight);

        if (vertex.edge == null) {
            vertex.edge = edge;
            return edge;
        }

        // 尾插发，链表中存储边（同一个走向可能存在多条边）
        Edge next = vertex.edge;
        while (next.nextEdge != null) {
            next = next.nextEdge;
        }
        next.nextEdge = edge;
        return edge;
    }

    public Edge getEdge(String A, String B) {
        Vertex vertex = getVertex(A);
        Vertex vertexTo = getVertex(B);

        // 检查节点是否存在
        if (vertex == null || vertexTo == null) {
            return null;
        }

        // 编辑链表，找到对应的边
        Edge edge = vertex.edge;
        while (edge != null) {
            if (edge.toNode.equals(vertexTo)) {
                return edge;
            }
            edge = edge.nextEdge;
        }
        return null;
    }

    public void print() {
        map.forEach((node, vertex) -> {
            System.out.println("node:" + node);
            Edge edge = vertex.edge;
            while (edge != null) {
                System.out.println(node + "->" + edge.toNode.node + " weight:" + edge.weight);
                edge = edge.nextEdge;
            }
        });
    }

    class Vertex {
        String node;
        Edge edge;

        public Vertex(String node) {
            this.node = node;
        }
    }

    class Edge {
        Vertex toNode;
        int weight;
        Edge nextEdge;

        public Edge(Vertex toNode, int weight) {
            this.toNode = toNode;
            this.weight = weight;
        }
    }
}

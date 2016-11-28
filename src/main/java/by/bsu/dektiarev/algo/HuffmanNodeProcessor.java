package by.bsu.dektiarev.algo;

import by.bsu.dektiarev.entity.Node;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by USER on 25.11.2016.
 */
public final class HuffmanNodeProcessor {

    public static Node buildHuffmanTree(Queue<Node> nodeQueue) {
        while(nodeQueue.size() > 1) {
            Node leftNode = nodeQueue.remove();
            Node rightNode = nodeQueue.remove();
            Node sumNode = new Node(leftNode.getValue() +  rightNode.getValue());
            leftNode.setParent(sumNode);
            rightNode.setParent(sumNode);
            sumNode.setLeftChild(leftNode);
            sumNode.setRightChild(rightNode);
            nodeQueue.add(sumNode);
        }
        return nodeQueue.remove();
    }

    public static List<Integer> buildHuffmanCode(Node node) {
        List<Integer> code = new ArrayList<>();
        Node parent = node.getParent();
        while(parent != null) {
            code.add(parent.getLeftChild().equals(node) ? 0 : 1);
            node = parent;
            parent = parent.getParent();
        }
        Collections.reverse(code);
        return code;
    }

    public static List<Integer> encodeString(String text, Map<String, Node> nodeMap) {
        String[] symbols = text.split("");
        return Arrays.stream(symbols).flatMap(symbol -> {
            if(!nodeMap.containsKey(symbol)) {
                throw new RuntimeException("No such symbol: " + symbol);
            }
            return buildHuffmanCode(nodeMap.get(symbol)).stream();
        }).collect(Collectors.toList());
    }

    private HuffmanNodeProcessor() {
    }
}

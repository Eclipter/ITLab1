package by.bsu.dektiarev;

import by.bsu.dektiarev.algo.HuffmanNodeProcessor;
import by.bsu.dektiarev.entity.Node;
import by.bsu.dektiarev.util.NodeLoader;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by USER on 25.11.2016.
 */
public class Main {

    private static final String FILENAME = "input.txt";
    private static final String TEXT = "abcdabcef";

    public static void main(String[] args) {

        Map<String, Node> nodeMap = NodeLoader.loadNodesFromFile(FILENAME);
        Queue<Node> nodeQueue = new PriorityQueue<>(nodeMap.values());
        HuffmanNodeProcessor.buildHuffmanTree(nodeQueue);

        double midLength = 0;
        double midEntropy = 0;
        for(String letter : nodeMap.keySet()) {
            Node node = nodeMap.get(letter);
            List<Integer> code = HuffmanNodeProcessor.buildHuffmanCode(node);
            System.out.println(String.format("%s (%f): ", letter, node.getValue()) +
                    code + ", Length: " + code.size());
            midLength += node.getValue() * code.size();
            midEntropy += node.getValue() * Math.log(node.getValue()) / Math.log(2);
        }
        midEntropy *= -1;

        System.out.println("Length: " + midLength + ", Entropy: " + midEntropy);

        List<Integer> code = HuffmanNodeProcessor.encodeString(TEXT, nodeMap);
        System.out.print(TEXT + ": ");
        code.forEach(System.out::print);
    }

}

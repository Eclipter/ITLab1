package by.bsu.dektiarev.util;

import by.bsu.dektiarev.entity.Node;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by USER on 25.11.2016.
 */
public final class NodeLoader {

    public static Map<String, Node> loadNodesFromFile(String filename) {
        try {
            Path path = Paths.get(NodeLoader.class.getResource("/" + filename).toURI());
            List<String> stringList = Files.readAllLines(path);
            String[] values = stringList.get(0).split(" ");
            return Stream.of(values).map(value -> {
                String[] parts = value.split(":");
                return new Pair<>(parts[0], new Node(parts[0], Double.parseDouble(parts[1])));
            }).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private NodeLoader() {
    }
}

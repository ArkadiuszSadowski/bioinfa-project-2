import javafx.util.Pair;

import javax.print.attribute.HashAttributeSet;
import java.util.*;
import java.util.stream.Collectors;

public class Vertex {
    private String value;
    private Boolean isError;
    private Integer id;
    private HashMap<Vertex, Integer> neighbourConnections;

    public Vertex(String value) {
        this.isError = false;
        this.neighbourConnections = new HashMap<>();
        this.value = value;
    }

    public void addNeighbour(Vertex vertex) {
        int coverage = getCoverage(vertex.getValue());
        neighbourConnections.put(vertex, coverage);
    }

    private int getCoverage(String neighbourValue) {
        int coverage = 0;
        for (int i = 1; i < value.length(); i++) {
            if (value.substring(i).equals(neighbourValue.substring(0, neighbourValue.length()-i))) {
                coverage = neighbourValue.length()-i;
                return coverage;
            }
        }
        return  coverage;
    }
    
    public void sortNeighbours() {
        HashMap<Vertex, Integer> sorted = new HashMap<>();

        HashMap<Vertex, Integer> sortedNeighbour;
        sortedNeighbour = new HashMap<>(neighbourConnections);
        sortedNeighbour = sortedNeighbour
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        for (Map.Entry<Vertex, Integer> pair : sortedNeighbour.entrySet()) {
            sorted.put(pair.getKey(), pair.getValue());
        }

        neighbourConnections = sorted;
    }

    public void printNeighbours() {
        sortNeighbours();
        for (Map.Entry<Vertex, Integer> pair : neighbourConnections.entrySet()) {
            System.out.println("Neighbour = " + pair.getKey().getValue() + "Coverage = " + pair.getValue());
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getError() {
        return isError;
    }

    public void setError(Boolean error) {
        isError = error;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HashMap<Vertex, Integer> getNeighbourConnections() {
        return neighbourConnections;
    }

    public void setNeighbourConnections(HashMap<Vertex, Integer> neighbourConnections) {
        this.neighbourConnections = neighbourConnections;
    }
}

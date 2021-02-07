package subway.domain;


import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.*;

public class StationRepository {

    static final Station kyoDae = new Station("교대역");
    static final Station gangNam = new Station("강남역");
    static final Station yokSam = new Station("역삼역");
    static final Station namBuTerminal = new Station("남부터미널역");
    static final Station yangJae = new Station("양재역");
    static final Station yangJaeForest = new Station("양재시민의숲역");
    static final Station maeBong = new Station("매봉역");
    static final List<Station> stations = Arrays.asList(kyoDae, gangNam, yokSam, namBuTerminal, yangJae, yangJaeForest, maeBong);

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static Graph setDistance(Graph graph) {
        for (Station station : stations()) {
            graph.addVertex(station);
        }
        graph.setEdgeWeight(graph.addEdge(kyoDae, gangNam), 2);
        graph.setEdgeWeight(graph.addEdge(gangNam, yokSam), 2);
        graph.setEdgeWeight(graph.addEdge(kyoDae, namBuTerminal), 3);
        graph.setEdgeWeight(graph.addEdge(namBuTerminal, yangJae), 6);
        graph.setEdgeWeight(graph.addEdge(yangJae, maeBong), 1);
        graph.setEdgeWeight(graph.addEdge(gangNam, yangJae), 2);
        graph.setEdgeWeight(graph.addEdge(yangJae, yangJaeForest), 10);
        return graph;
    }

    public static Graph getShortestDistancePath() {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph
                = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        return setDistance(graph);
    }

    public static Graph setTime(Graph graph) {
        for (Station station : stations()) {
            graph.addVertex(station);
        }
        graph.setEdgeWeight(graph.addEdge(kyoDae, gangNam), 3);
        graph.setEdgeWeight(graph.addEdge(gangNam, yokSam), 3);
        graph.setEdgeWeight(graph.addEdge(kyoDae, namBuTerminal), 2);
        graph.setEdgeWeight(graph.addEdge(namBuTerminal, yangJae), 5);
        graph.setEdgeWeight(graph.addEdge(yangJae, maeBong), 1);
        graph.setEdgeWeight(graph.addEdge(gangNam, yangJae), 8);
        graph.setEdgeWeight(graph.addEdge(yangJae, yangJaeForest), 3);
        return graph;
    }

    public static Graph getShortestTimePath() {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph
                = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        return setTime(graph);
    }


}

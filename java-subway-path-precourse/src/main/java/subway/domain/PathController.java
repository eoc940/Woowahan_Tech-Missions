package subway.domain;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.List;

public class PathController {

    private static final int INITIALIZED_VALUE = 0;
    private static final int FIRST_INDEX = 0;
    private static final int ONE = 1;

    public List<Station> getTotalPath(Graph graph, Station startStation, Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<Station> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        return shortestPath;
    }

    public int getTotalWeight(Graph graph, Station startStation, Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return (int) dijkstraShortestPath.getPath(startStation, endStation).getWeight();
    }

    public int getOtherWeight(Graph graph, List<Station> stationList) {
        int total = INITIALIZED_VALUE;
        for (int i = FIRST_INDEX; i < stationList.size() - ONE; i++) {
            total += graph.getEdgeWeight(graph.getEdge(stationList.get(i), stationList.get(i+ONE)));
        }
        return total;
    }
}

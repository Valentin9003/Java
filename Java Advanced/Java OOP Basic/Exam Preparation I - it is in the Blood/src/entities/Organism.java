package entities;

import entities.cells.Cell;
import entities.clusters.Cluster;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Organism {

    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.setName(name);
        this.clusters = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    public void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    public void addCluster(Cluster cluster) {
        this.clusters.add(cluster);
    }

    private int getCellsCount() {
        int count = 0;
        for (Cluster cluster : clusters) {
            for (Cell[] cells : cluster.getCells()) {
                for (Cell cell : cells) {
                    if (cell != null) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public Cluster getClusterById(String clusterId) {
        for (Cluster cluster : clusters) {
            if (cluster.getId().equals(clusterId)) {
                return cluster;
            }
        }

        return null;
    }

    public void moveClusterToTheEnd() {
        Cluster cluster = this.getClusters().get(0);
        this.clusters.remove(0);
        this.clusters.add(cluster);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Organism - %s", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("--Clusters: %d", this.getClusters().size()))
                .append(System.lineSeparator())
                .append(String.format("--Cells: %d", this.getCellsCount()));

        if (this.getClusters().size() > 0) {
            sb.append(System.lineSeparator());
        }

        for (Cluster cluster : clusters) {
            sb.append(cluster.toString());
        }

        return sb.toString();

    }

}

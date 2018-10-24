package factory;

import entities.clusters.Cluster;

public final class ClusterFactory {

    private ClusterFactory() {
    }

    public static Cluster createCluster(String id, int rows, int cols) {
        return new Cluster(id, rows, cols);
    }
}

package controllers;

import constants.Config;
import entities.Organism;
import entities.cells.Cell;
import entities.clusters.Cluster;
import factory.CellFactory;
import factory.ClusterFactory;
import factory.OrganismFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The business logic of the program. This class hold the main functionality.
 */
public class HealthManager implements HealthManagerController {

    private Map<String, Organism> organismDB;

    public HealthManager() {
        this.organismDB = new LinkedHashMap<>();
    }

    @Override
    public String checkCondition(String organismName) {
        /** RETURNS detailed information about the condition of the organism
         *  with the given name */
        String result = "";
        if (this.organismDB.containsKey(organismName)) {
            result = this.organismDB.get(organismName).toString();
        }
        return result;
    }

    @Override
    public String createOrganism(String name) {
        /** CREATES an organism with the given name
         o	RETURNS message "Created organism <name>"
         o	If an organism with the same name already exists, returns message "Organism <name> already exists"
         */
        if (this.organismDB.containsKey(name)) {
            return String.format("Organism %s already exists", name);
        } else {
            Organism organism = OrganismFactory.createOrganism(name);
            this.organismDB.put(name, organism);
            return String.format("Created organism %s", organism.getName());
        }
    }

    @Override
    public String addCluster(String organismName, String clusterId, int rows, int cols) {
        /** CREATES a cluster with the given id, rows and cols
         o	ADDS the cluster to the cluster collection of the organism with the given name
         o	If the organism already has a cluster with the same Id, nothing happens
         o	RETURNS message "Organism <organism name>: Created cluster <cluster id>";
         */
        if (!this.organismDB.containsKey(organismName)) {
            throw new IllegalArgumentException(Config.NOT_EXIST_ORGANISM_EX_MSG);
        }
        Cluster cluster = ClusterFactory.createCluster(clusterId, rows, cols);
        this.organismDB.get(organismName).addCluster(cluster);

        return String.format("Organism %s: Created cluster %s", organismName, clusterId);
    }

    @Override
    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        /** CREATES a cell of the given type with the given id, health, positionRow, positionCol, and the given additional property (size, velocity or virulense).
         o	FINDS the organism with given name, find the cluster with given id in the cluster collection of that organism and ADDS the cell to the cells collection of that cluster
         o	RETURNS message "Organism <organism name>: Created cell <cell id> in cluster <cluster id>"
         */
        if (!this.organismDB.containsKey(organismName)) {
            throw new IllegalArgumentException(Config.NOT_EXIST_ORGANISM_EX_MSG);
        }

        Cluster cluster = this.organismDB.get(organismName).getClusterById(clusterId);
        if (cluster == null) {
            throw new IllegalArgumentException(Config.NOT_EXIST_CLUSTER_EX_MSG);
        }

        Cell cell = CellFactory.createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);
        cluster.addCell(cell);

        return String.format("Organism %s: Created cell %s in cluster %s",
                organismName,
                cellId,
                clusterId);
    }

    @Override
    public String activateCluster(String organismName) {
        /** FINDS the organism with the given name
         o	ACTIVATES the next cluster in order
         o	RETURNS message "Organism <organism name>: Activated cluster <cluster id>. Cells left: <cells count>"
         */

        if (this.organismDB.containsKey(organismName)) {
            if (this.organismDB.get(organismName).getClusters().size() > 0) {

                Cluster cluster = this.organismDB.get(organismName).getClusters().get(0);

                cluster.activate();

                this.organismDB.get(organismName).moveClusterToTheEnd();

                return String.format("Organism %s: Activated cluster %s. " +
                        "Cells left: %d", organismName, cluster.getId(), cluster.getCellsCount());
            }
        }
        return "";
    }
}

package controllers;

public interface HealthManagerController {

    String checkCondition(String organismName);

    String createOrganism(String name);

    String addCluster(String organismName, String clusterId, int rows, int cols);

    String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty);

    String activateCluster(String organismName);

}

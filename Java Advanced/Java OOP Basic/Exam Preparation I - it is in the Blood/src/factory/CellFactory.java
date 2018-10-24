package factory;

import entities.cells.Cell;
import entities.cells.bloodcells.RedBloodCell;
import entities.cells.bloodcells.WhiteBloodCell;
import entities.cells.microbs.Bacteria;
import entities.cells.microbs.Fungi;
import entities.cells.microbs.Virus;

public final class CellFactory {

    private static final String CELL_TYPE_WHITE_BLOOD = "WhiteBloodCell";
    private static final String CELL_TYPE_RED_BLOOD = "RedBloodCell";
    private static final String CELL_TYPE_MICROBE_VIRUS = "Virus";
    private static final String CELL_TYPE_MICROBE_FUNGI = "Fungi";
    private static final String CELL_TYPE_MICROBE_BACTERIA = "Bacteria";

    private CellFactory() {
    }

    public static Cell createCell(String cellType,
                                  String cellId,
                                  int health,
                                  int positionRow,
                                  int positionCol,
                                  int additionalProperty) {
        Cell cell = null;
        switch (cellType) {
            case CELL_TYPE_WHITE_BLOOD:
                cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case CELL_TYPE_RED_BLOOD:
                cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case CELL_TYPE_MICROBE_VIRUS:
                cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case CELL_TYPE_MICROBE_FUNGI:
                cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case CELL_TYPE_MICROBE_BACTERIA:
                cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
        }

        return cell;
    }

}

package engine;

import IO.impl.ConsoleReader;
import IO.impl.ConsoleWriter;
import IO.interfaces.Reader;
import IO.interfaces.Writer;
import constants.Config;
import controllers.HealthManager;

public class OrganismEngine {

    private HealthManager healthManager;
    private Reader reader;
    private Writer writer;

    public OrganismEngine() {
        this.healthManager = new HealthManager();
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
    }

    public void run() {
        String command;
        while (!Config.END_INPUT_SEQUENCE.equalsIgnoreCase(command = this.reader.readLine())) {

            String[] cmdArgs = command.split("\\s+");

            switch (cmdArgs[0]){
                case "checkCondition":
                    executeCheckCondition(cmdArgs[1]);
                    break;
                case "createOrganism":
                    executeCreateOrganism(cmdArgs[1]);
                    break;
                case "addCluster":
                    executeAddCluster(cmdArgs);
                    break;
                case "addCell":
                    executeAddCell(cmdArgs);
                    break;
                case "activateCluster":
                    executeActivateCluster(cmdArgs[1]);
                    break;
            }
        }
    }

    private void executeActivateCluster(String cmdArg) {
        String resultString = this.healthManager.activateCluster(cmdArg);

        if (!Config.EMPTY_STRING.equals(resultString)) {
            this.writer.writeLine(resultString);
        }
    }

    private void executeAddCell(String[] cmdArgs) {
        String orgName = cmdArgs[1];
        String clusterId = cmdArgs[2];
        String cellType = cmdArgs[3];
        String cellId = cmdArgs[4];
        int health = Integer.parseInt(cmdArgs[5]);
        int positionRow = Integer.parseInt(cmdArgs[6]);
        int positionCol = Integer.parseInt(cmdArgs[7]);
        int additionalProperty = Integer.parseInt(cmdArgs[8]);

        try {
            this.writer.writeLine(
                    this.healthManager.addCell(
                            orgName,
                            clusterId,
                            cellType,
                            cellId,
                            health,
                            positionRow,
                            positionCol,
                            additionalProperty));
        } catch (IllegalArgumentException ignored) {
            ;
        }
    }

    private void executeAddCluster(String[] cmdArgs) {
        String organismName = cmdArgs[1];
        String id = cmdArgs[2];
        int rows = Integer.parseInt(cmdArgs[3]);
        int cols = Integer.parseInt(cmdArgs[4]);

        try {
            this.writer.writeLine(
                    this.healthManager.addCluster(organismName, id, rows, cols));
        } catch (IllegalArgumentException ignored) {
            ;
        }
    }

    private void executeCreateOrganism(String cmdArg) {
        this.writer.writeLine(
                this.healthManager.createOrganism(cmdArg));
    }

    private void executeCheckCondition(String cmdArg) {
        String result = this.healthManager.checkCondition(cmdArg);
        if (!Config.EMPTY_STRING.equals(result)){
            this.writer.write(result);
        }
    }
}

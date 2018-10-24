package app.exam.terminal;

import app.exam.config.Config;
import app.exam.controller.CategoryController;
import app.exam.controller.EmployeesController;
import app.exam.controller.ItemsController;
import app.exam.controller.OrdersController;
import app.exam.io.interfaces.ConsoleIO;
import app.exam.io.interfaces.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    private final FileIO fileIO;
    private final ConsoleIO consoleIO;
    private final CategoryController categoryController;
    private final EmployeesController employeesController;
    private  final ItemsController itemsController;
    private final OrdersController ordersController;

    @Autowired
    public Terminal(FileIO fileIO,
                    ConsoleIO consoleIO,
                    CategoryController categoryController,
                    EmployeesController employeesController,
                    ItemsController itemsController,
                    OrdersController ordersController) {
        this.fileIO = fileIO;
        this.consoleIO = consoleIO;
        this.categoryController = categoryController;
        this.employeesController = employeesController;
        this.itemsController = itemsController;
        this.ordersController = ordersController;
    }

    @Override
    public void run(String... args) throws Exception {

        //Import Employees and positions from Json and print message for every record
        this.consoleIO.write(
                this.employeesController.importDataFromJSON(
                        this.fileIO.read(Config.EMPLOYEES_IMPORT_JSON)
                )
        );

        //Import Items and categories from Json and print message for every record
        this.consoleIO.write(
                this.itemsController.importDataFromJSON(
                        this.fileIO.read(Config.ITEMS_IMPORT_JSON)
                )
        );

        //Import Orders from XML and print message for every record
        this.consoleIO.write(
                this.ordersController.importDataFromXML(
                        this.fileIO.read(Config.ORDERS_IMPORT_XML)
                )
        );

        //Json Export - All Orders by Employee
        String exportJsonContent =
                this.ordersController
                        .exportOrdersByEmployeeAndOrderType(
                                "Avery Rush", "ToGo");
        this.fileIO.write(exportJsonContent, "exportOrdersByEmployeeAndOrderType.json");
    }
}

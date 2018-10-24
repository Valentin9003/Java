package softuni.gamestore.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import softuni.gamestore.demo.command.CommandFactory;
import softuni.gamestore.demo.model.dto.binding.UserLogoutBindingModel;
import softuni.gamestore.demo.service.gameService.GameService;
import softuni.gamestore.demo.service.roleService.RoleService;
import softuni.gamestore.demo.service.userService.UserService;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class CmdRunner implements org.springframework.boot.CommandLineRunner {

    private final GameService gameService;
    private final UserService userService;
    private final RoleService roleService;
    private final Set<UserLogoutBindingModel> usersInSystem;

    @Autowired
    public CmdRunner(CommandFactory cf,
                     GameService gameService,
                     UserService userService,
                     RoleService roleService) {
        this.gameService = gameService;
        this.userService = userService;
        this.roleService = roleService;
        this.usersInSystem = new HashSet<>();
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CommandFactory cf = CommandFactory.initHome(gameService, userService, roleService);

        cf.listCommands();
        String[] commandTokens = reader.readLine().split("\\|");

        while (!commandTokens[0].equalsIgnoreCase("Exit")) {

            if (commandTokens[0].equals("LoginUser")) {
                usersInSystem.add(this.userService.loginUser(commandTokens[1]));
                cf.executeCommand(commandTokens);

                String email = commandTokens[1];
                if (this.userService.isADMIN(email)) {
                    CommandFactory cfa = CommandFactory.initAdmin(gameService, userService, roleService);
                    execute(reader, cfa);
                } else {
                    CommandFactory cfu = CommandFactory.initUser(gameService, userService, roleService);
                    execute(reader, cfu);
                }
            }

            cf.listCommands();
            commandTokens = reader.readLine().split("\\|");
        }

        logOutAfterExit();

    }

    private void logOutAfterExit() {
        this.usersInSystem.forEach(this.userService::logout);
    }

    private void execute(BufferedReader reader, CommandFactory cf) throws IOException {
        String[] commandTokens;
        while (true) {
            cf.listCommands();
            commandTokens = reader.readLine().split("\\|");
            if (commandTokens[0].equals("LogoutUser")) {
                cf.executeCommand(commandTokens);
                break;
            }
            if (commandTokens[0].equalsIgnoreCase("OwnedGame")) {
                for (UserLogoutBindingModel userLogoutBindingModel : usersInSystem) {
                    String[] tokens = new String[]{"OwnedGame", userLogoutBindingModel.getEmail()};
                    cf.executeCommand(tokens);
                }
            } else {
                cf.executeCommand(commandTokens);
            }
        }
    }
}

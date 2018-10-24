package users.system.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import users.system.entity.User;
import users.system.service.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class RunnerTerminal implements CommandLineRunner {

    private UserService userService;
    private TownService townService;
    private PictureService pictureService;
    private CountryService countryService;
    private AlbumService albumService;

    @Autowired
    public RunnerTerminal(UserService userService, TownService townService, PictureService pictureService, CountryService countryService, AlbumService albumService) {
        this.userService = userService;
        this.townService = townService;
        this.pictureService = pictureService;
        this.countryService = countryService;
        this.albumService = albumService;
    }

    @Override
    public void run(String... strings) throws Exception {
        initUserData();
//        findAllByEmileProvider();
//        removeInactiveUsers();
    }

    private void removeInactiveUsers() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter date (yyyy-MM-dd): ");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(reader.readLine());

        List<User> userList = this.userService.usersLastTimeLoggedInAfter(date);
        this.userService.removeAllUnActiveUsersAfterDate(date);

        if (userList.size() > 0) {
            System.out.println(userList.size() + "users has been deleted");
        } else {
            System.out.println("No users has been deleted");
        }

        this.userService.deleteAllByIsDeletedTrue();
    }

    private void findAllByEmileProvider() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter email provider: ");
        String provider = reader.readLine();

        this.userService.findAllUsersByEmailProvider(provider).forEach(u -> {
            System.out.println(u.getUsername() + " " + u.getEmail());
        });
    }

    private void initUserData() {
        User user = new User();
        user.setUsername("Someone");
        user.setPassword("RssRTs413?");
        user.setEmail("toi@abv.bg");
        user.setAge(18);
        user.setFirstName("Someoncho");
        user.setLastName("Toshevski");

        this.userService.persist(user);
    }
}

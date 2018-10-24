import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ranking {

    private static final String END_CONTESTS = "end of contests";
    private static final String END_SUBMISSIONS = "end of submissions";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /**The Map keep Key: contest, Value: password -> Map<Contest, Password>*/
        Map<String, String> contestPassDB = new LinkedHashMap<>();
        fillContestDB(reader, contestPassDB);
        /**The Map keep Key: user, Value: <key-Contest, value-Points> -> Map<User, Map<Contest, Points>>*/
        Map<String, Map<String, Integer>> studentsDB = new TreeMap<>();

        String lineSub;
        while (!END_SUBMISSIONS.equalsIgnoreCase(lineSub = reader.readLine())) {
            String[] tokens = lineSub.split("=>");
            /**input will coming in the format “{contest}=>{password}=>{username}=>{points}”*/

            String contest = tokens[0];
            String password = tokens[1];
            String userName = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (!contestPassDB.containsKey(contest) || !contestPassDB.get(contest).equals(password)) {
                /**If the contest don't exist OR the password is incorrect
                 stop current loop and read new line*/
                continue;
            }

            fillStudentsDbWithData(studentsDB, contest, userName, points);
        }

        /**•	On the first line print the best user*/
        printBestUser(studentsDB);
        /**•	Then print all students ordered as mentioned above..*/
        printAllStudentsRanking(studentsDB);
    }

    private static void fillStudentsDbWithData(Map<String, Map<String, Integer>> studentsDB, String contest, String userName, int points) {
        if (!studentsDB.containsKey(userName)) {
            /**If the user do not exist in the Database, create it with the given data*/
            studentsDB.putIfAbsent(userName, new LinkedHashMap<>());
            studentsDB.get(userName).put(contest, points);
        } else {
            if (studentsDB.get(userName).containsKey(contest)) {
                /**If the contest is already in the Database for the current user,
                 and have already mark/point from the given contest*/

                int oldPt = studentsDB.get(userName).get(contest);
                /**Getting the user points from the current contest*/

                if (points > oldPt) {
                    /**If the current points are greater than old points
                     replace the contest points with the current points (best points)*/
                    studentsDB.get(userName).replace(contest, points);
                }
            } else {
                /**Else if the contest isn't in the Database for the current user, put/add it*/
                studentsDB.get(userName).putIfAbsent(contest, points);
            }
        }
    }

    private static void printAllStudentsRanking(Map<String, Map<String, Integer>> studentsDB) {
        System.out.println("Ranking:");

        studentsDB.forEach((student, contests) -> {
            System.out.println(student);

            contests.entrySet()
                    .stream()
//                  .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(exam -> {
                        System.out.println(String.format("#  %s -> %d", exam.getKey(), exam.getValue()));
                    });
        });
    }

    private static void printBestUser(Map<String, Map<String, Integer>> studentsDB) {
        studentsDB.entrySet().stream()
                .sorted((user1, user2) -> {
                    int totalPointsUser1 = user1.getValue().values().stream().mapToInt(Integer::valueOf).sum();
                    int totalPointsUser2 = user2.getValue().values().stream().mapToInt(Integer::valueOf).sum();

                    return totalPointsUser2 - totalPointsUser1;
                }).limit(1)
                .forEach(user -> {
                    int userPt = user.getValue().values().stream().mapToInt(Integer::valueOf).sum();
                    System.out.println(
                            String.format("Best candidate is %s with total %d points.",
                                    user.getKey(), userPt));
                });
    }

    private static void fillContestDB(BufferedReader reader, Map<String, String> contestPassDB) throws IOException {
        String lineContests;
        while (!END_CONTESTS.equalsIgnoreCase(lineContests = reader.readLine())) {
            String[] tokens = lineContests.split(":");
            /**input will coming in the format “{contest}:{password for contest}”*/
            String contest = tokens[0];
            String password = tokens[1];

            contestPassDB.putIfAbsent(contest, password);
        }
    }
}

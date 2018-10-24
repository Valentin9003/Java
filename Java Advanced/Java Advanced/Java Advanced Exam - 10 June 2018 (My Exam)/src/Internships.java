import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Internships {

    private static final String VALID_NAME_REGEX = "\\b[A-Z][a-z]+[ ][A-Z][a-z]+\\b";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfProblems = Integer.parseInt(reader.readLine());
        int numberOfCandidates = Integer.parseInt(reader.readLine());

        /**Keep the problems data in to Stack*/
        Deque<String> problems = new ArrayDeque<>();
        fillProblemsStack(reader, numberOfProblems, problems);

        /**Keep the candidates in to Queue*/
        Deque<String> candidates = new ArrayDeque<>();
        fillCandidatesQueue(reader, numberOfCandidates, candidates);

        while (problems.size() != 0) {

            if (candidates.size() == 1) {
                /**If there is only one candidate left, the program ends and
                 you should write on the console: "{candidate} gets the job!"*/
                System.out.println(candidates.poll() + " gets the job!");
                return;
            }
            /**Get the most hard problem - the last one (Last In -> First Out)*/
            String problem = problems.pop();
            /**Start with the first candidate - the first one (First In -> First Out)*/
            String currentCandidate = candidates.poll();

            if (problemIsSolved(problem, currentCandidate)) {
                /**If a Problem is solved,
                 * it is removed from the stack with problems,
                 * and the Candidate who solved it goes to the
                 * end of the queue. You should write on the console:
                 * "{candidate} solved {problem}."*/
                candidates.offer(currentCandidate);
                System.out.println(currentCandidate + " solved " + problem + ".");

            } else {
                /**If a Problem is unsolved, it goes to the bottom
                 * of the stack and the candidate fails the interview,
                 * so he leaves in tears. You should write on the console:
                 * "{candidate} failed {problem}."*/
                problems.addLast(problem);
                System.out.println(currentCandidate + " failed " + problem + ".");
            }
        }

        /**In case there are no more tasks to solve you should print
         on the console the names of the candidates, separate by comma*/
        System.out.println(String.join(", ", candidates));
    }

    private static void fillCandidatesQueue(BufferedReader reader, int numberOfCandidates, Deque<String> candidates) throws IOException {
        /**The Candidates are solving the problems in a queue one by one,
         but only if their name is valid. A valid Candidate name
         consists of First and Last name in proper casing
         (e.g. Ivan Ivanov - is valid name; invalid names - ivan IVanov, Ivan ivanov...)*/
        for (int i = 0; i < numberOfCandidates; i++) {
            String candidate = reader.readLine();
            if (candidate.matches(VALID_NAME_REGEX)) {
                candidates.offer(candidate);
            }
        }
    }

    private static void fillProblemsStack(BufferedReader reader, int numberOfProblems, Deque<String> problems) throws IOException {
        /**Problems, ordered in a stack, one after another, reading them from the console.*/
        for (int i = 0; i < numberOfProblems; i++) {
            String problem = reader.readLine();
            problems.push(problem);
        }
    }

    private static boolean problemIsSolved(String problem, String currentCandidate) {
        /**If the sum of Candidate`s name letters (ASCII value) is greater
         from the sum of the Problem`s letters (ASCII value) => the Problem is solved.
         Otherwise, the Problem is unsolved.*/
        long candidateNameLettersSum = currentCandidate.chars().mapToLong(ch -> ch).sum();
        long problemLettersSum = problem.chars().mapToLong(ch -> ch).sum();

        return candidateNameLettersSum > problemLettersSum;
    }
}

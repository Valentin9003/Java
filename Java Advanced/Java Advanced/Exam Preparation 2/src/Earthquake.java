import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        Deque<int[]> waves = new ArrayDeque<>();
        for (int i = 0; i < lines; i++) {
            String[] input = reader.readLine().split("\\s+");
            int[] wave = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                wave[j] = Integer.parseInt(input[j]);
            }
            waves.offer(wave);
            //Slow!
//            waves.offer(
//                    Arrays.stream(reader.readLine().split("\\s+"))
//                            .mapToInt(Integer::parseInt)
//                            .toArray()
//            );
        }

        StringBuilder sb = new StringBuilder();
        int wavesCount = 0;
        while (!waves.isEmpty()) {
            int[] currentWave = waves.removeFirst();
            int seismicity = currentWave[0];
            boolean matched = false;
            for (int i = 1; i < currentWave.length; i++) {
                if (seismicity < currentWave[i]) {
                    int[] newWave = new int[currentWave.length - i];
                    System.arraycopy(currentWave, i, newWave, 0, currentWave.length - i);
                    currentWave = newWave;
                    matched = true;
                    break;
                }

            }

            sb.append(seismicity).append(" ");
            wavesCount++;
            if (matched && currentWave.length > 0) {
                waves.addLast(currentWave);
            }
        }

        System.out.println(wavesCount);
        System.out.println(sb);
    }
}

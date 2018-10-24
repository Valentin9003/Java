package p09_trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<TrafficMachine> trafficMachines = new ArrayList<>();

        String[] tokens = reader.readLine().split("\\s+");
        for (String light : tokens) {
            trafficMachines.add(new TrafficMachine(light));
        }

        int rotations = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rotations; i++) {
            for (TrafficMachine machine : trafficMachines) {
                machine.changeLight();
                sb.append(machine.toString()).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb.toString());
    }
}

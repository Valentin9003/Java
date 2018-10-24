package p01_shapesDrawing;

import p01_shapesDrawing.models.Circle;
import p01_shapesDrawing.models.Drawable;
import p01_shapesDrawing.models.Rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) {
            queue.add(Integer.parseInt(reader.readLine()));
        }

        Drawable circle = new Circle(queue.poll());
        Drawable rect = new Rectangle(queue.poll(), queue.poll());

        circle.draw();
        rect.draw();
    }
}

package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Class<?> clazz = BlackBoxInt.class;
		try {
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

			String line;
			while (!"END".equalsIgnoreCase(line = reader.readLine())){
				String[] tokens = line.split("_");
				String command = tokens[0];
				int value = Integer.parseInt(tokens[1]);

				Method method = BlackBoxInt.class.getDeclaredMethod(command, int.class);
				if (method != null) {
					method.setAccessible(true);
					method.invoke(blackBoxInt, value);
				}

				Field field = BlackBoxInt.class.getDeclaredField("innerValue");
				field.setAccessible(true);

				System.out.println(field.get(blackBoxInt));
			}

		} catch (NoSuchMethodException |
				IllegalAccessException |
				InstantiationException |
				InvocationTargetException |
				IOException |
				NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}

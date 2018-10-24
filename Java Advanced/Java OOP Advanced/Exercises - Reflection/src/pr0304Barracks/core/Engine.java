package pr0304Barracks.core;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.core.annotations.Inject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Engine implements Runnable {

    private final String COMMAND_PATH = "pr0304Barracks.core.commands.";
    private final String COMMAND_SUFFIX = "Command";

    private Repository repository;
    private UnitFactory unitFactory;
    private String[] data;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();

                String[] data = input.split("\\s+");
                String commandName = data[0];

                String result = interpredCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }

                System.out.println(result);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4 ==> READY!!!
    private String interpredCommand(String[] data, String commandName) {
        this.data = data;

        String commandClassName = Character.toUpperCase(commandName.charAt(0)) +
                commandName.substring(1).toLowerCase() + COMMAND_SUFFIX;

        String result;
        try {
            Class<?> commandClass = Class.forName(COMMAND_PATH + commandClassName);
            Constructor<?> constructor = commandClass.getDeclaredConstructor();
            Executable command = (Executable) constructor.newInstance();

            injectData(command);

            Method method = commandClass.getDeclaredMethod("execute");
            method.setAccessible(true);
            result = (String) method.invoke(command);

        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            throw new RuntimeException("Invalid command!", e.getCause());
        }
        return result;
    }

    private <T> void injectData(T clazz) {
        Field[] thisFields = this.getClass().getDeclaredFields();

        Field[] clazzFields = Arrays.stream(clazz.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Inject.class))
                .toArray(Field[]::new);

        for (Field clazzField : clazzFields) {
            clazzField.setAccessible(true);
            for (Field thisField : thisFields) {
                thisField.setAccessible(true);

                if (clazzField.getName().equals(thisField.getName()) &&
                        clazzField.getType().getName().equals(thisField.getType().getName())) {
                    try {
                        clazzField.set(clazz, thisField.get(this));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

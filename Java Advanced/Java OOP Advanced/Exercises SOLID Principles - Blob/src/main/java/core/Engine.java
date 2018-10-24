package core;

import annotations.Inject;
import interfaces.Executable;
import interfaces.Runnable;
import io.interfaces.Reader;
import io.interfaces.Writer;
import models.Blob;
import observers.Subject;
import repositories.interfaces.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private static final String TERMINATE_COMMAND = "drop";
    private static final String COMMAND_PATH = "core.commands.";
    private static final String COMMAND_SUFFIX_NAME = "Command";

    private Reader reader;
    private Writer writer;
    private Repository<Blob> repository;
    private String[] data;
    private Subject subject;

    public Engine(Reader reader, Writer writer, Repository<Blob> repository, Subject subject) {
        this.reader = reader;
        this.writer = writer;
        this.repository = repository;
        this.subject = subject;
    }

    @Override
    public void run() {
        while (true) {
            String userInput = this.reader.readLine();

            if (TERMINATE_COMMAND.equals(userInput)) {
                break;
            }

            String[] data = userInput.split("\\s+");

            String commandName = data[0];
            this.data = Arrays.stream(data).skip(1).toArray(String[]::new);

            this.commandExecutor(commandName);

            this.subject.notifyAllObservers();
        }
    }

    private String parseCommandName(String commandName) {
        return Arrays.stream(commandName.split("-"))
                .map(word -> String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(""));
    }

    private void commandExecutor(String commandName) {
        try {
            String commandClassName = this.parseCommandName(commandName);

            Class<?> commandClass =
                    Class.forName(COMMAND_PATH + commandClassName + COMMAND_SUFFIX_NAME);

            Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor();
            Executable command = (Executable) declaredConstructor.newInstance();

            this.injectDependencies(command);

            command.execute();

        } catch (ClassNotFoundException |
                NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException e) {
            throw new RuntimeException("Invalid command!");
        }
    }

    private <T> void injectDependencies(T clazz) throws IllegalAccessException {
        Field[] commandFields = clazz.getClass().getDeclaredFields();
        Field[] engineFields = this.getClass().getDeclaredFields();

        for (Field commandField : commandFields) {
            commandField.setAccessible(true);

            if (commandField.isAnnotationPresent(Inject.class)) {

                for (Field engineField : engineFields) {
                    engineField.setAccessible(true);

                    if (commandField.getType().getSimpleName().equals(engineField.getType().getSimpleName())
                            && commandField.getType().equals(engineField.getType())) {
                        commandField.set(clazz, engineField.get(this));
                    }
                }
            }
        }

    }
}

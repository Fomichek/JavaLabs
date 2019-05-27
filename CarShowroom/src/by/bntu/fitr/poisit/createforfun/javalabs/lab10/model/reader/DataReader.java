package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.reader;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.exception.CustomException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public static List<String> readFile(Path path) throws CustomException {
        List<String> rows = new ArrayList<>();

        if (path == null) {
            LOGGER.error("Path is null");
            return rows;
        }

        try (Stream<String> lineStream = Files.lines(path)) {

            rows = lineStream.collect(Collectors.toList());

        } catch (IOException exception) {
            LOGGER.fatal("File not found: ", exception);
            throw new CustomException("Path is incorrect: ", exception);
        }
        return rows;
    }
}

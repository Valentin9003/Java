package app.exam.io;

import app.exam.io.interfaces.FileIO;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileIOImpl implements FileIO {

    @Override
    public String read(String file) throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStream inputStream = this.getClass().getResourceAsStream(file);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                //log here...
            }
        }
        return builder.toString() ;
    }

    @Override
    public void write(String fileContent, String file) throws IOException {
        OutputStream outputStream = new FileOutputStream(file);
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(fileContent);
            writer.flush();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                //log here...
            }
        }
    }
}

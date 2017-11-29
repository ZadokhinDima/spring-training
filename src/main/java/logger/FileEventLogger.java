package logger;

import entities.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String filename;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void init() throws IOException{
        File file = new File(filename);
        if (!file.canWrite()) {

        }
    }

    @Override
    public void logEvent(Event msg) {
        try {
            FileUtils.writeStringToFile(new File(filename), msg.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

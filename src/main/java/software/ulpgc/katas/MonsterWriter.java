package software.ulpgc.katas;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class MonsterWriter {
    public static void writerSummary(Map<String, Long> summary, OutputStream outputStream) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))){
            for(Map.Entry<String, Long> entry : summary.entrySet()){
                bufferedWriter.write(entry.getKey() + ": " + entry.getValue() + " monsters\n");
            }
            bufferedWriter.flush();
        }
    }
}

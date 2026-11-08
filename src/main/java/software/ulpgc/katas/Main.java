package software.ulpgc.katas;

import software.ulpgc.katas.adapters.CsvMonsterLoader;
import software.ulpgc.katas.adapters.GsonMonsterWriter;
import software.ulpgc.katas.domains.Monster;
import software.ulpgc.katas.ports.MonsterLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class Main {
    static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("monsters.csv");
             OutputStream outputStream = System.out){
            MonsterLoader loader = new CsvMonsterLoader();
            List<Monster> monsters = loader.load(inputStream);
            Map<String, Long> summary = MonsterAnalyzer.countMonsterBySourcebook(monsters);
            GsonMonsterWriter.writeToJson(monsters,summary,outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

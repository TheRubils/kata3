package software.ulpgc.katas.adapters;

import software.ulpgc.katas.domains.Monster;
import software.ulpgc.katas.ports.MonsterLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvMonsterLoader implements MonsterLoader {
    @Override
    public List<Monster> load(InputStream inputStream) throws IOException {
        List<Monster> monsters = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            boolean is_header = true;
            while ((line = bufferedReader.readLine()) != null){
                if (is_header){
                    is_header = false;
                    continue;
                }
                try {
                    monsters.add(toMonster(line));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return monsters;
    }

    private Monster toMonster(String line) {
        String[] fields = line.split(",");
        return new Monster(
                fields[0],
                fields[1],
                Double.parseDouble(fields[2]),
                Integer.parseInt(fields[3]),
                Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5])
        );
    }
}

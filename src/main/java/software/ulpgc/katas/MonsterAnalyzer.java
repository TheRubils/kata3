package software.ulpgc.katas;

import software.ulpgc.katas.domains.Monster;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MonsterAnalyzer {
    public static Map<String, Long> countMonsterBySourcebook(List<Monster> monsters){
        return monsters.stream()
                .collect(Collectors.groupingBy(Monster::sourcebook, Collectors.counting()));
    }
}

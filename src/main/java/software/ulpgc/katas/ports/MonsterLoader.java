package software.ulpgc.katas.ports;

import software.ulpgc.katas.domains.Monster;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface MonsterLoader {
    List<Monster> load(InputStream inputStream) throws IOException;
}

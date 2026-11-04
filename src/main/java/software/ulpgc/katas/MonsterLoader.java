package software.ulpgc.katas;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface MonsterLoader {
    List<Monster> load(InputStream inputStream) throws IOException;
}

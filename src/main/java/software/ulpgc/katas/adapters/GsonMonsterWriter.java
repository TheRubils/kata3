package software.ulpgc.katas.adapters;

import com.google.gson.*;
import software.ulpgc.katas.domains.Monster;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class GsonMonsterWriter {
    public static void writeToJson(List<Monster> monsters, Map<String,Long> summary, OutputStream outputStream) throws IOException {
        writeJson(toJsonObject(monsters, summary), outputStream);
    }

    private static void writeJson(JsonObject jsonObject, OutputStream outputStream) throws IOException {
        try (Writer writer = new OutputStreamWriter(outputStream)){
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .disableHtmlEscaping()
                    .create();
            gson.toJson(jsonObject, writer);
            writer.flush();
        }
    }

    private static JsonObject toJsonObject(List<Monster> monsters, Map<String, Long> summary) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("totalRecords", monsters.size());
        jsonObject.add("summaryBySourceBook", summaryToJson(summary));
        jsonObject.add("monsters", toJsonArray(monsters));
        return jsonObject;
    }

    private static JsonArray toJsonArray(List<Monster> monsters) {
        JsonArray array = new JsonArray();
        monsters.stream().map(GsonMonsterWriter::toJsonElement).forEach(array::add);
        return array;
    }

    private static JsonObject toJsonElement(Monster monster) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", monster.name());
        jsonObject.addProperty("sourcebook", monster.sourcebook());
        jsonObject.addProperty("cr", monster.cr());
        jsonObject.addProperty("xp", monster.xp());
        jsonObject.addProperty("hp", monster.hp());
        jsonObject.addProperty("ac", monster.ac());
        return jsonObject;
    }

    private static JsonObject summaryToJson(Map<String, Long> summary) {
        JsonObject summaryObject = new JsonObject();
        summary.forEach(summaryObject::addProperty);
        return summaryObject;
    }
}

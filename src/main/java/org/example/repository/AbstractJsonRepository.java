package org.example.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractJsonRepository<T> {

    protected List<T> data = new ArrayList<>();
    protected String filename;
    protected ObjectMapper mapper;

    public AbstractJsonRepository(String filename) {
        this.filename = filename;
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        load();
    }

    protected void load() {
        try {
            String content = Files.readString(Path.of(filename));
            JsonNode root = mapper.readTree(content);

            ArrayNode array = extractArray(root);
            if (array == null) {
                throw new RuntimeException("No JSON array found in file");
            }

            for (JsonNode node : array) {
                data.add(fromJson(node));
            }

        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON file", e);
        }
    }

    private ArrayNode extractArray(JsonNode node) {

        // dacă nodul este array, l-am găsit
        if (node.isArray()) {
            return (ArrayNode) node;
        }

        // dacă este obiect, căutăm în copiii lui
        if (node.isObject()) {
            Iterator<JsonNode> it = node.elements();
            while (it.hasNext()) {
                JsonNode child = it.next();
                ArrayNode result = extractArray(child);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    protected abstract T fromJson(JsonNode json);

    public List<T> findAll() {
        return List.copyOf(data);
    }
}

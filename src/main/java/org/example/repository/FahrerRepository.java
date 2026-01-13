package org.example.repository;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.model.Fahrer;
import org.example.model.FahrerStatus;

public class FahrerRepository
        extends AbstractJsonRepository<Fahrer> {

    public FahrerRepository(String filename) {
        super(filename);
    }

    @Override
    protected Fahrer fromJson(JsonNode json) {
        return new Fahrer(
                json.get("id").asInt(),
                json.get("name").asText(),
                json.get("team").asText(),
                FahrerStatus.valueOf(json.get("status").asText()),
                json.get("skillLevel").asInt()
        );
    }
}
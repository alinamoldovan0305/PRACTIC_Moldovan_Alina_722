package org.example.repository;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.model.EreignisTyp;
import org.example.model.Fahrer;
import org.example.model.FahrerStatus;
import org.example.model.RennenEreignis;

public class RennenEreignisRepository
        extends AbstractJsonRepository<RennenEreignis> {

    public RennenEreignisRepository(String filename) {
        super(filename);
    }

    @Override
    protected RennenEreignis fromJson(JsonNode json) {
        return new RennenEreignis(
                json.get("id").asInt(),
                json.get("fahrer_id").asInt(),
                EreignisTyp.valueOf(json.get("typ").asText()),
                json.get("basepoint").asInt(),
                json.get("lap").asInt()
        );
    }
}
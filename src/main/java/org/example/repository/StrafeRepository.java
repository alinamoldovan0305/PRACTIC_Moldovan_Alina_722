package org.example.repository;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.model.Fahrer;
import org.example.model.FahrerStatus;
import org.example.model.Strafe;
import org.example.model.StrafeGrund;

public class StrafeRepository
        extends AbstractJsonRepository<Strafe> {

    public StrafeRepository(String filename) {
        super(filename);
    }

    @Override
    protected Strafe fromJson(JsonNode json) {
        return new Strafe(
                json.get("id").asInt(),
                json.get("fahrer_id").asInt(),
                StrafeGrund.valueOf(json.get("strafe").asText()),
                json.get("seconds").asInt(),
                json.get("lap").asInt()
        );
    }
}
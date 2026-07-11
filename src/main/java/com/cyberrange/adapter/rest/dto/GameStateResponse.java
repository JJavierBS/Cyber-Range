package com.cyberrange.adapter.rest.dto;

import java.util.Map;

public record GameStateResponse(
        String gameId,
        String phase,
        Map<String, Integer> ciaLevels,
        int currentRoundNumber) {
}

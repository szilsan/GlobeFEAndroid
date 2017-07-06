package com.example.szilsan.globerest.dto;

import java.util.Set;

/**
 * Created by szilsan on 06/07/2017.
 */

public class PositionsDTO {
    private Set<GlobeDTO> positions;

    public Set<GlobeDTO> getPositions() {
        return positions;
    }

    public void setPositions(Set<GlobeDTO> positions) {
        this.positions = positions;
    }
}

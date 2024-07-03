package com.genshin.artifactsimulator;

import java.util.List;

public class Goblet extends ArtifactType {

    @Override
    public String getArtifactType() {
        return "Goblet of Eonothem";
    }

    @Override
    public List<String> getPossibleMainStats() {
        return List.of("ATK%", "DEF%", "HP%", "EM");
    }
    
    @Override
    public int getResourceID() {
        return R.drawable.goblet_fohm;
    }
}
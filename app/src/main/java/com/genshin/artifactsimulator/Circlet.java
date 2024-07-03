package com.genshin.artifactsimulator;
import java.util.List;

public class Circlet extends ArtifactType {
    @Override
    public List<String> getPossibleMainStats() {
        return List.of("ATK%", "DEF%", "HP%", "CR%", "CD%", "EM", "HB%");
    }
    
    @Override
    public String getArtifactType() {
        return "Circlet of Logos";
    }
    
    @Override
    public int getResourceID() {
        return R.drawable.circlet_fohm;
    }
}
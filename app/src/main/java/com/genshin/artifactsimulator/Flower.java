package com.genshin.artifactsimulator;
import java.util.List;

public class Flower extends ArtifactType {
    @Override
    public List<String> getPossibleMainStats() {
        return List.of("HP");
    }
    
    @Override
    public String getArtifactType() {
        return "Flower of Life";
    }
    
    @Override
    public int getResourceID() {
        return R.drawable.flower_fohm;
    }
}
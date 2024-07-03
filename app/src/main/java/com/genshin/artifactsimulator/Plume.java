package com.genshin.artifactsimulator;
import java.util.List;

public class Plume extends ArtifactType {
    @Override
    public List<String> getPossibleMainStats() {
        return List.of("ATK");
    }
    
    @Override
    public String getArtifactType() {
        return "Plume of Death";
    }
    
    @Override
    public int getResourceID() {
        return R.drawable.plume_fohm;
    }
}
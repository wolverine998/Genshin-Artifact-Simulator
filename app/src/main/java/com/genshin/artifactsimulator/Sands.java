package com.genshin.artifactsimulator;
import androidx.annotation.NonNull;
import java.util.List;

public class Sands extends ArtifactType {
    @Override
    public List<String> getPossibleMainStats() {
        return List.of("ATK%", "DEF%", "HP%", "ER%", "EM");
    }
    
    @Override
    public String getArtifactType() {
        return "Sands of Eon";
    }
    
    @Override
    public int getResourceID() {
        return R.drawable.sands_fohm;
    }
}
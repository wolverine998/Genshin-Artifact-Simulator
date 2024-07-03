package com.genshin.artifactsimulator;

public class Artifact {
    private ArtifactType artifactType;
    private String setName;
    private int rarity;
    private String mainStatType;
    private MainStat<?> mainStatValue;
    
    public Artifact(ArtifactType artifactType, int rarity, String setName, String mainStatType, MainStat<?> mainStatValue) {
        this.artifactType = artifactType;
        this.rarity = rarity;
        this.setName = setName;
        this.mainStatType = mainStatType;
        this.mainStatValue = mainStatValue;
    }
    
    public ArtifactType getArtifactType() {
        return artifactType;
    }
    
    public void setArtifactType(ArtifactType artifactType) {
        this.artifactType = artifactType;
    }
    
    public int getRarity() {
        return rarity;
    }
    
    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
    
    public String getSetName() {
        return setName;
    }
    
    public void setSetName(String setName) {
        this.setName = setName;
    }
    
    public String getMainStatType() {
        return mainStatType;
    }
    
    public void setMainStatType(String mainStatType) {
        this.mainStatType = mainStatType;
    }
    
    public MainStat<?> getMainStatValue() {
        return mainStatValue;
    }
    
    public void setMainStatValue(MainStat<?> mainStatValue) {
        this.mainStatValue = mainStatValue;
    }
    
    public String getArtifactTypeString() {
        return artifactType.getArtifactType();
    }
    
    public int getResourceID() {
        return artifactType.getResourceID();
    }
}
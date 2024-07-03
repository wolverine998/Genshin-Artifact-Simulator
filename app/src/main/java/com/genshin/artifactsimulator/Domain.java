package com.genshin.artifactsimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Domain {
    private String name;
    private List<String> artifactSets;
    private Random random;
    
    public Domain(String name, String setName1, String setName2) {
        this.name = name;
        this.random = new Random();
        artifactSets = List.of(setName1, setName2);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Artifact> simulateArtifactDrops(int numDrops) {
        List<Artifact> drops = new ArrayList<>();
        
        for(int i = 0; i < numDrops; ++i) {
            String randomSet = artifactSets.get(random.nextInt(artifactSets.size()));
            Artifact artifact = ArtifactGenerator.generateRandomArtifact(randomSet, random);
            drops.add(artifact);
        }
        
        return drops;
    }
}
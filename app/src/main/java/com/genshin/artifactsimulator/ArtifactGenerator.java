package com.genshin.artifactsimulator;
import java.util.List;
import java.util.Random;

public class ArtifactGenerator {
    public static Artifact generateRandomArtifact(String setName, Random random) {
        ArtifactType artifactType;
        switch(random.nextInt(5)) {
            case 0:
                artifactType = new Flower();
                break;
            case 1:
                artifactType = new Plume();
                break;
            case 2:
                artifactType = new Sands();
                break;
            case 3:
                artifactType = new Goblet();
                break;
            case 4:
                artifactType = new Circlet();
                break;
            default:
                throw new IllegalStateException("Unexpected behavior occured");
        }
        List<String> possibleMainStats = artifactType.getPossibleMainStats();
        String mainStat = possibleMainStats.get(random.nextInt(possibleMainStats.size()));
        return new Artifact(artifactType, 5, setName, mainStat, artifactType.getRandomMainStat(mainStat, random));
    }
}
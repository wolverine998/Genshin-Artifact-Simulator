package com.genshin.artifactsimulator;

import java.util.List;
import java.util.Random;

public abstract class ArtifactType {
    public abstract List<String> getPossibleMainStats();
    public abstract String getArtifactType();
    public abstract int getResourceID();

    public MainStat<?> getRandomMainStat(String mainStatType, Random random) {
        switch (mainStatType) {
            case "HP":
            case "ATK":
            case "DEF":
            case "EM":
                return new MainStat<>(10 + random.nextInt(100));
            case "ATK%":
            case "DEF%":
            case "HP%":
            case "ER%":
            case "CR%":
            case "CD%":
            case "HB%":
                return new MainStat<>(10.0f + random.nextFloat() * 90.0f);
            default:
                throw new IllegalArgumentException("Unsupported main stat type: " + mainStatType);
        }
    }
}
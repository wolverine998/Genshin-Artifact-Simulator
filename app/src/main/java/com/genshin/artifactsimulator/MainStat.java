package com.genshin.artifactsimulator;

public class MainStat<T extends Number> {
    private T value;
    
    public MainStat(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
}
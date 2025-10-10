package com.training.marathon.plan.util;

public class WorkoutStep {

    private int index;
    private String name;
    private StepDuration duration;
    private StepTarget target;
    private double durationValue;
    private int targetLow;
    private int targetHigh;

    public WorkoutStep(int index, String name, StepDuration duration, double durationValue,
            StepTarget target, int targetLow, int targetHigh) {
        this.index = index;
        this.name = name;
        this.duration = duration;
        this.durationValue = durationValue;
        this.target = target;
        this.targetLow = targetLow;
        this.targetHigh = targetHigh;
    }

    // Getters
    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public StepDuration getDuration() {
        return duration;
    }

    public double getDurationValue() {
        return durationValue;
    }

    public StepTarget getTarget() {
        return target;
    }

    public int getTargetLow() {
        return targetLow;
    }

    public int getTargetHigh() {
        return targetHigh;
    }
}

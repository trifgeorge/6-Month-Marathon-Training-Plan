package com.model;

/**
 * Represents a single workout in the training plan
 */
public class Workout {
    private int week;
    private int workoutNumber;
    private String name;
    private WorkoutType type;
    private double distanceKm;
    private double tempoDistanceKm;
    private int intervals;

    // Constructor for easy/long runs
    public Workout(int week, int workoutNumber, String name, WorkoutType type, double distanceKm) {
        this.week = week;
        this.workoutNumber = workoutNumber;
        this.name = name;
        this.type = type;
        this.distanceKm = distanceKm;
    }

    // Constructor for tempo runs
    public Workout(int week, int workoutNumber, String name, double totalKm, double tempoKm) {
        this.week = week;
        this.workoutNumber = workoutNumber;
        this.name = name;
        this.type = WorkoutType.TEMPO_RUN;
        this.distanceKm = totalKm;
        this.tempoDistanceKm = tempoKm;
    }

    // Constructor for interval runs
    public Workout(int week, int workoutNumber, String name, int intervals) {
        this.week = week;
        this.workoutNumber = workoutNumber;
        this.name = name;
        this.type = WorkoutType.INTERVAL_RUN;
        this.intervals = intervals;
    }

    public int getWeek() {
        return week;
    }

    public int getWorkoutNumber() {
        return workoutNumber;
    }

    public String getName() {
        return name;
    }

    public WorkoutType getType() {
        return type;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public double getTempoDistanceKm() {
        return tempoDistanceKm;
    }

    public int getIntervals() {
        return intervals;
    }

    public String getFilename() {
        return String.format("Week%02d_Workout%d_%s.fit",
                week, workoutNumber, name.replaceAll(" ", "_"));
    }

}

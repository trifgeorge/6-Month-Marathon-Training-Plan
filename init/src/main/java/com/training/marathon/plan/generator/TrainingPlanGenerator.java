package com.training.marathon.plan.generator;

import java.util.List;

import com.model.Workout;
import com.model.WorkoutStep;
import com.training.marathon.plan.util.Constants;
import com.training.marathon.plan.util.WorkoutType;

public class TrainingPlanGenerator {

    private FITFileWriter fitWriter;
    private WorkoutBuilder workoutBuilder;

    public TrainingPlanGenerator(String outputDirectory) {
        this.fitWriter = new FITFileWriter(outputDirectory);
        this.workoutBuilder = new WorkoutBuilder();
    }
    
    public void generateCompleteMarathonPlan() {
        generatePhase1BaseBuilding();
        generatePhase2StrengthBuilding();
        generatePhase3PeakTraining();
        generatePhase4Taper();
        marathonRaceDay();
    }
    
    // ========== PHASE 1: BASE BUILDING ==========
    private void generatePhase1BaseBuilding() {
        
        System.out.println("Phase 1: Base Building (Weeks 1-8)");
        
        // Week 1: 20km total
        createWorkout(new Workout(1, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 5.0));
        createWorkout(new Workout(1, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 6.0));
        createWorkout(new Workout(1, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 9.0));
        
        // Week 2: 22km total
        createWorkout(new Workout(2, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 5.0));
        createWorkout(new Workout(2, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 7.0));
        createWorkout(new Workout(2, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 10.0));
        
        // Week 3: 25km total
        createWorkout(new Workout(3, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 6.0));
        createWorkout(new Workout(3, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(3, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 11.0));
        
        // Week 4: 20km total (Recovery)
        createWorkout(new Workout(4, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 5.0));
        createWorkout(new Workout(4, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 6.0));
        createWorkout(new Workout(4, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 9.0));
        
        // Week 5: 28km total
        createWorkout(new Workout(5, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 6.0));
        createWorkout(new Workout(5, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 9.0));
        createWorkout(new Workout(5, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 13.0));
        
        // Week 6: 32km total
        createWorkout(new Workout(6, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 7.0));
        createWorkout(new Workout(6, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 10.0));
        createWorkout(new Workout(6, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 15.0));
        
        // Week 7: 35km total
        createWorkout(new Workout(7, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 7.0));
        createWorkout(new Workout(7, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 11.0));
        createWorkout(new Workout(7, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 17.0));
        
        // Week 8: 28km total (Recovery)
        createWorkout(new Workout(8, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 6.0));
        createWorkout(new Workout(8, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(8, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 14.0));
    }
    
    // ========== PHASE 2: STRENGTH BUILDING ==========
    private void generatePhase2StrengthBuilding() {
        System.out.println("\nPhase 2: Strength Building (Weeks 9-16)");
        
        // Week 9: 38km
        createWorkout(new Workout(9, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 7.0));
        createWorkout(new Workout(9, 2, Constants.TEMPO_RUN, 10.0, 6.0));
        createWorkout(new Workout(9, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 18.0));
        createWorkout(new Workout(9, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 3.0));
        
        // Week 10: 42km
        createWorkout(new Workout(10, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(10, 2, Constants.TEMPO_RUN, 11.0, 7.0));
        createWorkout(new Workout(10, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 20.0));
        createWorkout(new Workout(10, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 3.0));
        
        // Week 11: 45km
        createWorkout(new Workout(11, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(11, 2, Constants.FIVE_BY_1KM_INTERVALS, 5));
        createWorkout(new Workout(11, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 22.0));
        createWorkout(new Workout(11, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 3.0));
        
        // Week 12: 35km (Recovery)
        createWorkout(new Workout(12, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 7.0));
        createWorkout(new Workout(12, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 10.0));
        createWorkout(new Workout(12, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 16.0));
        createWorkout(new Workout(12, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 2.0));
        
        // Week 13: 48km
        createWorkout(new Workout(13, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(13, 2, Constants.TEMPO_RUN, 12.0, 8.0));
        createWorkout(new Workout(13, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 24.0));
        createWorkout(new Workout(13, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 4.0));
        
        // Week 14: 52km
        createWorkout(new Workout(14, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(14, 2, Constants.SIX_BY_1KM_INTERVALS, 6));
        createWorkout(new Workout(14, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 26.0));
        createWorkout(new Workout(14, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 5.0));
        
        // Week 15: 55km
        createWorkout(new Workout(15, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 9.0));
        createWorkout(new Workout(15, 2, Constants.TEMPO_RUN, 13.0, 9.0));
        createWorkout(new Workout(15, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 28.0));
        createWorkout(new Workout(15, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 5.0));
        
        // Week 16: 42km (Recovery)
        createWorkout(new Workout(16, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(16, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 10.0));
        createWorkout(new Workout(16, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 20.0));
        createWorkout(new Workout(16, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 4.0));
    }
    
    // ========== PHASE 3: PEAK TRAINING ==========
    private void generatePhase3PeakTraining() {
        System.out.println("\nPhase 3: Peak Training (Weeks 17-22)");
        
        // Week 17: 58km
        createWorkout(new Workout(17, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 9.0));
        createWorkout(new Workout(17, 2, Constants.TEMPO_RUN, 14.0, 10.0));
        createWorkout(new Workout(17, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 30.0));
        createWorkout(new Workout(17, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 5.0));
        
        // Week 18: 62km (PEAK)
        createWorkout(new Workout(18, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 10.0));
        createWorkout(new Workout(18, 2, Constants.EIGHT_BY_1KM_INTERVALS, 8));
        createWorkout(new Workout(18, 3, Constants.PEAK_LONG_RUN, WorkoutType.LONG_RUN, 32.0));
        createWorkout(new Workout(18, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 6.0));
        
        // Week 19: 60km
        createWorkout(new Workout(19, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 10.0));
        createWorkout(new Workout(19, 2, Constants.TEMPO_RUN, 14.0, 10.0));
        createWorkout(new Workout(19, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 30.0));
        createWorkout(new Workout(19, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 6.0));
        
        // Week 20: 48km (Recovery)
        createWorkout(new Workout(20, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(20, 2, Constants.EASY_MIDWEEK_RUN, WorkoutType.EASY_RUN, 12.0));
        createWorkout(new Workout(20, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 24.0));
        createWorkout(new Workout(20, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 4.0));
        
        // Week 21: 55km
        createWorkout(new Workout(21, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 9.0));
        createWorkout(new Workout(21, 2, Constants.TEMPO_RUN, 13.0, 9.0));
        createWorkout(new Workout(21, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 28.0));
        createWorkout(new Workout(21, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 5.0));
        
        // Week 22: 50km
        createWorkout(new Workout(22, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(22, 2, Constants.TEMPO_RUN, 12.0, 8.0));
        createWorkout(new Workout(22, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 25.0));
        createWorkout(new Workout(22, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 5.0));
    }
    
    // ========== PHASE 4: TAPER ==========
    private void generatePhase4Taper() {
        System.out.println("\nPhase 4: Taper (Weeks 23-26)");
        
        // Week 23: 42km
        createWorkout(new Workout(23, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(23, 2, Constants.SHORT_TEMPO, 10.0, 6.0));
        createWorkout(new Workout(23, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 20.0));
        createWorkout(new Workout(23, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 4.0));
        
        // Week 24: 35km
        createWorkout(new Workout(24, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 7.0));
        createWorkout(new Workout(24, 2, Constants.SHORT_TEMPO, 8.0, 5.0));
        createWorkout(new Workout(24, 3, Constants.LONG_RUN, WorkoutType.LONG_RUN, 16.0));
        createWorkout(new Workout(24, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 4.0));
        
        // Week 25: 28km
        createWorkout(new Workout(25, 1, Constants.EASY_RECOVERY_RUN, WorkoutType.EASY_RUN, 6.0));
        createWorkout(new Workout(25, 2, Constants.EASY_RUN_WITH_STRIDES, WorkoutType.EASY_RUN, 8.0));
        createWorkout(new Workout(25, 3, Constants.EASY_LONG_RUN, WorkoutType.LONG_RUN, 12.0));
        createWorkout(new Workout(25, 4, Constants.SHAKEOUT_RUN, WorkoutType.EASY_RUN, 2.0));
        
        // Week 26: Race Week
        createWorkout(new Workout(26, 1, Constants.EASY_SHAKEOUT, WorkoutType.EASY_RUN, 5.0));
        createWorkout(new Workout(26, 2, Constants.EASY_SHAKEOUT, WorkoutType.EASY_RUN, 3.0));
        createWorkout(new Workout(26, 3, Constants.PRE_RACE_SHAKEOUT, WorkoutType.EASY_RUN, 3.0));
        
    }

    private void marathonRaceDay() {
        // Marathon Race Day
        Workout marathon = new Workout(26, 4, "MARATHON RACE DAY", WorkoutType.RACE, 42.195);
        List<WorkoutStep> raceSteps = workoutBuilder.buildMarathonRace();
        fitWriter.writeWorkout(marathon, raceSteps);
    }
    
    // ========== HELPER METHOD ==========
    private void createWorkout(Workout workout) {
        List<WorkoutStep> steps;
        
        switch (workout.getType()) {
            case EASY_RUN:
                steps = workoutBuilder.buildEasyRun(workout.getDistanceKm());
                break;
                
            case LONG_RUN:
                steps = workoutBuilder.buildLongRun(workout.getDistanceKm());
                break;
                
            case TEMPO_RUN:
                steps = workoutBuilder.buildTempoRun(workout.getDistanceKm(), workout.getTempoDistanceKm());
                break;
                
            case INTERVAL_RUN:
                steps = workoutBuilder.buildIntervals(workout.getIntervals());
                break;
                
            default:
                throw new IllegalArgumentException("Unknown workout type: " + workout.getType());
        }
        
        fitWriter.writeWorkout(workout, steps);
    }
}

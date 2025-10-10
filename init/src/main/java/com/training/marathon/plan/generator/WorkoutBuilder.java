package com.training.marathon.plan.generator;

import java.util.ArrayList;
import java.util.List;

import com.training.marathon.plan.util.Constants;
import com.training.marathon.plan.util.StepDuration;
import com.training.marathon.plan.util.StepTarget;
import com.training.marathon.plan.util.WorkoutStep;

public class WorkoutBuilder {

    /**
     * Build steps for an easy run
     */
    public List<WorkoutStep> buildEasyRun(double distanceKm) {
        List<WorkoutStep> steps = new ArrayList<>();

        steps.add(new WorkoutStep(0, Constants.WARM_UP, StepDuration.DISTANCE, 1000.0, StepTarget.OPEN, 0, 0));
        steps.add(new WorkoutStep(1, Constants.EASY_RUN, StepDuration.DISTANCE, distanceKm * 1000.0, StepTarget.HEART_RATE, 120,
                150));
        steps.add(new WorkoutStep(2, Constants.COOL_DOWN, StepDuration.DISTANCE, 1000.0, StepTarget.OPEN, 0, 0));

        return steps;
    }

    /**
     * Build steps for a long run
     */
    public List<WorkoutStep> buildLongRun(double distanceKm) {
        List<WorkoutStep> steps = new ArrayList<>();

        steps.add(new WorkoutStep(0, Constants.WARM_UP, StepDuration.DISTANCE, 2000.0, StepTarget.OPEN, 0, 0));
        steps.add(new WorkoutStep(1, Constants.LONG_RUN, StepDuration.DISTANCE, distanceKm * 1000.0, StepTarget.HEART_RATE, 115,
                145));
        steps.add(new WorkoutStep(2, Constants.COOL_DOWN, StepDuration.DISTANCE, 1000.0, StepTarget.OPEN, 0, 0));

        return steps;
    }

    /**
     * Build steps for a tempo run
     */
    public List<WorkoutStep> buildTempoRun(double totalKm, double tempoKm) {
        List<WorkoutStep> steps = new ArrayList<>();

        double warmupKm = (totalKm - tempoKm) / 2.0;
        double cooldownKm = warmupKm;

        steps.add(new WorkoutStep(0, Constants.WARM_UP, StepDuration.DISTANCE, warmupKm * 1000.0, StepTarget.OPEN, 0, 0));
        steps.add(new WorkoutStep(1, Constants.TEMPO_PACE, StepDuration.DISTANCE, tempoKm * 1000.0, StepTarget.HEART_RATE, 155,
                170));
        steps.add(new WorkoutStep(2, Constants.RECOVERY, StepDuration.DISTANCE, 1000.0, StepTarget.OPEN, 0, 0));
        steps.add(new WorkoutStep(3, Constants.COOL_DOWN, StepDuration.DISTANCE, cooldownKm * 1000.0, StepTarget.OPEN, 0, 0));

        return steps;
    }

    /**
     * Build steps for interval training
     */
    public List<WorkoutStep> buildIntervals(int numIntervals) {
        List<WorkoutStep> steps = new ArrayList<>();
        int stepIndex = 0;

        // Warm-up
        steps.add(new WorkoutStep(stepIndex++, Constants.WARM_UP, StepDuration.DISTANCE, 2000.0, StepTarget.OPEN, 0, 0));

        // Intervals
        for (int i = 0; i < numIntervals; i++) {
            steps.add(new WorkoutStep(stepIndex++, String.format("Interval %d", i + 1), StepDuration.DISTANCE, 1000.0, StepTarget.HEART_RATE, 165, 180));
            steps.add(new WorkoutStep(stepIndex++, Constants.RECOVERY, StepDuration.DISTANCE, 400.0, StepTarget.OPEN, 0, 0));
        }

        // Cool-down
        steps.add(new WorkoutStep(stepIndex++, Constants.COOL_DOWN, StepDuration.DISTANCE, 2000.0, StepTarget.OPEN, 0, 0));

        return steps;
    }

    /**
     * Build steps for marathon race
     */
    public List<WorkoutStep> buildMarathonRace() {
        List<WorkoutStep> steps = new ArrayList<>();
        steps.add(new WorkoutStep(0, Constants.MARATHON, StepDuration.DISTANCE, 42195.0, StepTarget.HEART_RATE, 150, 170));
        return steps;
    }
}

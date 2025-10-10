package com.training.marathon.plan.generator;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.garmin.fit.DateTime;
import com.garmin.fit.FileEncoder;
import com.garmin.fit.FileIdMesg;
import com.garmin.fit.Fit;
import com.garmin.fit.Intensity;
import com.garmin.fit.Manufacturer;
import com.garmin.fit.Sport;
import com.garmin.fit.WktStepDuration;
import com.garmin.fit.WktStepTarget;
import com.garmin.fit.WorkoutMesg;
import com.garmin.fit.WorkoutStepMesg;
import com.model.Workout;
import com.model.WorkoutStep;
import com.training.marathon.plan.util.StepDuration;
import com.training.marathon.plan.util.StepTarget;
import com.training.marathon.plan.util.WorkoutType;

public class FITFileWriter {

    private String outputDirectory;

    public FITFileWriter(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    /**
     * Write a workout to a FIT file
     */
    public void writeWorkout(Workout workout, List<WorkoutStep> steps) {
        String filepath = outputDirectory + workout.getFilename();

        try {
            FileEncoder encoder = new FileEncoder(new File(filepath), Fit.ProtocolVersion.V2_0);

            // Write file ID
            writeFileId(encoder);

            // Write workout header
            writeWorkoutHeader(encoder, workout, steps.size());

            // Write all steps
            for (WorkoutStep step : steps) {
                writeWorkoutStep(encoder, step);
            }

            encoder.close();
            System.out.println("  ✓ Created: " + workout.getFilename());

        } catch (Exception e) {
            System.err.println("  ✗ Error creating " + workout.getFilename() + ": " + e.getMessage());
        }
    }

    private void writeFileId(FileEncoder encoder) {
        FileIdMesg fileIdMesg = new FileIdMesg();
        fileIdMesg.setType(com.garmin.fit.File.WORKOUT);
        fileIdMesg.setManufacturer(Manufacturer.DEVELOPMENT);
        fileIdMesg.setProduct(1);
        fileIdMesg.setTimeCreated(new DateTime(new Date()));
        fileIdMesg.setSerialNumber(12345L);
        encoder.write(fileIdMesg);
    }

    private void writeWorkoutHeader(FileEncoder encoder, Workout workout, int numSteps) {
        WorkoutMesg workoutMesg = new WorkoutMesg();

        String workoutName = String.format("W%d: %s", workout.getWeek(), workout.getName());
        if (workout.getType() == WorkoutType.LONG_RUN) {
            workoutName += String.format(" (%.0fkm)", workout.getDistanceKm());
        }

        workoutMesg.setWktName(workoutName);
        workoutMesg.setSport(Sport.RUNNING);
        workoutMesg.setNumValidSteps(numSteps);
        encoder.write(workoutMesg);
    }

    private void writeWorkoutStep(FileEncoder encoder, WorkoutStep step) {
        WorkoutStepMesg stepMesg = new WorkoutStepMesg();
        stepMesg.setMessageIndex(step.getIndex());
        stepMesg.setWktStepName(step.getName());

        // Set duration
        if (step.getDuration() == StepDuration.DISTANCE) {
            stepMesg.setDurationType(WktStepDuration.DISTANCE);
            stepMesg.setDurationValue((long) step.getDurationValue());
        } else if (step.getDuration() == StepDuration.TIME) {
            stepMesg.setDurationType(WktStepDuration.TIME);
            stepMesg.setDurationValue((long) (step.getDurationValue() * 1000));
        } else {
            stepMesg.setDurationType(WktStepDuration.OPEN);
            stepMesg.setDurationValue(0L);
        }

        // Set target
        if (step.getTarget() == StepTarget.HEART_RATE) {
            stepMesg.setTargetType(WktStepTarget.HEART_RATE);
            stepMesg.setTargetValue(0L);
            stepMesg.setCustomTargetValueLow((long) step.getTargetLow());
            stepMesg.setCustomTargetValueHigh((long) step.getTargetHigh());
        } else {
            stepMesg.setTargetType(WktStepTarget.OPEN);
            stepMesg.setTargetValue(0L);
        }

        stepMesg.setIntensity(Intensity.ACTIVE);
        encoder.write(stepMesg);
    }

}

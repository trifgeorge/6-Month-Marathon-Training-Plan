package com.training.marathon.plan;

import java.io.File;

import com.training.marathon.plan.generator.TrainingPlanGenerator;

public class Main {

    private static final String OUTPUT_DIR = "./workouts/";
    public static void main(String[] args) {
        // Create output directory if it doesn't exist
        File dir = new File(OUTPUT_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        System.out.println("=== Marathon Training Plan Generator ===");
        System.out.println("Generating 26 weeks of training workouts...\n");
        
        TrainingPlanGenerator planGenerator = new TrainingPlanGenerator(OUTPUT_DIR);
        
        planGenerator.generateCompleteMarathonPlan();
        
        System.out.println("\n=== Generation Complete! ===");
        System.out.println("All workout FIT files have been created in: " + OUTPUT_DIR);
    }
}
package pl.pwr.ite.bedrylo.logic;

import pl.pwr.ite.bedrylo.data.*;
import pl.pwr.ite.bedrylo.misc.ConfigClass;

public abstract class Evolution {
    
    public static MatchList evolve(AvailableStock availableStock, Integer generations, Integer matchListCount, Integer comparisonAmount) {
        Generation bestGeneration = null;
        Integer carryoverStep = Math.max(1,Math.floorDiv(PreferenceList.getPreferenceAmount(), generations));
        Integer carryoverAmount = 0;
        Integer repetitions = 0;
        Integer maxCarryoveramount = PreferenceList.getPreferenceAmount() - 1;
        for (int i = 0; i < generations; i++) {
            ConfigClass.setActualGeneration(i);
            Generation newGeneration = GenerationGenerator.generateGeneration(availableStock, matchListCount, carryoverAmount, comparisonAmount, bestGeneration);
            if (bestGeneration == null || newGeneration.getMaxPoints() > bestGeneration.getMaxPoints()) {
                bestGeneration = newGeneration;
                carryoverAmount += carryoverStep;
                repetitions = 0;
            } else {
                repetitions++;
                if (repetitions > 10) {
                    carryoverAmount = Math.max(0,carryoverAmount - carryoverStep);
                    repetitions = 0;
                } else {
                    carryoverAmount++;
                }
            }
            System.out.println(bestGeneration);
            if ((Math.abs(bestGeneration.getMinPoints()/bestGeneration.getMaxPoints()) < 0.001)||(carryoverAmount > maxCarryoveramount)) {
                return bestGeneration.getBestMatchList();
            }
        }
        return bestGeneration.getBestMatchList();
    }
    
}

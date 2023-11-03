package pl.pwr.ite.bedrylo.logic;

import pl.pwr.ite.bedrylo.data.AvailableStock;
import pl.pwr.ite.bedrylo.data.Generation;
import pl.pwr.ite.bedrylo.data.MatchList;
import pl.pwr.ite.bedrylo.data.PreferenceList;

public abstract class Evolution {
    
    public static MatchList evolve(AvailableStock availableStock, Integer generations, Integer matchListCount, Integer comparisonAmount) {
        Generation bestGeneration = null;
        int carryoverStep = Math.max(1,Math.floorDiv(PreferenceList.getPreferenceAmount(), generations));
        int carryoverAmount = 0;
        int repetitions = 0;
        int maxCarryoveramount = PreferenceList.getPreferenceAmount() - 1;
        for (int i = 0; i < generations; i++) {
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
        assert bestGeneration != null;
        return bestGeneration.getBestMatchList();
    }
    
}

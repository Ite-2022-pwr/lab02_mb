package pl.pwr.ite.bedrylo.logic;

import pl.pwr.ite.bedrylo.data.AvailableStock;
import pl.pwr.ite.bedrylo.data.Generation;

public abstract class GenerationGenerator  {
    public static Generation generateGeneration(AvailableStock availableStock, Integer matchListCount, Integer carryoverAmount, Integer comparisonAmount, Generation bestGeneration){
        Generation generation = new Generation();
        if (bestGeneration == null) {
            for (int i = 0; i < matchListCount; i++) {
                AvailableStock tempAvailableStock = new AvailableStock(availableStock);
                generation.addMatchList(MatchListGenerator.generateMatchList(tempAvailableStock, null, comparisonAmount));
            }
            generation.sortDescendingPoints();
            return generation;
        }
        for (int i = 0; i < matchListCount; i++) {
            AvailableStock tempAvailableStock = new AvailableStock(availableStock);
            generation.addMatchList(MatchListGenerator.generateMatchList(tempAvailableStock, bestGeneration.getBestMatchList().getTopNMatches(carryoverAmount), comparisonAmount));
        }
        generation.sortDescendingPoints();
        return generation;
    }
}

package pl.pwr.ite.bedrylo.logic;

import pl.pwr.ite.bedrylo.data.AvailableStock;
import pl.pwr.ite.bedrylo.data.Generation;

public abstract class GenerationGenerator  {
    public static Generation generateGeneration(AvailableStock availableStock, Integer matchListCount, Integer carryoverAmount, Generation bestGeneration, Integer comparisonAmount)throws CloneNotSupportedException{
        Generation generation = new Generation(matchListCount);
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
            generation.addMatchList(MatchListGenerator.generateMatchList(tempAvailableStock, bestGeneration.getMatchLists().get(i).getTopNMatches(carryoverAmount), comparisonAmount));
        }
        generation.sortDescendingPoints();
        return generation;
    }
}

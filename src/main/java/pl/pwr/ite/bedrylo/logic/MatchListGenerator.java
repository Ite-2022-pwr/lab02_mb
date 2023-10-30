package pl.pwr.ite.bedrylo.logic;

import pl.pwr.ite.bedrylo.data.*;

import java.util.ArrayList;

public abstract class MatchListGenerator {
    public static MatchList generateMatchList(AvailableStock availableStock, ArrayList<Match> topNMatches, Integer amount){
        MatchList matchList = new MatchList();
        if (topNMatches != null) {
            for (Match match : topNMatches) {
                if (match.getSki() != null) {
                    matchList.addMatch(match);
                }
            }
        }
        for (PersonalPreference preference: PreferenceList.getPreferences()) {
            if (matchList.getMatches().stream().noneMatch(match -> match.getPreferenceId().equals(preference.getId()))) {
                Match match = PairingMechanism.pair(preference, availableStock, amount);
                matchList.addMatch(match);
            }
        }
        return matchList;
    }
}

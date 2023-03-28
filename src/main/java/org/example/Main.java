package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findBetterStation());
    }
}

class Solution {
    public ArrayList<String> findBetterStation() {

        Set<String> statesToInclude = new HashSet<>(List.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

        Stations stations = new Stations();

        ArrayList<String> ans = new ArrayList<>();




        while (!statesToInclude.isEmpty()) {

            String betterStation = null;
            Set<String> coveredStates = new HashSet<>();


            for (Map.Entry<String, Set<String>> entry : stations.stations.entrySet()) {
                String station = entry.getKey();
                Set<String> states = entry.getValue();

                Set<String> covereds = new HashSet<>(statesToInclude);
                covereds.retainAll(states);

                if (covereds.size() > coveredStates.size()) {
                    betterStation = station;
                    coveredStates = states;
                }
            }

            statesToInclude.removeAll(coveredStates);
            ans.add(betterStation);
        }



        return ans;
    }
}

class Stations {

    HashMap<String, Set<String>> stations;


    public Stations() {

        Set<String> um = new HashSet<>(List.of("id", "nv", "ut"));
        Set<String> dois = new HashSet<>(List.of("wa", "id", "mt"));
        Set<String> tres = new HashSet<>(List.of("or", "nv", "ca"));
        Set<String> quatro = new HashSet<>(List.of("nv", "ut"));
        Set<String> cinco = new HashSet<>(List.of("ca", "az"));

        HashMap<String, Set<String>> stations = new HashMap<>();

        stations.put("kum", um);
        stations.put("kdois", dois);
        stations.put("ktres", tres);
        stations.put("kquatro", quatro);
        stations.put("kcinco", cinco);


        this.stations = stations;

    }

}
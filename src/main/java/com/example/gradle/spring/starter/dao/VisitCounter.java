package com.example.gradle.spring.starter.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.gradle.spring.starter.model.Stats;

import org.springframework.stereotype.Service;

@Service
public class VisitCounter {

    // Return the Map of User Id and number of visits by that user
    // Input param takes an ArrayList of Map objects which contains String userId as
    // Key and Stats object as value
    public Map<Long, Integer> count(List<Map<String, Stats>> input) {
        Map<Long, Integer> result = new HashMap<Long, Integer>();

        for (int i = 0; i < input.size(); i++) {
            Map<String, Stats> mapObj = input.get(i);
            for (String userId : mapObj.keySet()) {
                Stats userStats = mapObj.get(userId);
                    // Considers only UserStats object with a valid value
                    if (userStats != null) {
                        result.put(Long.valueOf(userId), userStats.getVisitCount());
                    }
            }
        }

        return result;
    }

    // -------------TESTING------------

    public static void main(String... args) {

        VisitCounter visitCounter = new VisitCounter();

        List<Map<String, Stats>> listOfVisits = new ArrayList<Map<String, Stats>>();

        // Valid entry
        Map<String, Stats> visit1 = new HashMap<String, Stats>();
        visit1.put("some great user id", new Stats(1));
        listOfVisits.add(visit1);

        // Valid entry
        Map<String, Stats> visit2 = new HashMap<String, Stats>();
        visit2.put("wow another great user id", new Stats(15));
        listOfVisits.add(visit2);

        Map<Long, Integer> result = visitCounter.count(listOfVisits);
        for (Long key : result.keySet()) {
            System.out.println("User Id: " + key + ", VistCount: " + result.get(key));
        }
    }

}
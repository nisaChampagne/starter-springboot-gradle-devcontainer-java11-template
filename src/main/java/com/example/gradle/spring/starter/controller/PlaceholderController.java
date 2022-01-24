package com.example.gradle.spring.starter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.example.gradle.spring.starter.dao.*;
import com.example.gradle.spring.starter.model.Stats;

@RestController
@RequestMapping("/api/placeholder")
public class PlaceholderController {

    private final static Logger SYSLOG = LoggerFactory.getLogger(PlaceholderController.class);


    @Autowired
    private PlaceholderDAO placeholderDAO;

    @GetMapping("")
    ResponseEntity<Object> placeholder (final HttpServletRequest httprequest) throws Exception {
        SYSLOG.debug("Placeholder");
        final Map<String, Object> response = new HashMap<String, Object>();
        response.put("TESTING", "test");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping("/somewords")
    ResponseEntity<String> somewords (final HttpServletRequest httprequest) throws Exception {
        SYSLOG.debug("some words");
        return new ResponseEntity<>(this.placeholderDAO.placeholder(), HttpStatus.OK);
    }

    @GetMapping("/visitCounter")
    ResponseEntity<Map<Long, Integer>> visitCount (final HttpServletRequest httprequest) throws Exception {
        SYSLOG.debug("debugging visitCount");

        VisitCounter visitCounter = new VisitCounter();

        List<Map<String, Stats>> listOfVisits = new ArrayList<Map<String, Stats>>();

        // visit count by userid
        Map<String, Stats> visit1 = new HashMap<String, Stats>();
        visit1.put("1", new Stats(1));
        listOfVisits.add(visit1);

        Map<String, Stats> visit2 = new HashMap<String, Stats>();
        visit2.put("2", new Stats(100));
        listOfVisits.add(visit2);
        
        return new ResponseEntity<>(visitCounter.count(listOfVisits), HttpStatus.OK);
    }


    
}

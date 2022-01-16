package com.example.gradle.spring.starter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.gradle.spring.starter.dao.*;

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
    ResponseEntity<Object> somewords (final HttpServletRequest httprequest) throws Exception {
        SYSLOG.debug("some words");
        final Map<String, Object> response =  new HashMap<String, Object>();
        response.put("TESTING", this.placeholderDAO.placeholder());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}

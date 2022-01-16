package com.example.gradle.spring.starter.dao;

import org.springframework.stereotype.Repository;

@Repository
public class PlaceholderDAOImpl implements PlaceholderDAO{

    @Override
    public String placeholder() {
        return "Hello World";
    }
    
}

package com.cabbooking.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private final String name;
    private final String gender;
    private final int age;
    private String chosenRide;
}

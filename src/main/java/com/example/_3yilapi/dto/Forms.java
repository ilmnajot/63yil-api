package com.example._3yilapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Forms(
            String isolated,
            String initial, 
            String medial,
            @JsonProperty("final") String finalForm) {}
package com.example._3yilapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// The JSON for the lesson page
public record LetterDetail(
        Long id,
        Integer order,
        String name,
        String arabic,
        String arabicName,
        String sound,
        String makhraj,
        Forms forms,
        Example example,
        Activities activities) {



}
package com.example._3yilapi.dto;

import java.util.Date;

public record LetterDto(
        Long id,
        Integer order,
        String arabic,
        String arabicName,
        String name,
        String sound,
        String makhraj,
        String form_isolated,
        String form_initial,
        String form_medial,
        String form_final,
        String example_arabic,
        String example_translit,
        String example_meaning
        ) {
}

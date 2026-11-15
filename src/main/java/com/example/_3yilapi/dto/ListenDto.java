package com.example._3yilapi.dto;

import java.util.Date;

public record ListenDto(
        Long id,
        String url,
        Long letter_id,
        Date created_date,
        Integer is_active
) {
}

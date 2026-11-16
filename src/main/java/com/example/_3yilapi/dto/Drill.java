package com.example._3yilapi.dto;

import java.util.List;

public record Drill(Long id, String text, List<String> features, String audioUrl) {}
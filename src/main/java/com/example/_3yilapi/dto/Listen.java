package com.example._3yilapi.dto;

import java.util.List;

public record Listen(String instructions, String audioUrl, List<LetterSummary> distractors) {}

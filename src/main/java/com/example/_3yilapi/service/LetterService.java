package com.example._3yilapi.service;

import com.example._3yilapi.dto.LetterDetail;
import com.example._3yilapi.dto.LetterDto;
import com.example._3yilapi.dto.LetterSummary;

import java.util.List;

public interface LetterService {
    List<LetterSummary> getAllLetters();

    LetterDetail getOneLetter(Long id);
}

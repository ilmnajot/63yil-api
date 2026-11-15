package com.example._3yilapi.controller;

import com.example._3yilapi.dto.LetterDetail;
import com.example._3yilapi.dto.LetterDto;
import com.example._3yilapi.dto.LetterSummary;
import com.example._3yilapi.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/letters")
public class LetterController {
    private final LetterService service;

    @GetMapping
    public List<LetterSummary> getAllLetters() {
        return this.service.getAllLetters();
    }

    @GetMapping("/{id}")
    public LetterDetail getOneLetter(@PathVariable Long id) {
        return this.service.getOneLetter(id);
    }
}

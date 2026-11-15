package com.example._3yilapi.service.impl;

import com.example._3yilapi.dto.*;
import com.example._3yilapi.mapper.LetterMapper;
import com.example._3yilapi.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LetterServiceImpl implements LetterService {
    private final LetterMapper mapper;

    @Override
    public List<LetterSummary> getAllLetters() {
        return mapper.getAllLetters();
    }

    @Override
    public LetterDetail getOneLetter(Long id) {
        LetterRow r = mapper.getOneLetter(id);
        if (r == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Letter not found");
        }
        List<LetterSummary> distractors = r.listenId() == null
                ? List.of()
                : mapper.getDistractors(r.listenId());

        return new LetterDetail(
                r.id(), r.order(), r.name(), r.arabic(), r.arabicName(), r.sound(), r.makhraj(),
                new Forms(r.formIsolated(), r.formInitial(), r.formMedial(), r.formFinal()),
                new Example(r.exampleArabic(), r.exampleTranslit(), r.exampleMeaning()),
                new Activities(
                        new Drawing(orDefault(r.traceInstructions(), r.name() + " harfini nuqtali chiziqlar boʻylab chizing."), r.traceForm()),
                        new Drawing(orDefault(r.writeInstructions(), "Endi " + r.name() + " harfini namunasiz, oʻzingiz yozing."), r.writeForm()),
                        new Listen(orDefault(r.listenInstructions(), "Diqqat bilan tinglang, soʻng eshitgan harfingizni bosing."), r.listenAudioUrl(), distractors),
                        new Repeat(orDefault(r.repeatInstructions(), r.name() + " harfini tinglang, soʻng uni aytib, ovozingizni yozib oling."), r.repeatAudioUrl())));
    }

    /**
     * An activity row can be missing or inactive; the lesson still needs all four.
     */
    private static String orDefault(String value, String fallback) {
        return value != null ? value : fallback;
    }
}

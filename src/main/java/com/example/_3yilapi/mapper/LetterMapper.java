package com.example._3yilapi.mapper;
import com.example._3yilapi.dto.DrillRow;
import com.example._3yilapi.dto.JoiningRow;
import com.example._3yilapi.dto.LetterRow;
import com.example._3yilapi.dto.LetterSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LetterMapper {

    List<LetterSummary> getAllLetters();

    LetterRow getOneLetter(@Param("id") Long id);

    List<LetterSummary> getDistractors(@Param("listenId") Long listenId);

    JoiningRow getJoining(@Param("letterId") Long letterId);

    List<DrillRow> getDrills(@Param("joiningId") Long joiningId);
}

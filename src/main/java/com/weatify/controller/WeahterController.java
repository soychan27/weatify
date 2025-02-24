package com.weatify.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@Tag(name="Weather API", description = "날씨 정보를 제공하는 API")
public class WeahterController {

    @GetMapping("/current")
    @Operation(summary = "현재 위치 조회", description = "현재 위치에 해당하는 정보")
    public String getCurrentWeather() {
        return "현재 날씨 : 맑음 ";
    }
}

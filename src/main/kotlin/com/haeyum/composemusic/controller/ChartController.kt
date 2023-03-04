package com.haeyum.composemusic.controller

import com.haeyum.composemusic.domain.chart.model.Song
import com.haeyum.composemusic.domain.chart.service.StreamingChartService
import com.haeyum.composemusic.domain.chart.service.impl.StreamingChartServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ChartController {
    private val streamingChartService: StreamingChartService = StreamingChartServiceImpl()

    @GetMapping("/info")
    fun info(): String {
        return "Info"
    }

    @GetMapping("/chart/melon")
    fun chartMelon(): List<Song> = streamingChartService.getMelonChart()

    @GetMapping("/chart/bugs")
    fun chartBugs(): List<Song> = streamingChartService.getBugsChart()

    @GetMapping("/chart/genie")
    fun chartVibe(): List<Song> = streamingChartService.getGenieChart()
}
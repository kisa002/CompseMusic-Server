package com.haeyum.composemusic.domain.chart.service

import com.haeyum.composemusic.domain.chart.model.Song

interface StreamingChartService {
    fun getMelonChart(): List<Song>
    fun getBugsChart(): List<Song>
    fun getGenieChart(): List<Song>
}
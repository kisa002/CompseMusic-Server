package com.haeyum.composemusic.domain.chart.repository

import com.haeyum.composemusic.domain.chart.model.Song

interface ChartRepository {
    fun getChart100(): List<Song>
}
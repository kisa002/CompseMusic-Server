package com.haeyum.composemusic.domain.chart.repository

interface StreamingChartRepository {
    val melonChart: ChartRepository
    val bugsChart: ChartRepository
    val genieChart: ChartRepository
}
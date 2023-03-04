package com.haeyum.composemusic.domain.chart.repository.impl

import com.haeyum.composemusic.domain.chart.repository.ChartRepository
import com.haeyum.composemusic.domain.chart.repository.StreamingChartRepository

class StreamingChartRepositoryImpl: StreamingChartRepository {
    override val melonChart: ChartRepository = MelonChartImpl()
    override val bugsChart: ChartRepository = BugsChartImpl()
    override val genieChart: ChartRepository = GenieChartImpl()
}
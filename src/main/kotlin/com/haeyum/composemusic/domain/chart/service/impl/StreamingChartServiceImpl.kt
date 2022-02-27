package com.haeyum.composemusic.domain.chart.service.impl

import com.haeyum.composemusic.domain.chart.model.Song
import com.haeyum.composemusic.domain.chart.repository.StreamingChartRepository
import com.haeyum.composemusic.domain.chart.repository.impl.StreamingChartRepositoryImpl
import com.haeyum.composemusic.domain.chart.service.StreamingChartService

class StreamingChartServiceImpl: StreamingChartService {
    private val streamingChartRepository: StreamingChartRepository = StreamingChartRepositoryImpl()

    override fun getMelonChart(): List<Song> = streamingChartRepository.melonChart.getChart100()
    override fun getBugsChart(): List<Song> = streamingChartRepository.bugsChart.getChart100()
    override fun getGenieChart(): List<Song> = streamingChartRepository.genieChart.getChart100()
}
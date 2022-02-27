package com.haeyum.composemusic.domain.chart.repository.impl

import com.haeyum.composemusic.domain.chart.model.Song
import com.haeyum.composemusic.domain.chart.repository.ChartRepository
import org.jsoup.Jsoup

class GenieChartImpl : ChartRepository {
    override fun getChart100(): List<Song> {
        val document = Jsoup.connect("https://www.genie.co.kr/chart/top200").get()

        val titles = document.select(".info .albumtitle").textNodes().map { it.text() }
        val artists = document.select(".info .artist").textNodes().map { it.text() }

        val chart = titles.zip(artists) { title, artist ->
            Song(title = title, artist = artist)
        }

        return chart.take(100)
    }
}
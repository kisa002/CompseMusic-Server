package com.haeyum.composemusic.domain.chart.repository.impl

import com.haeyum.composemusic.domain.chart.model.Song
import com.haeyum.composemusic.domain.chart.repository.ChartRepository
import org.jsoup.Jsoup

class GenieChartImpl : ChartRepository {
    override fun getChart100(): List<Song> {
        val document = Jsoup.connect("https://www.genie.co.kr/chart/top200").get()

        val titles = document.select(".title.ellipsis").textNodes().map { it.text().trim() }
        val artists = document.select(".artist.ellipsis").textNodes().map { it.text() }
        val thumbnails = document.select(".cover img").map { it.attr("src") }

        val chart = maxOf(titles.size, artists.size, thumbnails.size).downTo(1).filter { it < 50 }.map { index ->
            Song(title = titles[index], artist = artists[index], thumbnail = thumbnails[index])
        }.reversed()

        return chart
    }
}
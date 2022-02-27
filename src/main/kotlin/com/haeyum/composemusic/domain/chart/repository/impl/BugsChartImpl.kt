package com.haeyum.composemusic.domain.chart.repository.impl

import com.haeyum.composemusic.domain.chart.model.Song
import com.haeyum.composemusic.domain.chart.repository.ChartRepository
import org.jsoup.Jsoup

class BugsChartImpl : ChartRepository {
    override fun getChart100(): List<Song> {
        val document = Jsoup.connect("https://music.bugs.co.kr/chart").get()

        val titles = document.select("tbody .title a").textNodes().map { it.text() }
        val artists = document.select("tbody .artist a").textNodes().map { it.text() }
        val thumbnails = document.select("tbody .thumbnail img").map { it.attr("src") }

        val chart = maxOf(titles.size, artists.size, thumbnails.size).downTo(1).filter { it < 100 }.map { index ->
            Song(title = titles[index], artist = artists[index], thumbnail = thumbnails[index])
        }.reversed()

        return chart
    }
}
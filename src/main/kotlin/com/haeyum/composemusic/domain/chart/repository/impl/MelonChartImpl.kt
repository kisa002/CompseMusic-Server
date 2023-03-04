package com.haeyum.composemusic.domain.chart.repository.impl

import com.haeyum.composemusic.domain.chart.repository.ChartRepository
import com.haeyum.composemusic.domain.chart.model.Song
import org.jsoup.Jsoup

class MelonChartImpl: ChartRepository {
    override fun getChart100(): List<Song> {
        val document = Jsoup.connect("https://www.melon.com/chart/index.htm").get()

        val titles = document.select(".ellipsis.rank01 a").textNodes().map { it.text() }
        val artists = document.select("div .ellipsis.rank02>a:first-child").textNodes().map { it.text() }
        val thumbnails = document.select(".image_typeAll img").map { it.attr("src") }

//        print("${titles.size}/${artists.size}/${thumbnails.size}")
        val chart = maxOf(titles.size, artists.size, thumbnails.size).downTo(1).filter { it < 100 }.map { index ->
            Song(title = titles[index], artist = artists[index], thumbnail = thumbnails[index])
        }.reversed()

        return chart
    }
}
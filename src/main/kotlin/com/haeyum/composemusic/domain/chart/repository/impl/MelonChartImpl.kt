package com.haeyum.composemusic.domain.chart.repository.impl

import com.haeyum.composemusic.domain.chart.repository.ChartRepository
import com.haeyum.composemusic.domain.chart.model.Song
import org.jsoup.Jsoup

class MelonChartImpl: ChartRepository {
    override fun getChart100(): List<Song> {
        val document = Jsoup.connect("https://www.melon.com/chart/index.htm").get()
        val select = document.select(".wrap_song_info div span a").textNodes()

        val titles = select.filterIndexed { index, _ -> index % 2 == 1 }.map { it.text() }
        val artists = select.filterIndexed { index, _ -> index % 2 == 0 }.map { it.text() }

        val chart = titles.zip(artists) { title, artist ->
            Song(title = title, artist = artist)
        }

        return chart.take(100)
    }
}
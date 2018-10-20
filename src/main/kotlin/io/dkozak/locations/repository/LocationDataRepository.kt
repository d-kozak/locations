package io.dkozak.locations.repository

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service

@Service
class LocationDataRepository {

    @Value("classpath:static/data/Biking.csv")
    private var resource: Resource? = null

    fun getBikingData(): List<Pair<Double, Double>> {
        val content = resource?.inputStream?.bufferedReader().use {
            it?.readText() ?: ""
        }.split("\n")
        val withoutHeader = if (content.size > 1)
            content.subList(1, content.size)
        else content

        return withoutHeader.map {
            val split = it.split(",")
            if (split.size > 3) {
                try {
                    split[1].toDouble() to split[2].toDouble()
                } catch (ex: NumberFormatException) {
                    -1.0 to -1.0
                }
            } else -1.0 to -1.0
        }.filter {
            it.first != -1.0 && it.second != -1.0
        }
    }
}

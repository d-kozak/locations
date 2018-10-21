package io.dkozak.locations.repository

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service

@Service
class LocationDataRepository {

    @Value("classpath:static/data/Biking.csv")
    private lateinit var bikingResource: Resource

    @Value("classpath:static/data/Driving.csv")
    private lateinit var drivingResource: Resource

    @Value("classpath:static/data/Running.csv")
    private lateinit var runningResource: Resource

    @Value("classpath:static/data/Walking.csv")
    private lateinit var walkingResource: Resource

    fun getBikingData(): List<Pair<Double, Double>> = bikingResource.asLocations()

    fun getDrivingData(): List<Pair<Double, Double>> = drivingResource.asLocations()

    fun getRunningData(): List<Pair<Double, Double>> = runningResource.asLocations()

    fun getWalkingData(): List<Pair<Double, Double>> = walkingResource.asLocations()


}

private fun Resource.asLocations(): List<Pair<Double, Double>> {
    val content = loadFileContent(this).split("\n")
    val withoutHeader = if (content.size > 1)
        content.subList(1, content.size)
    else content

    return withoutHeader
            .asSequence()
            .map { it.split(",") }
            .filter { it.size >= 3 }
            .map {
                try {
                    it[1].toDouble() to it[2].toDouble()
                } catch (ex: NumberFormatException) {
                    -1.0 to -1.0
                }
            }.toList()
}

private fun loadFileContent(resource: Resource) = resource.inputStream.bufferedReader().use {
    it.readText()
}

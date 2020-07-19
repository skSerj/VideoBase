package com.videobase.network.model

data class RequestMovieModel(
    var id: Int,
    var url: String,
    var name: String,
    var type: String,
    var language: String,
    var genres: List<String>,
    var status: String,
    var runtime: Int,
    var premiered: String,
    var officialSite: String,
    var schedule: Schedule,
    var rating: Rating,
    var weight: Int,
    var network: Network,
    var webChannel: Any,
    var externals: Externals,
    var image: Image,
    var summary: String,
    var updated: Int,
    var links: List<Links>
)

data class Externals(
    var tvrage: Int,
    var thetvdb: Int,
    var imdb: String
)

data class Image(
    var medium: String,
    var original: String
)

data class Links(
    var self: List<Self>,
    var previousepisode: List<Previousepisode>
)

data class Network(
    var id: Int,
    var name: String,
    var country: Country
)

data class Country(
    var name: String,
    var code: String,
    var timezone: String
)

data class Previousepisode(
    var href: String
)

data class Self(
    var href: String
)

data class Schedule(
    var time: String,
    var days: List<String>
)

data class Rating(
    var average: Float
)
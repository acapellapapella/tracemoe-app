package lol.hostov.tracemoe.data.remote.model

import androidx.compose.runtime.Immutable
import com.google.gson.JsonElement

@Immutable
data class SearchResponse(
    val frameCount: Int,
    val error: String,
    val result: List<SearchResponseItem>
)

data class SearchResponseItem(
    val anilist: AnilistInfo,
    val filename: String,
    val episode: JsonElement?,
    val from: Float,
    val at: Float,
    val to: Float,
    val duration: Float,
    val similarity: Float,
    val video: String,
    val image: String,
)

@Immutable
data class AnilistInfo(
    val id: Int,
    val idMal: Int?,
    val type: String,
    val title: AnilistResponse.MediaItem.Title,
    val format: String?,
    val genres: List<String>,
    val season: String?,
    val source: String?,
    val status: String,
    val startDate: AnilistResponse.MediaItem.Date,
    val endDate: AnilistResponse.MediaItem.Date?,
    val siteUrl: String,
    val studios: AnilistResponse.MediaItem.Studios,
    val duration: Int?,
    val episodes: Int?,
    val coverImage: AnilistResponse.MediaItem.CoverImage,
    val bannerImage: String?,
    val popularity: Int,
    val seasonYear: Int?,
    val synonyms: List<String>,
    val isAdult: Boolean,
    val externalLinks: List<AnilistResponse.MediaItem.ExternalLink>,
    val countryOfOrigin: String,
    val synonyms_chinese: List<String>,
)

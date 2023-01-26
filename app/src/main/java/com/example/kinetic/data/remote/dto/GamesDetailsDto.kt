package com.example.kinetic.data.remote.dto

import com.example.kinetic.domain.model.GameDetailsModel
import kotlinx.serialization.Serializable

@Serializable
data class GamesDetailsDto(
    val achievements_count: Int? = 0,
    val added: Int? = 0,
    val added_by_status: AddedByStatusX? = AddedByStatusX(),
    val additions_count: Int? = 0,
    val alternative_names: List<String>? = emptyList(),
    val background_image: String? = "",
    val background_image_additional: String? = "",
    val clip: String? = "",
    val creators_count: Int? = 0,
    val description: String? = "",
    val description_raw: String? = "",
    val developers: List<Developer>? = emptyList(),
    val dominant_color: String? = "",
    val esrb_rating: EsrbRatingX? = EsrbRatingX(),
    val game_series_count: Int? = 0,
    val genres: List<GenreX>? = emptyList(),
    val id: Int,
    val metacritic: Int? = 0,
    val metacritic_platforms: List<MetacriticPlatform?>? = emptyList(),
    val metacritic_url: String? = "",
    val movies_count: Int? = 0,
    val name: String? = "",
    val name_original: String? = "",
    val parent_achievements_count: Int? = 0,
    val parent_platforms: List<ParentPlatformX?>? = emptyList(),
    val parents_count: Int? = 0,
    val platforms: List<PlatformXXXXX?>? = emptyList(),
    val playtime: Int? = 0,
    val publishers: List<Publisher?>? = emptyList(),
    val rating: Double? = 0.0,
    val rating_top: Int? = 0,
    val ratings: List<RatingX?>? = emptyList(),
    val ratings_count: Int? = 0,
    val reactions: Reactions? = Reactions(),
    val reddit_count: Int? = 0,
    val reddit_description: String? = "",
    val reddit_logo: String? = "",
    val reddit_name: String? = "",
    val reddit_url: String? = "",
    val released: String? = "",
    val reviews_count: Int? = 0,
    val reviews_text_count: Int? = 0,
    val saturated_color: String? = "",
    val screenshots_count: Int? = 0,
    val slug: String? = "",
    val stores: List<StoreXX?>? = emptyList(),
    val suggestions_count: Int? = 0,
    val tags: List<TagX?>? = emptyList(),
    val tba: Boolean? = false,
    val twitch_count: Int? = 0,
    val updated: String? = "",
    val user_game: String? = "",
    val website: String? = "",
    val youtube_count: Int? = 0,
)

fun GamesDetailsDto.toGameDetailsModel(): GameDetailsModel{
    return GameDetailsModel(
        name = name?:"",
        metacritic = metacritic?:0,
        backgroundImage = background_image?:"",
        backgroundImageAdditional = background_image_additional?:"",
        rating = rating?:0.0,
        platforms = platforms?.map { it?.platform?.slug }?: emptyList(),
        pcRequirements = platforms?.first { it?.platform?.name == "PC" }?.requirements?.minimum?:"",
        genres = genres?.map { it.slug }?: emptyList(),
        publisher = publishers?.first()?.name?:"",
        publisherImage = publishers?.first()?.image_background?:"",
        esrbRating = esrb_rating?.name?:"",
        description = description_raw?:"",
    )
}
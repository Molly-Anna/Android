package com.example.esteticfilms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.esteticfilms.ui.theme.EsteticFilmsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EsteticFilmsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ViewingSelectionOfMovies()
                }
            }
        }
    }
}

//Основная активность.
@Composable
fun ViewingSelectionOfMovies() {
    //состояние для текущего индекса фильма
    var currentFilmIndex by remember { mutableIntStateOf(0) }

    //список фильмов индексы
    val totalIndexFilms = 16

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 7.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
    ) {
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = stringResource(R.string.aesthetic_films),
            fontSize = 22.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Black,
            modifier = Modifier
                .padding(bottom = 8.dp, top = 16.dp)
                .align(alignment = Alignment.Start)
        )
        Spacer(modifier = Modifier.height(15.dp))
        when (currentFilmIndex) {
            0 -> {
                Poster(
                    image = R.drawable.person,
                    descriptionFilm = R.string.person_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.person_film,
                    R.string.person_film_director,
                    R.string.person_film_country,
                    R.string.person_film_year
                )
            }

            1 -> {
                Poster(
                    R.drawable.eyes_wide_shut,
                    R.string.eyes_wide_shut_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.eyes_wide_shut_film,
                    R.string.eyes_wide_shut_film_director,
                    R.string.eyes_wide_shut_film_country,
                    R.string.eyes_wide_shut_film_year
                )
            }

            2 -> {
                Poster(
                    R.drawable.belly,
                    R.string.belly_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.belly_film,
                    R.string.belly_film_director,
                    R.string.belly_film_country,
                    R.string.belly_film_year
                )
            }

            3 -> {
                Poster(
                    R.drawable.manhunter,
                    R.string.manhunter_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.manhunter_film,
                    R.string.manhunter_film_director,
                    R.string.manhunter_film_country,
                    R.string.manhunter_film_year
                )
            }

            4 -> {
                Poster(
                    R.drawable.ichi_the_killer,
                    R.string.ichi_the_killer_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.ichi_the_killer_film,
                    R.string.ichi_the_killer_film_director,
                    R.string.ichi_the_killer_film_country,
                    R.string.ichi_the_killer_film_year
                )
            }

            5 -> {
                Poster(
                    R.drawable.blade,
                    R.string.blade_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.blade_film,
                    R.string.blade_film_director,
                    R.string.blade_film_country,
                    R.string.blade_film_year
                )
            }

            6 -> {
                Poster(
                    R.drawable.letztes_jahr_in_marienbad,
                    R.string.letztes_jahr_in_matienbad_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.letztes_jahr_in_matienbad_film,
                    R.string.letztes_jahr_in_matienbad_film_director,
                    R.string.letztes_jahr_in_matienbad_film_country,
                    R.string.letztes_jahr_in_matienbad_film_year
                )
            }

            7 -> {
                Poster(
                    R.drawable.garnet_color,
                    R.string.garnet_color_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.garnet_color_film,
                    R.string.garnet_color_film_director,
                    R.string.garnet_color_film_country,
                    R.string.garnet_color_film_year
                )
            }

            8 -> {
                Poster(
                    R.drawable.lizard_in_a_woman_s_skin,
                    R.string.lizard_in_a_woman_skin_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.lizard_in_a_woman_skin_film,
                    R.string.lizard_in_a_woman_skin_film_director,
                    R.string.lizard_in_a_woman_skin_film_country,
                    R.string.lizard_in_a_woman_skin_film_year
                )
            }

            9 -> {
                Poster(
                    R.drawable.gattaca,
                    R.string.gattaca_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.gattaca_film,
                    R.string.gattaca_film_director,
                    R.string.gattaca_film_country,
                    R.string.gattaca_film_year
                )
            }

            10 -> {
                Poster(
                    R.drawable.neon_demon,
                    R.string.the_neon_demon_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.the_neon_demon_film,
                    R.string.the_neon_demon_film_director,
                    R.string.the_neon_demon_film_country,
                    R.string.the_neon_demon_film_year
                )
            }

            11 -> {
                Poster(
                    R.drawable.american_psycho,
                    R.string.american_psycho_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.american_psycho_film,
                    R.string.american_psycho_film_director,
                    R.string.american_psycho_film_country,
                    R.string.american_psycho_film_year
                )
            }

            12 -> {
                Poster(
                    R.drawable.leon,
                    R.string.leon_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.leon_film,
                    R.string.leon_film_director,
                    R.string.leon_film_country,
                    R.string.leon_film_year
                )
            }

            13 -> {
                Poster(
                    R.drawable.pulp_fiction,
                    R.string.pulp_fiction_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.pulp_fiction_film,
                    R.string.pulp_fiction_film_director,
                    R.string.pulp_fiction_film_country,
                    R.string.pulp_fiction_film_year
                )
            }

            14 -> {
                Poster(
                    R.drawable.holy_mountain,
                    R.string.the_holy_mountain_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.the_holy_mountain_film,
                    R.string.the_holy_mountain_film_director,
                    R.string.the_holy_mountain_film_country,
                    R.string.the_holy_mountain_film_year
                )
            }

            15 -> {
                Poster(
                    R.drawable.oldboy,
                    R.string.oldboy_film_description
                )
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionText(
                    R.string.oldboy_film,
                    R.string.oldboy_film_director,
                    R.string.oldboy_film_country,
                    R.string.oldboy_film_year
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        NavigationButton(
            onPreviousClick = {
                if (currentFilmIndex == 0) {
                    currentFilmIndex = totalIndexFilms - 1
                } else {
                    currentFilmIndex--
                }
            },
            onNextClick = {
                if (currentFilmIndex == totalIndexFilms - 1) {
                    currentFilmIndex = 0
                } else {
                    currentFilmIndex++
                }
            }
        )
    }
}


//картиночка
@Composable
fun Poster(
    image: Int,
    descriptionFilm: Int
) {
    Image(
        painter = painterResource(image),
        contentDescription = stringResource(descriptionFilm),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            //.height(220.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

//название и описание
@Composable
fun DescriptionText(nameFilm: Int, directorFilm: Int, countryFilm: Int, yearFilm: Int) {
    Column(
        modifier = Modifier
            .padding(start = 5.dp)
    ) {
        Text(
            text = stringResource(nameFilm),
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Director: ${stringResource(directorFilm)}",
            fontSize = 15.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "Country: ${stringResource(countryFilm)}",
            fontSize = 15.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "Year: ${stringResource(yearFilm)}",
            fontSize = 15.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )
    }
}

//кнопки навигации назад и вперед
@Composable
fun NavigationButton(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "<- Previous",
                fontSize = 11.sp,
                fontFamily = FontFamily.Serif
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            )
        )
        {
            Text(
                text = "Next ->",
                fontSize = 11.sp,
                fontFamily = FontFamily.Serif
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewingSelectionOfMoviesPreview() {
    EsteticFilmsTheme {
        ViewingSelectionOfMovies()
    }
}


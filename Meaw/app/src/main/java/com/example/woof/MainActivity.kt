package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.woof.data.Cat
import com.example.woof.data.cats
import com.example.woof.ui.theme.CatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MeowApp()
                }
            }
        }
    }
}

/**
 * Composable that displays an app bar and a list of cats.
 * Компонуемый, который отображает панель приложений и список котов.
 * Scaffold -> добавление пробелов во всех штучкач сразу
 */
@Composable
fun MeowApp() {
    Scaffold(

        topBar = {
            MeowTopAppBar()
        }

    ) { it ->

        LazyColumn(contentPadding = it) {

            items(cats) {
                CatItem(
                    cat = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeowTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.ic_cat_logo),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

/**
 * Composable that displays a list item containing a cat icon and their information.
 * отображающий элемент списка, отображает фотографию кота и инфоррмацию о ней.
 *
 * @param cat contains the data that populates the list item
 * содержит данные, которые заполняют элемент списка
 * @param modifier modifiers to set to this composable
 * модификаторы для установки в этот компонуемый элемент
 */
@Composable
fun CatItem(
    cat: Cat,
    modifier: Modifier = Modifier
) {
    var expended by remember { mutableStateOf(false) }
    Card(modifier = modifier) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                CatIcon(cat.imageResourceId)
                CatInformation(cat.name, cat.age)
                //отодвинуть кнопку к боку
                Spacer(modifier = Modifier.weight(1f))
                CatItemButton(
                    expended,
                    { expended = !expended },
                )
            }
            if (expended) {
                CatHobby(
                    cat.hobbies,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

//Создание композитного значка Равзернуть еще
@Composable
private fun CatItemButton(
    //для расширенного состояния
    expendet: Boolean,
    //для обрабтки нажатия кнопки
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expendet)Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            //цвет значка
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

/**
 * Composable that displays a photo of a cat.
 * Компонуемый объект, отображающий фотографию котов.
 *
 * @param catIcon is the resource ID for the image of the cat
 * это идентификатор ресурса для изображения кота
 * @param modifier modifiers to set to this composable
 * модификаторы, устанавливаемые для этого компонуемого объекта
 */
@Composable
fun CatIcon(
    @DrawableRes catIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            //делает круглым, но не достаточно
            .clip(MaterialTheme.shapes.small),
        //делает окончательно круглым
        contentScale = ContentScale.Crop,
        painter = painterResource(catIcon),
        contentDescription = null
    )
}

/**
 * Composable that displays a cat's name and age.
 * Компонуемый, который отображает имя и возраст кота.
 *
 * @param catName is the resource ID for the string of the cat's name
 * это идентификатор ресурса для строки имени кота
 * @param catAge is the Int that represents the cat's age
 *это значение Int, представляющее возраст кота
 * @param modifier modifiers to set to this composable
 *модификаторы для установки в этот компонуемый параметр
 */
@Composable
fun CatInformation(
    @StringRes catName: Int,
    catAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(catName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.years_old, catAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

/**
 * Сост функция с Text компонентом для отображения информации о хобби.
 */
@Composable
fun CatHobby(
    //идентификатор ресурса со строкой "хобби кота"
    @StringRes catHobby: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(catHobby),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 * Компонуемый, который отображает, как выглядит пользовательский интерфейс приложения в легкой теме на вкладке дизайн.
 */
@Preview
@Composable
fun CatPreview() {
    CatTheme(darkTheme = false) {
        MeowApp()
    }
}

@Preview
@Composable
fun CatDarkPreview() {
    CatTheme(darkTheme = true) {
        MeowApp()
    }
}

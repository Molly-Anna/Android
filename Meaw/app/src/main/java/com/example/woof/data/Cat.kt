package com.example.woof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.woof.R

/**
 * A data class to represent the information presented in the cat card
 * Класс данных для представления информации, представленной в карточке cat
 */
data class Cat(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

val cats = listOf(
    Cat(R.drawable.adolf, R.string.cat_name_1, 2, R.string.cat_description_1),
    Cat(R.drawable.murzic, R.string.cat_name_2, 16, R.string.cat_description_2),
    Cat(R.drawable.oleg, R.string.cat_name_3, 2, R.string.cat_description_3),
    Cat(R.drawable.spidercat, R.string.cat_name_4, 8, R.string.cat_description_4),
    Cat(R.drawable.chtirlez, R.string.cat_name_5, 8, R.string.cat_description_5),
    Cat(R.drawable.valera, R.string.cat_name_6, 14, R.string.cat_description_6),
    Cat(R.drawable.ivleev, R.string.cat_name_7, 2, R.string.cat_description_7),
    Cat(R.drawable.prochor, R.string.cat_name_8, 7, R.string.cat_description_8),
    Cat(R.drawable.markiz, R.string.cat_name_9, 4, R.string.cat_description_9)
)

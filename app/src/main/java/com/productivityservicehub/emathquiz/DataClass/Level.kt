package com.productivityservicehub.emathquiz.DataClass

import com.productivityservicehub.emathquiz.R

data class Level(
    val number: Int,
    val questionImageRes: Int,
    val correctAnswer: String
)

val levels = listOf(
    Level(1, R.drawable.img, "87"),
    Level(2, R.drawable.img_1, "6"),
    Level(3, R.drawable.img_2, "25"),
    Level(4, R.drawable.img, "87"),
    Level(5, R.drawable.img_1, "6"),
    Level(6, R.drawable.img_2, "25"),
    Level(7, R.drawable.img, "87"),
    Level(8, R.drawable.img_1, "6"),
    Level(9, R.drawable.img_2, "25"),
    Level(10, R.drawable.img, "87"),
    Level(11, R.drawable.img_1, "6"),
    Level(12, R.drawable.img_2, "25"),
    Level(13, R.drawable.img, "87"),
    Level(14, R.drawable.img_1, "6"),
    Level(15, R.drawable.img_2, "25"),
    Level(16, R.drawable.img, "87"),
    Level(17, R.drawable.img_1, "6"),
    Level(18, R.drawable.img_2, "25"),
    Level(19, R.drawable.img, "87"),
    Level(20, R.drawable.img_1, "6"),
    Level(21, R.drawable.img_2, "25"),
    Level(22, R.drawable.img, "87"),
    Level(23, R.drawable.img_1, "6"),
    Level(24, R.drawable.img_2, "25"),
    Level(25, R.drawable.img, "87"),
    Level(26, R.drawable.img_1, "6"),
    Level(27, R.drawable.img_2, "25"),


    // Add more levels as needed
)
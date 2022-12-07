package com.example.pushupchallenge.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.pushupchallenge.R

data class Challenge(
    @StringRes val day: Int,
    @DrawableRes val imageDesc: Int,
    @StringRes val workout: Int
)

val challenges = listOf(
    Challenge(R.string.day1, R.drawable.day_1_image, R.string.challenge1),
    Challenge(R.string.day2, R.drawable.day_2_image, R.string.challenge2),
    Challenge(R.string.day3, R.drawable.day_3_image, R.string.challenge3),
    Challenge(R.string.day4, R.drawable.day_4_image, R.string.challenge4),
    Challenge(R.string.day5, R.drawable.day_5_image, R.string.challenge5),
    Challenge(R.string.day6, R.drawable.day_6_image, R.string.challenge6),
    Challenge(R.string.day7, R.drawable.day_7_image, R.string.challenge7),
    Challenge(R.string.day8, R.drawable.day_8_image, R.string.challenge8),
    Challenge(R.string.day9, R.drawable.day_9_image, R.string.challenge9),
    Challenge(R.string.day10, R.drawable.day_10_image, R.string.challenge10),
    Challenge(R.string.day11, R.drawable.day_1_image, R.string.challenge11),
    Challenge(R.string.day12, R.drawable.day_2_image, R.string.challenge12),
    Challenge(R.string.day13, R.drawable.day_3_image, R.string.challenge13),
    Challenge(R.string.day14, R.drawable.day_4_image, R.string.challenge14),
    Challenge(R.string.day15, R.drawable.day_5_image, R.string.challenge15),
    Challenge(R.string.day16, R.drawable.day_6_image, R.string.challenge16),
    Challenge(R.string.day17, R.drawable.day_7_image, R.string.challenge17),
    Challenge(R.string.day18, R.drawable.day_8_image, R.string.challenge18),
    Challenge(R.string.day19, R.drawable.day_9_image, R.string.challenge19),
    Challenge(R.string.day20, R.drawable.day_10_image, R.string.challenge20),
    Challenge(R.string.day21, R.drawable.day_1_image, R.string.challenge21),
    Challenge(R.string.day22, R.drawable.day_2_image, R.string.challenge22),
    Challenge(R.string.day23, R.drawable.day_3_image, R.string.challenge23),
    Challenge(R.string.day24, R.drawable.day_4_image, R.string.challenge24),
    Challenge(R.string.day25, R.drawable.day_5_image, R.string.challenge25),
    Challenge(R.string.day26, R.drawable.day_6_image, R.string.challenge26),
    Challenge(R.string.day27, R.drawable.day_7_image, R.string.challenge27),
    Challenge(R.string.day28, R.drawable.day_8_image, R.string.challenge28),
    Challenge(R.string.day29, R.drawable.day_9_image, R.string.challenge29),
    Challenge(R.string.day30, R.drawable.day_10_image, R.string.challenge30)


)

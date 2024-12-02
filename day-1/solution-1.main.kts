#!/usr/bin/env kotlin

import java.io.File
import kotlin.math.abs

File("input.txt")
    .readLines()
    .map {
        it.split("\\s+".toRegex())
    }
    .map { (left, right) ->
        left.toInt() to right.toInt()
    }
    .unzip()
    .let { (left, right) ->
        left
            .sorted()
            .zip(right.sorted())
            .sumOf { (left, right) ->
                distance(left, right)
            }
    }
    .let(::println)

fun distance(a: Int, b: Int) = abs(a - b)

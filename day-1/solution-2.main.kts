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
        val frequencies =
            right
                .groupingBy { it }
                .eachCount()

        left.sumOf {
            it * frequencies.getOrDefault(it, 0)
        }
    }
    .let(::println)

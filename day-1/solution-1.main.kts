#!/usr/bin/env kotlin

import java.io.File
import kotlin.math.abs

File("input")
    .readLines()
    .map {
        it.split("\\s+".toRegex())
    }
    .map { (left, right) ->
        left.toLong() to right.toLong()
    }
    .unzip()
    .let { (left, right) ->
        left.sorted()
            .zip(right.sorted())
            .sumOf { (left, right) ->
                abs(left - right)
            }
    }
    .let(::println)

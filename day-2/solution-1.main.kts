#!/usr/bin/env kotlin

import java.io.File

File("input.txt")
    .readLines()
    .map { it.split(" ") }
    .count { report ->
        report
            .map { it.toInt() }
            .windowed(2)
            .map { (left, right) ->
                left - right
            }
            .run {
                all { it in (-3..-1) } || all { it in (1..3) }
            }
    }
    .let(::println)
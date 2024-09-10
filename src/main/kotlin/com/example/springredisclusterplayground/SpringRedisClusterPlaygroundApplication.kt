package com.example.springredisclusterplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringRedisClusterPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<SpringRedisClusterPlaygroundApplication>(*args)
}

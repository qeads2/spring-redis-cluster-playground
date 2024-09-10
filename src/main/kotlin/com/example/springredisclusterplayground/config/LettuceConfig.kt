package com.example.springredisclusterplayground.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisClusterConfiguration
import org.springframework.data.redis.connection.RedisNode
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class LettuceConfig {
    fun getRedisHost(): List<String> {
        return listOf("127.0.0.1:6379", "127.0.0.1:6380", "127.0.0.1:6381")
    }

    @Bean
    fun redisConnectionFactory(): LettuceConnectionFactory {
        val config = RedisClusterConfiguration(getRedisHost())
        config.setClusterNodes(getRedisHost().map { host ->
            val split = host.split(":")
            RedisNode(split[0], split[1].toInt())
        })
        return LettuceConnectionFactory(config)
    }
    @Bean
    fun redisTemplate(): RedisTemplate<String, String> {
        val redisTemplate = RedisTemplate<String, String>()
        redisTemplate.connectionFactory = redisConnectionFactory()

        redisTemplate.keySerializer = StringRedisSerializer()
        redisTemplate.valueSerializer = StringRedisSerializer()
        return redisTemplate
    }
}
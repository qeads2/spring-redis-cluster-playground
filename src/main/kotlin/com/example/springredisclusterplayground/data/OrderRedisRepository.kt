package com.example.springredisclusterplayground.data

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class OrderRedisRepository(
    private val redisTemplate: RedisTemplate<String, String>
) {
    fun getOrders(): String? {
        return redisTemplate.opsForValue()
            .get("order:1")
    }

    fun setOrder(orderId: Int, itemId: Int) {
        redisTemplate.opsForValue()
            .set("order:$orderId", itemId.toString())
    }
}
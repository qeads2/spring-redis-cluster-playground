package com.example.springredisclusterplayground.service

import com.example.springredisclusterplayground.data.OrderRedisRepository
import com.example.springredisclusterplayground.data.OrderRepository
import com.example.springredisclusterplayground.domain.Orders
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderRedisRepository: OrderRedisRepository
) {
    fun getOrders(): String? {
        return orderRedisRepository.getOrders()
    }
    
    fun createOrder(itemId: Int) {
        orderRepository.save(Orders(itemId = itemId))
        orderRedisRepository.setOrder(1, itemId)
    }
}
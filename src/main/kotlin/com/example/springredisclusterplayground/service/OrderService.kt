package com.example.springredisclusterplayground.service

import com.example.springredisclusterplayground.data.OrderRepository
import com.example.springredisclusterplayground.domain.Orders
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {
    fun getOrders() = orderRepository.findAll()
    
    fun createOrder(itemId: Int) = orderRepository.save(Orders(itemId = itemId))
}
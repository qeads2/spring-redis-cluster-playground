package com.example.springredisclusterplayground.controller

import com.example.springredisclusterplayground.controller.dto.CreateOrderDto
import com.example.springredisclusterplayground.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping("/orders")
    fun getOrders() = orderService.getOrders()
    
    @PostMapping("/orders")
    fun createOrder(
        @RequestBody createOrderDto: CreateOrderDto
    ) = orderService.createOrder(createOrderDto.itemId)
}
package com.example.springredisclusterplayground.data

import com.example.springredisclusterplayground.domain.Orders
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Orders, Int> {
}
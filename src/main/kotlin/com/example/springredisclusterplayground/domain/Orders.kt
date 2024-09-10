package com.example.springredisclusterplayground.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Orders(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,
    @Column(name = "item_id")
    val itemId: Int,
)
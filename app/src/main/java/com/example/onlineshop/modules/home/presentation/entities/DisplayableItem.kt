package com.example.onlineshop.modules.home.presentation.entities

interface DisplayableItem{
        fun getItemId(): Long

        fun getItemHash(): Int
}
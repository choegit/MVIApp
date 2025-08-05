package com.example.mviapp

sealed class GreetingIntent {
    data class EnterName(val name: String) : GreetingIntent()
    object Greet: GreetingIntent()
}
package edu.iesam.superheroesdam.core

sealed class ErrorApp:Throwable() {
   object ServerError : ErrorApp()
   object InternetError : ErrorApp()
}
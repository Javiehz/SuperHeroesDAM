package edu.iesam.superheroesdam.core

sealed class ErrorApp:Throwable() {
   object ServerErrorApp : ErrorApp()
   object InternetError : ErrorApp()
}
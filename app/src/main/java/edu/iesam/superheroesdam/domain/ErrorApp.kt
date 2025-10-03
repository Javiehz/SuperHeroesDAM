package edu.iesam.superheroesdam.domain
sealed class ErrorApp:Throwable() {
   object ServerErrorApp : ErrorApp()
   object InternetError : ErrorApp()
}
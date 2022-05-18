package com.example.filmescoroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    fun getFilmes(callback: (filmes: List<Filmes>) -> Unit) {
        Thread(
            Runnable {
                Thread.sleep(3000)
                callback.invoke(
                    listOf(
                        Filmes(id = 1, titulo = "Filme o1"),
                        Filmes(id = 1, titulo = "Titulo 02")
                    )
                )
            }
        ).start()
    }

    suspend fun getFilmesCoroutines(): List<Filmes>{
        return withContext(Dispatchers.Default){
            delay(3000)
            listOf(
                Filmes(id = 1, titulo = "Filme o1"),
                Filmes(id = 1, titulo = "Titulo 02")
            )
        }
    }
}

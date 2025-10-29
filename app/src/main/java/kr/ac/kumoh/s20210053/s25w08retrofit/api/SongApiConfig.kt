package kr.ac.kumoh.s20210053.s25w08retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SongApiConfig {
    const val PROJECT_URL = "https://tsakcsrlpnlmabgnaxpi.supabase.co"
    const val SERVER_URL = "$PROJECT_URL/rest/v1/"
    const val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRzYWtjc3JscG5sbWFiZ25heHBpIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjE1NDY3NTQsImV4cCI6MjA3NzEyMjc1NH0.ed7IL_xVkzRmMuiX4AcQrXKLKo9_3QytxViTlhDm4yM"

    // Retrofit Singleton Instance
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // SongApi 인터페이스 구현체
    val songService: SongApi by lazy {
        retrofit.create(SongApi::class.java)
    }
}
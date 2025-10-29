package kr.ac.kumoh.s20210053.s25w08retrofit.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kr.ac.kumoh.s20210053.s25w08retrofit.model.Song
import kr.ac.kumoh.s20210053.s25w08retrofit.repository.SongRepository

class SongViewModel(
    private val repository: SongRepository = SongRepository()
) : ViewModel() {
    private val _songList = MutableStateFlow<List<Song>>(emptyList())
    // 코드가 간결해서 좋음
    val songList: StateFlow<List<Song>> = _songList
    // 이렇게 써도 됨
    // val songList = _songList.asStateFlow()
// 참조 변수가 추가되는 것을 막을 수 있음
//    val songList: StateFlow<List<Song>>
//        get() = _songList

    init {
        fetchSongs()
    }

    private fun fetchSongs() {
        viewModelScope.launch {
            try {
                val response = repository.getSongs()
                _songList.value = response
                Log.i("fetchSongs()", response.toString())
            } catch(e: Exception) {
                Log.e("fetchSongs()", e.toString())
            }
        }
    }
}
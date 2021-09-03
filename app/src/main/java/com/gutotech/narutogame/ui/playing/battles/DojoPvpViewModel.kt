package com.gutotech.narutogame.ui.playing.battles

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gutotech.narutogame.data.repository.DojoWaitingRoomRepository

class DojoPvpViewModel : ViewModel() {
    private val repository = DojoWaitingRoomRepository.getInstance()

    fun getTotalPlayers(): LiveData<Long> {
        return repository.totalPlayersInQueue
    }
}
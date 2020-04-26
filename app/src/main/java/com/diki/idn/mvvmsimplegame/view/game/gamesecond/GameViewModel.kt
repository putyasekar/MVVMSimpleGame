package com.diki.idn.mvvmsimplegame.view.game.gamesecond

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    var word = ""
    var score = 0
    private lateinit var wordList: MutableList<String>

    private fun refreshList() {
        wordList = mutableListOf(
            "apple",
            "dog",
            "cat",
            "food",
            "book",
            "pillow",
            "clothes",
            "country",
            "snack",
            "pencil",
            "dress",
            "toothbrush",
            "tooth",
            "plate",
            "fork",
            "jar",
            "laptop",
            "bed",
            "table",
            "cable",
            "snail",
            "soap",
            "bag"
        )
        wordList.shuffle()
    }

    fun onSkip() {
        score--
        nextClue()
    }

    fun onCorrect() {
        score++
        nextClue()
    }

    private fun nextClue() {
        if (wordList.isEmpty()) {
            word = wordList.removeAt(0)
        }
    }

    init {
        Log.i("View Model For Game", "Created!")
        refreshList()
        nextClue()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("View Model For Game", "Destroyed!")
    }
}
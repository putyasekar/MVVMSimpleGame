package com.diki.idn.mvvmsimplegame.view.game.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    var score = finalScore

    init {
        Log.i("ScoreVM", "Final Score is $finalScore")
    }
}
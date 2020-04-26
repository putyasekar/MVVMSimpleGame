package com.diki.idn.mvvmsimplegame.view.game.gamesecond

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.diki.idn.mvvmsimplegame.R
import com.diki.idn.mvvmsimplegame.databinding.FragmentGameBinding
import com.diki.idn.mvvmsimplegame.view.GameFragmentDirections

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    private lateinit var dataBindingGame: FragmentGameBinding
    private lateinit var gameViewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        // Inflate the layout for this fragment
        dataBindingGame =
            DataBindingUtil.inflate(inflater,
                R.layout.fragment_game, container, false)
        Log.i("Game Fragment", "Called Providers")

        dataBindingGame.gotItButton.setOnClickListener { onCorrectAnswers() }
        dataBindingGame.skip.setOnClickListener { onSkipAnswers() }
        dataBindingGame.endGame.setOnClickListener { onEndGame() }
        updateScored()
        updateWords()
        return dataBindingGame.root //root agar jd default dataBinding
    }

    private fun updateWords() {
        dataBindingGame.wordText.text = gameViewModel.word
    }

    private fun updateScored() {
        dataBindingGame.scoreText.text = gameViewModel.score.toString()
    }

    private fun onEndGame() {
        gameEnded()
    }

    private fun gameEnded() {
        val action =
            GameFragmentDirections.actionGameDestinationToScoreDestination()
        action.score = gameViewModel.score
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun onSkipAnswers() {
        gameViewModel.onSkip()
        updateWords()
        updateScored()
    }

    private fun onCorrectAnswers() {
        gameViewModel.onCorrect()
        updateWords()
        updateScored()
    }
}
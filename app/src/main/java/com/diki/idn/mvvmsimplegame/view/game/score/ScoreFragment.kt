package com.diki.idn.mvvmsimplegame.view.game.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.diki.idn.mvvmsimplegame.R
import com.diki.idn.mvvmsimplegame.databinding.FragmentScoreBinding
import com.diki.idn.mvvmsimplegame.fragment.ScoreFragmentArgs

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {
    private lateinit var scoreViewModel: ScoreViewModel
    private lateinit var scoreViewModelFactory: ScoreViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBindingScore: FragmentScoreBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)
        scoreViewModelFactory =
            ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments!!).score)
        scoreViewModel = ViewModelProviders.of(this, scoreViewModelFactory)
            .get(ScoreViewModel::class.java)

        return dataBindingScore.root
    }

}

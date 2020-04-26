package com.diki.idn.mvvmsimplegame.view.game.opening

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.diki.idn.mvvmsimplegame.R
import com.diki.idn.mvvmsimplegame.databinding.FragmentOpeningBinding
import com.diki.idn.mvvmsimplegame.fragment.OpeningFragmentDirections

/**
 * A simple [Fragment] subclass.
 */
class OpeningFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBindingOpening: FragmentOpeningBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_opening, container, false)
        // Inflate the layout for this fragment

        dataBindingOpening.playGameButton.setOnClickListener {
            findNavController().navigate(
                OpeningFragmentDirections.actionOpeningDestinationToGameDestination2()
            )
        }
        return dataBindingOpening.root
    }
}
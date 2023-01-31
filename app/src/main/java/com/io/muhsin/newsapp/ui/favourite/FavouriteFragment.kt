package com.io.muhsin.newsapp.ui.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.io.muhsin.newsapp.R
import com.io.muhsin.newsapp.databinding.FragmentDetailsBinding
import com.io.muhsin.newsapp.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment() {


    private lateinit var binding: FragmentFavouriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


}
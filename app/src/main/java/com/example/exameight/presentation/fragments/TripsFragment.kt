package com.example.exameight.presentation.fragments

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.exameight.R
import com.example.exameight.data.common.Resource
import com.example.exameight.databinding.FragmentTripsBinding
import com.example.exameight.presentation.CustomPageTransformer
import com.example.exameight.presentation.adapter.TripsAdapter
import com.example.exameight.presentation.base.BaseFragment
import com.example.exameight.presentation.viewModels.TripsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class TripsFragment : BaseFragment<FragmentTripsBinding>(FragmentTripsBinding::inflate) {


    private lateinit var tripsAdapter: TripsAdapter
    private val viewModel: TripsViewModel by viewModels()
    override fun setUp() {
        initPager()
        viewModel.getTripList()
        bindObserves()
    }

    override fun listeners() {

    }

    private fun initPager(){
        tripsAdapter = TripsAdapter()
        binding.apply {
            binding.viewPager.adapter = tripsAdapter
            val transformer = CustomPageTransformer()
            viewPager.setPageTransformer(transformer)
            binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.tripsFlow.collect() {
                    when (it) {

                        is Resource.Loading -> {
                            binding.pbTrips.visibility = View.VISIBLE
                        }

                        is Resource.Success -> {
                            binding.pbTrips.visibility = View.GONE
                            val tripsList = it.responseData
                            tripsAdapter.submitList(tripsList)

                        }

                        is Resource.Failed -> {
                            binding.pbTrips.visibility = View.GONE
                            val errorMessage = it.message
                            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT)
                                .show()

                        }

                    }
                }
            }
        }
    }

}
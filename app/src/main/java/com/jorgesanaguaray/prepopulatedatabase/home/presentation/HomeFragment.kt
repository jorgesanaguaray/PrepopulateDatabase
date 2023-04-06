package com.jorgesanaguaray.prepopulatedatabase.home.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import com.jorgesanaguaray.prepopulatedatabase.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this).get()
        homeAdapter = HomeAdapter()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                homeViewModel.homeState.collect {
                    setUpViews(it)
                }
            }
        }

        binding.mSwipeRefresh.setOnRefreshListener {
            homeViewModel.getUsers()
            binding.mSwipeRefresh.isRefreshing = false
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpViews(homeState: HomeState) {

        homeAdapter.setUsers(homeState.users)
        binding.mRecyclerView.adapter = homeAdapter

        if (homeState.isContent) binding.mRecyclerView.visibility = View.VISIBLE
        else binding.mRecyclerView.visibility = View.GONE

        if (homeState.isLoading) binding.mProgressBar.visibility = View.VISIBLE
        else binding.mProgressBar.visibility = View.GONE

    }

}
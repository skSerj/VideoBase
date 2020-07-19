package com.videobase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.videobase.network.ShowsApi
import com.videobase.network.ShowsRepository
import kotlinx.android.synthetic.main.shows_fragment.*

class ShowsFragment : Fragment() {

    private lateinit var factory: ShowsViewModelFactory
    private lateinit var viewModel: ShowsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shows_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = ShowsApi()
        val repository = ShowsRepository(api)
        factory = ShowsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(ShowsViewModel::class.java)
        viewModel.getShows()
        viewModel.shows.observe(viewLifecycleOwner, Observer {shows->
            recycler_view_shows.also{
                it.layoutManager = GridLayoutManager(requireContext(),2)
                it.setHasFixedSize(true)
                it.adapter = ShowsAdapter(shows)
            }
        })
    }
}
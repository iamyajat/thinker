package com.dscvit.thinker.ui.createdeck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dscvit.thinker.adapter.SearchResultsAdapter
import com.dscvit.thinker.databinding.FragmentSearchTopicBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchTopicFragment : Fragment() {

    private val searchTopicViewModel: SearchTopicViewModel by activityViewModels()
    private var _binding: FragmentSearchTopicBinding? = null
    private lateinit var searchResultsAdapter: SearchResultsAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSearchTopicBinding.inflate(inflater, container, false)
        val root: View = binding.root

        searchTopicViewModel.apply {
            searchResponse.observe(
                viewLifecycleOwner,
                {
                    if (it != null) {
                        binding.searchResultsRecyclerView.visibility = View.VISIBLE
                        searchResultsAdapter = SearchResultsAdapter(it)
                        binding.searchResultsRecyclerView.apply {
                            adapter = searchResultsAdapter
                            layoutManager = LinearLayoutManager(context)
                        }
                        searchResultsAdapter.apply {
                            dataSetChange(it)
                            notifyDataSetChanged()
                        }
                    }
                }
            )
            text.observe(
                viewLifecycleOwner,
                {
                    binding.textSearchTopic.text = it
                }
            )
        }

        binding.searchEditText.doOnTextChanged { text, start, before, count ->
            if (text != null && text.trim() != "") {
                searchTopicViewModel.getSearchResponse(text.toString().trim().replace(" ", "_"))
            } else {
                binding.searchResultsRecyclerView.visibility = View.GONE
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

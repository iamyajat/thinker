package com.dscvit.thinker.ui.createdeck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dscvit.thinker.R
import com.dscvit.thinker.databinding.FragmentSearchTopicBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SearchTopicFragment : Fragment() {

    private lateinit var searchTopicViewModel: SearchTopicViewModel
    private var _binding: FragmentSearchTopicBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchTopicViewModel =
            ViewModelProvider(this)[SearchTopicViewModel::class.java]

        _binding = FragmentSearchTopicBinding.inflate(inflater, container, false)
        val root: View = binding.root


        searchTopicViewModel.text.observe(
            viewLifecycleOwner,
            {
                binding.textSearchTopic.text = it
            }
        )
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

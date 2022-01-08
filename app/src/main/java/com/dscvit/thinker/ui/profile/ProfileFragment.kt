package com.dscvit.thinker.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.transform.CircleCropTransformation
import com.dscvit.thinker.R
import com.dscvit.thinker.databinding.FragmentProfileBinding
import com.dscvit.thinker.ui.settings.SettingsModalBottomSheet

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val modalBottomSheet = SettingsModalBottomSheet()
        binding.settingsButton.setOnClickListener {
            modalBottomSheet.show(parentFragmentManager, SettingsModalBottomSheet.TAG)
        }

        setupProfilePage()

        return root
    }

    private fun setupProfilePage() {
        profileViewModel.apply {
            username.observe(
                viewLifecycleOwner, {
                    binding.profileUsername.text = it
                }
            )
            bio.observe(
                viewLifecycleOwner, {
                    binding.profileBio.text = it
                }
            )
            name.observe(
                viewLifecycleOwner, {
                    binding.profileName.text = it
                }
            )
            imageUrl.observe(
                viewLifecycleOwner, {
                    binding.profileImage.load(it) {
                        crossfade(true)
                        placeholder(R.drawable.circle)
                        transformations(CircleCropTransformation())
                    }
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

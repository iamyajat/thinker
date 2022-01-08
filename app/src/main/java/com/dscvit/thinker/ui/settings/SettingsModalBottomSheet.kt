package com.dscvit.thinker.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dscvit.thinker.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SettingsModalBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.settings_fragment, container, false)
        if (savedInstanceState == null) {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
            childFragmentManager.executePendingTransactions()
        }
        return root
    }

    companion object {
        const val TAG = "SettingsModalBottomSheet"
    }
}
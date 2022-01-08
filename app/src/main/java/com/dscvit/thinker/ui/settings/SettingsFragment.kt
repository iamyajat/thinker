package com.dscvit.thinker.ui.settings

import android.content.Intent
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.dscvit.thinker.R
import com.dscvit.thinker.ui.AuthActivity
import com.google.firebase.auth.FirebaseAuth


class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        setupLogout()
    }

    private fun setupLogout() {
        val logoutPref: Preference? = findPreference("logout")
        logoutPref?.setOnPreferenceClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(context, AuthActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
            true
        }
    }
}

package com.example.nontonin.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.nontonin.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val welcomeTextView: TextView = binding.welcome
        welcomeTextView.text = "C030322027"

        val profileUsernameTextView: TextView = binding.profileUsernameText
        profileUsernameTextView.text = "Noor Rizky Permana"

        val linkedInButton: TextView = binding.linkedinButton
        linkedInButton.setOnClickListener{
            val linkedInUrl = "https://www.linkedin.com/in/noor-rizky-permana-965969269/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl))
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

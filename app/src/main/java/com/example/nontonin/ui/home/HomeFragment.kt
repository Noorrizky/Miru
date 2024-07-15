package com.example.nontonin.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nontonin.R
import com.example.nontonin.databinding.FragmentHomeBinding
import com.example.nontonin.ui.activity.ActivityDetails

class HomeFragment : Fragment(), HomeAdapter.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize RecyclerView
        val recyclerView: RecyclerView = binding.rvMenu
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Sample data with drawable resources
        val items = listOf(
            Item("Naruto", "Naruto Uzumaki, a young ninja, seeks recognition and dreams of becoming the Hokage.", R.drawable.sample_image),
            Item("Boruto", "Boruto Uzumaki, the son of Naruto, embarks on his own ninja journey.", R.drawable.sample_image),
            Item("Spy X Family", "A spy, an assassin, and a telepath form an unconventional family.", R.drawable.sample_image),
            Item("One Piece", "Monkey D. Luffy and his crew search for the legendary One Piece treasure.", R.drawable.sample_image),
            Item("Attack on Titan", "Eren Yeager and his friends fight against titanic creatures to save humanity.", R.drawable.sample_image),
            Item("Demon Slayer", "Tanjiro Kamado becomes a demon slayer to avenge his family and cure his sister.", R.drawable.sample_image),
            Item("My Hero Academia", "Izuku Midoriya, born without powers, still dreams of becoming a hero.", R.drawable.sample_image)
        )


        val adapter = HomeAdapter(items, this)
        recyclerView.adapter = adapter

        return root
    }

    override fun onItemClick(item: Item) {
        val intent = Intent(context, ActivityDetails::class.java).apply {
            putExtra(ActivityDetails.EXTRA_THUMBNAIL, item.imageResId)
            putExtra(ActivityDetails.EXTRA_TITLE, item.name)
            putExtra(ActivityDetails.EXTRA_RELEASE_DATE, "Sample Release Date")  // Adjust according to your data model
            putExtra(ActivityDetails.EXTRA_SYNOPSIS, item.description)
        }
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

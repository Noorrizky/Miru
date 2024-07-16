package com.example.nontonin.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nontonin.R
import com.example.nontonin.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: SearchAdapter
    private lateinit var items: List<SearchItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        items = listOf(
            SearchItem(R.drawable.sample_image, "Naruto", "2002", "Naruto Uzumaki, a young ninja, seeks recognition and dreams of becoming the Hokage."),
            SearchItem(R.drawable.sample_image, "Boruto", "2017", "Boruto Uzumaki, the son of Naruto, embarks on his own ninja journey."),
            SearchItem(R.drawable.sample_image, "Spy X Family", "2020", "A spy, an assassin, and a telepath form an unconventional family."),
            SearchItem(R.drawable.sample_image, "One Piece", "1999", "Monkey D. Luffy and his crew search for the legendary One Piece treasure."),
            SearchItem(R.drawable.sample_image, "Attack on Titan", "2013", "Eren Yeager and his friends fight against titanic creatures to save humanity."),
            SearchItem(R.drawable.sample_image, "Demon Slayer", "2019", "Tanjiro Kamado becomes a demon slayer to avenge his family and cure his sister."),
            SearchItem(R.drawable.sample_image, "My Hero Academia", "2016", "Izuku Midoriya, born without powers, still dreams of becoming a hero."),
            SearchItem(R.drawable.sample_image, "Jujutsu Kaisen", "2020", "Yuji Itadori joins a secret organization to battle supernatural threats."),
            SearchItem(R.drawable.sample_image, "Tokyo Revengers", "2021", "Takemichi Hanagaki travels back in time to save his loved ones from a gang."),
            SearchItem(R.drawable.sample_image, "Death Note", "2006", "Light Yagami gains a notebook with the power to kill anyone whose name is written in it."),
            SearchItem(R.drawable.sample_image, "Fullmetal Alchemist", "2003", "Two brothers use alchemy in their quest to restore their bodies."),
            SearchItem(R.drawable.sample_image, "Dragon Ball Z", "1989", "Goku and his friends defend Earth against powerful foes and seek the Dragon Balls.")
        )

        adapter = SearchAdapter(items)
        binding.rvSearch.layoutManager = LinearLayoutManager(context)
        binding.rvSearch.adapter = adapter

        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    performSearch(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun performSearch(query: String) {
        val filteredItems = items.filter {
            it.name.contains(query, ignoreCase = true) ||
                    it.description.contains(query, ignoreCase = true)
        }

        if(filteredItems.isEmpty()){
            Toast.makeText(requireContext(), "No results found.", Toast.LENGTH_SHORT).show()
        }else{
            adapter.updateData(filteredItems)
        }
    }
}

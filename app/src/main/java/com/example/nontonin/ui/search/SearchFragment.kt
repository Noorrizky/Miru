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
        val searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        items = listOf(
            SearchItem(R.drawable.sample_image, "2002", "Naruto", "Naruto Uzumaki, a young ninja, seeks recognition and dreams of becoming the Hokage."),
            SearchItem(R.drawable.sample_image, "2017", "Boruto", "Boruto Uzumaki, the son of Naruto, embarks on his own ninja journey."),
            SearchItem(R.drawable.sample_image, "2020", "Spy X Family", "A spy, an assassin, and a telepath form an unconventional family."),
            SearchItem(R.drawable.sample_image, "1999", "One Piece", "Monkey D. Luffy and his crew search for the legendary One Piece treasure."),
            SearchItem(R.drawable.sample_image, "2013", "Attack on Titan", "Eren Yeager and his friends fight against titanic creatures to save humanity."),
            SearchItem(R.drawable.sample_image, "2019", "Demon Slayer", "Tanjiro Kamado becomes a demon slayer to avenge his family and cure his sister."),
            SearchItem(R.drawable.sample_image, "2016", "My Hero Academia", "Izuku Midoriya, born without powers, still dreams of becoming a hero."),
            SearchItem(R.drawable.sample_image, "2020", "Jujutsu Kaisen", "Yuji Itadori joins a secret organization to battle supernatural threats."),
            SearchItem(R.drawable.sample_image, "2021", "Tokyo Revengers", "Takemichi Hanagaki travels back in time to save his loved ones from a gang."),
            SearchItem(R.drawable.sample_image, "2006", "Death Note", "Light Yagami gains a notebook with the power to kill anyone whose name is written in it."),
            SearchItem(R.drawable.sample_image, "2003", "Fullmetal Alchemist", "Two brothers use alchemy in their quest to restore their bodies."),
            SearchItem(R.drawable.sample_image, "1989", "Dragon Ball Z", "Goku and his friends defend Earth against powerful foes and seek the Dragon Balls.")
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
        adapter = SearchAdapter(filteredItems)
        binding.rvSearch.adapter = adapter
        Toast.makeText(requireContext(), "Searching for: $query", Toast.LENGTH_SHORT).show()
    }
}

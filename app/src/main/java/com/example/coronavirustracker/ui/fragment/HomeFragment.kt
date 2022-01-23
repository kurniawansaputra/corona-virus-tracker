package com.example.coronavirustracker.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.coronavirustracker.R
import com.example.coronavirustracker.databinding.FragmentHomeBinding
import com.example.coronavirustracker.ui.activity.MainActivity
import com.example.coronavirustracker.viewModel.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var positive: String
    private lateinit var addPositive: String
    private lateinit var death: String
    private lateinit var addDeath: String
    private lateinit var treated: String
    private lateinit var addTreated: String
    private lateinit var recovered: String
    private lateinit var addRecovered: String
    private lateinit var updatedAt: String
    private lateinit var homeViewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
        setTotal()
        swipeRefresh()
    }

    private fun setTotal() {
        homeViewModel.isRefresh.observe(viewLifecycleOwner, {
            setRefresh(it)
        })
        homeViewModel.total.observe(viewLifecycleOwner, {
            positive = it.update.total.jumlahPositif.toString()
            recovered = it.update.total.jumlahSembuh.toString()
            treated = it.update.total.jumlahDirawat.toString()
            death = it.update.total.jumlahMeninggal.toString()
            addPositive = it.update.penambahan.jumlahPositif.toString()
            addRecovered = it.update.penambahan.jumlahSembuh.toString()
            addTreated = it.update.penambahan.jumlahDirawat.toString()
            addDeath = it.update.penambahan.jumlahMeninggal.toString()
            updatedAt = it.update.penambahan.created

            binding.apply {
                textPositive.text = positive
                textTreated.text = treated
                textRecovered.text = recovered
                textDeath.text = death
                textAddPositive.text = "+$addPositive"
                textAddRecovered.text = "+$addRecovered"
                textAddTreated.text = "+$addTreated"
                textAddDeath.text = "+$addDeath"
                textUpdatedAt.text = updatedAt
            }
        })
    }

    private fun setRefresh(isRefresh: Boolean) {
        binding.swipeRefresh.isRefreshing = isRefresh
    }

    private fun swipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            homeViewModel.getTotal()
        }
    }

    private fun setListener() {
        binding.cardHospital.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_navigation_home_to_hospitalFragment) }
        }
        binding.buttonDetailMap.setOnClickListener {
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://covid19.go.id/peta-sebaran")
            startActivity(openUrl)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
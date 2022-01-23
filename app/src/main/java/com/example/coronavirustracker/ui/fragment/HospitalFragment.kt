package com.example.coronavirustracker.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.coronavirustracker.R
import com.example.coronavirustracker.adapter.HospitalAdapter
import com.example.coronavirustracker.databinding.FragmentHospitalBinding
import com.example.coronavirustracker.model.HospitalResponse
import com.example.coronavirustracker.viewModel.HospitalViewModel

class HospitalFragment : Fragment() {
    private lateinit var hospitalViewModel: HospitalViewModel

    private var _binding: FragmentHospitalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        hospitalViewModel =
            ViewModelProvider(this)[HospitalViewModel::class.java]
        // Inflate the layout for this fragment
        _binding = FragmentHospitalBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
        setHospital()
    }

    private fun setListener() {
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setHospital() {
        hospitalViewModel.isLoading.observe(viewLifecycleOwner, {
            setLoading(it)
        })
        hospitalViewModel.hospital.observe(viewLifecycleOwner, {
            val hospitalAdapter = HospitalAdapter(it as List<HospitalResponse>)
            binding.rvHospital.adapter = hospitalAdapter
            binding.rvHospital.setHasFixedSize(true)
        })
    }

    private fun setLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}
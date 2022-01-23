package com.example.coronavirustracker.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coronavirustracker.adapter.CaseAdapter
import com.example.coronavirustracker.databinding.FragmentInformationBinding
import com.example.coronavirustracker.model.ListDataItem
import com.example.coronavirustracker.viewModel.InformationViewModel

class InformationFragment : Fragment() {

    private lateinit var informationViewModel: InformationViewModel
    private var _binding: FragmentInformationBinding? = null
    private var provinceList: ArrayList<ListDataItem> = ArrayList()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        informationViewModel =
            ViewModelProvider(this)[InformationViewModel::class.java]

        _binding = FragmentInformationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCase()
    }

    private fun setCase() {
        informationViewModel.isLoading.observe(viewLifecycleOwner, {
            setLoading(it)
        })
        informationViewModel.case.observe(viewLifecycleOwner, {
            val caseAdapter = CaseAdapter(it.listData)
            binding.rvCase.adapter = caseAdapter
            binding.rvCase.setHasFixedSize(true)

            provinceList.addAll(it.listData)
        })
    }

    private fun setLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
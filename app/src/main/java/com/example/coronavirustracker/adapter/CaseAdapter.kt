package com.example.coronavirustracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coronavirustracker.databinding.ItemRowCaseBinding
import com.example.coronavirustracker.model.ListDataItem

class CaseAdapter(private val listCase: List<ListDataItem>):
    RecyclerView.Adapter<CaseAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemRowCaseBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowCaseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listCase[position]) {
                val province = key
                val positive = jumlahKasus
                val recovered = jumlahSembuh
                val death = jumlahMeninggal
                val addPositive = penambahan.positif
                val addRecovered = penambahan.sembuh
                val addDeath = penambahan.meninggal

                binding.apply {
                    textProvince.text = province
                    textPositive.text = positive.toString()
                    textAddPositive.text = "+$addPositive"
                    textRecovered.text = recovered.toString()
                    textAddRecovered.text = "+$addRecovered"
                    textDeath.text = death.toString()
                    textAddDeath.text = "+$addDeath"
                }
            }
        }
    }

    override fun getItemCount(): Int = listCase.size
}
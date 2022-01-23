package com.example.coronavirustracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coronavirustracker.R
import com.example.coronavirustracker.databinding.ItemRowHospitalBinding
import com.example.coronavirustracker.databinding.LayoutBottomSheetHospitalBinding
import com.example.coronavirustracker.model.HospitalResponse
import com.google.android.material.bottomsheet.BottomSheetDialog

class HospitalAdapter(private val listHospital: List<HospitalResponse>):
    RecyclerView.Adapter<HospitalAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemRowHospitalBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listHospital[position]) {
                val name = name
                val address = address
                val province = province
                val phone = phone

                binding.apply {
                    textName.text = name
                    textAddress.text = address

                    cardHospital.setOnClickListener {
                        val dialog = BottomSheetDialog(itemView.context, R.style.BottomSheetDialogTheme)
                        val bindingBottomSheetHospital = LayoutBottomSheetHospitalBinding.inflate(LayoutInflater.from(itemView.rootView.context))
                        dialog.setContentView(bindingBottomSheetHospital.root)

                        bindingBottomSheetHospital.apply {
                            textProvince.text = province
                            textName.text = name
                            textAddress.text = address
                            textPhone.text = phone
                        }

                        dialog.setCancelable(true)
                        dialog.show()
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = listHospital.size
}
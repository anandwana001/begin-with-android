package com.akshay.dragonballteam.DataBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.akshay.dragonballteam.BR
import com.akshay.dragonballteam.DragonTeamData
import com.akshay.dragonballteam.databinding.ListItemDataBindingBinding

/**
 * Created by akshaynandwana on
 * 07, May, 2020
 **/
class DragonTeamDataBingingAdapter(var teamList: List<DragonTeamData>) :
    RecyclerView.Adapter<DragonTeamDataBingingAdapter.DragonTeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonTeamViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemDataBindingBinding.inflate(layoutInflater, parent, false)
        return DragonTeamViewHolder(binding)
    }

    override fun getItemCount(): Int = teamList.size

    override fun onBindViewHolder(holder: DragonTeamViewHolder, position: Int) {
        holder.bind(teamList[position])
    }

    class DragonTeamViewHolder constructor(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dragonTeamData: DragonTeamData) {
            binding.setVariable(BR.dragonData, dragonTeamData)
        }
    }

}

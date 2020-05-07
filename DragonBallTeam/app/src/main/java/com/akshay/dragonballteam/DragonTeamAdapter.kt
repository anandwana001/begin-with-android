package com.akshay.dragonballteam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by akshaynandwana on
 * 07, May, 2020
 **/
class DragonTeamAdapter(var teamList: List<DragonTeamData>, var context: Context) :
    RecyclerView.Adapter<DragonTeamAdapter.DragonTeamViewHolder>() {

    class DragonTeamViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(
            dragonTeam: DragonTeamData,
            context: Context
        ) {
            view.charNameTv.text = dragonTeam.name
            Glide.with(context)
                .load(dragonTeam.image)
                .into(view.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonTeamViewHolder {
        return DragonTeamViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = teamList.size

    override fun onBindViewHolder(holder: DragonTeamViewHolder, position: Int) {
        holder.bind(teamList[position], context)
    }

}

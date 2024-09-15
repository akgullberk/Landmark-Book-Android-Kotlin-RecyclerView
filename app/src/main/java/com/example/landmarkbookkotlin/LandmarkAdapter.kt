package com.example.landmarkbookkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.landmarkbookkotlin.databinding.RecyclerRowBinding

class LandmarkAdapter(val landmarkList : ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {

    class LandmarkHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder { //viewHolder ilk oluştuğunda ne yapacak
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkHolder(binding)
    }

    override fun getItemCount(): Int {  //kaç tane oluşturacağız
        return landmarkList.size
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) { //bağlandıktan sonra ne olacak
        holder.binding.recyclerViewTextView.text = landmarkList.get(position).name

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList.get(position))
            MySingleton.chosenLandmark = landmarkList.get(position)
            holder.itemView.context.startActivity(intent)
        }
    }
}
package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.days16response.DataItem
import com.example.weatherapp.days16response.Next16DaysResponse
import kotlinx.android.synthetic.main.recycler_view2.view.*

class Next16Adapter(val list1: List<DataItem>):
    RecyclerView.Adapter<Next16Adapter.UserViewHolder>() {

    var onItemClick: ((user: DataItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_view2,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list1.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list1[position])
    }

    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(user: DataItem) {
            itemView.apply {
                date.text = user.datetime.toString()
                temprature.text = "Temprature:" + user.temp.toString()
                mintemp.text = "Min Temp:" + user.minTemp.toString()
                maxtemp.text =  "Max Temp:" + user.maxTemp.toString()
                wind.text = "Wind:" + user.windDir.toString()
                setOnClickListener{
                    onItemClick?.invoke(user)
                }
            }
        }
    }
}

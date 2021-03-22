package space.basyk.changemoney.screen.start

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.money_item.view.*
import space.basyk.changemoney.R
import space.basyk.changemoney.model.nal.PrivatMoneyItem

class StartAdapter:RecyclerView.Adapter<StartAdapter.MyViewHolder>() {

    private var listMoney = emptyList<PrivatMoneyItem>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.money_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tv_title.text = listMoney[position].ccy
        holder.itemView.tv_rate.text = listMoney[position].buy
        holder.itemView.tv_date.text = listMoney[position].sale
    }

    override fun getItemCount(): Int {
        return listMoney.size
    }
    fun setList(list: List<PrivatMoneyItem>){
        listMoney = list
        notifyDataSetChanged()
    }
}
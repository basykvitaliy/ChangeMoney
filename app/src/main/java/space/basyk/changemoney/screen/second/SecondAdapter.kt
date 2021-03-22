package space.basyk.changemoney.screen.second

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.money_item.view.*
import space.basyk.changemoney.R
import space.basyk.changemoney.model.beznal.BeznalModelItem

class SecondAdapter: RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {

    private var listbeznal = emptyList<BeznalModelItem>()

    class SecondViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.money_item, parent, false)
        return SecondViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.itemView.tv_title.text = listbeznal[position].ccy
        holder.itemView.tv_rate.text = listbeznal[position].buy
        holder.itemView.tv_date.text = listbeznal[position].sale
    }

    override fun getItemCount(): Int {
        return listbeznal.size
    }

    fun setList(list: List<BeznalModelItem>){
        listbeznal = list
        notifyDataSetChanged()
    }
}
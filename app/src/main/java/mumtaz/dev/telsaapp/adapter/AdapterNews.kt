package mumtaz.dev.telsaapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mumtaz.dev.telsaapp.databinding.ItemNewsBinding
import mumtaz.dev.telsaapp.model.GetAllNewsResponseItem

class AdapterNews(private val onCLick: (GetAllNewsResponseItem)-> Unit): RecyclerView.Adapter<AdapterNews.ViewHolder>() {
    private var listNews : List<GetAllNewsResponseItem>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setDataNews(list: List<GetAllNewsResponseItem>){
        this.listNews = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(listNews!![position]){
                binding.tvJudul.text = judul
                binding.tvRilis.text = rilis


            }
        }
        holder.binding.itemNews.setOnClickListener { onCLick(listNews!![position]) }
    }

    override fun getItemCount(): Int {
        return if (listNews.isNullOrEmpty()){
            0
        }else{
            listNews!!.size
        }
    }
}
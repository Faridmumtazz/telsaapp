package mumtaz.dev.telsaapp.adapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mumtaz.dev.telsaapp.databinding.ItemActivityBinding
import mumtaz.dev.telsaapp.model.GetAllActivityResponseItem

class AdapterActivity(private val onClick: (GetAllActivityResponseItem)->Unit):RecyclerView.Adapter<AdapterActivity.ViewHolder>() {
    private var listActivity: List<GetAllActivityResponseItem>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setDataActivity(list: List<GetAllActivityResponseItem>){
        this.listActivity = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemActivityBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemActivityBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(listActivity!![position]){
                binding.tvJudul.text = judul
                binding.tvRilis.text = rilis
            }
        }
        holder.binding.itemActivity.setOnClickListener { onClick(listActivity!![position]) }
    }

    override fun getItemCount(): Int {
        return if (listActivity.isNullOrEmpty()){
            0
        }else{
            listActivity!!.size
        }
    }

}
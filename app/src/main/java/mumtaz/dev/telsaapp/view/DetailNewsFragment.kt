package mumtaz.dev.telsaapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import mumtaz.dev.telsaapp.R
import mumtaz.dev.telsaapp.databinding.FragmentDetailNewsBinding
import mumtaz.dev.telsaapp.model.GetAllNewsResponseItem


class DetailNewsFragment : Fragment(R.layout.fragment_detail_news)  {

    private var fragmentDetailNewsBinding: FragmentDetailNewsBinding?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailNewsBinding.bind(view)
        fragmentDetailNewsBinding = binding

        getAllNewsDetail()
    }

    @Suppress("DEPRECATION")
    @SuppressLint("SetTextI18n")
    fun getAllNewsDetail(){
        if (requireArguments().containsKey("NEWSDATA")){
            val newsDetail = arguments?.getSerializable("NEWSDATA") as GetAllNewsResponseItem

            fragmentDetailNewsBinding!!.tvJudulDetailNews.text = newsDetail.judul
            fragmentDetailNewsBinding!!.tvRilisDetailNews.text = newsDetail.rilis
            fragmentDetailNewsBinding!!.tvDescDetailNews.text = newsDetail.description
        }
    }


}
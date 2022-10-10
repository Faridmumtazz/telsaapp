package mumtaz.dev.telsaapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mumtaz.dev.telsaapp.R
import mumtaz.dev.telsaapp.databinding.FragmentDetailActivityBinding
import mumtaz.dev.telsaapp.databinding.FragmentDetailNewsBinding
import mumtaz.dev.telsaapp.model.GetAllActivityResponseItem
import mumtaz.dev.telsaapp.model.GetAllNewsResponseItem


class DetailActivityFragment : Fragment(R.layout.fragment_detail_activity) {

    private var fragmentDetailActivityBinding: FragmentDetailActivityBinding?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailActivityBinding.bind(view)
        fragmentDetailActivityBinding = binding

        getAllActivityDetail()
    }

    @Suppress("DEPRECATION")
    @SuppressLint("SetTextI18n")
    fun getAllActivityDetail(){
        if (requireArguments().containsKey("ACTIVITYDATA")){
            val newsDetail = arguments?.getSerializable("ACTIVITYDATA") as GetAllActivityResponseItem

            fragmentDetailActivityBinding!!.tvJudulDetailActivity.text = newsDetail.judul
            fragmentDetailActivityBinding!!.tvRilisDetailActivity.text = newsDetail.rilis
            fragmentDetailActivityBinding!!.tvDescDetailActivity.text = newsDetail.description
        }
    }


}
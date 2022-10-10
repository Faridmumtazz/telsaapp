package mumtaz.dev.telsaapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import mumtaz.dev.telsaapp.R
import mumtaz.dev.telsaapp.adapter.AdapterActivity
import mumtaz.dev.telsaapp.adapter.AdapterNews
import mumtaz.dev.telsaapp.databinding.FragmentHomeBinding
import mumtaz.dev.telsaapp.viewmodel.ActivityApiViewModel
import mumtaz.dev.telsaapp.viewmodel.NewsApiViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterNews: AdapterNews
    private lateinit var adapterActivity: AdapterActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initRecyclerview()
        getNewsDataViewModel()
        initRecyclerView()
        getActivityDataViewModel()

        return binding.root
    }

    private fun initRecyclerview(){
        _binding!!.rvNews.layoutManager = LinearLayoutManager(requireContext())
        AdapterNews {
            val clickedNews = bundleOf("NEWSDATA" to it)
            with(Navigation) {
                findNavController(requireView())
                    .navigate(R.id.action_homeFragment_to_detailNewsFragment, clickedNews)
            }
        }.also { adapterNews = it }
        _binding!!.rvNews.adapter = adapterNews
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getNewsDataViewModel(){
        val viewModel = ViewModelProvider(requireActivity())[NewsApiViewModel::class.java]
        viewModel.getLiveNewsObserver().observe(requireActivity()){
            if (it != null){
                adapterNews.setDataNews(it)
                adapterNews.notifyDataSetChanged()
            }
        }
        viewModel.getAllNewsApi()
    }

    private fun initRecyclerView(){
        _binding!!.rvActivity.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapterActivity = AdapterActivity {
            val clickedActivity = bundleOf("ACTIVITYDATA" to it)
            Navigation.findNavController(requireView())
                .navigate(R.id.action_homeFragment_to_detailActivityFragment, clickedActivity)
        }
        _binding!!.rvActivity.adapter = adapterActivity
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getActivityDataViewModel(){
        val viewModel = ViewModelProvider(requireActivity())[ActivityApiViewModel::class.java]
        viewModel.getLiveActivityObserver().observe(requireActivity()){
            if (it != null){
                adapterActivity.setDataActivity(it)
                adapterActivity.notifyDataSetChanged()
            }
        }
        viewModel.getAllActivityApi()
    }


}
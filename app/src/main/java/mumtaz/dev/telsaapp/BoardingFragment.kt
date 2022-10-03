package mumtaz.dev.telsaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import mumtaz.dev.telsaapp.databinding.ActivityMainBinding
import mumtaz.dev.telsaapp.databinding.FragmentBoardingBinding


class BoardingFragment : Fragment(),View.OnClickListener {

    private var _binding: FragmentBoardingBinding?= null
    private val binding get() =_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBoardingBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnExplore.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_explore -> {
                p0.findNavController().navigate(R.id.action_boardingFragment_to_loginFragment)
            }
        }
    }


}
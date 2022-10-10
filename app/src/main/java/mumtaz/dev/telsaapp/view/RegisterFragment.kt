package mumtaz.dev.telsaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import mumtaz.dev.telsaapp.R
import mumtaz.dev.telsaapp.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment(),View.OnClickListener {

    private var _binding: FragmentRegisterBinding?= null
    private val binding get() =_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegister.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_register -> {
                p0.findNavController().navigate(R.id.action_registerFragment_to_loginFragment2)
            }
        }
    }


}
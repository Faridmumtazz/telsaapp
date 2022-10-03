package mumtaz.dev.telsaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import mumtaz.dev.telsaapp.databinding.FragmentBoardingBinding
import mumtaz.dev.telsaapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() ,View.OnClickListener{

    private var _binding: FragmentLoginBinding?= null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener(this)
        binding.btnSignup.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_login -> {
                p0.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
            R.id.btn_signup -> {
                p0.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }


}
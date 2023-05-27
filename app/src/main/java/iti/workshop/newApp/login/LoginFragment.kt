package iti.workshop.newApp.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import iti.workshop.data.source.remote.models.login.LoginBody
import iti.workshop.data.source.remote.models.regieter.RegisterBody
import iti.workshop.newApp.R
import iti.workshop.newApp.databinding.FragmentLoginBinding
import iti.workshop.newApp.registration.RegistrationViewModel
import iti.workshop.newApp.states.LoginState
import iti.workshop.newApp.states.RegisterState
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    val viewModel: LoginViewModel by viewModels { LoginViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpTxtView.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment2)

        }

        binding.buttonlogin.setOnClickListener{
            login()
        }
        binding.checkBoxLogin.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(activity, "Check Box is Enable", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Check Box is Disable", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun login() {
        val email: String = binding.emailloginEditTxt.getText().toString()
        val password: String = binding.passwordloginEditTxt.getText().toString()


        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val isEmailValid = email.matches(emailPattern.toRegex())

        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        val isPasswordValid = password.matches(passwordPattern.toRegex())
        if (!isEmailValid || !isPasswordValid) {
              lifecycleScope.launch {
                  viewModel.logInUser(LoginBody(email,password, false))
                  viewModel.loginStatus.collect {
                      when (it) {
                          is LoginState.Success -> {
                              Toast.makeText(requireContext(), "Done", Toast.LENGTH_LONG).show()
                              Log.i("TAG2", "DONE: ")
                              findNavController().navigate(R.id.action_loginFragment_to_newsListFragment)
                          }

                          is LoginState.Loading -> {
                              Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG)
                                  .show()
                              Log.i("TAG2", "LOADING: ")

                          }

                          is LoginState.Failure -> {
                             Toast.makeText(
                                  requireContext(), "Credential  not valide", Toast.LENGTH_LONG
                              ).show()
                              Log.i("TAG2", "${it.error.toString()}")

                          }

                          else -> {
                              println("TEEEE")
                          }
                      }
                  }

              }
           } else {
               Toast.makeText(activity, "All Fields Required", Toast.LENGTH_SHORT).show()
           }

      /*  val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val isEmailValid = email.matches(emailPattern.toRegex())

        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        val isPasswordValid = password.matches(passwordPattern.toRegex())
        if (!isEmailValid || !isPasswordValid) {
            //  binding.emailloginEditTxt.error = "Invalid email address"
            Toast.makeText(activity, "invalide input", Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(activity, email, Toast.LENGTH_SHORT).show()

        }*/

    }

}
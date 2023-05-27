package iti.workshop.newApp.registration

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import iti.workshop.data.source.remote.models.regieter.RegisterBody
import iti.workshop.newApp.MainActivity
import iti.workshop.newApp.R
import iti.workshop.newApp.helpers.ValidationReg
import iti.workshop.newApp.states.RegisterState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RegistrationFragment : Fragment() {
lateinit var userName:EditText
lateinit var password:EditText
lateinit var confPassword:EditText
lateinit var email:EditText
lateinit var submit:Button
val viewModel: RegistrationViewModel by viewModels { RegistrationViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        submit.setOnClickListener(View.OnClickListener {
            if (ValidationReg.validateData(password.text.toString(),email.text.toString(),confPassword.text.toString())){
                lifecycleScope.launch {
                    viewModel.regUser(RegisterBody(userName.text.toString(),email.text.toString(),password.text.toString(),false))
                    viewModel.regbool.collect{
                        when(it){
                            is RegisterState.Success->{
                                Toast.makeText(requireContext(),"Done",Toast.LENGTH_LONG).show()
                                Log.i("TAG2", "DONE: ")
                            }
                            is RegisterState.Loading->{
                                Toast.makeText(requireContext(),"Loading",Toast.LENGTH_LONG).show()
                                Log.i("TAG2", "LOADING: ")

                            }
                            is RegisterState.Failure->{
                                Toast.makeText(requireContext(),"${it.error.toString()}",Toast.LENGTH_LONG).show()
                                Log.i("TAG2", "${it.error.toString()}")

                            }
                            else->{
                                println("TEEEE")
                            }
                        }
                    }

                }



            }else{

            }
        })
    }
fun init(view:View){
    userName=view.findViewById(R.id.userName)
    password=view.findViewById(R.id.passWord)
    email=view.findViewById(R.id.email)
    submit=view.findViewById(R.id.submit)
    confPassword=view.findViewById(R.id.confPassword)

}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

}
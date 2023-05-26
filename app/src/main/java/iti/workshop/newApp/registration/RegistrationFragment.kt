package iti.workshop.newApp.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import iti.workshop.newApp.R
import iti.workshop.newApp.helpers.ValidationReg

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
lateinit var userName:EditText
lateinit var password:EditText
lateinit var confPassword:EditText
lateinit var email:EditText
lateinit var submit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        submit.setOnClickListener(View.OnClickListener {
            if (ValidationReg.validateData(password.text.toString(),email.text.toString(),confPassword.text.toString())){

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

}
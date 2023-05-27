package iti.workshop.newApp.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import iti.workshop.newApp.R
import iti.workshop.newApp.databinding.FragmentNewsListBinding
import iti.workshop.newApp.registration.RegistrationViewModel
import iti.workshop.newApp.states.NewsState
import iti.workshop.newApp.states.RegisterState
import kotlinx.coroutines.launch


class NewsListFragment : Fragment() {
    private val viewModel: NewsListViewModel by viewModels { NewsListViewModel.Factory }

    lateinit var binding: FragmentNewsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewsListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch{
            viewModel.updateNews()
            viewModel.newsStatus.collect {
                when (it) {
                    is NewsState.Success -> {
                        binding.header.text= it.data[0].title
                        Log.i("TAG2", "Success")
                    }

                    is NewsState.Loading -> {

                        Log.i("TAG2", "LOADING: ")

                    }

                    is NewsState.Failure -> {
                        Log.i("TAG2", it.error.toString())

                    }

                    else -> {
                        println("TEEEE")
                    }
                }
            }

        }
    }
}
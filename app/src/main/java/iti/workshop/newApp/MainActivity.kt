package iti.workshop.newApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import iti.workshop.data.source.Constants
import iti.workshop.newApp.di.AppDependency
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        // Set up the ActionBar with the NavController
        NavigationUI.setupActionBarWithNavController(this,navController)
        lifecycleScope.launchWhenCreated {
            AppDependency.getNewsUseCase.invoke(Constants.NEWS_API_KEY,"us").collect{
                print(it.size)
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        // Handle the navigation up button press
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}


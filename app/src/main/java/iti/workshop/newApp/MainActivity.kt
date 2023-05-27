package iti.workshop.newApp

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import iti.workshop.data.source.Constants
import iti.workshop.newApp.di.AppDependency
import kotlinx.coroutines.launch
import iti.workshop.data.source.shared.SharedManager

class MainActivity : AppCompatActivity() {
    lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration.Builder(R.id.logout)
            .build()
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        // Set up the ActionBar with the NavController
        NavigationUI.setupActionBarWithNavController(this,navController)
        lifecycleScope.launchWhenCreated {
            AppDependency.getNewsUseCase.invoke(Constants.NEWS_API_KEY,"us").collect{
                print(it.size)
            }
        }
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        // Handle the navigation up button press
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        menuInflater.inflate(R.menu.action_bar,menu)

        inflater.inflate(R.menu.home_menu, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            //-------------To Delete Plan Table -----------------------
            val sharedManager = SharedManager.getInstance(this)!!
            sharedManager.clearUser()
            this@MainActivity.finish()
        }
        when (item.itemId) {
            R.id.search -> {
                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                val navController = navHostFragment.navController
                navController.navigate(R.id.action_splashFragment_to_newsListFragment)
                return true
            }

            R.id.favourite -> //add the function to perform here
            {
                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                val navController = navHostFragment.navController
                navController.navigate(R.id.action_splashFragment_to_newsListFragment)
                return true

            }





        }
        return super.onOptionsItemSelected(item)
    }
}


package space.basyk.changemoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import space.basyk.changemoney.data.repository.Repository
import space.basyk.changemoney.databinding.ActivityMainBinding
import space.basyk.changemoney.utils.APP_ACTIVITY
import space.basyk.changemoney.utils.REPOSITORY

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding ?= null
    private val mBinding get() = binding!!
    lateinit var navController: NavController
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        REPOSITORY = Repository()
        navController = Navigation.findNavController(this, R.id.nav_host)
        bottomNavigationView = mBinding.bottomNavigationView
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
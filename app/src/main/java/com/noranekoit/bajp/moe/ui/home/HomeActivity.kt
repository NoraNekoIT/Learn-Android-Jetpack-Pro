package com.noranekoit.bajp.moe.ui.home


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.tabs.TabLayoutMediator
import com.noranekoit.bajp.moe.databinding.ActivityHomeBinding

private val typeMoe = arrayOf(
    "Movie",
    "Tv Show"
)

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        val viewPager = activityHomeBinding.viewPager
        val tabLayout = activityHomeBinding.tabs
        val adapter = SectionsPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = typeMoe[position]
        }.attach()

    }


}



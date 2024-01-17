package com.novelitech.tablayoutwithviewpagertwokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.novelitech.tablayoutwithviewpagertwokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val images = listOf(
            R.drawable.naruto1,
            R.drawable.naruto2,
            R.drawable.naruto3,
            R.drawable.naruto4,
            R.drawable.naruto5,
            R.drawable.naruto6,
        )

        val adapter = ViewPagerAdapter(images)

        binding.viewPager2.adapter = adapter

        /**
         * As I am using ViewPager2, I need to use this Mediator to link Tab and ViewPager.
         * In the and I need to call .attach() to really connect both features.
         *
         * If I was using ViewPager (normal), I would do the link by the method: binding.tabLayout.setupWithViewPager()
         */
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = "Tab $position"
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d("TAB", "SELECTED ${tab?.text}")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("TAB", "UNSELECTED ${tab?.text}")
            }

            // If I'm in Tab1 and click again in Tab1
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("TAB", "RESELECTED ${tab?.text}")
            }
        })
    }
}
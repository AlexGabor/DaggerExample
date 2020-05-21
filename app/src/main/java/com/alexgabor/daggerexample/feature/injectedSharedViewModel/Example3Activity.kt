package com.alexgabor.daggerexample.feature.injectedSharedViewModel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexgabor.daggerexample.databinding.ExamplePagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class Example3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ExamplePagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = Example3PagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
            tab.text = "Fragment ${(position + 1)}"
        }.attach()

        @SuppressLint("SetTextI18n")
        binding.description.text = """
              You can get either the activity view model or the fragments view model 
        """.trimIndent()
    }
}
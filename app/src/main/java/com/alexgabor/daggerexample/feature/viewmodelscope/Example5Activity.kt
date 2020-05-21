package com.alexgabor.daggerexample.feature.viewmodelscope

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexgabor.daggerexample.databinding.ExamplePagerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Example5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ExamplePagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabs.tabMode = TabLayout.MODE_SCROLLABLE
        binding.pager.adapter = Example5PagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
            tab.text = "Fragment ${(position + 1)}"
        }.attach()

        @SuppressLint("SetTextI18n")
        binding.description.text = """
            Since ViewModelRepo is scoped on the view model there will be a single instance of it in the dependency graph of the view model
        """.trimIndent()
    }
}
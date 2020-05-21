package com.alexgabor.daggerexample.feature

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexgabor.daggerexample.databinding.MainActivityBinding
import com.alexgabor.daggerexample.feature.assistedInject.Example4Activity
import com.alexgabor.daggerexample.feature.injectedSharedViewModel.Example3Activity
import com.alexgabor.daggerexample.feature.injectedViewModelInActivity.Example1Activity
import com.alexgabor.daggerexample.feature.injectedViewModelInFragment.Example2Activity
import com.alexgabor.daggerexample.feature.viewmodelscope.Example5Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.adapter = MainMenuAdapter().apply {
            setClickListener { onItemSelected(it.activity) }
            submitList(menuItems)
        }
    }

    private fun onItemSelected(activity: Class<out AppCompatActivity>) {
        startActivity(Intent(this, activity))
    }
}

private val menuItems = listOf(
    MainMenuAdapter.Item("Get a view model in activity", "Get a view model with injected constructor parameters", Example1Activity::class.java),
    MainMenuAdapter.Item("Get a view model in fragment", "Get a view model with injected constructor parameters", Example2Activity::class.java),
    MainMenuAdapter.Item("Get a shared view model in fragment", "Get a shared view model with injected constructor parameters", Example3Activity::class.java),
    MainMenuAdapter.Item("Get a view model with argument", "Get a view model with injected constructor parameters and late argument", Example4Activity::class.java),
    MainMenuAdapter.Item("Dependency scoped on a view model", "Example of view model scope", Example5Activity::class.java)
)
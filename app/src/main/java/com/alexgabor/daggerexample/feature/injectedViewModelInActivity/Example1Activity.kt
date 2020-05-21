package com.alexgabor.daggerexample.feature.injectedViewModelInActivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.alexgabor.daggerexample.databinding.ExampleBinding
import com.alexgabor.daggerexample.feature.StringAdapter
import com.alexgabor.daggerexample.util.viewModels
import com.alexgabor.daggerexample.util.viewModelComponent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class Example1Activity : AppCompatActivity() {

    private val viewModel: Example1ViewModel by viewModels { viewModelComponent.example1ViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logOutput.adapter = StringAdapter().apply {
            viewModel.logFlow.onEach {
                submitList(it)
            }.launchIn(lifecycleScope)
        }

        @SuppressLint("SetTextI18n")
        binding.description.text = """
            The view model maintains its lifecycle because the view model factory controls the instantiation of a view model even if it is part of dagger.  
        """.trimIndent()
    }
}
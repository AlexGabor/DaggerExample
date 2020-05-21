package com.alexgabor.daggerexample.feature.viewmodelscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.alexgabor.daggerexample.databinding.ExampleBinding
import com.alexgabor.daggerexample.feature.StringAdapter
import com.alexgabor.daggerexample.util.autoCleared
import com.alexgabor.daggerexample.util.viewModelComponent
import com.alexgabor.daggerexample.util.viewModels
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class Example5Fragment : Fragment() {

    private var binding: ExampleBinding by autoCleared()
    private val viewModel: Example5ViewModel by viewModels { viewModelComponent.example5ViewModel }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ExampleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logOutput.adapter = StringAdapter().apply {
            viewModel.logFlow.onEach {
                submitList(it)
            }.launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }
}
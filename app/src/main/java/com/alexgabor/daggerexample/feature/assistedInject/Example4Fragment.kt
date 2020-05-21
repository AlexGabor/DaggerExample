package com.alexgabor.daggerexample.feature.assistedInject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexgabor.daggerexample.databinding.ExampleInputBinding
import com.alexgabor.daggerexample.util.activityViewModels
import com.alexgabor.daggerexample.util.autoCleared
import com.alexgabor.daggerexample.util.viewModelComponent

class Example4Fragment : Fragment() {

    private var binding: ExampleInputBinding by autoCleared()
    private val sharedViewModel: Example4ViewModel by activityViewModels { viewModelComponent.example4ViewModel }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ExampleInputBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            sharedViewModel.sendMessage(binding.input.text.toString())
        }
    }
}
package com.alexgabor.daggerexample.feature.assistedInject

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.alexgabor.daggerexample.databinding.ExampleBinding
import com.alexgabor.daggerexample.feature.StringAdapter
import com.alexgabor.daggerexample.util.autoCleared
import com.alexgabor.daggerexample.util.viewModels
import com.alexgabor.daggerexample.util.viewModelComponent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class Example4FragmentWithArg : Fragment() {

    private var binding: ExampleBinding by autoCleared()
    private val viewModel: Example4ViewModelWithArg by viewModels { viewModelComponent.example4ViewModelFactory.create(requireArguments().message) }

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

        @SuppressLint("SetTextI18n")
        binding.description.text = """
                This one uses fragment's view model          
            """.trimIndent()
    }

    companion object {
        private const val POSITION = "POSITION"

        fun newInstance(message: String) = Example4FragmentWithArg().apply {
            arguments = Bundle().apply {
                this.message = message
            }
        }

        private var Bundle.message: String
            get() = getString(POSITION)!!
            set(value) {
                putString(POSITION, value)
            }
    }
}
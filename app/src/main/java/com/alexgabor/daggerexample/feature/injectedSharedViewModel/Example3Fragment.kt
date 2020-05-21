package com.alexgabor.daggerexample.feature.injectedSharedViewModel

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.alexgabor.daggerexample.databinding.ExampleBinding
import com.alexgabor.daggerexample.feature.StringAdapter
import com.alexgabor.daggerexample.util.activityViewModels
import com.alexgabor.daggerexample.util.autoCleared
import com.alexgabor.daggerexample.util.viewModels
import com.alexgabor.daggerexample.util.viewModelComponent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class Example3Fragment : Fragment() {

    private var binding: ExampleBinding by autoCleared()
    private val viewModel: Example3ViewModel by viewModels { viewModelComponent.example3ViewModel }
    private val sharedViewModel: Example3ActivityViewModel by activityViewModels { viewModelComponent.example3ActivityViewModel }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ExampleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logOutput.adapter = StringAdapter().apply {
            if (arguments?.position == 0) {
                viewModel.logFlow.onEach {
                    submitList(it)
                }.launchIn(viewLifecycleOwner.lifecycleScope)
            } else {
                sharedViewModel.logFlow.onEach {
                    submitList(it)
                }.launchIn(viewLifecycleOwner.lifecycleScope)
            }
        }

        @SuppressLint("SetTextI18n")
        binding.description.text = if (arguments?.position == 0) {
            """
                This one uses fragment's view model          
            """
        } else {
            """ 
                This one uses activity's shared view model
            """
        }.trimIndent()
    }

    companion object {
        private const val POSITION = "POSITION"

        fun newInstance(position: Int) = Example3Fragment().apply {
            arguments = Bundle().apply {
                this.position = position
            }
        }

        private var Bundle.position: Int
            get() = getInt(POSITION)
            set(value) {
                putInt(POSITION, value)
            }
    }
}
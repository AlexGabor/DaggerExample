package com.alexgabor.daggerexample.feature.assistedInject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.alexgabor.daggerexample.R
import com.alexgabor.daggerexample.util.viewModelComponent
import com.alexgabor.daggerexample.util.viewModels
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class Example4Activity : AppCompatActivity() {

    private val viewModel: Example4ViewModel by viewModels { viewModelComponent.example4ViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_fragment_container)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, Example4Fragment())
            }
        }

        viewModel.messageEvent.onEach { message ->
            supportFragmentManager.commit {
                replace(R.id.fragment_container, Example4FragmentWithArg.newInstance(message))
                addToBackStack(null)
            }
        }.launchIn(lifecycleScope)
    }
}

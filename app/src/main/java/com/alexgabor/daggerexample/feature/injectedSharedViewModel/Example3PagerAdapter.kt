package com.alexgabor.daggerexample.feature.injectedSharedViewModel

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class Example3PagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int) = Example3Fragment.newInstance(position)
}
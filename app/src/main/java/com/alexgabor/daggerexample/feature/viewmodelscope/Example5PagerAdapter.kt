package com.alexgabor.daggerexample.feature.viewmodelscope

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class Example5PagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = 5

    override fun createFragment(position: Int) = Example5Fragment()
}
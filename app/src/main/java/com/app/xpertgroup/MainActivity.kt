package com.app.xpertgroup

import android.os.Bundle
import android.transition.Fade
import androidx.appcompat.app.AppCompatActivity
import com.app.xpertgroup.ui.screens.MainNavigationController
import com.app.xpertgroup.ui.screens.home.HomeFragment
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), MainNavigationController {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchFragment(HomeFragment())
    }

    /**
     * Replaces the current fragment with the provided fragment.
     *
     * @param fragment The fragment to switch to.
     */
    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, fragment)
            .commit()
    }

    override fun navigateToHomeFragment() {
        switchFragment(HomeFragment().apply {
            enterTransition = Fade()
            exitTransition = Fade()
        })
    }
}
package com.alwan.capstoneprojectvbarbershop.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alwan.capstoneprojectvbarbershop.R
import com.alwan.capstoneprojectvbarbershop.databinding.ActivityMainBinding
import com.alwan.capstoneprojectvbarbershop.ui.camera.CameraARCoreActivity
import com.alwan.capstoneprojectvbarbershop.ui.history.BookingFragment
import com.alwan.capstoneprojectvbarbershop.ui.home.HomeFragment
import com.google.android.material.navigation.NavigationBarView
import com.snap.camerakit.support.app.CameraActivity


class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener,
    View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment())
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() = with(binding) {
        with(bnv.menu) {
            selectedItemId = R.id.menuHome
            setOnItemSelectedListener(this@MainActivity)
        }
        fab.setOnClickListener(this@MainActivity)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuHome -> loadFragment(HomeFragment())
            R.id.menuSearch -> {
                true
            }
            R.id.menuDiscover -> loadFragment(BookingFragment())
            R.id.menuAccount -> {
                true
            }
            else -> false
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.fab -> {
                val cameraIntent = Intent(this, CameraARCoreActivity::class.java)
                startActivity(cameraIntent)
            }
        }
    }


}
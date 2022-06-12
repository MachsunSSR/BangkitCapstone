package com.bangkit.ambroise.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bangkit.ambroise.R
import com.bangkit.ambroise.databinding.ActivityMainBinding
import com.bangkit.ambroise.ui.camera.ARCameraActivity
import com.bangkit.ambroise.ui.discover.DiscoverFragment
import com.bangkit.ambroise.ui.history.BookingFragment
import com.bangkit.ambroise.ui.home.HomeFragment
import com.bangkit.ambroise.ui.profile.ProfileFragment
import com.bangkit.ambroise.util.showToast
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener,
    View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setStatusBarColor(fragment)
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main, fragment)
                .commit()
            return true
        }
        return false
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setStatusBarColor(fragment: Fragment?) {
        if(fragment is HomeFragment){
            window.statusBarColor = getColor(R.color.primary)
            var flags = window.decorView.systemUiVisibility
            flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            window.decorView.systemUiVisibility = flags
        }else{
            window.statusBarColor = getColor(R.color.whiter)
            window.decorView.systemUiVisibility =  View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuHome -> loadFragment(HomeFragment())
            R.id.menuSearch -> loadFragment(DiscoverFragment())
            R.id.menuDiscover -> loadFragment(BookingFragment())
            R.id.menuAccount -> loadFragment(ProfileFragment())
            else -> false
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.fab -> {
                val cameraIntent = Intent(this, ARCameraActivity::class.java)
                startActivity(cameraIntent)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                showToast(getString(R.string.not_get_permission))
                finish()
            }
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    companion object {
        const val CAMERA_X_RESULT = 200
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
}
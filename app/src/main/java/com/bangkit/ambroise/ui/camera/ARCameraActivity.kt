package com.bangkit.ambroise.ui.camera

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.ambroise.R
import com.bangkit.ambroise.core.domain.entity.Haircut
import com.bangkit.ambroise.databinding.ActivityArcameraBinding
import com.bangkit.ambroise.util.DummyData
import com.bangkit.ambroise.util.showToast
import com.bangkit.ambroise.util.snapScroll

class ARCameraActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityArcameraBinding? = null
    private val binding get() = _binding!!
    private var imageCapture: ImageCapture? = null
    private var cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA
    private val haircutCameraAdapter = HaircutCameraAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityArcameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.statusBarColor = Color.TRANSPARENT

        startCamera()
        initView()
        initRv()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() = with(binding) {
        imgClose.setOnClickListener(this@ARCameraActivity)
        imgRotate.setOnClickListener(this@ARCameraActivity)
    }

    private fun initRv() {
        val listHaircut = ArrayList<Haircut>()
        repeat(5) {
            listHaircut.addAll(DummyData.provideHaircut())
        }
        haircutCameraAdapter.setData(listHaircut)

        with(binding.rvHaircut) {
            adapter = haircutCameraAdapter
            layoutManager =
                LinearLayoutManager(this@ARCameraActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            snapScroll()
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.previewCamera.surfaceProvider)
                }

            imageCapture = ImageCapture.Builder().build()

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    this,
                    cameraSelector,
                    preview,
                    imageCapture
                )
            } catch (exc: Exception) {
                showToast(getString(R.string.failed_camera))

            }
        }, ContextCompat.getMainExecutor(this))
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                imgClose -> finish()
                imgRotate -> {
                    cameraSelector =
                        if (cameraSelector == CameraSelector.DEFAULT_FRONT_CAMERA) CameraSelector.DEFAULT_BACK_CAMERA
                        else CameraSelector.DEFAULT_FRONT_CAMERA
                }
            }
        }
    }

}
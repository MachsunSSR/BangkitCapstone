package com.alwan.capstoneprojectvbarbershop.ui.camera

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alwan.capstoneprojectvbarbershop.R
import com.alwan.capstoneprojectvbarbershop.databinding.ActivityCameraBinding
import com.google.ar.core.AugmentedFace
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Texture
import com.google.ar.sceneform.ux.AugmentedFaceNode

class CameraARCoreActivity : AppCompatActivity() {
    private var _binding: ActivityCameraBinding? = null
    private val binding get() = _binding!!
    private lateinit var modelRenderable: ModelRenderable
    private lateinit var texture: Texture
    private var isAdded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() = with(binding) {

    }

    private fun initAr() {
        val arFragment = supportFragmentManager.findFragmentById(R.id.arFragment) as HairArFragment

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ModelRenderable.builder().setSource(this, R.raw.fox_face).build().thenAccept {
                modelRenderable = it

                modelRenderable.apply {
                    isShadowCaster = false
                    isShadowReceiver = false
                }
            }

            Texture.builder().setSource(this, R.drawable.fox_face_mesh_texture).build().thenAccept {
                texture = it
            }

            arFragment.arSceneView.scene.addOnUpdateListener {
                val frame = arFragment.arSceneView.arFrame

                val augmentedFaces = frame?.getUpdatedTrackables(AugmentedFace::class.java)

                augmentedFaces?.let {
                    for (face in it) {
                        if (isAdded) return@let

                        val augmentedFaceNode = AugmentedFaceNode(face)
                        augmentedFaceNode.apply {
                            setParent(arFragment.arSceneView.scene)
                            faceRegionsRenderable = modelRenderable
                            faceMeshTexture = texture
                        }

                        isAdded = true
                    }
                }
            }
        }
    }
}
package com.example.proyectoaplicacionprueba.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.proyectoaplicacionprueba.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val boton = binding.button2


        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        /////////////////////////////////////

        val a = binding.editTextText2
        val b = binding.editTextText3
        val c = binding.editTextText4

        /////////////////////////////////////

        boton.setOnClickListener(){
            textView.text = calculoNumeros(a.text.toString().toFloat(), b.text.toString().toFloat(), c.text.toString().toFloat()).toString()
        }
        return root
    }


    fun calculoNumeros(a: Float, b: Float, c: Float): Float{
        var d : Float
        d = a + b * c
        d = d / b
        d = d + a
        return d
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
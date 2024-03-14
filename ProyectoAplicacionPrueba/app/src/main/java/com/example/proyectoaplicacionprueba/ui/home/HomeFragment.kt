package com.example.proyectoaplicacionprueba.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.proyectoaplicacionprueba.databinding.FragmentHomeBinding
import kotlin.math.log
import kotlin.random.Random

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = "Has presionado el boton " + 0 + " veces"
            textView.text = "Lista de animales: \n"
        }

        var Boton = binding.button
        var contador = 0
        val catalagoAnimales = arrayOf("Perro", "Gato", "Leon", "Jirafa", "Pajaro", "Tortuga")
        //val catalagoAnimales = arrayOf("Perro")
        var animalSeleccionado = 0

        ////////////////ESTO ES LO QUE HACE FUNCIONAR AL BOTON////////////////
        Boton.setOnClickListener(){
            /*contador = contador + 1
            textView.text = "Has presionado el boton " + contador + " veces"*/

            /*
            animalSeleccionado = Random.nextInt(0, 6)
            println(animalSeleccionado)
            if(animalSeleccionado > catalagoAnimales.size)
                textView.text = "Este animal no esta en el catalogo"
            else
                textView.text = "El animal seleccionado fue " + catalagoAnimales[animalSeleccionado]
            */

            animalSeleccionado = Random.nextInt(0, 6)
            textView.text = textView.text.toString() + catalagoAnimales[animalSeleccionado] + "\n"

        }
        //////////////////////////////////////////////////////////////////////



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
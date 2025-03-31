package com.example.concesionario

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.concesionario.adapter.AdapterMarca
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.dataset.DataSet
import com.example.concesionario.model.Marca

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterMarca: AdapterMarca
    private lateinit var listaMarcas: ArrayList<Marca>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        instancias()
        acciones()
    }

    private fun instancias (){
        listaMarcas = arrayListOf(
            Marca("Mercedes","https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Mercedes-Logo.svg/1200px-Mercedes-Logo.svg.png"),
            Marca("Audi","https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Audi_logo_detail.svg/1200px-Audi_logo_detail.svg.png"),
            Marca("Ford","https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Ford_logo_flat.svg/2560px-Ford_logo_flat.svg.png"),
            Marca("BMW","https://www.google.com/url?sa=i&url=https%3A%2F%2Fes.m.wikipedia.org%2Fwiki%2FArchivo%3ABMW.svg&psig=AOvVaw1MXRZDEPGpOlaUvb7EkW96&ust=1740671048580000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCOjc943X4YsDFQAAAAAdAAAAABAE"),
            )
        adapterMarca = AdapterMarca(listaMarcas, applicationContext)
        binding.SpinnerMarca.adapter = adapterMarca
    }
    private fun acciones(){
        binding.SpinnerMarca.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val Marca: Marca = adapterMarca.getItem(p2)
                //Log.v("marca", "Seleccionado ${Marca.nombre}")//para que salga el nombre
                Glide.with(applicationContext).load(Marca.imagen).placeholder(R.drawable.ferrari).into(binding.imagenMarca)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        binding.btnFiltro.setOnClickListener {
            // adapterMarca.agregarMarca(Marca("desconocida",""))
            DataSet.agregarDatos(Marca("cosa",""))
        }
    }
}
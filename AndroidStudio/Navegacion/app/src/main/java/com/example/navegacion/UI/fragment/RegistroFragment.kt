package com.example.navegacion.UI.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.example.navegacion.UI.model.User
import com.example.navegacion.databinding.FragmentLoginBinding
import com.example.navegacion.databinding.FragmentRegistroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegistroFragment: Fragment() {
    private lateinit var binding : FragmentRegistroBinding
    private lateinit var auth:FirebaseAuth
    private lateinit var database: FirebaseDatabase //conexion bbdd

    //primer metodo que se inicializa en el cliclo de vida
    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://agendaapp-aadd7-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    //metodo que asocia lo gráfico y lo lógico
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistroBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnCrearCuenta.setOnClickListener {
            // database.reference.child("app").child("nombre").setValue(null)
            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPassword.text.toString()
            ).addOnCompleteListener {
                if(it.isSuccessful){
                    // guardar los datos del usuario en base de datos
                    guardarUsuario(
                        User(
                            nombre = binding.editNombre.text.toString(),
                            correo = binding.editCorreo.text.toString(),
                            telefono = binding.editTelefono.text.toString().toInt()
                        )
                    )
                findNavController().navigate(R.id.action_registroFragment_to_mainFragment)
                }else{
                    Snackbar.make(binding.root, "Error en el registro", Snackbar.LENGTH_SHORT).show()
                }
            }
           // findNavController().navigate(R.id.action_registroFragment_to_mainFragment)
        }
    }
    private fun guardarUsuario(usuario: User) {
        database.reference.child("usuarios").child(auth.currentUser!!.uid).setValue(usuario)

    }
}
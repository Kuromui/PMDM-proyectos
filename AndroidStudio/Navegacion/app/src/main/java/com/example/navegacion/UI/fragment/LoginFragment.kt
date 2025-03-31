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
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginFragment: Fragment() {
    private lateinit var binding : FragmentLoginBinding
    private lateinit var auth:FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    //metodo que asocia lo gráfico y lo lógico
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onStart() { //para los botones
        super.onStart()
        binding.btnLogin.setOnClickListener {

            auth.signInWithEmailAndPassword(binding.editCorreo.text.toString(), binding.editPassword.text.toString()).addOnCompleteListener {
                if(it.isSuccessful){
                    //paso de datos entre pantalla paso bundle al navigate
                    auth.currentUser!!.uid
                    val bundle = Bundle()
                    bundle.putSerializable("usuario", User(binding.editCorreo.text.toString(), binding.editPassword.text.toString()))
                    //accion botón paso de pantalla
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment, bundle)
                }else{
                    Snackbar.make(binding.root, "Error en el registro", Snackbar.LENGTH_SHORT).setAction("Quieres registrarte?"){
                        findNavController().navigate(R.id.action_loginFragment_to_registroFragment)
                    }.show()
                }
            }


        }
        binding.btnResgitro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment)
        }
    }
}
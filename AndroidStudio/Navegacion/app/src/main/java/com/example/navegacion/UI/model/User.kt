package com.example.navegacion.UI.model

import java.io.Serializable

class User(var correo: String? = null,
           var nombre: String? = null,
           var telefono: Int? = null) :
    Serializable {
}
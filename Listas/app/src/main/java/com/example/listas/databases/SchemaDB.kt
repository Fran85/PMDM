package com.example.listas.databases

interface SchemaDB {

    companion object{
        val DB_NOMBRE: String = "concesionario"
        val TAB_NAME: String = "coche"
        val COL_ID: String = "id"
        val COL_NAME: String = "nombre"
        val COL_MARK: String = "marca"
        val COL_CV: String = "cv"
        val COL_PRE: String = "precio"
        val COL_IMG: String = "imagen"
    }

}
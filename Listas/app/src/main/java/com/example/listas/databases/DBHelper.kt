package com.example.listas.databases

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.listas.model.Coche

class DBHelper(var contexto: Context, var dbname: String, var version: Int):
    SQLiteOpenHelper(contexto,dbname,null, version) {

    //Permite "llegar" a la base de datos
    override fun onCreate(db: SQLiteDatabase?) {
        //crea la base de datos si no existe
        db?.execSQL("CREATE TABLE ${SchemaDB.TAB_NAME} (${SchemaDB.COL_ID} INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                "${SchemaDB.COL_NAME} TEXT, ${SchemaDB.COL_MARK} TEXT,"
            +"${SchemaDB.COL_PRE}  INTEGER,${SchemaDB.COL_CV} INTEGER,${SchemaDB.COL_IMG} TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //actualizar la base de datos a version superior a la version actual
    }


    //metodos que actuan contra la base de datos --> CRUD
    //metodo
    fun agregarCoche(coche: Coche){
        val baseDatos = this.writableDatabase
        //dos opciones
        //por query INSERT into coche (nombre,marca,precio,cv,imagen) VALUES ('wer' '123' '1234')

        //o por contentValues
        val contenValue = ContentValues()
        contenValue.put(SchemaDB.COL_NAME, coche.nombre)
        contenValue.put(SchemaDB.COL_MARK, coche.marca)
        contenValue.put(SchemaDB.COL_CV, coche.cv)
        contenValue.put(SchemaDB.COL_PRE, coche.precio)
        contenValue.put(SchemaDB.COL_IMG, coche.imagen)
        baseDatos.insert(SchemaDB.TAB_NAME,null,contenValue)
    }

    fun getCoches(): ArrayList<Coche>{
        val baseDatos = this.readableDatabase
        val query = "SELECT * FROM ${SchemaDB.TAB_NAME}"
        val resultado = baseDatos.rawQuery(query, null)
        val listaResultados  = ArrayList<Coche>()

        while (resultado.moveToNext()){
            val posicionNombre = resultado.getColumnIndex(SchemaDB.COL_NAME)
            val nombre = resultado.getString(posicionNombre)
            val posicionMarca = resultado.getColumnIndex(SchemaDB.COL_MARK)
            val marca= resultado.getString(posicionMarca)
            val posicionPrecio = resultado.getColumnIndex(SchemaDB.COL_PRE)
            val precio = resultado.getString(posicionPrecio)
            val posicionCv = resultado.getColumnIndex(SchemaDB.COL_CV)
            val cv = resultado.getInt(posicionCv)
            val posicionImagen = resultado.getColumnIndex(SchemaDB.COL_IMG)
            val imagen = resultado.getString(posicionImagen)

            Coche(nombre,marca,precio, cv, imagen)

        }

        return listaResultados
    }

    //un select es diferente a los otro

}
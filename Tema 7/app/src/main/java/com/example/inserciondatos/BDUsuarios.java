package com.example.inserciondatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class BDUsuarios extends SQLiteOpenHelper
{
    private Context contexto;
    // Sentencia SQL para crear la tabla de Usuarios
    private final String SQLCREATE = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT, fecha DATE)";
    // Sentencia SQL para eliminar la tabla de Usuarios
    private final String SQLDROP = "DROP TABLE IF EXISTS Usuarios";
    // Base de datos
    private SQLiteDatabase bd = null;

    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "DBUsuarios.db";

    /**
     * Constructor de la clase
     * @param contexto Contexto de la aplicación
     */
    public BDUsuarios(Context contexto)
    {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
        this.contexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQLCREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva)
    {
        db.execSQL(SQLDROP);
        db.execSQL(SQLCREATE);
    }

    public void cerrarBD()
    {
        if( bd != null )
            bd.close();
    }

    /**
     * Inserta un nuevo usuario en la base de datos
     * @param codigo Código del usuario
     * @param nombre Nombre del usuario
     * @throws Exception Esta excepción se lenzará si ocurre algún error en la inserción
     */
    public void insertarUsuario(int codigo, String nombre, Date fecha) throws Exception
    {
        // Obtengo los datos en modos de escritura
        bd = getWritableDatabase();
        // Si hemos abierto correctamente la base de datos
        if(bd != null)
        {
            long newRowId;
            try
            {
                // Creo un ContentValues con los valores a insertar
                ContentValues values = new ContentValues();
                values.put("codigo", codigo);
                values.put("nombre", nombre);
                values.put("fecha", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(fecha));
                // Inserta la nueva fila, devolviendo el valor de la clave
                // primaria de la nueva fila
                newRowId = bd.insert("Usuarios", "", values);
            }
            catch (Exception e)
            {
                throw new Exception(e.toString());
            }
        }
    }

    /**
     * Obtiene todos los usuarios de la base de datos
     * @return Array con todos los usuarios de la base de datos
     * @throws Exception Esta excepción saltará cuando ocurra algún error recuperando los datos
     */
    public ArrayList<Usuario> obtenerTodosUsuarios() throws Exception
    {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        // Obtengo los datos en modo de lectura
        bd = getReadableDatabase();
        // Si hemos abierto correctamente la base de datos
        try
        {
            // Indico como quiero que se ordenen los resultados
            String sortOrder = "codigo ASC";
            // Creo el cursor de la consulta
            Cursor c = bd.query
                    (
                            "Usuarios",   // Tabla para consultar
                            null,       // Columnas a devolver
                            null,      // Columnas de la clausula WHERE
                            null,   // Valores de la columna de la clausula WHERE
                            null,       // Valores de la clausula GROUP BY
                            null,        // Valores de la clausula HAVING
                            sortOrder           // Orden de la clausula ORDER BY
                    );
            // Muestro los datos
            c.moveToFirst();
            if( c.getCount() > 0 )
            {
                do
                {
                    int codigo = c.getInt(0);
                    String nombre = c.getString(1);
                    String fechat = c.getString(2);
                    Date fecha = (Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(fechat);
                    usuarios.add(new Usuario(codigo, nombre,fecha));
                } while (c.moveToNext());
            }

            cerrarBD();

            return usuarios;
        }
        catch (Exception e)
        {
            throw new Exception(e.toString());
        }
    }
}

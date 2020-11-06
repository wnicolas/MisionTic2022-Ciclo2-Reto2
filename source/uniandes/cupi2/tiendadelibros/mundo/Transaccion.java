/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_tiendaDeLibros
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.tiendadelibros.mundo;

/**
 * Clase que representa una transacci�n de un libro.
 */
public class Transaccion
{
    // -----------------------------------------------------------------
    // Enumeraciones
    // -----------------------------------------------------------------

    /**
     * Enumeradores para los tipos de transacciones posibles.
     */
    public enum Tipo {
        /**
         * Representa el tipo venta
         */
        VENTA,
        /**
         * Representa el tipo abastecimiento
         */
        ABASTECIMIENTO
    }

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Tipo de la transacci�n.
     */
    private Tipo tipo;

    /**
     * Cantidad de ejemplares utilizados en la transacci�n.
     */
    private int cantidad;

    /**
     * Fecha en que se realiz� la transacci�n.
     */
    private String fecha;

    /**
     * Fecha-ISBN-Cantidad.
     */
    private String idTransaccion;
    
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea una transacci�n con el tipo, cantidad de ejemplares y la fecha en que se realiz�.
     * @param pTipo Tipo de la transacci�n. pTipo != null.
     * @param pCantidad Cantidad de ejemplares utilizados en la transacci�n. pCantidad > 0.
     * @param pFecha Fecha en que se realiz� la transacci�n. pFecha != null && pFecha != "".
     */
    public Transaccion( Tipo pTipo, int pCantidad, String pFecha, String pIdTransaccion )
    {
    	tipo = pTipo;
        cantidad = pCantidad;
        fecha = pFecha;
        idTransaccion = pIdTransaccion;
        
        costo=0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el tipo de la transacci�n.
     * @return El tipo de la transacci�n.
     */
    public Tipo darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna la cantidad de ejemplares utilizados en la transacci�n.
     * @return La cantidad de ejemplares utilizados en la transacci�n.
     */
    public int darCantidad( )
    {
        return cantidad;
    }

    /**
     * Retorna la fecha de la transacci�n.
     * @return La fecha de la transacci�n.
     */
    public String darFecha( )
    {
        return fecha;
    }
    
    public String darIdTransaccion()
    {
    	return idTransaccion;
    }

    /**
     * Retorna la representaci�n en cadena de caracteres un objeto Transaccion.
     * @return La representaci�n en cadena de caracteres del objeto Transaccion.
     */
    public String toString( )
    {
        String representacion = fecha + " - " + tipo + ": " + cantidad;
        return representacion;
    }
    
    private double costo;

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
    
}

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

import java.util.ArrayList;

/**
 * Clase que representa el libro.
 */
public class Libro
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El c�digo ISBN del libro.
     */
    private String isbn;

    /**
     * El t�tulo del libro.
     */
    private String titulo;

    /**
     * El precio de venta del libro.
     */
    private double precioVenta;

    /**
     * El precio de compra del libro.
     */
    private double precioCompra;

    /**
     * Cantidad actual de ejemplares del libro.
     */
    private int cantidadActual;

    /**
     * Ruta de la imagen del libro.
     */
    private String rutaImagen;

    /**
     * Colecci�n de transacciones realizadas.
     */
    private ArrayList<Transaccion> transacciones;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea un libro con su t�tulo, isbn, autor y precioVenta. La cantidad actual se inicializa en cero y la colecci�n de transacciones es vac�a.
     * @param pTitulo T�tulo del libro. pTitulo != null && pTitulo != "".
     * @param pIsbn C�digo ISBN del libro. pIsbn != null && pIsbn != "".
     * @param pPrecioVenta precioVenta del libro. pPrecioVenta > 0.
     * @param pPrecioCompra precioVenta del libro. pPrecioCompra > 0.
     * @param pRutaImagen Ruta de la imagen del libro. pRutaImagen != null && pRutaImagen != "".
     */
    public Libro( String pTitulo, String pIsbn, double pPrecioVenta, double pPrecioCompra, String pRutaImagen )
    {
        titulo = pTitulo;
        isbn = pIsbn;
        precioVenta = pPrecioVenta;
        precioCompra = pPrecioCompra;
        rutaImagen = pRutaImagen;
        cantidadActual = 5;
        transacciones = new ArrayList<Transaccion>( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el c�digo IBSN del libro.
     * @return El c�digo ISBN del libro.
     */
    public String darIsbn( )
    {
        return isbn;
    }

    /**
     * Retorna el t�tulo del libro.
     * @return El t�tulo del libro.
     */
    public String darTitulo( )
    {
        return titulo;
    }

    /**
     * Retorna el precio de venta del libro.
     * @return El precio de venta del libro.
     */
    public double darPrecioVenta( )
    {
        return precioVenta;
    }
    
    

    public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	/**
     * Retorna el precio de compra del libro.
     * @return El precio de compra del libro.
     */
    public double darPrecioCompra( )
    {
        return precioCompra;
    }

    /**
     * Retorna la cantidad actual de ejemplares del libro.
     * @return La cantidad actual de ejemplares del libro.
     */
    public int darCantidadActual( )
    {
        return cantidadActual;
    }

    /**
     * Retorna la ruta de la imagen del libro.
     * @return La ruta de la imagen del libro.
     */
    public String darRutaImagen( )
    {
        return rutaImagen;
    }

    /**
     * Vende la cantidad de ejemplares que entra por par�metro.
     * @param pCantidad La cantidad de ejemplares que se van a vender.
     * @param pFecha La fecha en la que se realiz� la transacci�n. pFecha != "" && pFecha != null.
     * @return Retorna true en caso de que se pueda vender la cantidad que entra por par�metro. Retorna false en caso de que la cantidad sea mayor a la actual.
     */
    public boolean vender( int pCantidad, String pFecha )
    {
        boolean vendido = false;
        // Verifica que la cantidad que entra por par�metro sea menor o igual a la cantidad igual
        if( pCantidad <= cantidadActual )
        {
            // Disminuye la cantidad actual de ejemplares
            cantidadActual -= pCantidad;
            // Crear el codigo de la transaccion
            String idTransaccion = pFecha + "-" + isbn + "-" + pCantidad;
            // Crea una nueva transacci�n con el tipo venta y la fecha actual
            Transaccion nueva = new Transaccion( Transaccion.Tipo.VENTA, pCantidad, pFecha, idTransaccion );
            // Agrega la nueva transacci�n a la colecci�n de transacciones del libro
            
            nueva.setCosto(pCantidad*precioVenta);
            transacciones.add( nueva );
            vendido = true;
        }
        return vendido;
    }

    /**
     * Abastece la cantidad de ejemplares que entra por par�metro.
     * @param pCantidad La cantidad de ejemplares que se van a agregar a la cantidad actual.
     * @param pFecha La fecha en la que se realiz� la transacci�n. pFecha != "" && pFecha != null.
     */
    public void abastecer( int pCantidad, String pFecha )
    {
        // Aumenta la cantidad actual de ejemplares
        cantidadActual += pCantidad;
        // Crea el codigo de la transaccion
        String idTransaccion = pFecha + "-" + isbn + "-" + pCantidad;
        // Crea una nueva transacci�n con el tipo abastecimiento y la fecha actual
        Transaccion nueva = new Transaccion( Transaccion.Tipo.ABASTECIMIENTO, pCantidad, pFecha, idTransaccion );
        // Agrega la nueva transacci�n a la colecci�n de transacciones del libro
        transacciones.add( nueva );
    }

    /**
     * Retorna la colecci�n de transacciones.
     * @return La colecci�n de transacciones.
     */
    public ArrayList<Transaccion> darTransacciones( )
    {
        return transacciones;
    }

    /**
     * Retorna la representaci�n en cadena de caracteres un objeto Libro.
     * @return La representaci�n en cadena de caracteres del objeto Libro.
     */
    public String toString( )
    {
        String representacion = titulo + " (" + isbn + ")";
        return representacion;
    }

}

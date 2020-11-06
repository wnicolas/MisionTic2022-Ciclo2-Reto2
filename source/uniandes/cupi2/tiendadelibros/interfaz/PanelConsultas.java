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
package uniandes.cupi2.tiendadelibros.interfaz;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.tiendadelibros.mundo.Libro;

/**
 * Panel que presenta las consultas sobre la tienda de libros.
 */
@SuppressWarnings("serial")
public class PanelConsultas extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para buscar un libro por su nombre.
     */
    public final static String BUSCAR_POR_NOMBRE = "Buscar por nombre";

    /**
     * Comando para buscar un libro por su ISBN.
     */
    public final static String BUSCAR_POR_ISBN = "Buscar por ISBN";

    /**
     * Comando para buscar el libro m�s vendido.
     */
    public final static String MAS_VENDIDO = "Mas vendido";

    /**
     * Comando para buscar el libro m�s costoso.
     */
    public final static String MAS_COSTOSO = "Mas costoso";

    /**
     * Comando para buscar el libro m�s econ�mico.
     */
    public final static String MAS_ECONOMICO = "M�s econ�mico";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Bot�n libro m�s costoso.
     */
    private JButton btnMasCostoso;

    /**
     * Bot�n libro menos costoso.
     */
    private JButton btnMenosCostoso;

    /**
     * Bot�n libro m�s vendido.
     */
    private JButton btnMasVendido;

    /**
     * Bot�n buscar por ISBN.
     */
    private JButton btnBuscarISBN;

    /**
     * Bot�n buscar por nombre.
     */
    private JButton btnBuscarNombre;

    /**
     * Etiqueta ISBN.
     */
    private JLabel lblISBN;

    /**
     * Etiqueta t�tulo.
     */
    private JLabel lblTitulo;

    /**
     * Etiqueta precio de compra.
     */
    private JLabel lblPrecioCompra;

    /**
     * Etiqueta precio de venta.
     */
    private JLabel lblPrecioVenta;

    /**
     * Campo de texto ISBN.
     */
    private JTextField txtISBN;

    /**
     * Campo de texto t�tulo.
     */
    private JTextField txtTitulo;

    /**
     * Campo de texto precio de compra.
     */
    private JTextField txtPrecioCompra;

    /**
     * Campo de texto precio de venta.
     */
    private JTextField txtPrecioVenta;

    /**
     * Scroll que contiene la lista de transacciones.
     */
    private JScrollPane scroll;

    /**
     * La lista de transacciones.
     */
    private JList transacciones;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la tienda de libros.
     */
    private InterfazTiendaLibros interfaz;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel para hacer consultas sobre la tienda de libros. <br>
     * <b>post: </b> El panel se cre�, la secci�n que muestra el resultado est� vac�a.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     */
    public PanelConsultas( InterfazTiendaLibros pPrincipal )
    {
        interfaz = pPrincipal;
        setBorder( new TitledBorder( "Consultas" ) );

        JPanel botones = new JPanel( );
        botones.setLayout( new GridLayout( 5, 1 ) );

        btnBuscarISBN = new JButton( "Buscar Por ISBN" );
        btnBuscarISBN.setActionCommand( BUSCAR_POR_ISBN );
        btnBuscarISBN.addActionListener( this );
        botones.add( btnBuscarISBN );

        btnBuscarNombre = new JButton( "Buscar Por T�tulo" );
        btnBuscarNombre.setActionCommand( BUSCAR_POR_NOMBRE );
        btnBuscarNombre.addActionListener( this );
        botones.add( btnBuscarNombre );

        btnMenosCostoso = new JButton( "Libro M�s Econ�mico" );
        btnMenosCostoso.setActionCommand( MAS_ECONOMICO );
        btnMenosCostoso.addActionListener( this );
        botones.add( btnMenosCostoso );

        btnMasCostoso = new JButton( "Libro M�s Costoso" );
        btnMasCostoso.setActionCommand( MAS_COSTOSO );
        btnMasCostoso.addActionListener( this );
        botones.add( btnMasCostoso );

        btnMasVendido = new JButton( "Libro M�s Vendido" );
        btnMasVendido.setActionCommand( MAS_VENDIDO );
        btnMasVendido.addActionListener( this );
        botones.add( btnMasVendido );

        JPanel resultado = new JPanel( );
        resultado.setLayout( new GridLayout( 6, 2 ) );
        resultado.setBorder( new EmptyBorder( 0, 15, 0, 15 ) );

        resultado.add( new JLabel( ) );
        resultado.add( new JLabel( ) );

        lblISBN = new JLabel( "ISBN: " );
        resultado.add( lblISBN );
        txtISBN = new JTextField( );
        txtISBN.setEditable( false );
        resultado.add( txtISBN );

        lblTitulo = new JLabel( "T�tulo: " );
        resultado.add( lblTitulo );
        txtTitulo = new JTextField( );
        txtTitulo.setEditable( false );
        resultado.add( txtTitulo );

        lblPrecioCompra = new JLabel( "Precio de Compra: " );
        resultado.add( lblPrecioCompra );
        txtPrecioCompra = new JTextField( );
        txtPrecioCompra.setEditable( false );
        resultado.add( txtPrecioCompra );

        lblPrecioVenta = new JLabel( "Precio de Venta: " );
        resultado.add( lblPrecioVenta );
        txtPrecioVenta = new JTextField( );
        txtPrecioVenta.setEditable( false );
        resultado.add( txtPrecioVenta );

        resultado.add( new JLabel( ) );
        resultado.add( new JLabel( ) );

        transacciones = new JList( );
        scroll = new JScrollPane( );
        scroll.setBorder( new TitledBorder( "Transacciones del libro" ) );
        scroll.setViewportView( transacciones );
        scroll.setVerticalScrollBarPolicy( javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

        JPanel este = new JPanel( );
        este.add( scroll );

        setLayout( new BorderLayout( ) );
        add( botones, BorderLayout.WEST );
        add( resultado, BorderLayout.CENTER );
        add( este, BorderLayout.EAST );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * M�todo para actualizar el panel y mostrar el resultado.
     * @param pLibro Libro que se desea mostrar en el panel.
     */
    public void actualizar( Libro pLibro )
    {
        if( pLibro != null )
        {
            txtISBN.setText( pLibro.darIsbn( ) );
            txtTitulo.setText( pLibro.darTitulo( ) );
            NumberFormat formatter = NumberFormat.getInstance( );
            String moneyString = formatter.format( pLibro.darPrecioCompra( ) );
            txtPrecioCompra.setText( "$" + moneyString );
            String moneyString2 = formatter.format( pLibro.darPrecioVenta( ) );
            txtPrecioVenta.setText( "$" + moneyString2 );
            transacciones.setListData( pLibro.darTransacciones( ).toArray( ) );
        }
    }

    /**
     * Limpia el panel de la �ltima consulta realizada.
     */
    public void limpiar( )
    {
        txtISBN.setText( "" );
        txtTitulo.setText( "" );
        txtPrecioCompra.setText( "" );
        txtPrecioVenta.setText( "" );
        ArrayList vacio = new ArrayList( );
        transacciones.setListData( vacio.toArray( ) );

    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( BUSCAR_POR_ISBN ) )
        {
            interfaz.buscarPorISBN( );
        }
        else if( comando.equals( BUSCAR_POR_NOMBRE ) )
        {
            interfaz.buscarPorTitulo( );
        }
        else if( comando.equals( MAS_ECONOMICO ) )
        {
            interfaz.buscarMasEconomico( );
        }
        else if( comando.equals( MAS_COSTOSO ) )
        {
            interfaz.buscarMasCostoso( );
        }
        else
        {
            interfaz.buscarMasVendido( );
        }

    }

}

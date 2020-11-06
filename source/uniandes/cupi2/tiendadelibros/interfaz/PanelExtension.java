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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Panel para el acceso a los m�todos de extensi�n.
 */
@SuppressWarnings("serial")
public class PanelExtension extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para el m�todo de extensi�n 1.
     */
    public final static String COMANDO_1 = "UNO";

    /**
     * Constante para el m�todo de extensi�n 2.
     */
    public final static String COMANDO_2 = "DOS";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Bot�n opci�n 1.
     */
    private JButton btnOpc1;

    /**
     * Bot�n opci�n 2.
     */
    private JButton btnOpc2;

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
     * Constructor del panel para los m�todos de extensi�n.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     */
    public PanelExtension( InterfazTiendaLibros pPrincipal )
    {
        interfaz = pPrincipal;
        setLayout( new GridLayout( 1, 2 ) );
        setBorder( new TitledBorder( "Botones reto" ) );

        btnOpc1 = new JButton( "Aplicar descuento" );
        btnOpc1.setActionCommand( COMANDO_1 );
        btnOpc1.addActionListener( this );
        add( btnOpc1 );

        btnOpc2 = new JButton( "Venta mas cara" );
        btnOpc2.setActionCommand( COMANDO_2 );
        btnOpc2.addActionListener( this );
        add( btnOpc2 );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( COMANDO_1 ) )
        {
            interfaz.reqFuncOpcion1( );
        }
        else
        {
            interfaz.reqFuncOpcion2( );
        }

    }
}

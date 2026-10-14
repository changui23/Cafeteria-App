import java.awt.*;
import javax.swing.*;

public class CafeteriaApp {
    public static void main(String[] args) {

        String[] usuarioCajero = {"Error"};
        JLabel nombreUsuario = new JLabel();
        JLabel nombreUsuarioMesas = new JLabel();
        JLabel fecha = new JLabel("01/01/2026");

        //Ventana Principal
        JFrame ventana = new JFrame("Cafetería El Cafe");

        ventana.setSize(600, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        //Administrar Pantallas
        CardLayout cardLayout = new CardLayout();
        JPanel pantallas = new JPanel(cardLayout);

        /* ================
        Pantalla de Inicio
        ================ */

        JPanel pantallaInicio = new JPanel();
        pantallaInicio.setLayout(null);

        //Crear texto
        JLabel nombreCaf = new JLabel(
            "Cafetería el Cafe",
            SwingConstants.CENTER
         );

        //Estilo del texto
        nombreCaf.setFont(new Font("Arial", Font.BOLD, 50));
        nombreCaf.setBounds(50, 50, 500, 70);

        //crear boton
        JButton botonEntrar = new JButton("Entrar");

        //Tamano
        botonEntrar.setPreferredSize(new Dimension(200, 50));

        //Estilo del Boton
        botonEntrar.setFont(new Font("Arial", Font.BOLD, 18));
        botonEntrar.setBackground(Color.decode("#9A7B4F"));
        botonEntrar.setForeground(Color.WHITE);
        botonEntrar.setFocusPainted(false);

        //Posicion del Boton
        JPanel panelBotonEntrar = new JPanel();
        panelBotonEntrar.setBounds(200, 150, 200, 50);
        panelBotonEntrar.add(botonEntrar);

        //funcionalidad Boton Entrar
        botonEntrar.addActionListener(e -> {
            ventana.setSize(600, 600);
            ventana.setLocationRelativeTo(null);
            cardLayout.show(pantallas, "usuarios");
        });

        // Añadir componentes
        pantallaInicio.add(nombreCaf);
        pantallaInicio.add(panelBotonEntrar);

        /* ==================
        Pantalla de Usuarios
        =================== */ 

        JPanel pantallaUsuarios = new JPanel();
        pantallaUsuarios.setLayout(null);

        //Texto inicio de sesión
        JLabel tituloUsuarios = new JLabel(
            "Inicio de sesión",
            SwingConstants.CENTER
        );
        tituloUsuarios.setFont(new Font("Arial", Font.BOLD, 50));
        tituloUsuarios.setBounds(100, 100, 400, 70);

        //Texto numero de cajero
        JLabel textoUsuario = new JLabel(
            "ID del cajero:",
            SwingConstants.CENTER
        );
        textoUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        textoUsuario.setBounds(150, 200, 300, 50);

        //Campo de texto para el usuario
        JTextField campoUsuario = new JTextField();
        campoUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
        campoUsuario.setBounds(150, 250, 300, 50);

        //Texto contraseña
        JLabel textoContrasena = new JLabel(
            "Contraseña:",
            SwingConstants.CENTER
        );
        textoContrasena.setFont(new Font("Arial", Font.BOLD, 20));
        textoContrasena.setBounds(150, 300, 300, 50);

        //Campo de texto para la contraseña
        JTextField campoContrasena = new JTextField();
        campoContrasena.setFont(new Font("Arial", Font.PLAIN, 20));
        campoContrasena.setBounds(150, 350, 300, 50);

        //Boton de inicio de sesión
        JButton botonUsuarios = new JButton("Aceptar");

        botonUsuarios.setPreferredSize(new Dimension(200, 50));

        botonUsuarios.setFont(new Font("Arial", Font.BOLD, 18));
        botonUsuarios.setBackground(Color.decode("#9A7B4F"));
        botonUsuarios.setForeground(Color.WHITE);
        botonUsuarios.setFocusPainted(false);

        JPanel panelBotonUsuarios = new JPanel();
        panelBotonUsuarios.setBounds(200, 420, 200, 50);
        panelBotonUsuarios.add(botonUsuarios);

        botonUsuarios.addActionListener(e -> {
            // Obtener los valores ingresados por el usuario
            String usuario = campoUsuario.getText();
            String contrasena = campoContrasena.getText();

            // Usuarios y contraseñas válidos
            if (usuario.equals("85315") && contrasena.equals("1701")) {
                usuarioCajero[0] = "Jose Angel";
                nombreUsuario.setText(usuarioCajero[0]);
                ventana.setSize(1000, 700);
                ventana.setLocationRelativeTo(null);
                cardLayout.show(pantallas, "categorias");
                campoUsuario.setText("");
                campoContrasena.setText("");
            } else if (usuario.equals("86301") && contrasena.equals("2465")) {
                usuarioCajero[0] = "Santiago Gonzalez";
                nombreUsuario.setText(usuarioCajero[0]);
                ventana.setSize(1000, 700);
                ventana.setLocationRelativeTo(null);
                cardLayout.show(pantallas, "categorias");
                campoUsuario.setText("");
                campoContrasena.setText("");
            } else if (usuario.equals("83781") && contrasena.equals("6767")) {
                usuarioCajero[0] = "Jorge Tejo";
                nombreUsuario.setText(usuarioCajero[0]);
                ventana.setSize(1000, 700);
                ventana.setLocationRelativeTo(null);
                cardLayout.show(pantallas, "categorias");
                campoUsuario.setText("");
                campoContrasena.setText("");
            } else {
                JOptionPane.showMessageDialog(ventana, "Usuario o contraseña incorrectos");
            }
        });

        // Añadir componentes
        pantallaUsuarios.add(panelBotonUsuarios);
        pantallaUsuarios.add(textoContrasena);
        pantallaUsuarios.add(textoUsuario);
        pantallaUsuarios.add(campoContrasena);
        pantallaUsuarios.add(campoUsuario);
        pantallaUsuarios.add(tituloUsuarios);

        /* ================
        Pantalla Categorias
        ================ */

        JPanel pantallaCategorias = new JPanel();
        pantallaCategorias.setLayout(null);

        // Panel de navegación
        JPanel panelNavegacionCategorias = new JPanel();
        panelNavegacionCategorias.setLayout(null);
        panelNavegacionCategorias.setBackground(Color.decode("#9A7B4F"));
        panelNavegacionCategorias.setBounds(0, 0, 1000, 50);

        // nombre del usuario
        nombreUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
        nombreUsuario.setForeground(Color.WHITE);
        nombreUsuario.setBounds(15, 0, 200, 50);
        panelNavegacionCategorias.add(nombreUsuario);

        // Cambiar Cajero
        JButton botonCambiarCajero = new JButton("Cambiar Cajero");
        botonCambiarCajero.setPreferredSize(new Dimension(200, 40));
        botonCambiarCajero.setFont(new Font("Arial", Font.BOLD, 18));
        botonCambiarCajero.setBackground(Color.white);
        botonCambiarCajero.setForeground(Color.decode("#9A7B4F"));
        botonCambiarCajero.setFocusPainted(false);
        botonCambiarCajero.setBounds(780, 5, 200, 40);
        panelNavegacionCategorias.add(botonCambiarCajero);

        botonCambiarCajero.addActionListener(e -> {
            ventana.setSize(600, 600);
            ventana.setLocationRelativeTo(null);
            cardLayout.show(pantallas, "usuarios");
        });

        // Panel de categorías
        JPanel panelCategorias = new JPanel();
        panelCategorias.setLayout(null);
        panelCategorias.setBounds(0, 50, 1000, 580);

        //nombreUsuarioProductos.setText(nombreUsuario.getText());

        //Boton Dia
        JButton botonDia = new JButton("Día");
        botonDia.setPreferredSize(new Dimension(280, 530));
        botonDia.setFont(new Font("Arial", Font.BOLD, 50));
        botonDia.setBackground(Color.decode("#9A7B4F"));
        botonDia.setForeground(Color.WHITE);
        botonDia.setFocusPainted(false);
        botonDia.setBounds(50, 25, 280, 530);
        panelCategorias.add(botonDia);

        //Dialogo Dia
        botonDia.addActionListener(e -> {
            JDialog dialogoDia = new JDialog(ventana, "Día de operación", true);

            dialogoDia.setSize(350, 200);
            dialogoDia.setLocationRelativeTo(ventana);
            dialogoDia.setLayout(null);

            JLabel fechaDia = new JLabel("Fecha de operación:");
            fechaDia.setFont(new Font("Arial", Font.BOLD, 20));
            fechaDia.setBounds(75, 10, 200, 30);
            fechaDia.setForeground(Color.BLACK);
            fechaDia.setHorizontalAlignment(SwingConstants.CENTER);

            JTextField campoFechaDia = new JTextField(fecha.getText(), 10);
            campoFechaDia.setFont(new Font("Arial", Font.PLAIN, 20));
            campoFechaDia.setBounds(100, 50, 150, 30);

            JButton aceptarDia = new JButton("Aceptar");
            aceptarDia.setPreferredSize(new Dimension(280, 100));
            aceptarDia.setFont(new Font("Arial", Font.BOLD, 20));
            aceptarDia.setBackground(Color.decode("#9A7B4F"));
            aceptarDia.setForeground(Color.WHITE);
            aceptarDia.setFocusPainted(false);
            aceptarDia.setBounds(100, 100, 150, 60);

            aceptarDia.addActionListener(ev -> {
                fecha.setText(campoFechaDia.getText());
                dialogoDia.dispose();
            });

            dialogoDia.add(fechaDia);
            dialogoDia.add(campoFechaDia);
            dialogoDia.add(aceptarDia);

            dialogoDia.setVisible(true);
        });

        // Boton Mesas
        JButton botonMesas = new JButton("Mesas");
        botonMesas.setPreferredSize(new Dimension(280, 530));
        botonMesas.setFont(new Font("Arial", Font.BOLD, 50));
        botonMesas.setBackground(Color.decode("#9A7B4F"));
        botonMesas.setForeground(Color.WHITE);
        botonMesas.setFocusPainted(false);
        botonMesas.setBounds(360, 25, 280, 530);
        panelCategorias.add(botonMesas);

        botonMesas.addActionListener(e -> {
            ventana.setSize(808, 800);
            ventana.setLocationRelativeTo(null);
            cardLayout.show(pantallas, "mesas");
            nombreUsuarioMesas.setText(nombreUsuario.getText());
        });

        // Boton Caja
        JButton botonCaja = new JButton("Caja");
        botonCaja.setPreferredSize(new Dimension(280, 530));
        botonCaja.setFont(new Font("Arial", Font.BOLD, 50));
        botonCaja.setBackground(Color.decode("#9A7B4F"));
        botonCaja.setForeground(Color.WHITE);
        botonCaja.setFocusPainted(false);
        botonCaja.setBounds(670, 25, 280, 530);
        panelCategorias.add(botonCaja);

        botonCaja.addActionListener(e -> {
            JOptionPane.showMessageDialog(ventana, "Pantalla de Caja");
        });

        // Panel de abajo de categorías
        JPanel panelAbajoCategorias = new JPanel();
        panelAbajoCategorias.setLayout(null);
        panelAbajoCategorias.setBounds(0, 630, 1000, 45);
        panelAbajoCategorias.setBackground(Color.decode("#9A7B4F"));

        // Fecha
        fecha.setFont(new Font("Arial", Font.PLAIN, 20));
        fecha.setForeground(Color.WHITE);
        fecha.setBounds(870, 0, 130, 40);
        panelAbajoCategorias.add(fecha);

        // Añadir componentes
        pantallaCategorias.add(panelCategorias);
        pantallaCategorias.add(panelNavegacionCategorias);
        pantallaCategorias.add(panelAbajoCategorias);

        /* ===============
        Pantalla Mesas
        =============== */

        JPanel pantallaMesas = new JPanel();
        pantallaMesas.setLayout(null);

        // Panel de navegación
        JPanel panelNavegacionMesas = new JPanel();
        panelNavegacionMesas.setLayout(null);
        panelNavegacionMesas.setBackground(Color.decode("#9A7B4F"));
        panelNavegacionMesas.setBounds(0, 0, 800, 50);

        // nombre del usuario
        nombreUsuarioMesas.setFont(new Font("Arial", Font.PLAIN, 20));
        nombreUsuarioMesas.setForeground(Color.WHITE);
        nombreUsuarioMesas.setBounds(15, 0, 200, 50);
        panelNavegacionMesas.add(nombreUsuarioMesas);

        // Regresar a Categorias
        JButton botonRegresarMesas = new JButton("Regresar");
        botonRegresarMesas.setPreferredSize(new Dimension(200, 40));
        botonRegresarMesas.setFont(new Font("Arial", Font.BOLD, 18));
        botonRegresarMesas.setBackground(Color.white);
        botonRegresarMesas.setForeground(Color.decode("#9A7B4F"));
        botonRegresarMesas.setFocusPainted(false);
        botonRegresarMesas.setBounds(580, 5, 200, 40);
        panelNavegacionMesas.add(botonRegresarMesas);

        botonRegresarMesas.addActionListener(e -> {
            ventana.setSize(1000, 700);
            ventana.setLocationRelativeTo(null);
            cardLayout.show(pantallas, "categorias");
        });

        // Panel de Mesas
        JPanel panelMesas = new JPanel();
        panelMesas.setLayout(null);
        panelMesas.setBounds(0, 50, 800, 750);

        // Mesa 1
        JButton botonMesa1 = new JButton("Mesa 1");
        botonMesa1.setPreferredSize(new Dimension(380, 200));
        botonMesa1.setFont(new Font("Arial", Font.BOLD, 30));
        botonMesa1.setBackground(Color.WHITE);
        botonMesa1.setForeground(Color.decode("#9A7B4F"));
        botonMesa1.setFocusPainted(false);
        botonMesa1.setBounds(10, 10, 380, 200);
        botonMesa1.setBorder(BorderFactory.createLineBorder(
            Color.decode("#9A7B4F"), 2
        ));
        panelMesas.add(botonMesa1);

        // Mesa 2
        JButton botonMesa2 = new JButton("Mesa 2");
        botonMesa2.setPreferredSize(new Dimension(380, 200));
        botonMesa2.setFont(new Font("Arial", Font.BOLD, 30));
        botonMesa2.setBackground(Color.WHITE);
        botonMesa2.setForeground(Color.decode("#9A7B4F"));
        botonMesa2.setFocusPainted(false);
        botonMesa2.setBounds(410, 10, 380, 200);
        botonMesa2.setBorder(BorderFactory.createLineBorder(
            Color.decode("#9A7B4F"), 2
        ));
        panelMesas.add(botonMesa2);

        // Mesa 3
        JButton botonMesa3 = new JButton("Mesa 3");
        botonMesa3.setPreferredSize(new Dimension(380, 200));
        botonMesa3.setFont(new Font("Arial", Font.BOLD, 30));
        botonMesa3.setBackground(Color.WHITE);
        botonMesa3.setForeground(Color.decode("#9A7B4F"));
        botonMesa3.setFocusPainted(false);
        botonMesa3.setBounds(10, 220, 380, 200);
        botonMesa3.setBorder(BorderFactory.createLineBorder(
            Color.decode("#9A7B4F"), 2
        ));
        panelMesas.add(botonMesa3);

        // Mesa 4
        JButton botonMesa4 = new JButton("Mesa 4");
        botonMesa4.setPreferredSize(new Dimension(380, 200));
        botonMesa4.setFont(new Font("Arial", Font.BOLD, 30));
        botonMesa4.setBackground(Color.WHITE);
        botonMesa4.setForeground(Color.decode("#9A7B4F"));
        botonMesa4.setFocusPainted(false);
        botonMesa4.setBounds(410, 220, 380, 200);
        botonMesa4.setBorder(BorderFactory.createLineBorder(
            Color.decode("#9A7B4F"), 2
        ));
        panelMesas.add(botonMesa4);

        // Mesa 5
        JButton botonMesa5 = new JButton("Mesa 5");
        botonMesa5.setPreferredSize(new Dimension(380, 200));
        botonMesa5.setFont(new Font("Arial", Font.BOLD, 30));
        botonMesa5.setBackground(Color.WHITE);
        botonMesa5.setForeground(Color.decode("#9A7B4F"));
        botonMesa5.setFocusPainted(false);
        botonMesa5.setBounds(10, 430, 380, 200);
        botonMesa5.setBorder(BorderFactory.createLineBorder(
            Color.decode("#9A7B4F"), 2
        ));
        panelMesas.add(botonMesa5);

        // Mesa 6
        JButton botonMesa6 = new JButton("Mesa 6");
        botonMesa6.setPreferredSize(new Dimension(380, 200));
        botonMesa6.setFont(new Font("Arial", Font.BOLD, 30));
        botonMesa6.setBackground(Color.WHITE);
        botonMesa6.setForeground(Color.decode("#9A7B4F"));
        botonMesa6.setFocusPainted(false);
        botonMesa6.setBounds(410, 430, 380, 200);
        botonMesa6.setBorder(BorderFactory.createLineBorder(
            Color.decode("#9A7B4F"), 2
        ));
        panelMesas.add(botonMesa6);

        // Para llevar
        JButton botonLlevar = new JButton("Para llevar");
        botonLlevar.setPreferredSize(new Dimension(300, 60));
        botonLlevar.setFont(new Font("Arial", Font.BOLD, 30));
        botonLlevar.setBackground(Color.decode("#9A7B4F"));
        botonLlevar.setForeground(Color.WHITE);
        botonLlevar.setFocusPainted(false);
        botonLlevar.setBounds(250, 650, 300, 60);
        panelMesas.add(botonLlevar);

        pantallaMesas.add(panelMesas);
        pantallaMesas.add(panelNavegacionMesas);

        /* ==============
        Pantalla Caja
        ============== */

        JPanel pantallaCaja = new JPanel();
        pantallaCaja.setLayout(null);

        /* ====================
        REGISTRO DE PANTALLAS
        ==================== */

        pantallas.add(pantallaInicio, "inicio");
        pantallas.add(pantallaUsuarios, "usuarios");
        pantallas.add(pantallaCategorias, "categorias");
            pantallas.add(pantallaMesas, "mesas");
            pantallas.add(pantallaCaja, "caja");

        ventana.add(pantallas);

        // Mostrar ventana
        ventana.setVisible(true);
    }
}
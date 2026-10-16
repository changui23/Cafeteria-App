import java.awt.*;
import javax.swing.*;

public class CafeteriaApp {

    public static void main(String[] args) {

        String[] usuarioCajero = { "Error" };
        JLabel nombreUsuario = new JLabel();
        JLabel nombreUsuarioMesas = new JLabel();
        JLabel nombreUsuarioCorte = new JLabel();
        JLabel fecha = new JLabel("01/01/2026");

        // Ventana Principal
        JFrame ventana = new JFrame("Cafetería El Cafe");

        ventana.setSize(600, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        // Administrar Pantallas
        CardLayout cardLayout = new CardLayout();
        JPanel pantallas = new JPanel(cardLayout);

        /*
         * ================
         * Pantalla de Inicio
         * ================
         */

        JPanel pantallaInicio = new JPanel();
        pantallaInicio.setLayout(null);

        // Crear texto
        JLabel nombreCaf = crearLabel("Cafeteria el Cafe", 50, 50, 50, 500, 70, "", "");

        // crear boton
        JButton botonEntrar = crearBoton("Entrar", 200, 50, 18, "#9A7B4F", "#ffffff", 200, 150);

        // funcionalidad Boton Entrar
        botonEntrar.addActionListener(e -> {
            ventana.setSize(600, 600);
            ventana.setLocationRelativeTo(null);
            cardLayout.show(pantallas, "usuarios");
        });

        // Añadir componentes
        pantallaInicio.add(nombreCaf);
        pantallaInicio.add(botonEntrar);

        /*
         * ==================
         * Pantalla de Usuarios
         * ===================
         */

        JPanel pantallaUsuarios = new JPanel();
        pantallaUsuarios.setLayout(null);

        // Texto inicio de sesión
        JLabel tituloUsuarios = crearLabel("Inicio de sesion", 50, 100, 100, 400, 70, "", "");

        // Texto numero de cajero
        JLabel textoUsuario = crearLabel("ID del cajero", 20, 150, 200, 300, 50, "", "");

        // Campo de texto para el usuario
        JTextField campoUsuario = crearTextField("", 5, 20, 150, 250, 300, 50);

        // Texto contraseña
        JLabel textoContrasena = crearLabel("Contraseña", 20, 150, 300, 300, 50, "", "");

        // Campo de texto para la contraseña
        JTextField campoContrasena = crearTextField("", 4, 20, 150, 350, 300, 50);

        // Boton de inicio de sesión
        JButton botonUsuarios = crearBoton("Aceptar", 200, 50, 18, "#9A7B4F", "#ffffff", 200, 420);

        botonUsuarios.addActionListener(e -> {
            // Obtener los valores ingresados por el usuario
            String usuario = campoUsuario.getText();
            String contrasena = campoContrasena.getText();

            // Usuarios y contraseñas válidos
            if (usuario.equals("85315") && contrasena.equals("1701")) {
                usuarioCajero[0] = "Jose Angel";
                nombreUsuario.setText(usuarioCajero[0]);
                nombreUsuarioMesas.setText(usuarioCajero[0]);
                nombreUsuarioCorte.setText(usuarioCajero[0]);
                ventana.setSize(1000, 700);
                ventana.setLocationRelativeTo(null);
                cardLayout.show(pantallas, "categorias");
                campoUsuario.setText("");
                campoContrasena.setText("");
            } else if (usuario.equals("86301") && contrasena.equals("2465")) {
                usuarioCajero[0] = "Santiago Gonzalez";
                nombreUsuario.setText(usuarioCajero[0]);
                nombreUsuarioMesas.setText(usuarioCajero[0]);
                nombreUsuarioCorte.setText(usuarioCajero[0]);
                ventana.setSize(1000, 700);
                ventana.setLocationRelativeTo(null);
                cardLayout.show(pantallas, "categorias");
                campoUsuario.setText("");
                campoContrasena.setText("");
            } else if (usuario.equals("83781") && contrasena.equals("6767")) {
                usuarioCajero[0] = "Jorge Tejo";
                nombreUsuario.setText(usuarioCajero[0]);
                nombreUsuarioMesas.setText(usuarioCajero[0]);
                nombreUsuarioCorte.setText(usuarioCajero[0]);
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
        pantallaUsuarios.add(botonUsuarios);
        pantallaUsuarios.add(textoContrasena);
        pantallaUsuarios.add(textoUsuario);
        pantallaUsuarios.add(campoContrasena);
        pantallaUsuarios.add(campoUsuario);
        pantallaUsuarios.add(tituloUsuarios);

        /*
         * ================
         * Pantalla Categorias
         * ================
         */

        JPanel pantallaCategorias = new JPanel();
        pantallaCategorias.setLayout(null);

        // Panel de navegación
        JPanel panelNavegacionCategorias = crearBarraNavegacion(
                "usuarios", nombreUsuario, ventana, cardLayout, pantallas, 1000, 600, 600);

        // Panel de categorías
        JPanel panelCategorias = crearPanel(0, 50, 1000, 580);

        // Boton Dia
        JButton botonDia = crearBoton("Dia", 280, 530, 50, "#9A7B4F", "#ffffff", 50, 25);
        panelCategorias.add(botonDia);

        // Dialogo Dia
        botonDia.addActionListener(e -> {
            JDialog dialogoDia = crearDialogo(ventana, "Día de operación", true, 350, 200);

            JLabel fechaDia = crearLabel("Dia de operacion: ", 20, 75, 10, 200, 30, "", "");

            JTextField campoFechaDia = crearTextField(fecha.getText(), 10, 20, 100, 50, 150, 30);

            JButton aceptarDia = crearBoton("Aceptar", 150, 60, 20, "#9A7B4F", "#ffffff", 100, 100);

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
        JButton botonMesas = crearBoton("Mesas", 280, 530, 50, "#9A7B4F", "#ffffff", 360, 25);
        panelCategorias.add(botonMesas);

        botonMesas.addActionListener(e -> {
            ventana.setSize(808, 800);
            ventana.setLocationRelativeTo(null);
            cardLayout.show(pantallas, "mesas");
            nombreUsuarioMesas.setText(nombreUsuario.getText());
        });

        // Boton Caja
        JButton botonCaja = crearBoton("Caja", 280, 530, 50, "#9A7B4F", "#ffffff", 670, 25);
        panelCategorias.add(botonCaja);

        botonCaja.addActionListener(e -> {
            JOptionPane.showMessageDialog(ventana, "Pantalla de Caja");
        });

        // Panel de abajo de categorías
        JPanel panelAbajoCategorias = crearPanel(0, 630, 1000, 45);
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

        /*
         * ===============
         * Pantalla Mesas
         * ===============
         */

        JPanel pantallaMesas = new JPanel();
        pantallaMesas.setLayout(null);

        // Panel de navegación
        JPanel panelNavegacionMesas = crearBarraNavegacion("categorias", nombreUsuarioMesas, ventana, cardLayout,
                pantallas, 800, 1000, 700);

        // Panel de Mesas
        JPanel panelMesas = crearPanel(0, 50, 800, 750);

        // Mesa 1
        JButton botonMesa1 = crearBoton("Mesa 1", 380, 200, 30, "#ffffff", "#9A7B4F", 10, 10);
        botonMesa1.setBorder(BorderFactory.createLineBorder(
                Color.decode("#9A7B4F"), 2));
        panelMesas.add(botonMesa1);

        botonMesa1.addActionListener(e -> {
            abrirMesa(1, ventana);
        });

        // Mesa 2
        JButton botonMesa2 = crearBoton("Mesa 2", 380, 200, 30, "#ffffff", "#9A7B4F", 410, 10);
        botonMesa2.setBorder(BorderFactory.createLineBorder(
                Color.decode("#9A7B4F"), 2));
        panelMesas.add(botonMesa2);

        // Mesa 3
        JButton botonMesa3 = crearBoton("Mesa 3", 380, 200, 30, "#ffffff", "#9A7B4F", 10, 220);
        botonMesa3.setBorder(BorderFactory.createLineBorder(
                Color.decode("#9A7B4F"), 2));
        panelMesas.add(botonMesa3);

        // Mesa 4
        JButton botonMesa4 = crearBoton("Mesa 4", 380, 200, 30, "#ffffff", "#9A7B4F", 410, 220);
        botonMesa4.setBorder(BorderFactory.createLineBorder(
                Color.decode("#9A7B4F"), 2));
        panelMesas.add(botonMesa4);

        // Mesa 5
        JButton botonMesa5 = crearBoton("Mesa 5", 380, 200, 30, "#ffffff", "#9A7B4F", 10, 430);
        botonMesa5.setBorder(BorderFactory.createLineBorder(
                Color.decode("#9A7B4F"), 2));
        panelMesas.add(botonMesa5);

        // Mesa 6
        JButton botonMesa6 = crearBoton("Mesa 6", 380, 200, 30, "#ffffff", "#9A7B4F", 410, 430);
        botonMesa6.setBorder(BorderFactory.createLineBorder(
                Color.decode("#9A7B4F"), 2));
        panelMesas.add(botonMesa6);

        // Para llevar
        JButton botonLlevar = crearBoton("Para Llevar", 300, 60, 30, "#9A7B4F", "#ffffff", 250, 650);
        panelMesas.add(botonLlevar);

        pantallaMesas.add(panelMesas);
        pantallaMesas.add(panelNavegacionMesas);

        /*
         * ==============
         * Pantalla Caja
         * ==============
         */

        JPanel pantallaCaja = new JPanel();
        pantallaCaja.setLayout(null);

        /*
         * ====================
         * REGISTRO DE PANTALLAS
         * ====================
         */

        pantallas.add(pantallaInicio, "inicio");
        pantallas.add(pantallaUsuarios, "usuarios");
        pantallas.add(pantallaCategorias, "categorias");
        pantallas.add(pantallaMesas, "mesas");
        pantallas.add(pantallaCaja, "caja");

        ventana.add(pantallas);

        // Mostrar ventana
        ventana.setVisible(true);
    }

    /*
     * ======
     * METODOS
     * ======
     */

    // Crear Texto
    public static JLabel crearLabel(String texto, int size, int x, int y, int width, int height, String colorBackground,
            String colorForeground) {
        JLabel etiqueta = new JLabel(texto, SwingConstants.CENTER);

        etiqueta.setFont(new Font("Arial", Font.BOLD, size));
        etiqueta.setBounds(x, y, width, height);
        if (!colorBackground.equals("")) {
            etiqueta.setBackground(Color.decode(colorBackground));
        }
        if (colorForeground.equals("")) {
            etiqueta.setForeground(Color.BLACK);
        } else {
            etiqueta.setForeground(Color.decode(colorForeground));
        }

        return etiqueta;
    }

    // Crear boton
    public static JButton crearBoton(String texto, int width, int height, int size, String colorBackground,
            String colorForeground, int x, int y) {
        JButton boton = new JButton(texto);

        boton.setPreferredSize(new Dimension(width, height));

        // Estilo del Boton
        boton.setFont(new Font("Arial", Font.BOLD, size));
        if (!colorBackground.equals("")) {
            boton.setBackground(Color.decode(colorBackground));
        }
        if (colorForeground.equals("")) {
            boton.setForeground(Color.BLACK);
        } else {
            boton.setForeground(Color.decode(colorForeground));
        }
        boton.setFocusPainted(false);
        boton.setBounds(x, y, width, height);

        return boton;
    }

    // Crear TextField
    public static JTextField crearTextField(String text, int columns, int size, int x, int y, int width, int height) {
        JTextField textField = new JTextField(text, columns);
        textField.setFont(new Font("Arial", Font.PLAIN, size));
        textField.setBounds(x, y, width, height);

        return textField;
    }

    // Crear Panel
    public static JPanel crearPanel(int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x, y, width, height);

        return panel;
    }

    // Crear panel de navegacion
    public static JPanel crearBarraNavegacion(
            String pantallaAnterior,
            JLabel nombreUsuario,
            JFrame ventana,
            CardLayout cardLayout,
            JPanel pantallas,
            int width,
            int widthAnterior,
            int heightAnterior) {

        JPanel panelNavegacion = crearPanel(0, 0, width, 50);
        panelNavegacion.setBackground(Color.decode("#9A7B4F"));

        // Crear una etiqueta independiente para esta barra
        nombreUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
        nombreUsuario.setForeground(Color.WHITE);
        nombreUsuario.setBounds(15, 0, 250, 50);
        panelNavegacion.add(nombreUsuario);

        JButton botonRegresar = crearBoton("Regresar", 200, 40, 18, "#ffffff", "#9A7B4F", width - 220, 5);
        panelNavegacion.add(botonRegresar);

        botonRegresar.addActionListener(e -> {
            ventana.setSize(widthAnterior, heightAnterior);
            ventana.setLocationRelativeTo(null);
            cardLayout.show(pantallas, pantallaAnterior);
        });

        return panelNavegacion;
    }

    // Crear Dialogo
    public static JDialog crearDialogo(JFrame ventana, String titulo, boolean modal, int width, int height) {
        JDialog dialogo = new JDialog(ventana, titulo, modal);
        dialogo.setSize(width, height);
        dialogo.setLocationRelativeTo(ventana);
        dialogo.setLayout(null);

        return dialogo;
    }

    // Dialogo Mesas
    public static void abrirMesa(int numeroMesa, JFrame ventana) {

        JDialog dialogoMesa = crearDialogo(ventana, "Mesa " + numeroMesa, true, 600, 600);

        // Panel productos
        JPanel panelProductos = crearPanel(0, 250, 300, 400);
        CardLayout cardLayout = new CardLayout();
        panelProductos.setLayout(cardLayout);

        JPanel panelVacio = crearPanel(0, 0, 300, 400);
        cardLayout.show(panelProductos, "vacio");

        // Panel Navegacion
        JPanel panelNavegacion = crearPanel(0, 0, 600, 50);
        panelNavegacion.setBackground(Color.decode("#9A7B4F"));

        JLabel titulo = crearLabel("Mesa " + numeroMesa, 20, 250, 5, 100, 40, "", "#ffffff");
        panelNavegacion.add(titulo);

        JButton botonCerrar = crearBoton("Cerrar", 100, 40, 18, "#ffffff", "#9A7B4F", 480, 5);
        panelNavegacion.add(botonCerrar);

        botonCerrar.addActionListener(e -> dialogoMesa.dispose());

        // Panel Categorias
        JPanel panelCategorias = crearPanel(0, 50, 300, 200);

        JLabel labelCategorias = crearLabel("CATEGORIAS", 30, 20, 30, 200, 50, "", "");
        labelCategorias.setHorizontalAlignment(SwingConstants.LEFT);
        panelCategorias.add(labelCategorias);

        JButton botonCafes = crearBoton("Cafes", 120, 40, 20, "#9A7B4F", "#ffffff", 20, 90);
        panelCategorias.add(botonCafes);
        botonCafes.addActionListener(e -> {
            cardLayout.show(panelProductos, "cafes");
        });

        JButton botonPostres = crearBoton("Postres", 120, 40, 20, "#9A7B4F", "#ffffff", 160, 90);
        panelCategorias.add(botonPostres);
        botonPostres.addActionListener(e -> {
            cardLayout.show(panelProductos, "postres");
        });

        JButton botonSnacks = crearBoton("Snacks", 120, 40, 20, "#9A7B4F", "#ffffff", 20, 140);
        panelCategorias.add(botonSnacks);

        JButton botonBebidas = crearBoton("Bebidas", 120, 40, 20, "#9A7B4F", "#ffffff", 160, 140);
        panelCategorias.add(botonBebidas);

        /*
         * ==================
         * PANEL DE PRODUCTOS
         * ==================
         */

        // Cafes
        JPanel panelCafes = crearPanel(0, 0, 300, 400);

        JLabel labelCafes = crearLabel("CAFES", 30, 20, 0, 200, 50, "", "");
        labelCafes.setHorizontalAlignment(SwingConstants.LEFT);
        panelCafes.add(labelCafes);

        JButton botonEspresso = crearBoton("Espresso", 120, 40, 12, "#9A7B4F", "#ffffff", 20, 60);
        panelCafes.add(botonEspresso);

        JButton botonAmericano = crearBoton("Americano", 120, 40, 12, "#9A7B4F", "#ffffff", 160, 60);
        panelCafes.add(botonAmericano);

        JButton botonCappuccino = crearBoton("Cappuccino", 120, 40, 12, "#9A7B4F", "#ffffff", 20, 110);
        panelCafes.add(botonCappuccino);

        JButton botonLatte = crearBoton("Latte", 120, 40, 12, "#9A7B4F", "#ffffff", 160, 110);
        panelCafes.add(botonLatte);

        JButton botonMocaccino = crearBoton("Mocaccino", 120, 40, 12, "#9A7B4F", "#ffffff", 20, 160);
        panelCafes.add(botonMocaccino);

        JButton botonMoka = crearBoton("Moka", 120, 40, 12, "#9A7B4F", "#ffffff", 160, 160);
        panelCafes.add(botonMoka);

        JButton botonMacchiato = crearBoton("Macchiato", 120, 40, 12, "#9A7B4F", "#ffffff", 20, 210);
        panelCafes.add(botonMacchiato);

        JButton botonOlla = crearBoton("Olla", 120, 40, 12, "#9A7B4F", "#ffffff", 160, 210);
        panelCafes.add(botonOlla);

        JButton botonAffogato = crearBoton("Affogato", 120, 40, 12, "#9A7B4F", "#ffffff", 20, 260);
        panelCafes.add(botonAffogato);

        JButton botonFlatWhite = crearBoton("Flat White", 120, 40, 12, "#9A7B4F", "#ffffff", 160, 260);
        panelCafes.add(botonFlatWhite);

        // Panel postres
        JPanel panelPostres = crearPanel(0, 0, 300, 400);

        JLabel labelPostres = crearLabel("POSTRES", 30, 20, 0, 200, 50, "", "");
        labelPostres.setHorizontalAlignment(SwingConstants.LEFT);
        panelPostres.add(labelPostres);

        JButton botonBrownie = crearBoton("Brownie", 120, 40, 12, "#9A7B4F", "#ffffff", 20, 60);
        panelPostres.add(botonBrownie);

        JButton botonCheeseCake = crearBoton("Cheesecake", 120, 40, 12, "#9A7B4F", "#ffffff", 160, 60);
        panelPostres.add(botonCheeseCake);

        JButton botonPastel = crearBoton("Pastel Choco", 120, 40, 12, "#9A7B4F", "#ffffff", 20, 110);
        panelPostres.add(botonPastel);

        JButton botonGalleta = crearBoton("Galleta", 120, 40, 12, "#9A7B4F", "#ffffff", 160, 110);
        panelPostres.add(botonGalleta);

        JButton botonDona = crearBoton("Dona", 120, 40, 12, "#9A7B4F", "#ffffff", 20, 160);
        panelPostres.add(botonDona);

        JButton botonRolCanela = crearBoton("Rol Canela", 120, 40, 12, "#9A7B4F", "#ffffff", 160, 160);
        panelPostres.add(botonRolCanela);

        JButton botonMuffin = crearBoton("Muffin", 120, 40, 12, "#9A7B4F", "#ffffff", 20, 210);
        panelPostres.add(botonMuffin);

        JButton botonPay = crearBoton("Pay", 120, 40, 12, "#9A7B4F", "#ffffff", 160, 210);
        panelPostres.add(botonPay);

        JButton botonCrepa = crearBoton("Crepa", 120, 40, 12, "#9A7B4F", "#ffffff", 20, 260);
        panelPostres.add(botonCrepa);

        JButton botonCakePop = crearBoton("Cake Pop", 120, 40, 12, "#9A7B4F", "#ffffff", 160, 260);
        panelPostres.add(botonCakePop);

        panelProductos.add(panelVacio, "vacio");
        panelProductos.add(panelCafes, "cafes");
        panelProductos.add(panelPostres, "postres");

        // Panel Cuenta
        JPanel panelCuenta = crearPanel(300, 50, 300, 400);

        // Panel Total
        JPanel panelTotal = crearPanel(300, 450, 300, 150);

        dialogoMesa.add(panelNavegacion);
        dialogoMesa.add(panelCategorias);
        dialogoMesa.add(panelProductos);
        dialogoMesa.add(panelCuenta);
        dialogoMesa.add(panelTotal);

        dialogoMesa.setVisible(true);
    }
}
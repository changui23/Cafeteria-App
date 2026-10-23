import java.awt.*;
import javax.swing.*;

public class CafeteriaApp {

    public static String colorCafeClaro = "#9A7B4F";
    public static String colorBlanco = "#ffffff";
    public static String colorGrisClaro = "#a4a4a4";

    static String[] productos = {
            // Cafes
            "Espresso", "Americano", "Cappuccino", "Latte",
            "Mocaccino", "Moka", "Caramel Macchiato", "Olla",
            "Affogato", "Flat White",

            // Postres
            "Brownie", "Cheesecake", "Pastel Choco",
            "Galleta", "Dona", "Rol Canela",
            "Muffin", "Pay", "Crepa", "Cake Pop",

            // Snacks
            "Sandwich", "Cuernito", "Panini", "Papas",
            "Nachos", "Molletes", "Nuggets", "Dedos Queso",
            "Hot Dog", "Chicken Bake",

            // Bebidas
            "Malteada", "Taro", "Hot Choco", "Frappe",
            "Chai", "Limonada", "Te Helado", "Horchata",
            "Smoothie", "Matcha"
    };

    static double[] precios = {
            // Cafes
            30, 35, 45, 45, 50, 48, 55, 28, 52, 46,

            // Postres
            35, 45, 40, 15, 18, 25, 22, 38, 45, 20,

            // Snacks
            55, 50, 65, 40, 45, 42, 50, 60, 38, 65,

            // Bebidas
            55, 55, 45, 58, 55, 35, 32, 35, 50, 55
    };

    static int[][] cantidadesMesas = new int[7][40];

    static double[] totalCobradoDia = new double[7];

    static String fechaOperacion = "02/11/2026";

    static double dineroInicial;

    static double efectivoRetirado = 0;

    public static void main(String[] args) {

        String[] usuarioCajero = { "Error" };
        JLabel nombreUsuario = new JLabel();
        JLabel nombreUsuarioMesas = new JLabel();
        JLabel nombreUsuarioCorte = new JLabel();
        JLabel labelFecha = new JLabel(fechaOperacion);

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
        JButton botonEntrar = crearBoton("Entrar", 200, 50, 18, colorCafeClaro, colorBlanco, 200, 150);

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
        JButton botonUsuarios = crearBoton("Aceptar", 200, 50, 18, colorCafeClaro, colorBlanco, 200, 420);

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
        JButton botonDia = crearBoton("Dia", 280, 530, 50, colorCafeClaro, colorBlanco, 50, 25);
        panelCategorias.add(botonDia);

        // Dialogo Dia
        botonDia.addActionListener(e -> {
            JDialog dialogoDia = crearDialogo(ventana, "Día de operación", true, 350, 200);

            JLabel fechaDia = crearLabel("Dia de operacion: ", 20, 75, 10, 200, 30, "", "");

            JTextField campoFechaDia = crearTextField(fechaOperacion, 10, 20, 100, 50, 150, 30);

            JButton aceptarDia = crearBoton("Aceptar", 150, 60, 20, colorCafeClaro, colorBlanco, 100, 100);

            aceptarDia.addActionListener(ev -> {
                try {
                    java.time.LocalDate.parse(
                            campoFechaDia.getText(),
                            java.time.format.DateTimeFormatter.ofPattern("dd/MM/uuuu"));

                    fechaOperacion = campoFechaDia.getText();
                    labelFecha.setText(fechaOperacion);
                    dialogoDia.dispose();

                } catch (java.time.format.DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(
                            dialogoDia,
                            "Fecha inválida. Usa el formato dd/MM/aaaa");
                }
            });

            dialogoDia.add(fechaDia);
            dialogoDia.add(campoFechaDia);
            dialogoDia.add(aceptarDia);

            dialogoDia.setVisible(true);
        });

        // Boton Mesas
        JButton botonMesas = crearBoton("Mesas", 280, 530, 50, colorCafeClaro, colorBlanco, 360, 25);
        panelCategorias.add(botonMesas);

        botonMesas.addActionListener(e -> {
            ventana.setSize(808, 720);
            ventana.setLocationRelativeTo(null);
            cardLayout.show(pantallas, "mesas");
            nombreUsuarioMesas.setText(nombreUsuario.getText());
        });

        // Boton Caja
        JLabel labelFondoInicial = crearLabel("$0.00", 20, 20, 60, 200, 40, "", colorCafeClaro);
        JLabel labelEntradasNetas = crearLabel("$0.00", 20, 420, 60, 200, 40, "", colorCafeClaro);
        JLabel labelVentas = crearLabel("$0.00", 20, 20, 150, 200, 40, "", colorCafeClaro);
        JLabel labelEfectivo = crearLabel("$0.00", 20, 420, 150, 200, 40, "", colorCafeClaro);

        JButton botonCaja = crearBoton("Caja", 280, 530, 50, colorCafeClaro, colorBlanco, 670, 25);
        panelCategorias.add(botonCaja);
        botonCaja.addActionListener(e -> {
            ventana.setSize(800, 400);
            ventana.setLocationRelativeTo(null);
            cardLayout.show(pantallas, "caja");
            nombreUsuarioCorte.setText(nombreUsuario.getText());
            actualizarCaja(labelEntradasNetas, labelVentas, labelEfectivo, labelFondoInicial);
        });

        // Panel de abajo de categorías
        JPanel panelAbajoCategorias = crearPanel(0, 630, 1000, 45);
        panelAbajoCategorias.setBackground(Color.decode(colorCafeClaro));

        // Fecha
        labelFecha.setFont(new Font("Arial", Font.PLAIN, 20));
        labelFecha.setForeground(Color.WHITE);
        labelFecha.setBounds(870, 0, 130, 40);
        panelAbajoCategorias.add(labelFecha);

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
        JButton botonMesa1 = crearBoton("Mesa 1", 380, 200, 30, colorBlanco, colorCafeClaro, 10, 10);
        botonMesa1.setBorder(BorderFactory.createLineBorder(
                Color.decode(colorCafeClaro), 2));
        panelMesas.add(botonMesa1);
        botonMesa1.addActionListener(e -> {
            abrirMesa(1, ventana);
        });

        // Mesa 2
        JButton botonMesa2 = crearBoton("Mesa 2", 380, 200, 30, colorBlanco, colorCafeClaro, 410, 10);
        botonMesa2.setBorder(BorderFactory.createLineBorder(
                Color.decode(colorCafeClaro), 2));
        panelMesas.add(botonMesa2);
        botonMesa2.addActionListener(e -> {
            abrirMesa(2, ventana);
        });

        // Mesa 3
        JButton botonMesa3 = crearBoton("Mesa 3", 380, 200, 30, colorBlanco, colorCafeClaro, 10, 220);
        botonMesa3.setBorder(BorderFactory.createLineBorder(
                Color.decode(colorCafeClaro), 2));
        panelMesas.add(botonMesa3);
        botonMesa3.addActionListener(e -> {
            abrirMesa(3, ventana);
        });

        // Mesa 4
        JButton botonMesa4 = crearBoton("Mesa 4", 380, 200, 30, colorBlanco, colorCafeClaro, 410, 220);
        botonMesa4.setBorder(BorderFactory.createLineBorder(
                Color.decode(colorCafeClaro), 2));
        panelMesas.add(botonMesa4);
        botonMesa4.addActionListener(e -> {
            abrirMesa(4, ventana);
        });

        // Mesa 5
        JButton botonMesa5 = crearBoton("Mesa 5", 380, 200, 30, colorBlanco, colorCafeClaro, 10, 430);
        botonMesa5.setBorder(BorderFactory.createLineBorder(
                Color.decode(colorCafeClaro), 2));
        panelMesas.add(botonMesa5);
        botonMesa5.addActionListener(e -> {
            abrirMesa(5, ventana);
        });

        // Mesa 6
        JButton botonMesa6 = crearBoton("Mesa 6", 380, 200, 30, colorBlanco, colorCafeClaro, 410, 430);
        botonMesa6.setBorder(BorderFactory.createLineBorder(
                Color.decode(colorCafeClaro), 2));
        panelMesas.add(botonMesa6);
        botonMesa6.addActionListener(e -> {
            abrirMesa(6, ventana);
        });

        pantallaMesas.add(panelMesas);
        pantallaMesas.add(panelNavegacionMesas);

        /*
         * ==============
         * Pantalla Caja
         * ==============
         */

        JPanel pantallaCaja = new JPanel();
        pantallaCaja.setLayout(null);

        // Navegacion
        JPanel panelNavegacionCaja = crearBarraNavegacion("categorias", nombreUsuarioCorte, ventana, cardLayout,
                pantallas, 800, 1000, 700);
        JLabel tituloCaja = crearLabel("Caja", 20, 350, 5, 100, 40, "", colorBlanco);
        panelNavegacionCaja.add(tituloCaja);

        // Datos
        JPanel panelDatosCaja = crearPanel(0, 50, 800, 200);

        JLabel labelTextoFondoInicial = crearLabel("Fondo inicial", 20, 20, 20, 200, 40, "", "");
        labelTextoFondoInicial.setHorizontalAlignment(SwingConstants.LEFT);
        panelDatosCaja.add(labelTextoFondoInicial);

        labelFondoInicial.setHorizontalAlignment(SwingConstants.LEFT);
        panelDatosCaja.add(labelFondoInicial);

        JLabel labelTextoEntradasNetas = crearLabel("Entradas y salidas netas", 20, 420, 20, 300, 40, "", "");
        labelTextoEntradasNetas.setHorizontalAlignment(SwingConstants.LEFT);
        panelDatosCaja.add(labelTextoEntradasNetas);

        labelEntradasNetas.setHorizontalAlignment(SwingConstants.LEFT);
        panelDatosCaja.add(labelEntradasNetas);

        JLabel labelTextoVentas = crearLabel("Ventas del dia", 20, 20, 110, 200, 40, "", "");
        labelTextoVentas.setHorizontalAlignment(SwingConstants.LEFT);
        panelDatosCaja.add(labelTextoVentas);

        labelVentas.setHorizontalAlignment(SwingConstants.LEFT);
        panelDatosCaja.add(labelVentas);

        JLabel labelTextoEfectivo = crearLabel("Efectivo esperado", 20, 420, 110, 200, 40, "", "");
        labelTextoEfectivo.setHorizontalAlignment(SwingConstants.LEFT);
        panelDatosCaja.add(labelTextoEfectivo);

        labelEfectivo.setHorizontalAlignment(SwingConstants.LEFT);
        panelDatosCaja.add(labelEfectivo);

        // Operaciones
        JPanel panelOperacionesCaja = crearPanel(0, 250, 800, 150);

        JLabel labelOperacionesCaja = crearLabel("Operaciones", 20, 20, 0, 200, 40, "", "");
        labelOperacionesCaja.setHorizontalAlignment(SwingConstants.LEFT);
        panelOperacionesCaja.add(labelOperacionesCaja);

        // Boton Abrir Caja
        JButton botonAbrirCaja = crearBoton("Abrir Caja", 240, 60, 20, colorCafeClaro, colorBlanco, 20, 50);
        panelOperacionesCaja.add(botonAbrirCaja);
        botonAbrirCaja.addActionListener(e -> {
            JDialog dialogoAbrirCaja = crearDialogo(ventana, "Abrir Caja", true, 250, 200);

            JPanel panelAbrirCaja = crearPanel(0, 0, 250, 200);

            JLabel labelDineroInicial = crearLabel("Fondo Inicial", 20, 0, 0, 250, 40, "", "");
            panelAbrirCaja.add(labelDineroInicial);

            JTextField textFieldDineroInicial = crearTextField("", 10, 20, 50, 50, 150, 40);
            panelAbrirCaja.add(textFieldDineroInicial);

            JButton botonGuardarAbrirCaja = crearBoton("Guardar", 150, 40, 20, colorCafeClaro, colorBlanco, 50, 110);
            panelAbrirCaja.add(botonGuardarAbrirCaja);
            botonGuardarAbrirCaja.addActionListener(r -> {
                dineroInicial = Double.parseDouble(textFieldDineroInicial.getText());

                actualizarCaja(labelEntradasNetas, labelVentas, labelEfectivo, labelFondoInicial);

                dialogoAbrirCaja.dispose();
            });

            dialogoAbrirCaja.add(panelAbrirCaja);
            dialogoAbrirCaja.setVisible(true);
        });

        // Boton Movimientos
        JButton botonMovimientosCaja = crearBoton("Movimientos", 240, 60, 20, colorCafeClaro, colorBlanco, 280, 50);
        panelOperacionesCaja.add(botonMovimientosCaja);
        botonMovimientosCaja.addActionListener(e -> {
            JDialog dialogoMovimientosCaja = crearDialogo(ventana, "Movimientos de caja", true, 250, 200);

            JPanel panelMovimientosCaja = crearPanel(0, 0, 250, 200);

            JLabel labelRetirar = crearLabel("-Retirar o +Agregar", 20, 0, 0, 250, 40, "", "");
            panelMovimientosCaja.add(labelRetirar);

            JTextField textFieldRetirar = crearTextField("", 10, 20, 50, 50, 150, 40);
            panelMovimientosCaja.add(textFieldRetirar);

            JButton botonGuardarMovimientos = crearBoton("Guardar", 150, 40, 20, colorCafeClaro, colorBlanco, 50, 110);
            panelMovimientosCaja.add(botonGuardarMovimientos);
            botonGuardarMovimientos.addActionListener(r -> {
                efectivoRetirado += Double.parseDouble(textFieldRetirar.getText());

                actualizarCaja(labelEntradasNetas, labelVentas, labelEfectivo, labelFondoInicial);

                dialogoMovimientosCaja.dispose();
            });

            dialogoMovimientosCaja.add(panelMovimientosCaja);
            dialogoMovimientosCaja.setVisible(true);
        });

        // Boton Corte Caja
        JButton botonCorteCaja = crearBoton("Corte", 240, 60, 20, colorCafeClaro, colorBlanco, 540, 50);
        panelOperacionesCaja.add(botonCorteCaja);
        botonCorteCaja.addActionListener(e -> {
            JDialog dialogoCorteCaja = crearDialogo(ventana, "Corte Caja", true, 500, 500);
            JPanel panelCorteCaja = crearPanel(0, 0, 500, 500);

            // Panel Navegacion
            JPanel panelNavegacionCorteCaja = crearPanel(0, 0, 500, 50);
            panelNavegacionCorteCaja.setBackground(Color.decode(colorCafeClaro));
            panelCorteCaja.add(panelNavegacionCorteCaja);

            JLabel nombreUsuarioCorteDialogo = crearLabel(nombreUsuarioCorte.getText(), 20, 0, 0, 250, 50, "",
                    colorBlanco);
            nombreUsuarioCorteDialogo.setFont(new Font("Arial", Font.PLAIN, 20));
            panelNavegacionCorteCaja.add(nombreUsuarioCorteDialogo);

            JLabel labelCorteDeCaja = crearLabel("Corte de Caja", 20, 250, 0, 250, 50, "", colorBlanco);
            panelNavegacionCorteCaja.add(labelCorteDeCaja);

            // Resumen de turno
            JPanel panelResumenTurno = crearPanel(0, 50, 500, 300);
            panelCorteCaja.add(panelResumenTurno);

            JLabel labelResumenTurno = crearLabel("Resumen del turno", 20, 20, 20, 200, 50, "", "");
            labelResumenTurno.setHorizontalAlignment(SwingConstants.LEFT);
            panelResumenTurno.add(labelResumenTurno);

            JPanel panelResumenTurnoNumeros = crearPanel(18, 80, 460, 250);
            panelResumenTurnoNumeros.setBackground(Color.decode(colorCafeClaro));
            panelResumenTurno.add(panelResumenTurnoNumeros);

            JLabel labelTextoFondoInicialCorte = crearLabel("Fondo Inicial", 20, 10, 0, 190, 50, "", colorBlanco);
            labelTextoFondoInicialCorte.setHorizontalAlignment(SwingConstants.LEFT);
            labelTextoFondoInicialCorte.setFont(new Font("Arial", Font.PLAIN, 20));
            panelResumenTurnoNumeros.add(labelTextoFondoInicialCorte);

            JLabel labelFondoInicialCorte = crearLabel("$" + String.format("%.2f", dineroInicial), 20, 250, 0, 200, 50,
                    "", "");
            labelFondoInicialCorte.setHorizontalAlignment(SwingConstants.RIGHT);
            panelResumenTurnoNumeros.add(labelFondoInicialCorte);

            JLabel labelTextoVentasEfectivo = crearLabel("Ventas en Efectivo", 20, 10, 50, 190, 50, "", colorBlanco);
            labelTextoVentasEfectivo.setHorizontalAlignment(SwingConstants.LEFT);
            labelTextoVentasEfectivo.setFont(new Font("Arial", Font.PLAIN, 20));
            panelResumenTurnoNumeros.add(labelTextoVentasEfectivo);

            JLabel labelVentasEfectivo = crearLabel("$" + String.format("%.2f", calcularTotalVentas()), 20, 250, 50,
                    200, 50, "", "");
            labelVentasEfectivo.setHorizontalAlignment(SwingConstants.RIGHT);
            panelResumenTurnoNumeros.add(labelVentasEfectivo);

            JLabel labelTextoMovimientosCrote = crearLabel("Movimientos", 20, 10, 100, 190, 50, "", colorBlanco);
            labelTextoMovimientosCrote.setHorizontalAlignment(SwingConstants.LEFT);
            labelTextoMovimientosCrote.setFont(new Font("Arial", Font.PLAIN, 20));
            panelResumenTurnoNumeros.add(labelTextoMovimientosCrote);

            JLabel labelMovimientosCorte = crearLabel("$" + String.format("%.2f", efectivoRetirado), 20, 250, 100, 200,
                    50, "", "");
            labelMovimientosCorte.setHorizontalAlignment(SwingConstants.RIGHT);
            panelResumenTurnoNumeros.add(labelMovimientosCorte);

            JPanel panelLineaBlanca = crearPanel(0, 150, 460, 5);
            panelResumenTurnoNumeros.add(panelLineaBlanca);

            JLabel labelTextoEfectivoEsperado = crearLabel("Efectivo Esperado", 25, 10, 155, 290, 70, "", "");
            labelTextoEfectivoEsperado.setHorizontalAlignment(SwingConstants.LEFT);
            panelResumenTurnoNumeros.add(labelTextoEfectivoEsperado);

            JLabel labelEfectivoEsperado = crearLabel(
                    "$" + String.format("%.2f", efectivoRetirado + calcularTotalVentas() + dineroInicial), 25, 300, 155,
                    150, 70, "", colorBlanco);
            labelEfectivoEsperado.setHorizontalAlignment(SwingConstants.RIGHT);
            panelResumenTurnoNumeros.add(labelEfectivoEsperado);

            JButton botonCerrarCaja = crearBoton("Cerrar Caja", 300, 60, 20, colorCafeClaro, colorBlanco, 100, 400);
            panelCorteCaja.add(botonCerrarCaja);
            botonCerrarCaja.addActionListener(r -> {
                vaciarTotalVentas();
                actualizarCaja(labelEntradasNetas, labelVentas, labelEfectivo, labelFondoInicial);

                dialogoCorteCaja.dispose();
            });

            dialogoCorteCaja.add(panelCorteCaja);
            dialogoCorteCaja.setVisible(true);
        });

        pantallaCaja.add(panelNavegacionCaja);
        pantallaCaja.add(panelDatosCaja);
        pantallaCaja.add(panelOperacionesCaja);

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
        panelNavegacion.setBackground(Color.decode(colorCafeClaro));

        // Crear una etiqueta independiente para esta barra
        nombreUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
        nombreUsuario.setForeground(Color.WHITE);
        nombreUsuario.setBounds(15, 0, 250, 50);
        panelNavegacion.add(nombreUsuario);

        JButton botonRegresar = crearBoton("Regresar", 200, 40, 18, colorBlanco, colorCafeClaro, width - 220, 5);
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

        // Panel Productos
        JPanel panelProductos = crearPanel(0, 250, 300, 400);
        CardLayout cardLayout = new CardLayout();
        panelProductos.setLayout(cardLayout);

        JPanel panelVacio = crearPanel(0, 0, 300, 400);
        cardLayout.show(panelProductos, "vacio");

        // Panel Navegacion
        JPanel panelNavegacion = crearPanel(0, 0, 600, 50);
        panelNavegacion.setBackground(Color.decode(colorCafeClaro));

        JLabel titulo = crearLabel("Mesa " + numeroMesa, 20, 250, 5, 100, 40, "", colorBlanco);
        panelNavegacion.add(titulo);

        JButton botonCerrar = crearBoton("Cerrar", 100, 40, 18, colorBlanco, colorCafeClaro, 480, 5);
        panelNavegacion.add(botonCerrar);

        botonCerrar.addActionListener(e -> dialogoMesa.dispose());

        // Panel Categorias
        JPanel panelCategorias = crearPanel(0, 50, 300, 200);

        JLabel labelCategorias = crearLabel("CATEGORIAS", 30, 20, 30, 200, 50, "", "");
        labelCategorias.setHorizontalAlignment(SwingConstants.LEFT);
        panelCategorias.add(labelCategorias);

        JButton botonCafes = crearBoton("Cafes", 120, 40, 20, colorCafeClaro, colorBlanco, 20, 90);
        panelCategorias.add(botonCafes);
        botonCafes.addActionListener(e -> {
            cardLayout.show(panelProductos, "cafes");
        });

        JButton botonPostres = crearBoton("Postres", 120, 40, 20, colorCafeClaro, colorBlanco, 160, 90);
        panelCategorias.add(botonPostres);
        botonPostres.addActionListener(e -> {
            cardLayout.show(panelProductos, "postres");
        });

        JButton botonSnacks = crearBoton("Snacks", 120, 40, 20, colorCafeClaro, colorBlanco, 20, 140);
        panelCategorias.add(botonSnacks);
        botonSnacks.addActionListener(e -> {
            cardLayout.show(panelProductos, "snacks");
        });

        JButton botonBebidas = crearBoton("Bebidas", 120, 40, 20, colorCafeClaro, colorBlanco, 160, 140);
        panelCategorias.add(botonBebidas);
        botonBebidas.addActionListener(e -> {
            cardLayout.show(panelProductos, "bebidas");
        });

        // Panel Cuenta
        JPanel panelCuenta = crearPanel(300, 50, 300, 400);

        JTextArea areaCuenta = new JTextArea();
        areaCuenta.setEditable(false);

        JLabel labelCuenta = crearLabel("CUENTA", 30, 20, 30, 200, 50, "", "");
        labelCuenta.setHorizontalAlignment(SwingConstants.LEFT);
        panelCuenta.add(labelCuenta);

        JScrollPane scrollCuenta = new JScrollPane(areaCuenta);
        scrollCuenta.setBounds(10, 90, 280, 250);
        panelCuenta.add(scrollCuenta);

        JLabel labeltextoPromocion = crearLabel("Promocion: ", 20, 20, 340, 290, 35, "", "");
        labeltextoPromocion.setHorizontalAlignment(SwingConstants.LEFT);
        panelCuenta.add(labeltextoPromocion);

        JLabel labelPromocion = crearLabel(obtenerPromocion(), 10, 20, 375, 290, 15, "", "");
        labelPromocion.setHorizontalAlignment(SwingConstants.LEFT);
        panelCuenta.add(labelPromocion);

        // Panel Total
        JPanel panelTotal = crearPanel(300, 450, 300, 150);

        JLabel labelTextoTotal = crearLabel("TOTAL", 30, 20, 0, 130, 40, "", "");
        labelTextoTotal.setHorizontalAlignment(SwingConstants.LEFT);
        JLabel labelTotal = crearLabel(
                "$0.00", 30, 150, 0, 130, 40, "", colorCafeClaro);
        labelTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        panelTotal.add(labelTextoTotal);
        panelTotal.add(labelTotal);

        actualizarCuenta(numeroMesa, areaCuenta, labelTotal);

        JButton botonVaciarCuenta = crearBoton("Vaciar", 120, 40, 20, colorCafeClaro, colorBlanco, 20, 60);
        panelTotal.add(botonVaciarCuenta);
        botonVaciarCuenta.addActionListener(e -> {
            vaciarCuenta(numeroMesa, areaCuenta, labelTotal);
        });

        JButton botonCobrar = crearBoton("Cobrar", 120, 40, 20, colorCafeClaro, colorBlanco, 160, 60);
        panelTotal.add(botonCobrar);
        botonCobrar.addActionListener(e -> {
            JDialog dialogoCobrar = crearDialogo(ventana, "Cobrar", true, 300, 350);
            JLabel tituloCobrar = crearLabel("Cobrar", 20, 100, 0, 100, 40, "", "");

            JPanel panelCobrar = crearPanel(0, 50, 300, 250);

            JLabel textoTotal = crearLabel("Total:", 20, 0, 0, 150, 40, "", "");
            JLabel labelTotalCobrar = crearLabel("$" + calcularTotalMesa(numeroMesa), 20, 150, 0, 130, 40, "",
                    colorCafeClaro);
            panelCobrar.add(textoTotal);
            panelCobrar.add(labelTotalCobrar);

            JLabel textoPago = crearLabel("Pago:", 20, 0, 50, 150, 40, "", "");
            JTextField fieldPago = crearTextField("", 10, 20, 150, 50, 130, 40);
            panelCobrar.add(textoPago);
            panelCobrar.add(fieldPago);

            JLabel textoCambio = crearLabel("Cambio:", 20, 0, 150, 150, 40, "", "");
            JLabel labelCambio = crearLabel("$0.00", 20, 150, 150, 130, 40, "", colorCafeClaro);
            panelCobrar.add(textoCambio);
            panelCobrar.add(labelCambio);

            JButton botonCalcularCambio = crearBoton("Calcular Cambio", 260, 40, 20, colorCafeClaro, colorBlanco, 20,
                    100);
            panelCobrar.add(botonCalcularCambio);
            botonCalcularCambio.addActionListener(r -> {
                double cambio = -((calcularTotalMesa(numeroMesa) - Double.parseDouble(fieldPago.getText())));
                labelCambio.setText("$" + cambio);
            });

            JButton botonGuardar = crearBoton("Guardar", 260, 40, 20, colorCafeClaro, colorBlanco, 20, 200);
            panelCobrar.add(botonGuardar);
            botonGuardar.addActionListener(r -> {
                double totalVenta = calcularTotalMesa(numeroMesa);

                totalCobradoDia[numeroMesa] += totalVenta;

                vaciarCuenta(numeroMesa, areaCuenta, labelTotal);
                dialogoCobrar.dispose();
            });
            dialogoCobrar.add(panelCobrar);
            dialogoCobrar.add(tituloCobrar);

            dialogoCobrar.setVisible(true);
        });

        // Panel de productos

        // Cafes

        JPanel panelCafes = crearPanel(0, 0, 300, 400);

        JLabel labelCafes = crearLabel("CAFES", 30, 20, 0, 200, 50, "", "");
        labelCafes.setHorizontalAlignment(SwingConstants.LEFT);
        panelCafes.add(labelCafes);

        crearBotonesProductos(0, numeroMesa, areaCuenta, labelTotal, panelCafes);

        // Postres
        JPanel panelPostres = crearPanel(0, 0, 300, 400);

        JLabel labelPostres = crearLabel("POSTRES", 30, 20, 0, 200, 50, "", "");
        labelPostres.setHorizontalAlignment(SwingConstants.LEFT);
        panelPostres.add(labelPostres);

        crearBotonesProductos(10, numeroMesa, areaCuenta, labelTotal, panelPostres);

        // Snacks
        JPanel panelSnacks = crearPanel(0, 0, 300, 400);

        JLabel labelSnacks = crearLabel("SNACKS", 30, 20, 0, 200, 50, "", "");
        labelSnacks.setHorizontalAlignment(SwingConstants.LEFT);
        panelSnacks.add(labelSnacks);

        crearBotonesProductos(20, numeroMesa, areaCuenta, labelTotal, panelSnacks);

        // Bebidas
        JPanel panelBebidas = crearPanel(0, 0, 300, 400);

        JLabel labelBebidas = crearLabel("BEBIDAS", 30, 20, 0, 200, 50, "", "");
        labelBebidas.setHorizontalAlignment(SwingConstants.LEFT);
        panelBebidas.add(labelBebidas);

        crearBotonesProductos(30, numeroMesa, areaCuenta, labelTotal, panelBebidas);

        panelProductos.add(panelVacio, "vacio");
        panelProductos.add(panelCafes, "cafes");
        panelProductos.add(panelPostres, "postres");
        panelProductos.add(panelBebidas, "bebidas");
        panelProductos.add(panelSnacks, "snacks");

        dialogoMesa.add(panelNavegacion);
        dialogoMesa.add(panelCategorias);
        dialogoMesa.add(panelProductos);
        dialogoMesa.add(panelCuenta);
        dialogoMesa.add(panelTotal);

        dialogoMesa.setVisible(true);
    }

    // Crear Botones Productos
    public static void crearBotonesProductos(int desfase, int numeroMesa, JTextArea areaCuenta, JLabel labelTotal,
            JPanel panelProductos) {
        for (int i = 0; i < 10; i++) {
            int x = (i % 2 == 0) ? 20 : 160;
            int y = (i % 2 == 0) ? 60 + 50 * i / 2 : 60 + 50 * (i - 1) / 2;

            int indice = i + desfase;

            JButton boton = crearBoton(productos[i + desfase], 120, 40, 12, colorCafeClaro, colorBlanco, x, y);

            boton.addActionListener(e -> {

                cantidadesMesas[numeroMesa][indice]++;

                actualizarCuenta(
                        numeroMesa, areaCuenta, labelTotal);

            });

            panelProductos.add(boton);
        }
    }

    // Actualizar Cuenta
    public static void actualizarCuenta(
            int numeroMesa,
            JTextArea areaCuenta,
            JLabel labelTotal) {

        areaCuenta.setText("");

        for (int i = 0; i < productos.length; i++) {

            int cantidad = cantidadesMesas[numeroMesa][i];

            if (cantidad > 0) {

                double subtotal = cantidad * precios[i];

                areaCuenta.append(
                        productos[i] + " x" + cantidad
                                + " - $" + String.format("%.2f", subtotal)
                                + "\n");
            }
        }

        double total = calcularTotalMesa(numeroMesa);

        labelTotal.setText("$" + String.format("%.2f", total));
    }

    // Calcular total Mesa
    public static double calcularTotalMesa(int numeroMesa) {

        double total = 0;

        for (int i = 0; i < productos.length; i++) {
            int cantidad = cantidadesMesas[numeroMesa][i];

            if (cantidad <= 0) {
                continue;
            }
            if (fechaOperacion.equals("14/02/2026") && i >= 0 && i < 10) {
                int cantidadPagada = cantidad - cantidad / 2;
                total += cantidadPagada * precios[i];
            } else {
                total += cantidad * precios[i];
            }
        }

        total = promoChoco(numeroMesa, total);

        return total;
    }

    // Vaciar cuenta
    public static void vaciarCuenta(int numeroMesa, JTextArea areaCuenta, JLabel labelTotal) {
        for (int i = 0; i < productos.length; i++) {
            cantidadesMesas[numeroMesa][i] = 0;
        }
        actualizarCuenta(numeroMesa, areaCuenta, labelTotal);
    }

    // Obtener Promocion
    public static String obtenerPromocion() {

        if (esDiaPromocion(14, 2)) {
            return "2x1 en cafés";
        }

        if (esDiaPromocion(10, 5)) {
            return "Café gratis para mamás";
        }

        if (esDiaPromocion(2, 11)) {
            return "Pastel Choco gratis con la compra de un café";
        }

        return "Sin promociones por fecha";
    }

    // Es dia Promocion?
    public static boolean esDiaPromocion(int dia, int mes) {
        try {
            java.time.LocalDate fechaActual = java.time.LocalDate.parse(
                    fechaOperacion,
                    java.time.format.DateTimeFormatter.ofPattern("dd/MM/uuuu"));

            return fechaActual.getDayOfMonth() == dia
                    && fechaActual.getMonthValue() == mes;

        } catch (java.time.format.DateTimeParseException ex) {
            return false;
        }
    }

    // Promo pastel Choco
    public static double promoChoco(int numeroMesa, double total) {
        if (esDiaPromocion(2, 11)
                && cantidadesMesas[numeroMesa][12] > 0) {

            boolean comproCafe = false;

            for (int i = 0; i < 10; i++) {
                if (cantidadesMesas[numeroMesa][i] > 0) {
                    comproCafe = true;
                    break;
                }
            }

            if (comproCafe) {
                total -= precios[12];
            }
        }
        return total;
    }

    // Calcular total de Caja
    public static double calcularTotalVentas() {

        double total = 0;

        for (int i = 0; i < totalCobradoDia.length; i++) {
            total += totalCobradoDia[i];
        }

        return total;
    }

    // Vaciar total ventas
    public static void vaciarTotalVentas() {
        for (int i = 0; i < totalCobradoDia.length; i++) {
            totalCobradoDia[i] = 0;
        }

        dineroInicial = 0;
        efectivoRetirado = 0;

    }

    // Actualizar Caja
    public static void actualizarCaja(JLabel labelEntradasNetas, JLabel labelVentas, JLabel labelEfectivo,
            JLabel labelFondoInicial) {
        labelEntradasNetas.setText("$" + String.format("%.2f", calcularTotalVentas()));
        labelVentas.setText("$" + String.format("%.2f", dineroInicial + calcularTotalVentas()));
        labelEfectivo.setText("$" + String.format("%.2f", dineroInicial + calcularTotalVentas() + efectivoRetirado));
        labelFondoInicial.setText("$" + String.format("%.2f", dineroInicial));
    }

}
# Cafetería El Café ☕

¡Bienvenido al repositorio oficial del proyecto **Cafetería El Café**! Este software está desarrollado como parte de la materia de **Lógica de Programación**.

---

## 👥 Integrantes del Equipo
* **Jorge Alonso Trejo Hernández** (ID: 83781)
* **José Ángel Sierra** (ID: 85315)
* **Santiago González** (ID: 86301)

---

## 📌 Descripción del Proyecto
**Cafetería El Café** es una aplicación de escritorio desarrollada en **Java** utilizando **Swing** y `CardLayout`. Su objetivo es simular el flujo operativo básico de una cafetería, permitiendo el control de acceso de cajeros, la gestión de días de operación, la selección de categorías y la administración visual de mesas para la toma de pedidos.

---

## ⚙️ ¿Cómo Funciona la Aplicación?

1. **Pantalla de Inicio:** Muestra el título del sistema y un botón **"Entrar"** para acceder al módulo de inicio de sesión.
2. **Inicio de Sesión (Autenticación de Cajeros):** El sistema valida las credenciales de cada cajero mediante su ID y contraseña:
   * **José Ángel:** ID `85315` | Contraseña `1701`
   * **Santiago González:** ID `86301` | Contraseña `2465`
   * **Jorge Trejo:** ID `83781` | Contraseña `6767`
3. **Panel de Categorías:** Una vez autenticado, se muestra el nombre del cajero en la barra superior y se accede al menú principal con tres opciones:
   * **Día:** Permite consultar y modificar la fecha de operación del sistema mediante un cuadro de diálogo.
   * **Mesas:** Despliega una interfaz gráfica interactiva con 6 mesas disponibles y una opción de "Para llevar".
   * **Caja:** Módulo reservado para las transacciones y cobros.
4. **Navegación Dinámica:** Utiliza `CardLayout` para alternar fluidamente entre las distintas pantallas ajustando automáticamente las dimensiones de la ventana principal.

---

## 🛠️ Instrucciones para Clonar y Ejecutar el Repositorio

Sigue estos pasos para clonar el proyecto en tu computadora y editarlo o probarlo en tu entorno de desarrollo favorito (IntelliJ IDEA, Eclipse, NetBeans o VS Code):

### 1. Clonar el repositorio
Abre tu terminal y ejecuta el siguiente comando:

```bash
git clone <URL_DEL_REPOSITORIO>

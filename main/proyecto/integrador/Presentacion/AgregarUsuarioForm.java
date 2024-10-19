/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Presentacion;

/**
 *
 * @author genny
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.proyecto.integrador.Datos.Usuarios;
import main.proyecto.integrador.Logica.UsuarioService;
//import main.proyecto.integrador.Presentacion.Principal;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class AgregarUsuarioForm extends JDialog {
      private JTextField txtCedula, txtNombre, txtApellido, txtEmail, txtLogin, txtContrasena;
    private JComboBox<String> comboBoxActivo;
    private Principal principal;

    public AgregarUsuarioForm(Principal principal) {
        this.principal = principal; // Guarda la referencia a la clase Principal
        setTitle("Agregar Usuario");
        setModal(true);
        setSize(400, 350); // Ajusta el tamaño del diálogo
        setLocationRelativeTo(principal); // Centra el diálogo en la ventana principal
        setResizable(false); // Opcional: no permitir que se redimensione

        // Configura el formulario con GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes

        // Crea y agrega los componentes
        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("Cédula:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; txtCedula = new JTextField(20); add(txtCedula, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; txtNombre = new JTextField(20); add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("Apellido:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; txtApellido = new JTextField(20); add(txtApellido, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; txtEmail = new JTextField(20); add(txtEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 4; add(new JLabel("Activo:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4; comboBoxActivo = new JComboBox<>(new String[]{"S", "N"}); add(comboBoxActivo, gbc);

        gbc.gridx = 0; gbc.gridy = 5; add(new JLabel("Login:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5; txtLogin = new JTextField(20); add(txtLogin, gbc);

        gbc.gridx = 0; gbc.gridy = 6; add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1; gbc.gridy = 6; txtContrasena = new JPasswordField(20); add(txtContrasena, gbc);

        // Configura los botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        buttonPanel.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose()); // Cierra el diálogo sin guardar
        buttonPanel.add(btnCancelar);

        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2; // Ocupa dos columnas
        add(buttonPanel, gbc); // Agrega el panel de botones

        // Establece un tamaño mínimo para el diálogo
        setMinimumSize(new Dimension(400, 350));
        setPreferredSize(new Dimension(400, 350));
    }

    private void btnGuardarActionPerformed(ActionEvent evt) {
        // Recoge datos del formulario
        String cedula = txtCedula.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String email = txtEmail.getText();
        char activo = comboBoxActivo.getSelectedItem().toString().charAt(0);
        String login = txtLogin.getText();
        String contrasena = txtContrasena.getText();

        Usuarios nuevoUsuario = new Usuarios(cedula, nombre, apellido, email, login, contrasena, activo);
        UsuarioService usuarioService = new UsuarioService();

        // Verifica si el usuario ya existe
        if (usuarioService.existeUsuario(cedula)) {
            JOptionPane.showMessageDialog(this, "El usuario ya existe.");
        } else {
            // Agrega el nuevo usuario
            if (usuarioService.agregarUsuario(nuevoUsuario)) {
                JOptionPane.showMessageDialog(this, "Usuario agregado exitosamente");

                // Llama al método listarTablaUsuarios en la instancia principal
                principal.listarTablaUsuarios();

                dispose(); // Cierra el formulario
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar usuario");
            }
        }
    }
}
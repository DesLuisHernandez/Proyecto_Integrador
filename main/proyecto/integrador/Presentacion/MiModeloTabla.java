/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Presentacion;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author genny
 */
public class MiModeloTabla extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        // La columna 0 (Cédula) no es editable, las demás sí
        return column != 0;
    }
}
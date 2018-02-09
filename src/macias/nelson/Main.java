package macias.nelson;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Placa ventana = new Placa();
        ventana.setUndecorated(true);
        ventana.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        ventana.setBounds(400,200,600,300);
        ventana.setVisible(true);
    }
}
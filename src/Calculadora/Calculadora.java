package Calculadora;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class Calculadora implements ActionListener{

    JFrame frame2;
    JTextField espacioTexto;
    JButton[] botonesDeNumeros = new JButton[10];
    JButton[] botonesDeFunciones = new JButton[9];
    JButton botonSuma,botonResta,botonMultiplicar,botonDividir;
    JButton botonDecimal,botonIgual,botonBorrar, botonLimpiar, botonNegativo;
    JPanel panel;

    Font miFuente = new Font("Verdana", Font.BOLD, 20);

    double valor1=0, valor2=0, resultado=0;
    char operador;

    Calculadora() {

        frame2 = new JFrame("Calculadora");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(420, 550);
        frame2.setLayout(null);
        frame2.setResizable(false); // Para que el tamaño de la ventana no se pueda ajustar

        espacioTexto = new JTextField();
        espacioTexto.setBounds(50, 25, 300, 40);
        espacioTexto.setFont(miFuente);
        espacioTexto.setEditable(false);
        espacioTexto.setBorder(new LineBorder(Color.BLUE));


        botonSuma = new JButton("+");
        botonResta = new JButton("-");
        botonMultiplicar = new JButton("x");
        botonDividir = new JButton("/");
        botonDecimal = new JButton(".");
        botonIgual = new JButton("=");
        botonBorrar = new JButton("C/A");
        botonLimpiar = new JButton("C");
        botonNegativo = new JButton("(-)");

        botonesDeFunciones[0] = botonSuma;
        botonesDeFunciones[1] = botonResta;
        botonesDeFunciones[2] = botonMultiplicar;
        botonesDeFunciones[3] = botonDividir;
        botonesDeFunciones[4] = botonDecimal;
        botonesDeFunciones[5] = botonIgual;
        botonesDeFunciones[6] = botonBorrar;
        botonesDeFunciones[7] = botonLimpiar;
        botonesDeFunciones[8] = botonNegativo;

        for (int i = 0; i < 9; i++) {
            botonesDeFunciones[i].addActionListener(this);
            botonesDeFunciones[i].setFont(miFuente);
            botonesDeFunciones[i].setFocusable(false);
            botonesDeFunciones[i].setContentAreaFilled(false);
            botonesDeFunciones[i].setBorder(new LineBorder(Color.RED));
        }

        for (int i = 0; i < 10; i++) {
            botonesDeNumeros[i] = new JButton(String.valueOf(i));
            botonesDeNumeros[i].addActionListener(this);
            botonesDeNumeros[i].setFont(miFuente);
            botonesDeNumeros[i].setFocusable(false);
            botonesDeNumeros[i].setContentAreaFilled(false);
            botonesDeNumeros[i].setBorder(new LineBorder(Color.GREEN));
        }

        // Estableciendo límites
        botonNegativo.setBounds(50, 430, 100, 50);
        botonBorrar.setBounds(150, 430, 100, 50);
        botonLimpiar.setBounds(250, 430, 100, 50);

        // Configuro el panel donde estarán todos los botones
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Añado los botones de números y funciones al panel
        panel.add(botonesDeNumeros[1]);
        panel.add(botonesDeNumeros[2]);
        panel.add(botonesDeNumeros[3]);
        panel.add(botonSuma);
        panel.add(botonesDeNumeros[4]);
        panel.add(botonesDeNumeros[5]);
        panel.add(botonesDeNumeros[6]);
        panel.add(botonResta);
        panel.add(botonesDeNumeros[7]);
        panel.add(botonesDeNumeros[8]);
        panel.add(botonesDeNumeros[9]);
        panel.add(botonMultiplicar);
        panel.add(botonDecimal);
        panel.add(botonesDeNumeros[0]);
        panel.add(botonIgual);
        panel.add(botonDividir);

        // Añado el espacio de texto, el panel y los demás botones que están fuera del panel a la calculadora
        frame2.add(espacioTexto);
        frame2.add(panel);
        frame2.add(botonNegativo);
        frame2.add(botonBorrar);
        frame2.add(botonLimpiar);

        // Para que se vea la calculadora
        frame2.setVisible(true);
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if(e.getSource() == botonesDeNumeros[i]) {
                espacioTexto.setText(espacioTexto.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == botonDecimal) {
            espacioTexto.setText(espacioTexto.getText().concat("."));
        }
        if(e.getSource() == botonSuma) {
            valor1 = Double.parseDouble(espacioTexto.getText());
            operador = '+';
            espacioTexto.setText("");
        }
        if(e.getSource() == botonResta) {
            valor1 = Double.parseDouble(espacioTexto.getText());
            operador = '-';
            espacioTexto.setText("");
        }
        if(e.getSource() == botonMultiplicar) {
            valor1 = Double.parseDouble(espacioTexto.getText());
            operador = 'x';
            espacioTexto.setText("");
        }
        if(e.getSource() == botonDividir) {
            valor1 = Double.parseDouble(espacioTexto.getText());
            operador = '/';
            espacioTexto.setText("");
        }
        if(e.getSource() == botonIgual) {
            valor2 = Double.parseDouble(espacioTexto.getText());

            switch (operador) {
                case '+':
                    resultado = valor1 + valor2;
                    break;
                case '-':
                    resultado = valor1 - valor2;
                    break;
                case 'x':
                    resultado = valor1 * valor2;
                    break;
                case '/':
                    resultado = valor1 / valor2;
                    break;
            }
            espacioTexto.setText(String.valueOf(resultado));
            valor1 = resultado;
        }
        if(e.getSource() == botonNegativo) {
            double temporario = Double.parseDouble(espacioTexto.getText());
            temporario *= -1;
            espacioTexto.setText(String.valueOf(temporario));
        }
        if(e.getSource() == botonBorrar) {
            String string = espacioTexto.getText();
            espacioTexto.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                espacioTexto.setText(espacioTexto.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == botonLimpiar) {
            espacioTexto.setText("");
        }

    }
}

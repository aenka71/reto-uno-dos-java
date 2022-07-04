package com.mycompany.proyectocalculadora;

import java.lang.invoke.MethodHandles;
import javax.swing.JOptionPane;

/*
 *
 * @author Luis Alberto
 */
public class ClsCalculadora {

    final String menuPrincipal = """
                       Seleccione una opción:
                       
                       1. realizar una operación
                       2. Salir del menú
                       """;

    final String menuSecundario = """
                        Seleccione una operación
                        
                        1.Suma
                        2.Resta
                        3.Multiplicación
                        4.División
                        5.Potencia
                        6.Raiz Cuadrada
                        7.Salir
                        """;

    final String msgResultado = """
                       El resultado es: 
                             
                       """;
    int operacion;
    double numero1;
    double numero2;

    public void iniciarPrograma() {
        String opcionMenuprincipal = JOptionPane.showInputDialog(null, menuPrincipal);

        if (!opcionMenuprincipal.matches("[+-]?\\d*(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(null, "Ingrese un numero valido.");
            this.iniciarPrograma();
        }

        int opcionMenu = Integer.parseInt(opcionMenuprincipal);
        if (opcionMenu == 1) {
            String operacionMenuSecundario = JOptionPane.showInputDialog(null, menuSecundario);

            if (!operacionMenuSecundario.matches("[+-]?\\d*(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(null, "Ingrese una operacion valida.");
                this.iniciarPrograma();
            }

            this.operacion = Integer.parseInt(operacionMenuSecundario);

            if (this.Validar()) {
                double resultado = 0;
                switch (this.operacion) {
                    case 1: {
                        resultado = this.Suma();
                        break;
                    }
                    case 2: {
                        resultado = this.Resta();
                        break;
                    }
                    case 3: {
                        resultado = this.Multiplicacion();
                        break;
                    }
                    case 4: {
                        resultado = this.Division();
                        break;
                    }
                    case 5: {
                        resultado = this.Potencia();
                        break;
                    }
                    case 6: {
                        resultado = this.RaizCuadrada();

                    }

                }
                String resultadoDecimales = String.format("%.02f", resultado);
                JOptionPane.showMessageDialog(null, msgResultado + resultadoDecimales);
                this.iniciarPrograma();
            }

        }
    }

    private boolean Validar() {
        if (this.operacion == 6) {
            String numeroUno = JOptionPane.showInputDialog(null, "Ingrese el primer numero");
            if (!numeroUno.matches("[+-]?\\d*(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido.");
                this.iniciarPrograma();
            }
            this.numero1 = Double.parseDouble(numeroUno);
        } else {      

            if (this.operacion < 7 && this.operacion > 0) {

                String numeroUno = JOptionPane.showInputDialog(null, "Ingrese el primer numero");

                if (!numeroUno.matches("[+-]?\\d*(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero valido.");
                    this.iniciarPrograma();
                }

                String numeroDos = JOptionPane.showInputDialog(null, "Ingrese el segundo numero");

                if (!numeroDos.matches("[+-]?\\d*(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero valido.");
                    this.iniciarPrograma();
                }
                this.numero1 = Double.parseDouble(numeroUno);
                this.numero2 = Double.parseDouble(numeroDos);
                
                if (this.operacion == 4 && this.numero2 == 0) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero valido.");
                    this.iniciarPrograma();
                }
            }
        }
        return true;
    }

    private double Suma() {
        double resultado = this.numero1 + this.numero2;
        return resultado;
    }

    private double Resta() {
        double resultado = this.numero1 - this.numero2;
        return resultado;
    }

    private double Multiplicacion() {
        double resultado = this.numero1 * this.numero2;
        return resultado;
    }

    private double Division() {
        double resultado = this.numero1 / this.numero2;
        return resultado;
    }

    private double Potencia() {
        double resultado = Math.pow(this.numero1, this.numero2);
        return resultado;
    }

    private double RaizCuadrada() {
        double resultado = Math.sqrt(this.numero1);
        return resultado;
    }
}

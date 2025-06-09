package calculadorafiguras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        do {
            Historial.Decorador.cabecera("---- MENU PRINCIPAL ----");
            System.out.println("1. Calcular área de círculo");
            System.out.println("2. Calcular área de rectángulo");
            System.out.println("3. Calcular área de triángulo");
            System.out.println("4. Ver historial");
            System.out.println("5. Ver estadísticas");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        calcularCirculo(sc);
                        break;
                    case 2:
                        calcularRectangulo(sc);
                        break;
                    case 3:
                        calcularTriangulo(sc);
                        break;
                    case 4:
                        Historial.mostrarHistorial();
                        break;
                    case 5:
                        Historial.mostrarEstadisticas();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresa un número.");
            }
        } while (!salir);

        sc.close();
    }

    public static void calcularCirculo(Scanner sc) {
        try {
            System.out.print("Ingrese el radio: ");
            double radio = Double.parseDouble(sc.nextLine());
            if (radio <= 0) throw new IllegalArgumentException("El valor debe ser positivo.");
            Circulo c = new Circulo(radio);
            double area = c.calcularArea();
            System.out.println("Área del Círculo: " + area);
            Historial.agregarRegistro(c.getNombre(), area);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void calcularRectangulo(Scanner sc) {
        try {
            System.out.print("Ingrese la base: ");
            double base = Double.parseDouble(sc.nextLine());
             System.out.print("Ingrese la altura: ");
            double altura = Double.parseDouble(sc.nextLine());
            
            if (base <= 0 || altura <= 0) throw new IllegalArgumentException("Los valores deben ser positivos.");
            Rectangulo r = new Rectangulo(base, altura);
            double area = r.calcularArea();
            System.out.println("Área del Rectángulo: " + area);
            Historial.agregarRegistro(r.getNombre(), area);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void calcularTriangulo(Scanner sc) {
        try {
             System.out.print("Ingrese la base: ");
            double base = Double.parseDouble(sc.nextLine());
            System.out.print("Ingrese la altura: ");
            double altura = Double.parseDouble(sc.nextLine());
            
             if (base <= 0 || altura <= 0) throw new IllegalArgumentException("Los valores deben ser positivos.");
            Triangulo t = new Triangulo(base, altura);
            double area = t.calcularArea();
             System.out.println("Área del Triángulo: " + area);
            Historial.agregarRegistro(t.getNombre(), area);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
package calculadorafiguras;

import java.util.ArrayList;

public class Historial {
    private static ArrayList<Double> areas = new ArrayList<>();
    private static ArrayList<String> figuras = new ArrayList<>();

    public static void agregarRegistro(String figura, double area) {
        figuras.add(figura);
        areas.add(area);
    }

    public static void mostrarHistorial() {
        Decorador.linea();
        System.out.println("Historial de Cálculos:");
        for (int i = 0; i < figuras.size(); i++) {
            System.out.println(figuras.get(i) + " - Área: " + areas.get(i));
        }
        Decorador.linea();
    }

    public static void mostrarEstadisticas() {
        Decorador.linea();
        System.out.println("Estadísticas:");
        System.out.println("Total de figuras: " + figuras.size());
        double suma = 0;
        for (double area : areas) {
            suma += area;
        }
        double promedio = figuras.size() > 0 ? suma / figuras.size() : 0;
        System.out.println("Promedio de áreas: " + promedio);
        Decorador.linea();
    }

    public static class Decorador {
        public static void cabecera(String titulo) {
            System.out.println("\n=== " + titulo + " ===");
        }

        public static void linea() {
            System.out.println("-------------------------------");
        }
    }
}
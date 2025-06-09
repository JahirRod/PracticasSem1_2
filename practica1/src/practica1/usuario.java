package practica1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class Usuario {
    private String nombre;
    private int edad;
    private String ciudad;

    public Usuario(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Ciudad: " + ciudad;
    }
}

class ControladorUsuarios {
    public static double PromedioEdad(ArrayList<Usuario> usuarios) {
        int suma = 0;
        for (Usuario u : usuarios) {
            suma += u.getEdad();
        }
        return usuarios.isEmpty() ? 0 : (double) suma / usuarios.size();
    }

    public static ArrayList<Usuario> buscarUsuario(ArrayList<Usuario> usuarios, String nombre) {
        ArrayList<Usuario> encontrados = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                encontrados.add(u);
            }
        }
        return encontrados;
    }

    public static ArrayList<Usuario> buscarUsuarioPorCiudad(ArrayList<Usuario> usuarios, String ciudad) {
        ArrayList<Usuario> encontrados = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getCiudad().equalsIgnoreCase(ciudad)) {
                encontrados.add(u);
            }
        }
        return encontrados;
    }

    public static Usuario UsuarioDestacado(ArrayList<Usuario> usuarios) {
        if (usuarios.isEmpty()) return null;
        Random rand = new Random();
        int indice = (int) Math.floor(rand.nextDouble() * usuarios.size());
        return usuarios.get(indice);
    }

    static class MensajeDecorativo {
        public static void mostrarMensaje(String mensaje) {
            System.out.println("****************************");
            System.out.println("** " + mensaje);
            System.out.println("****************************");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese nombre del usuario: ");
            String nombre = scanner.nextLine();

            int edad = 0;
            while (true) {
                try {
                    System.out.print("Ingrese edad del usuario: ");
                    edad = Integer.parseInt(scanner.nextLine());
                    if (edad <= 0) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Edad inválida. Intente nuevamente.");
                }
            }

            System.out.print("Ingrese ciudad del usuario: ");
            String ciudad = scanner.nextLine();

            usuarios.add(new Usuario(nombre, edad, ciudad));

            System.out.print("¿Desea ingresar otro usuario? (s/n): ");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("s");
        }

        // Total de usuarios
        ControladorUsuarios.MensajeDecorativo.mostrarMensaje("Resumen de Usuarios");
        System.out.println("Total de usuarios registrados: " + usuarios.size());

        // Promedio de edad
        System.out.printf("Promedio de edad: %.2f\n", ControladorUsuarios.PromedioEdad(usuarios));

        // Nombre más largo
        String nombreMasLargo = "";
        for (Usuario u : usuarios) {
            if (u.getNombre().length() > nombreMasLargo.length()) {
                nombreMasLargo = u.getNombre();
            }
        }
        System.out.println("Nombre más largo ingresado: " + nombreMasLargo);

        // Usuario destacado
        Usuario destacado = ControladorUsuarios.UsuarioDestacado(usuarios);
        if (destacado != null) {
            ControladorUsuarios.MensajeDecorativo.mostrarMensaje("Usuario Destacado");
            System.out.println(destacado);
        }

        scanner.close();
    }
}

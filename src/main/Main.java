package main;

import factory.*;
import model.*;

public class Main {

    public static void main(String[] args) {
        // Lista de archivos solicitados en el Ejercicio 2 y Ejercicio 3
        String[] reports = {
            "ENT_FAC_001.txt",
            "ENT_COM_001.txt",
            "SAL_FAC_001.txt",
            "SAL_COM_001.txt",
            "MIX_FAC_001.txt", // Ejercicio 3: Nueva categoría MIXTA
            "MIX_COM_001.txt", // Ejercicio 3: Nueva categoría MIXTA
            "ENT_PED_001.txt"  // Ejercicio 3: Nuevo tipo PEDIDO en ENTRADA
        };

        procesarInformes(reports);
    }

    public static void procesarInformes(String[] reports) {
        for (String fileName : reports) {
            // Extraer la categoría y el tipo del nombre de archivo (ej: ENT_FAC_001.txt -> ENT y FAC)
            String[] parts = fileName.split("_");
            if (parts.length < 2) {
                System.out.println("Formato de archivo no válido: " + fileName);
                continue;
            }

            String catCode = parts[0];  // ENT, SAL, MIX
            String typeCode = parts[1]; // FAC, COM, PED

            // Obtener la fábrica correspondiente
            ReportFactory factory = getFactory(catCode);

            if (factory != null) {
                // Instanciar objetos usando el patrón Abstract Factory
                Category category = factory.createCategory();
                ReportType type = factory.createReportType(typeCode);

                // Imprimir resultado esperado por la guía
                System.out.println("Procesando informe de " + category.getCategoriaName() + " de tipo " + type.getTypeName());
            } else {
                System.out.println("Categoría no reconocida: " + catCode);
            }
        }
    }

    private static ReportFactory getFactory(String catCode) {
        switch (catCode) {
            case "ENT":
                return new EntReportFactory();
            case "SAL":
                return new SalReportFactory();
            case "MIX":
                return new MixReportFactory();
            default:
                return null;
        }
    }
}
package factory;

import model.*;

public class EntReportFactory implements ReportFactory {
    @Override
    public Category createCategory() {
        return new EntCategory();
    }

    @Override
    public ReportType createReportType(String typeCode) {
        switch (typeCode) {
            case "FAC":
                return new FacType();
            case "COM":
                return new ComType();
            case "PED": // Soporte para Ejercicio 3
                return new PedType();
            default:
                throw new IllegalArgumentException("Tipo no soportado para Entrada: " + typeCode);
        }
    }
}
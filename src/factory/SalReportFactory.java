package factory;

import model.*;

public class SalReportFactory implements ReportFactory {
    @Override
    public Category createCategory() {
        return new SalCategory();
    }

    @Override
    public ReportType createReportType(String typeCode) {
        switch (typeCode) {
            case "FAC":
                return new FacType();
            case "COM":
                return new ComType();
            default:
                throw new IllegalArgumentException("Tipo no soportado para Salida: " + typeCode);
        }
    }
}
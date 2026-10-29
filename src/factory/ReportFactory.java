package factory;

import model.Category;
import model.ReportType;

// Interfaz para la Fábrica Abstracta
public interface ReportFactory {
    Category createCategory();
    ReportType createReportType(String typeCode);
}
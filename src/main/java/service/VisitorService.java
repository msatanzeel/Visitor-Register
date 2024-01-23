package service;

import repository.entities.Visitor;
import repository.entities.VisitorType;

import java.time.LocalDate;
import java.util.List;

public interface VisitorService {

    Long addVisitor(Visitor Visitor);

    void updateVisitor(Visitor Visitor);

    void deleteVisitor(int visitorId);

    List<Visitor> getAllVisitors();

    Visitor getVisitorById(int visitorId);

    List<Visitor> getVisitorsByDateRange(LocalDate startDate, LocalDate endDate);

    List<Visitor> getVisitorsByType(VisitorType visitorType);
}

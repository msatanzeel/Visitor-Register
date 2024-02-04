package service;

import repository.entities.Visitor;
import repository.entities.VisitorType;

import java.time.LocalDate;
import java.util.List;

public interface VisitorService {

    Integer addVisitor(Visitor Visitor);

    Boolean updateVisitor(Visitor Visitor);

    Boolean deleteVisitor(Integer visitorId);

    List<Visitor> getAllVisitors();

    Visitor getVisitorById(Integer visitorId);

    List<Visitor> getVisitorsByDateRange(LocalDate startDate, LocalDate endDate);

    List<Visitor> getVisitorsByType(VisitorType visitorType);
}

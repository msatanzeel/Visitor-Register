package repository.dao;

import repository.entities.Visitor;

import java.util.List;

public interface VisitorDao {
    void addVisitor(Visitor visitor);

    void updateVisitor(Visitor visitor);

    void deleteVisitor(int visitorID);

    Visitor getVisitorById(int visitorID);

    List<Visitor> getAllVisitors();
}

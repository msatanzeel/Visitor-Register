package service;

import org.springframework.beans.factory.annotation.Autowired;
import repository.dao.VisitorDao;
import repository.entities.Visitor;
import repository.entities.VisitorType;

import java.time.LocalDate;
import java.util.List;

public class VisitorServiceImpl implements VisitorService{
    @Autowired
    private VisitorDao visitorDaoImpl;

    @Override
    public int addVisitor(Visitor Visitor) {
        return 0;
    }

    @Override
    public Boolean updateVisitor(Visitor Visitor) {
        return true;
    }

    @Override
    public void deleteVisitor(int visitorId) {

    }

    @Override
    public List<Visitor> getAllVisitors() {
        return null;
    }

    @Override
    public Visitor getVisitorById(int visitorId) {
        return null;
    }

    @Override
    public List<Visitor> getVisitorsByDateRange(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public List<Visitor> getVisitorsByType(VisitorType visitorType) {
        return null;
    }
}

package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.dao.VisitorDao;
import repository.entities.Visitor;
import repository.entities.VisitorType;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService{
    private VisitorDao visitorDaoImpl;

    public VisitorDao getVisitorDaoImpl() {
        return visitorDaoImpl;
    }

    @Autowired
    public void setVisitorDaoImpl(VisitorDao visitorDaoImpl) {
        this.visitorDaoImpl = visitorDaoImpl;
    }

    @Override
    public Integer addVisitor(Visitor visitor) {
        visitorDaoImpl.addVisitor(visitor);
        return 0;
    }

    @Override
    public Boolean updateVisitor(Visitor visitor) {
        if(visitorDaoImpl.getVisitorById(visitor.getVisitorID()) == null) {
            return false;
        }
        visitorDaoImpl.updateVisitor(visitor);
        return true;
    }

    @Override
    public Boolean deleteVisitor(Integer visitorId) {
        if(visitorDaoImpl.getVisitorById(visitorId) == null) {
            return false;
        }
        visitorDaoImpl.deleteVisitor(visitorId);
        return true;
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return null;
    }

    @Override
    public Visitor getVisitorById(Integer visitorId) {
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

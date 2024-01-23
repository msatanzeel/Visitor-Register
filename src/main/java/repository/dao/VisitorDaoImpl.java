package repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import repository.entities.Visitor;

import java.util.List;

public class VisitorDaoImpl implements VisitorDao{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addVisitor(Visitor visitor) {
        hibernateTemplate.save(visitor);
    }

    @Override
    public void updateVisitor(Visitor visitor) {
        hibernateTemplate.update(visitor);
    }

    @Override
    public void deleteVisitor(int visitorID) {
        Visitor visitor = getVisitorById(visitorID);
        if (visitor != null) {
            hibernateTemplate.delete(visitor);
        }
    }

    @Override
    public Visitor getVisitorById(int visitorID) {
        return hibernateTemplate.get(Visitor.class, visitorID);
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return hibernateTemplate.loadAll(Visitor.class);
    }
}

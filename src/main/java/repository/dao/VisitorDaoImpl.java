package repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.entities.Visitor;

import java.util.List;

@Repository
public class VisitorDaoImpl implements VisitorDao{
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    @Transactional
    public void addVisitor(Visitor visitor) {
        hibernateTemplate.save(visitor);
    }

    @Override
    @Transactional
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

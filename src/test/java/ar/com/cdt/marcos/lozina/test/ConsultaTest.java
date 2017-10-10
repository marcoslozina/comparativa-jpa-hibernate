package ar.com.cdt.marcos.lozina.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

import ar.com.cdt.marcos.lozina.modelo.Registro;

public class ConsultaTest {

    private JIntegrity helper;

    private EntityManager manager;

    @Before
    public void init() {
	this.helper = new JIntegrity();
	this.helper.useMySQL();

	this.manager = JPAHelper.currentEntityManager();
    }

    @Test
    public void deveRetornarTodosLosRegistrosConDescripcionFoo_NamedQuery() {
	TypedQuery<String> query = this.manager.createNamedQuery("Registro.descripcionesQueContengan", String.class);
	query.setParameter("descripcion", "%agua%");
	assertEquals(1, query.getResultList().size());
    }

    @Test
    public void deveRetornarTodosLosRegistrosConDescripcionFoo_JPACriteriaQuery() {
	CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
	CriteriaQuery<Registro> criteriaQuery = criteriaBuilder.createQuery(Registro.class);
	Root<Registro> registro = criteriaQuery.from(Registro.class);
	criteriaQuery.select(registro);

	List<Predicate> predicates = new ArrayList<Predicate>();
	ParameterExpression<String> descripcion = criteriaBuilder.parameter(String.class, "descripcion");
	predicates.add(criteriaBuilder.like(registro.<String>get("descripcion"), descripcion));
	criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
	TypedQuery<Registro> query = manager.createQuery(criteriaQuery);
	query.setParameter("descripcion", "%gaz%");

	assertEquals(1, query.getResultList().size());
	assertEquals(true, query.getResultList().get(0).getDescripcion().contains("gaz"));
    }

    @Test
    public void deveRetornarTodosLosRegistrosConDescripcionFoo_HibernateCriteriaQuery() {
	Session session = manager.unwrap(Session.class);
	Criteria criteria = session.createCriteria(Registro.class);

	criteria.add(Restrictions.ilike("descripcion", "internet", MatchMode.ANYWHERE));
	assertEquals(2, criteria.list().size());
    }

}

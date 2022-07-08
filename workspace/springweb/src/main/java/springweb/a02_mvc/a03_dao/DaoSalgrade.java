package springweb.a02_mvc.a03_dao;
//springweb.a02_mvc.a03_dao.DaoSalgrade

import java.util.List;

import org.springframework.stereotype.Repository;

import springweb.a02_mvc.a04_vo.Salgrade;

@Repository
public interface DaoSalgrade {
	public List<Salgrade> getSalgradeList(Salgrade sch);
	public Salgrade getSalgrade();
}

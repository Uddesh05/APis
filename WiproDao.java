package com.Company.WiproPvtLtd.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Company.WiproPvtLtd.Entity.Wipro;


@Repository
public class WiproDao {
	@Autowired
	SessionFactory sf;
	
	/*Configuration cfg = new Configuration();
	cfg.configure("hibernate3.xml");
	cfg.addAnnotatedClass(Staff.class);
	SessionFactory sf = cfg.buildSessionFactory();
	*/

	// create Method / load method
		public List<Wipro> showAllEmp() {
			Session session = sf.openSession();
			Criteria criteria = session.createCriteria(Wipro.class);
			List<Wipro> list = criteria.list();
			return list;
		}
// insert Method
	public String InsertEmp(Wipro wipro) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(wipro);
		tr.commit();
		return "Data Inserted Successfully";
	}

	

	// delete method

	public String deleteEmp(Wipro wipro) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		// agar koi data delete krna hoga to use pahele load krna padega
		session.load(wipro, 3);
		session.delete(wipro);
		tr.commit();
		return "Data Deleted Sucessfully !!!";
	}

	// all emp whose role is java dev
	public List<Wipro> getallJavaDev() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.like("role", "Java Devloper"));
		List<Wipro> list = criteria.list();
		return list;

	}

	// get all emp whose company location is pune
	public List<Wipro> getAllEmpCompLocationIsPune() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.like("companylocation", "Pune"));
		List<Wipro> list = criteria.list();
		return list;

	}

	//// get all emp whose name start with "S"..
	public List<Wipro> getAllSnameEmp() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.like("name", "s%"));
		List<Wipro> list = criteria.list();
		return list;

	}

	// get only name from database #Projections
	public List<Wipro> getOnlyName() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.setProjection(Projections.property("name"));
		List<Wipro> list = criteria.list();
		return list;
	}

	// get emp whose salary is more than 50k
	public List<Wipro> getEmpSalMor50k() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.gt("salary", "50000"));
		List<Wipro> list = criteria.list();
		return list;

	}

	// get emp whose salary is more than 55k and name Start with s
	public List<Wipro> getEmpSalMor55kNameWithS() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.like("name", "s%"));
		List<Wipro> list = criteria.list();
		System.out.println(list);
		return list;

	}

// get emp whose name start with s and end with t
	public List<Wipro> getEmpNameStartWithSandEndwithT() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.ilike("name", "s%t"));
		List<Wipro> list = criteria.list();
		return list;

	}

	// salary greater than 50k and role is java devloper
	public List<Wipro> EmpnameWithUaRoleJava() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.ilike("name", "u%"));
		List<Wipro> list = criteria.list();
		return list;

	}

	// get emp whose both location is amravati
	public List<Wipro> EmpBothLocationisAmravati() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		List<Wipro> list = criteria.list();
		return list;
	}

	// get Emp whose company location is Banglore
	public List<Wipro> EmplocationisBanglore() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.ilike("companylocation", "Banglore"));
		List<Wipro> list = criteria.list();
		return list;
	}

	// Salary more than 50k and location Banglore
	public List<Wipro> EmplocationisBangloreSalryMor50K() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.ilike("companylocation", "Banglore"));
		List<Wipro> list = criteria.list();
		return list;
	}

	// For Data Found
	public List<Wipro> check() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.ilike("role", "Full Stack Devloper"));
		List<Wipro> list = criteria.list();
		return list;
	}

	// max Salary in database
	public List<Wipro> maxSalary() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.setProjection(Projections.max("salary"));
		List<Wipro> list = criteria.list();
		return list;
	}

	// min Salary in database
	public List<Wipro> minSalary() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.setProjection(Projections.min("salary"));
		List<Wipro> list = criteria.list();
		return list;
	}

	// Sum of all Salary
	public List<Wipro> SumSalary() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.setProjection(Projections.sum("salary"));
		List<Wipro> list = criteria.list();
		return list;
	}
	
	// role is System Engineer and from amravati location
	public List<Wipro> EmplocationBothisAmaravtiRoleisSE() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.ilike("role", "System Engineer"));
		List<Wipro> list = criteria.list();
		System.out.println(list);
		return list;
	}
	
	// get only roles from database
	public List<Wipro> getAllRole() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.setProjection(Projections.property("role"));
		List<Wipro> list = criteria.list();
		System.out.println(list);
		return list;
	}
	
	// Count total row in database
	public List<Wipro> checkrow() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.setProjection(Projections.rowCount());
		List<Wipro> list = criteria.list();
		System.out.println(list);
		return list;
	}
	
	
	// get emp whose name start witj s and salary is greater 60,role python devloper,companylocation chennai
	public List<Wipro> EmpnameWithSsal60kRolePythonComlocChennai() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.ilike("name", "s%"));
		List<Wipro> list = criteria.list();
		
		return list;
	}
	
	// get all Experince from database (Projections)
	public List<Wipro> ExperinceDetails(){
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.setProjection(Projections.property("experince"));
		List<Wipro> list = criteria.list();
		System.out.println(list);
		return list;
	}
	
	
	// get All Freshers
	public List<Wipro> OnlyFreshers(){
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.ilike("experince","Fresher"));
		List<Wipro> list = criteria.list();
		System.out.println(list);
		return list;
	}
	
	// get Emp 1year Experince
	public List<Wipro> OneyearExp(){
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.ilike("experince","1year"));
		List<Wipro> list = criteria.list();
		System.out.println(list);
		return list;
	}
	
	
	// get Emp 2year Experince
	public List<Wipro> twoyearExp(){
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Wipro.class);
		criteria.add(Restrictions.ilike("experince","2year"));
		List<Wipro> list = criteria.list();
		System.out.println(list);
		return list;
	}
	
	// get Emp 3year Experince
		public List<Wipro> threeyearExp(){
			// TODO Auto-generated method stub
			Session session = sf.openSession();
			Criteria criteria = session.createCriteria(Wipro.class);
			criteria.add(Restrictions.ilike("experince","3year"));
			List<Wipro> list = criteria.list();
			System.out.println(list);
			return list;
		}
		
		// get Emp 4year Experince
				public List<Wipro> FouryearExp(){
					// TODO Auto-generated method stub
					Session session = sf.openSession();
					Criteria criteria = session.createCriteria(Wipro.class);
					criteria.add(Restrictions.ilike("experince","4year"));
					List<Wipro> list = criteria.list();
					System.out.println(list);
					return list;
				}
				
				// get Emp 5year Experince
				public List<Wipro> FiveYearExp(){
					// TODO Auto-generated method stub
					Session session = sf.openSession();
					Criteria criteria = session.createCriteria(Wipro.class);
					criteria.add(Restrictions.ilike("experince","5year"));
					List<Wipro> list = criteria.list();
					System.out.println(list);
					return list;
				}
				
				// get Emp 6year Experince
				public List<Wipro> SixYearExp(){
					// TODO Auto-generated method stub
					Session session = sf.openSession();
					Criteria criteria = session.createCriteria(Wipro.class);
					criteria.add(Restrictions.ilike("experince","6year"));
					List<Wipro> list = criteria.list();
					System.out.println(list);
					return list;
				}
				
				// get Emp 10year Experince
				public List<Wipro> TenYearExp(){
					// TODO Auto-generated method stub
					Session session = sf.openSession();
					Criteria criteria = session.createCriteria(Wipro.class);
					criteria.add(Restrictions.ilike("experince","10year"));
					List<Wipro> list = criteria.list();
					System.out.println(list);
					return list;
				}
				
				
				// get Emp name with S and  5year Experince
				public List<Wipro> Swith5YrExp(){
					// TODO Auto-generated method stub
					Session session = sf.openSession();
					Criteria criteria = session.createCriteria(Wipro.class);
					criteria.add(Restrictions.ilike("name","s%"));
					List<Wipro> list = criteria.list();
					System.out.println(list);
					return list;
				}
				

				// get Emp name with A and  1year Experince
				public List<Wipro> Awith1YrExp(){
					// TODO Auto-generated method stub
					Session session = sf.openSession();
					Criteria criteria = session.createCriteria(Wipro.class);
					criteria.add(Restrictions.ilike("name","a%"));
					List<Wipro> list = criteria.list();
					System.out.println(list);
					return list;
				}
}

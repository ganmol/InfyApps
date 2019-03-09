package com.infy.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infy.bean.MobileData;
import com.infy.entity.AppEntity;
import com.infy.entity.MobileEntity;
import com.infy.resources.HibernateUtility;

public class InfyAppsDAOImpl implements InfyAppsDAO {

	//do not tamper with the given method signature
	@Override
	public MobileData getEligibleAppsAndInstalledApps(Long IMEINumber) throws Exception {
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try {
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			MobileEntity me=(MobileEntity) session.get(MobileEntity.class, IMEINumber);
			if(me!=null){
				List<String> installedApps=new LinkedList<String>();
				List<String> eligibleApps=new LinkedList<String>();			
				String hql = "select appName from AppEntity where appSuitableFor=? or appSuitableFor=?";
					
				Query query = session.createQuery(hql);
					
				query.setParameter(0, me.getMobileUserType());
				query.setParameter(1, 'B');
					
				eligibleApps = query.list();
				for(AppEntity s:me.getApps()){
					installedApps.add(s.getAppName());
				}
				MobileData m=new MobileData();
				m.setEligibleApps(eligibleApps);
				m.setInstalledApps(installedApps);
				return m;
			}
			else return null;
				
			}
			
		catch (HibernateException exception) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(), exception); 
			throw new Exception("DAO.TECHNICAL_ERROR");
		} 
		catch (Exception exception) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(), exception);
			throw exception;
		}
		finally {
			if(session.isOpen()|| session!=null){
				session.close();
			}
		}
		
		
	}

	//do not tamper with the given method signature
	@Override
	public Integer installApps(Long IMEINumber, List<String> appNames) throws Exception {
		// your code goes here
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try {
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			List<AppEntity> list1=new LinkedList<>();
			MobileEntity me=(MobileEntity) session.get(MobileEntity.class, IMEINumber);
			if(me!=null){
				list1.addAll(me.getApps());
				Integer count=me.getAppsCount();
				for(String s:appNames){
					AppEntity ae=(AppEntity) session.get(AppEntity.class, s);
					list1.add(ae);
					count+=1;
				}
				me.setApps(list1);
				me.setAppsCount(count);
				session.beginTransaction();
				session.persist(me);
				session.getTransaction().commit();
				return count;
			}
			else return null;
				
			}
			
		catch (HibernateException exception) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(), exception); 
			throw new Exception("DAO.TECHNICAL_ERROR");
		} 
		catch (Exception exception) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(), exception);
			throw exception;
		}
		finally {
			if(session.isOpen()|| session!=null){
				session.close();
			}
		}
		
	}

	//do not tamper with the given method signature
	@Override
	public String getLargestApp() throws Exception {
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try {
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
					
				String hql = "select max(spaceRequiredInMB) from AppEntity";
				String hql1 = "select appName from AppEntity where spaceRequiredInMB=?";
				Query query = session.createQuery(hql);
				Integer max =(Integer)query.uniqueResult();
				Query query1 = session.createQuery(hql1);
				query1.setParameter(0, max);
				String name= (String)query1.uniqueResult();
				return name;
			
			
				
			}
			
		catch (HibernateException exception) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(), exception); 
			throw new Exception("DAO.TECHNICAL_ERROR");
		} 
		catch (Exception exception) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(), exception);
			throw exception;
		}
		finally {
			if(session.isOpen()|| session!=null){
				session.close();
			}
		}
	}

	//do not tamper with the given method signature
	@Override
	public List<MobileData> getDetailsOfMobiles(String appName) throws Exception {
		// your code goes here
		SessionFactory sessionFactory=null;
		Session session=null;
		List<MobileEntity> me=new LinkedList<>();
		List<MobileData> m=new LinkedList<>();
		try {
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
					
				String hql = "from MobileEntity";
				Query query = session.createQuery(hql);
				
				me=query.list();
				for (MobileEntity x:me){
					for(AppEntity a:x.getApps()){
						if(a.getAppName().equals(appName)){
							MobileData md=new MobileData();
							md.setIMEINumber(x.getIMEINumber());
							md.setAppsCount(x.getAppsCount());
							md.setMobileOS(x.getMobileOS());
							md.setMobileUserType(x.getMobileUserType());
							m.add(md);
						}
					}
				}
				return m;
				
			
			
				
			}
			
		catch (HibernateException exception) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(), exception); 
			throw new Exception("DAO.TECHNICAL_ERROR");
		} 
		catch (Exception exception) {
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(), exception);
			throw exception;
		}
		finally {
			if(session.isOpen()|| session!=null){
				session.close();
			}
		}
	}
	
	

}

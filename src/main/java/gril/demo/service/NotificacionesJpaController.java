package gril.demo.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;

import org.springframework.stereotype.Service;

import gril.demo.domain.Girl;
@Service
public class NotificacionesJpaController {
	
	 public NotificacionesJpaController() {		 		
			Map<String, String> properties = new HashMap<String, String>();		 
			properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
			properties.put("javax.persistence.jdbc.url", "jdbc:mysql://127.0.0.1:3306/dbgirl?useSSL=true");
			properties.put("javax.persistence.jdbc.user", "root");
			properties.put("javax.persistence.jdbc.password", "123456");			
	        this.emf = Persistence.createEntityManagerFactory("jpa", properties);
	    }
	    
	    private EntityManagerFactory emf = null;

	    public EntityManager getEntityManager() {
	        return emf.createEntityManager();
	    }

	    private static final String TABLE_COLUMNS = "select utc.COLUMN_NAME columnName , utc.DATA_TYPE dataType, utc.DATA_LENGTH dataLength "
	            + "from user_tab_columns utc "
	            + " "                
	            + "order by utc.column_name asc";
	    private static String SQL_NOTIFICATION = "select *  from Girl ";
	    public List<Girl> getNotifications(boolean all, int maxResults, int firstResult) {
	        EntityManager em = getEntityManager();
	        List<Girl> result = new ArrayList<>();
	        try {
	        	Query query = em.createNativeQuery(SQL_NOTIFICATION,Girl.class);
//	            Query query = em.createNativeQuery(SQL_NOTIFICATION);
//	            List<Object[]> rawResultList;
//	         
//	                rawResultList = query.getResultList();
//
//	                for (Object[] resultElement : rawResultList) {
//	                     
//	                	Notificaciones adl2 = new Notificaciones((Integer)resultElement[0], (String)resultElement[1],(String)resultElement[2],(Date)resultElement[3],(String)resultElement[4]);
//	                	result.add(adl2);
//	                }	                
	                
	            result = query.getResultList();	 
	            //List<TableColumn> listTables = new ArrayList<>();	            
	            //Query q = em.createNativeQuery(TABLE_COLUMNS, TableColumn.class);
	            //listTables = q.getResultList();
	            
//	            Query query = getEntityManager().createNativeQuery(TABLE_COLUMNS, "PojoExample");
//	            @SuppressWarnings("unchecked")
//	            List<TableColumn> data = query.getResultList();
	            
	            return result;
	        } finally {
	            em.close();
	        }
	    }
}

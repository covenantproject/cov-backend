package org.covn.service;

import static org.covn.util.CovidUtils.cast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.covn.model.db.LocationHierarchy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class LocationHierarchyService {
	
	  @Autowired
	  private EntityManager entityManager;
	
	  public List<Object> getHomeDetailById(int userId) {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("homedetails")
					.registerStoredProcedureParameter("userid", Integer.class, ParameterMode.IN)
					.setParameter("userid", userId);
			query.execute();
			List<Object> result = cast(query.getResultList());
			if (result.size() != 0) {
				return result;
			} else {
				return null;
			}

		}

	public List<LocationHierarchy> getLocHierarchy(int locationID) {
		
		List<LocationHierarchy> locHierarchy = new ArrayList<LocationHierarchy>();

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getLocationHierarchy")
				.registerStoredProcedureParameter("locationid", Integer.class, ParameterMode.IN)
				.setParameter("locationid", locationID);
		query.execute();
		List list= query.getResultList();	
		Iterator itr = list.iterator();
		LocationHierarchy lc=new LocationHierarchy();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			if (obj[0] != null) {
				lc.setLocationId(Integer.parseInt(String.valueOf(obj[0])));
			}
			if (obj[1] != null) {
				lc.setLocationName(String.valueOf(obj[1]));
			}
			if (obj[2] != null) {
				lc.setLocationAbbr(String.valueOf(obj[2]));
			}
			if (obj[3] != null) {
				lc.setAssignPatients(Boolean.parseBoolean(String.valueOf(obj[3])));
			}
			if (obj[4] != null) {
				lc.setParentLocationId(Integer.parseInt(String.valueOf(obj[4])));
			}
			if (obj[5] != null) {
				lc.setCountryCode(String.valueOf(obj[5]));
			}
			locHierarchy.add(lc);
		}
		
		return locHierarchy;		
	}

}

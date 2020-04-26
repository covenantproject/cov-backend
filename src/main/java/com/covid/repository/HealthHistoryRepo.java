
package com.covid.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.HealthHistory;

@Repository
public interface HealthHistoryRepo  extends CrudRepository<HealthHistory,Long>{

}


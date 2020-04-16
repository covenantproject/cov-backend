package com.covid.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.HealthProfessional;



@Repository
public interface HealthProfessionalRepo  extends CrudRepository<HealthProfessional,Long>{

	HealthProfessional findByUserId(long userId);

}


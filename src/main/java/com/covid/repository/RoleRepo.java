package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.Role;


@Repository
public interface RoleRepo extends CrudRepository<Role,Long> {

	Role findByRoleId(long roleId);

}

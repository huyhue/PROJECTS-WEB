package com.fpt.soft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fpt.soft.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	List<Department> findByNameLikeOrderByName(String name);
	Optional<Department> findDepartmentByName(String name);
	@Query("Select d from Department d where d.name like %?1%")
	public Page<Department> findDepartmentByName(String keyword, Pageable pageable);
	
//	@Modifying
//	@Query("update Department d set d.name = :name,d.address = :address,d.area = :area, d.canContain = :canContain, d.limitTimeRental = :limitTimeRental,d.rentalPeriod = :rentalPeriod,d.descrisption = :descrisption where d.id = :id")
//	void updateDepartment(@Param(value = "id") int id, 
//			@Param(value = "name") String name,
//			@Param(value = "address") String address,
//			@Param(value = "area") int area,
//			@Param(value = "canContain") int canContain,
//			@Param(value = "limitTimeRental") int limitTimeRental,
//			@Param(value = "rentalPeriod") int rentalPeriod,
//			@Param(value = "descrisption") String descrisption
//			);
}

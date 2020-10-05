/**********************************************************************************************************************************
 -File Name         :   Booking Repository Interface
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   Repository interface used to connect to the database 
 **********************************************************************************************************************************/
package com.cg.omtb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.omtb.entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long>{

	public List<BookingEntity> findByCustomerId(Integer customerId);
}

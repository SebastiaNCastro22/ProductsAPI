package com.upc.productsapi.complaints.respository;

import com.upc.productsapi.complaints.model.entity.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IComplaintsRepository extends JpaRepository<Complaints, Long> {

    Optional<Complaints> findByComplaintsId (long complaintsId);

}




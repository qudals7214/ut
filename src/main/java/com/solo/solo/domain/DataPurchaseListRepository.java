package com.solo.solo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataPurchaseListRepository extends JpaRepository<DataPurchaseListVO , Long> {
}

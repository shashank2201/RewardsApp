package com.practice.rewards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practice.rewards.entitiy.CustomerTransactions;

public interface RewardsRepository extends JpaRepository<CustomerTransactions, Long> {
	
	List<CustomerTransactions> findRewardsByCustomerIdAndTxnAmountGreaterThan(int custId,float txn); 
	
	@Query("SELECT DISTINCT customerId FROM CustomerTransactions")
    List<Integer> findDistinctCustomer();;

}

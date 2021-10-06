package com.practice.rewards.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.rewards.entitiy.CustomerRewards;
import com.practice.rewards.entitiy.CustomerTransactions;
import com.practice.rewards.repository.RewardsRepository;

@Service
public class RewardsService {
	
	@Autowired
	private RewardsRepository rewardsRepository;
	
	/**
	 * Service method to get reward details for all customers.
	 * @return rewards for all customers
	 */
	public List<CustomerRewards> getRewards() {
		
		List<CustomerRewards> customerRewards=new ArrayList<>();
		
		//get distinct customer ids from DB and get rewards for those individual IDs
		for(int customerId: rewardsRepository.findDistinctCustomer()) {			
			customerRewards.add(getRewardsByCustomer(customerId));					
		}
		
		return customerRewards;
	}

	/**
	 * Service method to get all transactions in table.
	 * @return all transactions
	 */
	public List<CustomerTransactions> getTransactions() {
		return rewardsRepository.findAll();
	}

	/**
	 * Service method to get reward details for a specified customer
	 * @param custId
	 * @return Reward details for a specified customer id
	 */
	public CustomerRewards getRewardsByCustomer(int custId) {		
		return new CustomerRewards(custId,calculateRewards(rewardsRepository.findRewardsByCustomerIdAndTxnAmountGreaterThan(custId,50)));
	}
	
	/**
	 * Calculate rewards for a given list of transactions for a customer
	 * @param transactionList
	 * @return Map of months and rewards earned
	 */
	public Map<String,Integer> calculateRewards(List<CustomerTransactions> transactionList){
		
		int reward=0;
		int txn=0;
		int total=0;
		String txnMonth;
		Map<String,Integer> myRewardMap=new TreeMap<String,Integer>();
		
		for(CustomerTransactions transaction: transactionList) {
			
			//round to nearest integer value and calculate rewards
			txn=Math.round(transaction.getTxnAmount());
			reward=(txn<=100)?(txn-50):2*(txn-100)+50;
			
			//get month in which transaction was performed
			txnMonth=transaction.getTxnDate().getMonthValue()+"-"+transaction.getTxnDate().getMonth().toString();
			
			//check if there is an existing entry in map, otherwise create an entry with 0 rewards.
			if(!myRewardMap.containsKey(txnMonth)){
				myRewardMap.put(txnMonth,0);
			}
			
			myRewardMap.put(txnMonth, myRewardMap.get(txnMonth)+reward);
//			System.out.println(transaction.getTxnAmount() +"|"+txn+"|"+reward);
			
			total+=reward;
		}
		
		myRewardMap.put("Total", total);
		
		return myRewardMap;
		
	}
}

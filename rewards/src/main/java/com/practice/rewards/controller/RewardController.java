package com.practice.rewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.rewards.entitiy.CustomerRewards;
import com.practice.rewards.entitiy.CustomerTransactions;
import com.practice.rewards.service.RewardsService;


@RestController
@RequestMapping("/rewards")
public class RewardController {
	
	@Autowired
	private RewardsService rewardsService;
	
	/**
	 * Reward details for all customers.
	 * @return rewards for all customers
	 */
	@GetMapping
	public List<CustomerRewards> getRewards() {
		return rewardsService.getRewards();
	}
	
	/**
	 * Reward details for specified customer id
	 * @param custId
	 * @return rewards for specified customer id
	 */
	@GetMapping("/{custId}")
	public CustomerRewards getRewardsByCustomer(@PathVariable("custId") int custId){
		return rewardsService.getRewardsByCustomer(custId);
	}
	
	
	/**
	 * Lists all transactions in DB
	 * @return all transactions in table
	 */
	@GetMapping("/txns")
	public List<CustomerTransactions> getTransactions() {
		return rewardsService.getTransactions();
	}
}

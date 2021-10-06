package com.practice.rewards.entitiy;

import java.util.Map;

public class CustomerRewards {
	
	private int customerId;
	private Map<String,Integer> rewardsMap;
	
	public CustomerRewards() {
		super();
	}

	public CustomerRewards(int customerId, Map<String, Integer> rewardsMap) {
		super();
		this.customerId = customerId;
		this.rewardsMap = rewardsMap;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public Map<String, Integer> getRewardsMap() {
		return rewardsMap;
	}
	
	public void setRewardsMap(Map<String, Integer> rewardsMap) {
		this.rewardsMap = rewardsMap;
	}

}

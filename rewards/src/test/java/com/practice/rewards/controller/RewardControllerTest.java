package com.practice.rewards.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.practice.rewards.entitiy.CustomerRewards;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RewardControllerTest {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getRewardsByCustomerTest() throws Exception {
		
		ResponseEntity<CustomerRewards> myRewards=this.restTemplate.getForEntity("http://localhost:" + port + "/rewards/1",
				CustomerRewards.class);
		
		assertEquals(HttpStatus.OK, myRewards.getStatusCode());
		assertThat(myRewards.getBody().getCustomerId()==1);
		assertThat(7).isEqualTo(myRewards.getBody().getRewardsMap().get("7-JULY"));
		assertThat(388).isEqualTo(myRewards.getBody().getRewardsMap().get("8-AUGUST"));
		assertThat(102).isEqualTo(myRewards.getBody().getRewardsMap().get("9-SEPTEMBER"));
		assertThat(497).isEqualTo(myRewards.getBody().getRewardsMap().get("Total"));
		
	}
	
	@Test
	public void getRewardsTest() throws Exception {
		
		ResponseEntity<CustomerRewards[]> myRewards=this.restTemplate.getForEntity("http://localhost:" + port + "/rewards",
				CustomerRewards[].class);
		
		CustomerRewards[] myRewardList=myRewards.getBody();
		
		assertEquals(HttpStatus.OK, myRewards.getStatusCode());
		assertThat(myRewardList.length>0);
		assertThat(myRewardList[1].getCustomerId()==2);
		assertThat(44).isEqualTo(myRewardList[1].getRewardsMap().get("7-JULY"));
		assertThat(39).isEqualTo(myRewardList[1].getRewardsMap().get("8-AUGUST"));
		assertThat(745).isEqualTo(myRewardList[1].getRewardsMap().get("9-SEPTEMBER"));
		assertThat(828).isEqualTo(myRewardList[1].getRewardsMap().get("Total"));
		
	}

}

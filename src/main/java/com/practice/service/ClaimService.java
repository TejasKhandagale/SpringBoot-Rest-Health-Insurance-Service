package com.practice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.ClaimRepository;
import com.practice.model.Claim;

@Service
public class ClaimService {
	
	@Autowired
	private ClaimRepository claimRepository;
	
	public Claim registerClaim(Claim claim)
	{
		if(claim.getRegDate() == null)
			claim.setRegDate(new Date());
		claimRepository.save(claim);
		if(claim.getCid() != 0) {
			claim.setDesc("Claim Registration successfull...!");
			claim.setStatus("Registered");
			claimRepository.save(claim);
		}
		else
			claim.setDesc("Claim Registration failed, Please try again");
		return claim;
	}

	public Claim getClaimStatus(String claimId) {
		// TODO Auto-generated method stub
		
		return claimRepository.findById(Integer.valueOf(claimId)).get();
	}

	public void setClaimStatus(Claim claim) {
		// TODO Auto-generated method stub
		claimRepository.save(claim);
	}

}

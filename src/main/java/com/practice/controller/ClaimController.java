package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Claim;
import com.practice.service.ClaimService;

@RestController
@RequestMapping("/insurance")
public class ClaimController {
	
	//Gson gson = new Gson();
	@Autowired
	private ClaimService claimService;

	@RequestMapping(path = "/register_claim", method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
	public Claim registerClaim(@RequestBody Claim claim)
	{
		//String response = "";
		if(!StringUtils.isEmpty(claim.getAmount()) && !StringUtils.isEmpty(claim.getPid()))
			claimService.registerClaim(claim);
		else
			claim.setDesc("Invalid Claim confirmation, Please try again.");
		
		return claim;
	}
	
	@RequestMapping(path = "/claim_status/{claimId}", method = RequestMethod.GET,produces = "application/json",consumes = "application/json")
	public Claim getClaimStatus(@PathVariable String claimId)
	{
		Claim claim = null;
		if(!StringUtils.isEmpty(claimId))
		{
			claim = claimService.getClaimStatus(claimId);
			
		}
		else {
			claim = new Claim();
			claim.setDesc("Invalid Claim ID");
		}
		return claim;
	}
	
	@RequestMapping(path = "/change_claim_status", method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
	public Claim getClaimStatus(@RequestBody Claim claim)
	{
		if(!StringUtils.isEmpty(claim.getCid()))
			claimService.setClaimStatus(claim);
		else 
			claim.setDesc("Invalid Claim ID");
		
		return claim;
	}
	
}

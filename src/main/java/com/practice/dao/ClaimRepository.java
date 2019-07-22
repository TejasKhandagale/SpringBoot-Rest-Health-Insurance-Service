package com.practice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Claim;
@Repository
public interface ClaimRepository extends CrudRepository<Claim, Integer> {

}

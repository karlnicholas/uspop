package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StatePop;

@Repository
public interface StatePopRepository extends JpaRepository<StatePop, Long> {

}

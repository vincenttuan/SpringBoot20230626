package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.one2many.oneway.Infect;

public interface InfectRepository extends JpaRepository<Infect, Long> {

}

package com.appgate.refactoring.exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appgate.refactoring.exercise.model.entities.FacebookEntity;

@Repository
public interface FacebookRepository extends CrudRepository<FacebookEntity, Long> {

}

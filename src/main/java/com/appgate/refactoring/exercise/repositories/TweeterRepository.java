package com.appgate.refactoring.exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appgate.refactoring.exercise.model.entities.TweeterEntity;

@Repository
public interface TweeterRepository extends CrudRepository<TweeterEntity, Long>{

}

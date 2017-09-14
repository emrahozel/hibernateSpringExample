package com.envanter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.envanter.model.envanterModel;

/**
 * Created by emrahozel on 13.09.2017.
 */
public interface envanterRepository extends JpaRepository<envanterModel, Integer> {
}

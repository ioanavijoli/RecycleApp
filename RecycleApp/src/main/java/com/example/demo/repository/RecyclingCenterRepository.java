
package com.example.demo.repository;

import com.example.demo.model.Feedback;
import com.example.demo.model.RecyclingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface RecyclingCenterRepository  extends JpaRepository<RecyclingCenter,Long> {
    RecyclingCenter findByName(String name);
    ArrayList<RecyclingCenter> findAllByNameContains(String name);
    Boolean existsByName(String name);
    void deleteById(Long id);
    RecyclingCenter findRecyclingCenterById(Long id);



}


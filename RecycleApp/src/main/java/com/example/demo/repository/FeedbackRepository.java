package com.example.demo.repository;

import com.example.demo.model.Feedback;
import com.example.demo.model.RecyclingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback,Long>{
 //   @Query("select f from Feedback f where f.center_id=?1")
    List<Feedback> findAllByRecyclingCenterId(Long id);


}

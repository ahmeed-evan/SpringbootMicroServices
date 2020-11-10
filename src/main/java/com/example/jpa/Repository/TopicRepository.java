package com.example.jpa.Repository;

import com.example.jpa.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, String> {

}

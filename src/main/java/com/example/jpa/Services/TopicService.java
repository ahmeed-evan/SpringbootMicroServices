package com.example.jpa.Services;

import com.example.jpa.Model.Topic;
import com.example.jpa.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopic(){
        List<Topic>topicList=new ArrayList<>();
        topicRepository.findAll().forEach(topicList::add);
        return topicList;
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void deleteTopic(String topicId){
        topicRepository.deleteById(topicId);
    }

    public Optional<Topic> getTopic(String topicId) {
      return topicRepository.findById(topicId);
    }

    public Topic updateTopic(Topic topic, String topicId) {
        return topicRepository.save(topic);
    }
}

package com.example.jpa.Controller;

import com.example.jpa.Model.Topic;
import com.example.jpa.Services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic>getAllTopic(){
        return topicService.getAllTopic();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}")
    public void deleteTopic(@PathVariable String topicId) {
        topicService.deleteTopic(topicId);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/topics/{topicId}")
    private Optional<Topic> getTopic(@PathVariable String topicId){
        return topicService.getTopic(topicId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}")
    private Topic updateTopic(@RequestBody Topic topic, @PathVariable String topicId) {
        return topicService.updateTopic(topic,topicId);
    }

}

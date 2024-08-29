package io.javabrains.springbootstarter.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	
	//GET method all topics
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	// GET method using  an id
	@GetMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	//POST Update methods
	@RequestMapping(method = RequestMethod.POST, value="/topics")
	public String addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return "Added Successfully.";
	}
	
	//PUT method
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
	public String addTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id,topic);
		return "Updated Successfully.";
	}
	
	// DELETE method using  an id
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
	public String deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		return "Deleted Successfully.";	
	}
}

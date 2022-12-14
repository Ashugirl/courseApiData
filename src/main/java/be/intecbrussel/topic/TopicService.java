package be.intecbrussel.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //marks class as Spring business service. Singleton.
// In other words, Spring makes one instance that is used among all the classes.

public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    //having this list as class variable in business service means there's only one copy of the list
    //this is important if you're using CRUD on the list.
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("History", "History", "old stuff"),
//            new Topic("Chemistry", "Chem 101", "chemical stuff"),
//            new Topic("Art", "Art", "arty stuff")
//
//
//    ));
    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
      return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);

        //topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
//        for(int i = 0; i < topics.size(); i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
        //topics.removeIf(t -> t.getId().equals(id));
    }
}

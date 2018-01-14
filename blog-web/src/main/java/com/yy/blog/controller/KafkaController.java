package com.yy.blog.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengjm5
 * @date 2018/1/12 13:36
 */
@RestController
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, String> template;

    public static Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @RequestMapping(value = "test", method = {RequestMethod.POST, RequestMethod.GET })
    public @ResponseBody Object test() {
        template.send("zjmTest", "zjmtest0", "郑佳铭0");
        template.send("zjmTest", "zjmtest1", "郑佳铭1");
        template.send("zjmTest", "zjmtest2", "郑佳铭2");
        return "发送成功！";
    }

    @KafkaListener(id = "t1", topics = {"zjmTest"})
//    @KafkaListener(id = "t1", topicPartitions={@TopicPartition(partitions={"0","2"}, topic="zjmTest")})
    public void listen1(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
    }
}

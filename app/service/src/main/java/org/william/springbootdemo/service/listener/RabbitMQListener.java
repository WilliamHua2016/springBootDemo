package org.william.springbootdemo.service.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.william.springbootdemo.common.dao.model.Student;

/**
 * Listen on notification request message from rabbit mq.
 *
 */
@Component
public class RabbitMQListener {
    
    private static final String SMS_QUEUE_NAME = "fincloud.queue.notification.sms";

    @RabbitListener(queues = SMS_QUEUE_NAME)
    public void processMessage(Student student) {
        System.out.println("received message from MQ request:"+student.getName());
    }

}

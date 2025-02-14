package com.lucasmartines.awssecret.sns;

import io.awspring.cloud.sns.core.SnsNotification;
import io.awspring.cloud.sns.core.SnsOperations;
import io.awspring.cloud.sns.core.SnsTemplate;
import io.awspring.cloud.sns.sms.SmsMessageAttributes;
import io.awspring.cloud.sns.sms.SmsType;
import io.awspring.cloud.sns.sms.SnsSmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SnsMessageSender implements TopicSender {

    private final SnsTemplate snsTemplate;

    private final SnsOperations snsOperations;

    private final SnsSmsTemplate snsSmsTemplate;

    public SnsMessageSender(SnsTemplate snsTemplate, SnsOperations snsOperations, SnsSmsTemplate snsSmsTemplate) {
        this.snsTemplate = snsTemplate;
        this.snsOperations = snsOperations;
        this.snsSmsTemplate = snsSmsTemplate;
    }

    @Override
    public void send(String message) {
       snsTemplate.sendNotification("sns-message-topic", new TesteMessage(message), "teste");
        SnsNotification<TesteMessage> customNotification = SnsNotification.builder(new TesteMessage(message)).build();

       snsOperations.sendNotification("sns-message-topic", customNotification);

        snsSmsTemplate.send("+55XXXXXXXXXXX", "the message", SmsMessageAttributes.builder()
                .smsType(SmsType.PROMOTIONAL).senderID("mySenderID").maxPrice("0.50").build());
    }
}

package com.iot.message.container;

import com.iot.api.client.RsocketClientSession;
import com.iot.api.server.handler.MemoryMessageHandler;
import com.iot.common.annocation.ProtocolType;
import com.iot.transport.client.TransportClient;
import com.iot.transport.server.TransportServer;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;


public class clientTest {

    @Test
    public void testClient() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
    RsocketClientSession clientSession= TransportClient.create("127.0.0.1",1884)
              .heart(10000)
              .protocol(ProtocolType.MQTT)
              .ssl(false)
              .log(true)
              .clientId("123")
                .password("12")
            .username("123")
            .willMessage("123")
            .willTopic("/lose")
              .exception(throwable -> System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+throwable))
              .messageAcceptor((topic,msg)->{
                    System.out.println(topic+":"+new String(msg));
               })
              .connect()
              .block();
        latch.await();



    }

}

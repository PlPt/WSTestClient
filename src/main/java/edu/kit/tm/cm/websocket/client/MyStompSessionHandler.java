package edu.kit.tm.cm.websocket.client;

import edu.kit.tm.cm.websocket.dtos.CoordinateResponse;
import edu.kit.tm.cm.websocket.dtos.DynamicVehicleDataResponse;
import edu.kit.tm.cm.websocket.dtos.StaticVehicleDataResponse;
import edu.kit.tm.cm.websocket.dtos.VehicleType;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

/**
 * This class is an implementation for <code>StompSessionHandlerAdapter</code>.
 * Once a connection is established, We subscribe to /topic/messages and 
 * send a sample message to server.
 * 
 * @author Kalyan
 *
 */
public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LogManager.getLogger(MyStompSessionHandler.class);

    @SneakyThrows
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/response/registerVehicle", this);
        logger.info("Subscribed to /response/test");
        StaticVehicleDataResponse r = new StaticVehicleDataResponse("1","1","t",1,1, VehicleType.DIESEL,"8888");
        session.send("/app/registerVehicle",r);

        Thread.sleep(5000);

        for (int i =0;i<11;i++){
            DynamicVehicleDataResponse r2 = new DynamicVehicleDataResponse(new CoordinateResponse(1.0d,1.0d),1.5f,1.7f,12.0f,String.valueOf(i));
            session.send("/app/addDynamicVehicleData/1",r2);
            logger.info("Message sent to websocket server");
            Thread.sleep(5000);
        }


    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }



    @Override
    public void handleFrame(StompHeaders headers, Object payload) {

        logger.info(String.format("Received: ",payload));
    }

}
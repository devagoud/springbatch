package com.spring.batch;

import com.mixpanel.mixpanelapi.ClientDelivery;
import com.mixpanel.mixpanelapi.MessageBuilder;
import com.mixpanel.mixpanelapi.MixpanelAPI;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MixpanelController {
    @Autowired
    private MessageBuilder messageBuilder;

    @PostMapping("/event")
    public ResponseEntity storeEvents(@RequestBody Panel panel) throws JSONException, IOException {
        // Create an event

        //JSONObject sentEvent = messageBuilder.event(panel.getName(), "Sent Message", null);

// You can send properties along with events
        JSONObject props = new JSONObject();
        props.put("Gender", "Male");
        props.put("Plan", "platinum");
        props.put("name", "deva");
        props.put("phone", "8184998808");

        JSONObject planEvent = messageBuilder.event(panel.getName(), "Deva Changed", props);

// Gather together a bunch of messages into a single
// ClientDelivery. This can happen in a separate thread
// or process from the call to MessageBuilder.event()
        ClientDelivery delivery = new ClientDelivery();
      //  delivery.addMessage(sentEvent);
        delivery.addMessage(planEvent);

// Use an instance of MixpanelAPI to send the messages
// to Mixpanel's servers.
        MixpanelAPI mixpanel = new MixpanelAPI();
        mixpanel.deliver(delivery);

/*


// Sets user 13793's "Plan" attribute to "Premium"
// This creates a profile for 13793 if one does not
// already exist.
        JSONObject props = new JSONObject();
        props.put("Plan", "Pla");
        props.put("$ip", "72.229.28.896");
        props.put("$ignore_time", "false");
        JSONObject update = messageBuilder.set(panel.getName(), props);

// Send the update to mixpanel
        MixpanelAPI mixpanel = new MixpanelAPI();
        mixpanel.sendMessage(update);


*/

/*


// Pass a Map to increment multiple properties
        Map<String, Long> properties = new HashMap<String, Long>();
        properties.put("dollars spent", 17l);

// Subtract by passing a negative value
        properties.put("credits remaining", -34l);
        JSONObject update =
                messageBuilder.increment(panel.getName(), properties);

// Send the update to mixpanel
        MixpanelAPI mixpanel = new MixpanelAPI();
        mixpanel.sendMessage(update);
*/
        return ResponseEntity.ok().build();

    }
}

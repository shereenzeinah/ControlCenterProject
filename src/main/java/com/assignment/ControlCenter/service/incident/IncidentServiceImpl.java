package com.assignment.ControlCenter.service.incident;

import com.assignment.ControlCenter.api.incident.ws.WSFetchIncidentResponse;
import com.assignment.ControlCenter.api.incident.ws.WSIncidentRequest;
import com.assignment.ControlCenter.api.incident.ws.WSIncidentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    KafkaTemplate<String, WSIncidentRequest> KafkaJsontemplate;

    RestTemplate restTemplate =  new RestTemplate();;
    private final String CREATE_INCIDENT_TOPIC = "create-incident";
    private final String UPDATE_INCIDENT_TOPIC = "update-incident";
    private final String DELETE_INCIDENT_TOPIC = "delete-incident";
    private final String FETCH_INCIDENTS_URL = "http://localhost:8080/incident/all";

    @Override
    public WSIncidentResponse createIncident(WSIncidentRequest wsIncidentRequest) {
        KafkaJsontemplate.send(CREATE_INCIDENT_TOPIC, wsIncidentRequest);
        WSIncidentResponse response = new WSIncidentResponse("Created successfully");
        return response;
    }

    @Override
    public WSIncidentResponse updateIncident(WSIncidentRequest wsIncidentRequest) {
        KafkaJsontemplate.send(UPDATE_INCIDENT_TOPIC, wsIncidentRequest);
        WSIncidentResponse response = new WSIncidentResponse("Updated successfully");
        return response;
    }

    @Override
    public WSIncidentResponse deleteIncident(int id) {
        WSIncidentRequest wsDeleteRequest = new WSIncidentRequest();
        wsDeleteRequest.setId(id);
        KafkaJsontemplate.send(DELETE_INCIDENT_TOPIC, wsDeleteRequest);
        WSIncidentResponse response = new WSIncidentResponse();
        response.setResponseMessage("Deleted successfully");
        return null;
    }

    @Override
    public WSFetchIncidentResponse[] fetchIncidents() {
        WSFetchIncidentResponse[] response = restTemplate.getForObject(FETCH_INCIDENTS_URL , WSFetchIncidentResponse[].class);
        return response;
    }
}

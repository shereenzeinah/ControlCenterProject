package com.assignment.ControlCenter.service.incident;

import com.assignment.ControlCenter.api.incident.ws.WSCreateIncidentRequest;
import com.assignment.ControlCenter.api.incident.ws.WSIncidentResponse;
import com.assignment.ControlCenter.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private KafkaSender kafkaSender;

    private final String CREATE_INCIDENT_TOPIC = "create-incident";
    private final String UPDATE_INCIDENT_TOPIC = "update-incident";
    private final String DELETE_INCIDENT_TOPIC = "delete-incident";

    @Override
    public WSIncidentResponse createIncident(WSCreateIncidentRequest wsCreateIncidentRequest) {
        kafkaSender.createIncident(wsCreateIncidentRequest.getCreatedDate(), CREATE_INCIDENT_TOPIC);
        WSIncidentResponse response = new WSIncidentResponse("Created successfully");
        return response;
    }

    @Override
    public WSIncidentResponse updateIncident(WSCreateIncidentRequest wsCreateIncidentRequest) {
        kafkaSender.updateIncident(wsCreateIncidentRequest.getCreatedDate(), UPDATE_INCIDENT_TOPIC);
        WSIncidentResponse response = new WSIncidentResponse("Updated successfully");
        return response;
    }

    @Override
    public WSIncidentResponse deleteIncident(Long id) {
        kafkaSender.updateIncident(id.toString(), DELETE_INCIDENT_TOPIC);
        WSIncidentResponse response = new WSIncidentResponse();
        response.setResponseMessage("Deleted successfully");
        return null;
    }
}

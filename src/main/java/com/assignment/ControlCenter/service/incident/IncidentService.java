package com.assignment.ControlCenter.service.incident;

import com.assignment.ControlCenter.api.incident.ws.WSFetchIncidentResponse;
import com.assignment.ControlCenter.api.incident.ws.WSIncidentRequest;
import com.assignment.ControlCenter.api.incident.ws.WSIncidentResponse;

public interface IncidentService {

     WSIncidentResponse createIncident (WSIncidentRequest wsIncidentRequest);
     WSIncidentResponse updateIncident (WSIncidentRequest wsIncidentRequest);
     WSIncidentResponse deleteIncident(int id);

     WSFetchIncidentResponse[] fetchIncidents();
}

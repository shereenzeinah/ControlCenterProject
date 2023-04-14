package com.assignment.ControlCenter.service.incident;

import com.assignment.ControlCenter.api.incident.ws.WSCreateIncidentRequest;
import com.assignment.ControlCenter.api.incident.ws.WSIncidentResponse;

public interface IncidentService {

     WSIncidentResponse createIncident (WSCreateIncidentRequest wsCreateIncidentRequest);
     WSIncidentResponse updateIncident (WSCreateIncidentRequest wsCreateIncidentRequest);
     WSIncidentResponse deleteIncident(Long id);
}

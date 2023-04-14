package com.assignment.ControlCenter.api.incident;

import com.assignment.ControlCenter.api.incident.ws.WSIncidentResponse;
import com.assignment.ControlCenter.api.incident.ws.WSCreateIncidentRequest;
import com.assignment.ControlCenter.service.incident.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incident")
public class IncidentApi {

    private IncidentService incidentService;

    @PostMapping(path = "/create-incident", produces = "application/json" , consumes = "application/json")
    public ResponseEntity<WSIncidentResponse> createIncident(@RequestBody WSCreateIncidentRequest wsCreateIncidentRequest) {
        WSIncidentResponse response = incidentService.createIncident(wsCreateIncidentRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/update-incident", produces = "application/json" , consumes = "application/json")
    public ResponseEntity<WSIncidentResponse> updateIncident(@RequestBody WSCreateIncidentRequest wsCreateIncidentRequest) {
        WSIncidentResponse response = incidentService.updateIncident(wsCreateIncidentRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/incident/{id}")
    public ResponseEntity<WSIncidentResponse> deletePost(@PathVariable Long id) {
        WSIncidentResponse response = incidentService.deleteIncident(id);
        return ResponseEntity.ok(response);
    }
    @Autowired
    public void setIncidentService(IncidentService incidentService) {
        this.incidentService = incidentService;
    }
}

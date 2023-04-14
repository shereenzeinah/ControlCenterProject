package com.assignment.ControlCenter.api.incident.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WSCreateIncidentRequest {
    private int id;
    private String creatorName;
    private String location;
    private String creatorPhoneNumber;
    private String createdDate;
}

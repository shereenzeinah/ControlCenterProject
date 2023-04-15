package com.assignment.ControlCenter.api.incident.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WSCreateIncidentRequest {
    private int id;
    private String title;
    private String address;
    private String phone;
    private String description;
    private String createdDate;
}

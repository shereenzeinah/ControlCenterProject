package com.assignment.ControlCenter.api.incident.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WSFetchIncidentResponse {
    private int id;
    private String title;
    private String address;
    private String phone;
    private String description;
}

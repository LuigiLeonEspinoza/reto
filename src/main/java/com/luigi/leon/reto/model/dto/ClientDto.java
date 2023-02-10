package com.luigi.leon.reto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String lastName;

    private String typeDocument;

    private String numberDocument;
    private String status;
}

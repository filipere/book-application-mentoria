package com.bookapplication.config.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class ExcetionResponse implements Serializable {

    private Date timestemp;
    private String message;
    private String details;

}

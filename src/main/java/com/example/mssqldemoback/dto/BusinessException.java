package com.example.mssqldemoback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author vannmaureen
 * @since 2021-05-05 19:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    private Integer code;
    private String message;
}

package com.wotrd.gateway.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalResponse<T> {

    private String code;

    private String msg;

    private T data;

}

package com.namphan.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class orderDTO {
    int orderId;
    String status;
    String orderCode;
    LocalDate orderDate;
    int accountId;
}

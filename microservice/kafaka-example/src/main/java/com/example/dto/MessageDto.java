package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nikolay Chechenko.
 * @since 25.01.2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private String userName;
    private String messageText;

}

package com.group05.abstractbusiness.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonPostDTO {
    @NotEmpty(message = "O nome não pode ser vazio")
    @NotNull(message = "O nome não pode ser nulo")
    private String name;
}

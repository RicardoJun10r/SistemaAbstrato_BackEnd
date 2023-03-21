package com.group05.abstractbusiness.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonPutDTO {
    @NotEmpty(message = "O id não pode ser vazio")
    @NotNull(message = "O id não pode ser nulo")
    private Long id;
    @NotEmpty(message = "O nome não pode ser vazio")
    @NotNull(message = "O nome não pode ser nulo")
    private String name;
}

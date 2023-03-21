/*Classe PersonMapper para converter um Person Post DTO em Person
 * Criado em 20/03/2023 - Ultima atualização em 20/03/2023 
*/

package com.group05.abstractbusiness.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group05.abstractbusiness.DTO.PersonPostDTO;
import com.group05.abstractbusiness.DTO.PersonPutDTO;
import com.group05.abstractbusiness.model.Person.Person;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {
    public static final PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class); 

    public abstract Person toPerson(PersonPostDTO  personPost);
    
    public abstract Person toPerson(PersonPutDTO  personPutt);
}

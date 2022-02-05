package com.supmti.employee.mapper;


public interface Mapper<M, D> {
    D mapToDTO(M entity, D entityDTO);
    M mapToEntity(D entityDTO, M entity);
}

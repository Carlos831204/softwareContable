package com.investigacion.softwareContable.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}

package com.bookapplication.core.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

@Getter
@Setter
@FieldNameConstants
@Builder
public class BookDTORequest implements Serializable {

//    @NotNull
//    @Column(name = Book.Fields.nome, nullable = false, length = 100)
    private String nome;

//    @NotNull
//    @Column(name = Book.Fields.autor, nullable = false, length = 100)
    private String autor;

//    @NotNull
//    @Column(name = Book.Fields.categoria, nullable = false, length = 100)
    private String categoria;

//    @NotNull
//    @Column(name = Book.Fields.tipo, nullable = false, length = 100)
    private String tipo;
}

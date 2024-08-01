package com.bookapplication.core.dtos;

import com.bookapplication.adapter.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@FieldNameConstants
@Builder
public class BookDTOResponse implements Serializable {

    @Id
    private UUID id;

    private String nome;

    private String autor;

    private String categoria;

    private String tipo;

    public BookDTOResponse(Book returnBook, BookDTOResponse bookDTOResponse) {

    }
}

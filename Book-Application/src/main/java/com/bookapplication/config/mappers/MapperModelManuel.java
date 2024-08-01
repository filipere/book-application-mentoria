package com.bookapplication.config.mappers;

import com.bookapplication.core.dtos.BookDTOResponse;
import com.bookapplication.adapter.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class MapperModelManuel {

    public List<BookDTOResponse> mapperModelToDTO(List<Book> response) {

        /* List<BookDTOResponse> listBook = null; */
        List<BookDTOResponse> listBook = new ArrayList<>();

        response.forEach(c -> listBook.add(BookDTOResponse.builder().id(c.getId()).nome(c.getNome())
                .autor(c.getAutor()).tipo(c.getTipo()).categoria(c.getCategoria()).build()));

        return listBook;
    }
}

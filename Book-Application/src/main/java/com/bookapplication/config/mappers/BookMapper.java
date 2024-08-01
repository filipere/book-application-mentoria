package com.bookapplication.config.mappers;

import com.bookapplication.adapter.entity.Book;
import com.bookapplication.core.dtos.BookDTORequest;
import com.bookapplication.core.dtos.BookDTOResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookMapper {

    private final ModelMapper mapper;

    public Book toBook(BookDTORequest request) {
        return mapper.map(request, Book.class);
    }

    public BookDTOResponse toBookResponse(Book book) {
        return mapper.map(book, BookDTOResponse.class);
    }

    public List<BookDTOResponse> toBookResponseList(List<Book> books) {
        return books.stream()
                .map(this::toBookResponse)
                .collect(Collectors.toList());
    }
}

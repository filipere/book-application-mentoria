package com.bookapplication.adapter.controller;

import com.bookapplication.core.dtos.BookDTORequest;
import com.bookapplication.core.dtos.BookDTOResponse;
import com.bookapplication.adapter.entity.Book;
import com.bookapplication.core.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService service;

    @PostMapping("/create")
    public String createBook(@RequestBody Book book) {
        service.create(book);
        return "Livro adicionado";
    }

    @GetMapping("/findAll")
    public List<Book> findAllBooks() {
         return service.findAllBooks();

    }

    @GetMapping("/{id}")
    public Optional<Book> findOneBook(@PathVariable(value = "id") UUID id) {
        return service.findBook(id);

    }

    @GetMapping("/filtrarNome")
    public List<BookDTOResponse> findNameBook(@RequestBody BookDTORequest bookDTORequest) {
        return service.findONameBook(bookDTORequest.getNome());
    }

    @GetMapping("/filtrarAutor")
    public List<BookDTOResponse> findAuthorBook(@RequestBody BookDTORequest bookDTORequest) {
        return service.findAuthorBook(bookDTORequest.getAutor());
    }

    @GetMapping("/filtrarCategoria")
    public List<BookDTOResponse> findCategoryBook(@RequestBody BookDTORequest bookDTORequest) {
        return service.findCategoryBook(bookDTORequest.getCategoria());
    }

    @GetMapping("/filtrarTipo")
    public List<BookDTOResponse> findTipoCategoryBook(@RequestBody BookDTORequest bookDTORequest) {
        return service.findTipoBook(bookDTORequest.getTipo());
    }

    @PutMapping("/put/{id}")
    public Book putBook(@RequestBody Book book) {
        return service.putBook(book);
    }

    @PatchMapping("/patch/{id}")
    public BookDTOResponse patchBook(@PathVariable UUID id, @RequestBody BookDTORequest bookDTORequest) {
        return service.patchBook(id, bookDTORequest);
    }

    @PatchMapping("/patchAuto/{id}")
    public BookDTOResponse patchBookAuto(@PathVariable UUID id, @RequestBody BookDTORequest bookDTORequest) {
        return service.patchBookAuto(id, bookDTORequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") UUID id){
        service.deleteBook(id);
        return "Livro excluido";
    }
}

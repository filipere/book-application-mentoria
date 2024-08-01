package com.bookapplication.core.services;

import com.bookapplication.config.mappers.BookMapper;
import com.bookapplication.core.ports.BookRepository;
import com.bookapplication.core.dtos.BookDTORequest;
import com.bookapplication.core.dtos.BookDTOResponse;
import com.bookapplication.config.mappers.MapperModelManuel;
import com.bookapplication.adapter.entity.Book;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class BookService {

    private final MapperModelManuel mapperModel = new MapperModelManuel();
    private final BookMapper bookMapper;

    private final Logger logger = Logger.getLogger(BookService.class.getName());

    @Autowired
    BookRepository repository;

    public Book create(Book bookDTO) {
        logger.info("Criando livro");
        return repository.save(bookDTO);
    }

    public List<Book> findAllBooks() {
        logger.info("Buscando todos os livros");
        return repository.findAll();
    }

    public Optional<Book> findBook(UUID id) {
        logger.info("Buscando livro");
        return repository.findById(id);
    }

    public Book putBook(Book book) {
        logger.info("Atualizando livro");
        book.setId(book.getId());
        return repository.save(book);
    }

    public BookDTOResponse patchBook(UUID id, BookDTORequest bookDTORequest) {
        logger.info("Atualizando livro");

        if(bookDTORequest.getNome() == null && bookDTORequest.getAutor() == null
                && bookDTORequest.getTipo() == null && bookDTORequest.getCategoria() == null) {
            throw new RuntimeException();
        }

//or else = Imposivel atualizar pois livro não existe, salve primeiro.
        var returnBook = findBook(id).orElseThrow();

//        BookDTOResponse bookDTOResponse = new BookDTOResponse();

        if(bookDTORequest.getNome() != null && !bookDTORequest.getNome().isEmpty()){
            returnBook.setNome(bookDTORequest.getNome());
        }

        if(bookDTORequest.getAutor() != null && !bookDTORequest.getAutor().isEmpty()){
            returnBook.setAutor(bookDTORequest.getAutor());
        }

        if(bookDTORequest.getCategoria() != null && !bookDTORequest.getCategoria().isEmpty()){
            returnBook.setCategoria(bookDTORequest.getCategoria());
        }

        if(bookDTORequest.getTipo() != null && !bookDTORequest.getTipo().isEmpty()){
            returnBook.setCategoria(bookDTORequest.getTipo());
        }

        var saveBook = repository.save(returnBook);
        return new BookDTOResponse(saveBook.getId(), saveBook.getNome(), saveBook.getAutor(), saveBook.getCategoria(), saveBook.getTipo());
    }

    public BookDTOResponse patchBookAuto(UUID id, BookDTORequest bookDTORequest) {

        if(bookDTORequest.getNome() == null && bookDTORequest.getAutor() == null
                && bookDTORequest.getTipo() == null && bookDTORequest.getCategoria() == null) {
            throw new RuntimeException();
        }
        var returnBook = findBook(id).orElseThrow();

        Book book = new Book();

        BookDTOResponse bookDTOResponse = bookMapper.toBookResponse(book);
        var saveBook = repository.save(returnBook);

        return new BookDTOResponse(saveBook, bookDTOResponse);
    }

    public void deleteBook(UUID id) {
        logger.info("Apagando livro");
        repository.deleteById(id);
    }

    public List<BookDTOResponse> findONameBook(String nome) {
        logger.info("Buscando livro pelo nome");
        var response = repository.searchBookTitleStream(String.valueOf(nome));
        return mapperModel.mapperModelToDTO(response);
    }

    public List<BookDTOResponse> findAuthorBook(String autor) {
        logger.info("Buscando livro pelo autor");
        var response = repository.searchBookAuthortStream(String.valueOf(autor));
        return mapperModel.mapperModelToDTO(response);
    }

    public List<BookDTOResponse> findCategoryBook(String autor) {
        logger.info("Buscando livro pelo autor");
        var response = repository.searchBookCategorytStream(String.valueOf(autor));
        return mapperModel.mapperModelToDTO(response);
    }

    public List<BookDTOResponse> findTipoBook(String autor) {
        logger.info("Buscando livro pelo autor");
        var response = repository.searchBookTipotStream(String.valueOf(autor));
        return mapperModel.mapperModelToDTO(response);
    }
}
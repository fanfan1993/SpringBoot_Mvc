package com.example.demo.converter;

import com.example.demo.dao.Book;
import com.example.demo.dto.BookDTO;

public class BookConverter {
    /**
     * 将数据库实体对象转换为 DTO 对象。
     *
     * get 获取给前端
     * @param book 数据库实体对象
     * @return 转换后的 DTO 对象
     */
    public static BookDTO convertToBook(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPrice(book.getPrice());
        return bookDTO;
    }


    /**
     * 将 DTO 对象转换为数据库实体对象。
     *
     * @param bookDTO DTO 对象
     * @return 转换后的数据库实体对象
     */
    public static Book convertToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        return book;
    }
}

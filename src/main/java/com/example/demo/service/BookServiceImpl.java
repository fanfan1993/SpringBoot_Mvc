package com.example.demo.service;

import com.example.demo.converter.BookConverter;
import com.example.demo.dao.Book;
import com.example.demo.dao.BookRepository;
import com.example.demo.dto.BookDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

// 加入容器中去，注入 方便其他对象注入
@Service
public class BookServiceImpl implements IBookService {

    // 注入这个book类 我们才可以用
    @Autowired
    private BookRepository bookRepository;

    // 实现抽象类 接口具体类的一个方法 重写
    @Override
    public BookDTO getBookById(long id) {
        Book book =  bookRepository.findById(id).orElseThrow(RuntimeException::new);
        return BookConverter.convertToBook(book);
    }

    @Override
    public Long addBook(BookDTO bookDTO) {
        List<Book> bookList = bookRepository.findByAuthor(bookDTO.getAuthor());
        if(!CollectionUtils.isEmpty(bookList)) {
            throw new IllegalStateException("Author:"+ bookDTO.getAuthor()+ "has been token");
        }
        Book book =  bookRepository.save(BookConverter.convertToBook(bookDTO));
        return book.getId();
    }

    @Override
    public void deleteBookById(long id) {
        bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id:"+id + "doest exist!"));
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional //注解表示这个方法的执行是事务性的，要么全部执行成功，要么全部回滚。
    public BookDTO updateBookById(long id, String name, String author, Double price) {
        // 从数据库中查找指定 ID 的书籍，如果找不到则抛出 IllegalArgumentException 异常
       Book bookInDB = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id:"+ id + "doest exist!"));
       if(StringUtils.hasLength(name) && !bookInDB.getName().equals(name)) {
           bookInDB.setName(name);
       }
       if(StringUtils.hasLength(author) && !bookInDB.getAuthor().equals(author)) {
           bookInDB.setAuthor(author);
       }
       // 如果 price 不为空且与数据库中的值不同，则更新 price
        if (price != null ) {
            bookInDB.setPrice(price);
        }
        //将更新后的书籍信息保存到数据库中。
        Book book =  bookRepository.save(bookInDB);
        return BookConverter.convertToBook(book);
    }


}

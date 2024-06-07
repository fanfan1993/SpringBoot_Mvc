package com.example.demo.controller;

//import com.example.demo.dao.Book;
import com.example.demo.Response;
import com.example.demo.dao.Book;
import com.example.demo.dto.BookDTO;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 利润
@RestController
public class BookController {

    // 自动注入 IBookService 的实例
    @Autowired
    private IBookService iBookService;

    @GetMapping("/book/{id}")
    //  PathVariable 路径ID对应上面的ID
    public Response<BookDTO> getBookById(@PathVariable long id) {
        return Response.newSuccess(iBookService.getBookById(id));
    }

    @PostMapping("/book")
    public Response<Long> addBook(@RequestBody BookDTO bookDTO) {
        return Response.newSuccess(iBookService.addBook(bookDTO));
    }

    @DeleteMapping("/book/{id}")
    public void deleteBookById(@PathVariable long id) {
        iBookService.deleteBookById(id);
    }

    @PutMapping("/book/{id}")
    public Response<BookDTO> updateBookById(@PathVariable long id, @RequestParam(required = false) String name, @RequestParam(required = false) String author, @RequestParam(required = false) Double price) {
        return Response.newSuccess(iBookService.updateBookById(id, name, author, price));
    }
}

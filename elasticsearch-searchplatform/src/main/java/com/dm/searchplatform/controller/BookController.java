package com.dm.searchplatform.controller;

import com.dm.searchplatform.bean.Book;
import com.dm.searchplatform.core.Result;
import com.dm.searchplatform.core.ResultGenerator;
import com.dm.searchplatform.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
  *                  ,;,,;
  *                ,;;'(    
  *      __      ,;;' ' \   
  *   /'  '\'~~'~' \ /'\.)  
  * ,;(      )    /  |.     
  *,;' \    /-.,,(   ) \    
  *     ) /       ) / )|    
  *     ||        ||  \)     
  *    (_\       (_\
  * @ClassName:BookController 
  * @Description:TODO
  * @author dm
  * @date 2020/1/10
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
@Controller
@RequestMapping("/searchplatform/book")
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping
    public Result add(@RequestBody Book book) {
        bookService.add(book);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        bookService.update(book);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Book book = bookService.queryById(id);
        return ResultGenerator.genSuccessResult(book);
    }



    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        List<Book> list = bookService.getPageList(page,size);
        return ResultGenerator.genSuccessResult(list);
    }
}

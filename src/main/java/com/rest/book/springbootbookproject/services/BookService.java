package com.rest.book.springbootbookproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rest.book.springbootbookproject.entities.Book;

@Component
public class BookService {

   private static List<Book> list=new ArrayList<>();

   static{
    list.add(new Book(102,"Head First Java","ABC"));
    list.add(new Book(103,"Python","GHL"));
    list.add(new Book(104,"JavaScript","XDD"));

   }

   // get all books
   public List<Book> getAllBooks(){
    return list;
   }

   //get single book by id
   public Book getBookById(int id){
    Book book=null;

    try {
      book =list.stream().filter(e->e.getId()==id).findFirst().get();
    } catch (Exception e) {
      
      e.printStackTrace();
    }


    
    return book;
   }


   // add book
   public Book addBook(Book b){
      list.add(b);
      return b;
   }

   public void deleteBook(int bid){
     list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
   }



   // update the book
   public void updateBook(Book book, int bookId){
      list = list.stream().map(b->{
         if(b.getId()==bookId){
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
         }
         return b;

      }).collect(Collectors.toList());
   }

    
}

package com.dio.model.entities;

import java.util.Comparator;
import java.util.Map;

public class Book {
    
    private String title;
    private String author;
    private Double price;

    public Book() {
    }

    public Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
    return "Livro{" +
        "titulo='" + title + '\'' +
        ", autor='" + author + '\'' +
        ", preco=" + price +
        '}';
  }
    
}

class ComparatorByPrice implements Comparator<Map.Entry<String, Book>> {
  @Override
  public int compare(Map.Entry<String, Book> b1, Map.Entry<String, Book> b2) {
    return Double.compare(b1.getValue().getPrice(), b2.getValue().getPrice());
  }
}

class ComparatorByAuthor implements Comparator<Map.Entry<String, Book>> {
  @Override
  public int compare(Map.Entry<String, Book> b1, Map.Entry<String, Book> b2) {
    return b1.getValue().getAuthor().compareToIgnoreCase(b2.getValue().getAuthor());
  }
}
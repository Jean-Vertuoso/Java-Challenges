package com.dio.model.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class OnlineBookstore {
    
    private Map<String, Book> onlineBookstore = new HashMap<>();

    public OnlineBookstore() {
    }
    
    public void addBook(String link, Book book){
        onlineBookstore.put(link, book);
    }
    
    public void removeBook(String titulo){
        if (!onlineBookstore.isEmpty()) {
            onlineBookstore.remove(titulo);
        } else {
            System.out.println("O livro solicitado não existe");
        }
    }
    
    public Map<String, Book> showBooksByPrice(){
        List<Map.Entry<String, Book>> booksToOrderByPrice = new ArrayList<>(onlineBookstore.entrySet());

        Collections.sort(booksToOrderByPrice, new ComparatorByPrice());

        Map<String, Book> booksOrderByPrice = new LinkedHashMap<>();

        for (Map.Entry<String, Book> entry : booksToOrderByPrice) {
          booksOrderByPrice.put(entry.getKey(), entry.getValue());
        }

        return booksOrderByPrice;
    }
    
    public Map<String, Book> showBooksByAuthor(){
        List<Map.Entry<String, Book>> booksToOrderByAuthor = new ArrayList<>(onlineBookstore.entrySet());

        Collections.sort(booksToOrderByAuthor, new ComparatorByAuthor());

        Map<String, Book> booksOrderByAuthor = new LinkedHashMap<>();

        for (Map.Entry<String, Book> entry : booksToOrderByAuthor) {
            booksOrderByAuthor.put(entry.getKey(), entry.getValue());
        }

        return booksOrderByAuthor;
    }
    
    public Map<String, Book> findBookByAuthor(String author) {
    Map<String, Book> booksByAuthor = new LinkedHashMap<>();
    for (Map.Entry<String, Book> entry : onlineBookstore.entrySet()) {
      Book livro = entry.getValue();
      if (livro.getAuthor().equals(author)) {
        booksByAuthor.put(entry.getKey(), livro);
      }
    }
    return booksByAuthor;
    }
    
    public List<Book> findMoreExpensiveBk(){
        List<Book> moreExpensBook = new ArrayList<>();
        double moreExpensive = Double.MIN_VALUE;

        if (!onlineBookstore.isEmpty()) {
          for (Book book : onlineBookstore.values()) {
            if (book.getPrice()> moreExpensive) {
              moreExpensive = book.getPrice();
            }
          }
        } else {
          throw new NoSuchElementException("A livraria está vazia!");
        }

        for(Map.Entry<String, Book> entry: onlineBookstore.entrySet()) {
          if(entry.getValue().getPrice() == moreExpensive) {
            Book livroComPrecoMaisAlto = onlineBookstore.get(entry.getKey());
            moreExpensBook.add(livroComPrecoMaisAlto);
          }
        }
        return moreExpensBook;
    }
    
    public List<Book> findMoreCheapBk() {
    List<Book> moreCheapBook = new ArrayList<>();
    double moreCheap = Double.MAX_VALUE;

    if (!onlineBookstore.isEmpty()) {
      for (Book livro : onlineBookstore.values()) {
        if (livro.getPrice() < moreCheap) {
          moreCheap = livro.getPrice();
        }
      }
    } else {
      throw new NoSuchElementException("A livraria está vazia!");
    }

    for(Map.Entry<String, Book> entry: onlineBookstore.entrySet()) {
      if(entry.getValue().getPrice() == moreCheap) {
        Book livroComPrecoMaisBaixo = onlineBookstore.get(entry.getKey());
        moreCheapBook.add(livroComPrecoMaisBaixo);
      }
    }
    return moreCheapBook;
  }

    public static void main(String[] args) {
        
        OnlineBookstore onlineBookstore = new OnlineBookstore();
        // Adiciona os livros à livraria online
        onlineBookstore.addBook("https://amzn.to/3EclT8Z", new Book("1984", "George Orwell", 50d));
        onlineBookstore.addBook("https://amzn.to/47Umiun", new Book("A Revolução dos Bichos", "George Orwell", 7.05d));
        onlineBookstore.addBook("https://amzn.to/3L1FFI6", new Book("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        onlineBookstore.addBook("https://amzn.to/3OYb9jk", new Book("Malorie", "Josh Malerman", 5d));
        onlineBookstore.addBook("https://amzn.to/45HQE1L", new Book("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        onlineBookstore.addBook("https://amzn.to/45u86q4", new Book("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Exibe todos os livros ordenados por preço
        System.out.println("\nExibe todos os livros ordenados por preço:");
        System.out.println("Livros ordenados por preço: \n" + onlineBookstore.showBooksByPrice());

        //Exibe todos os livros ordenados por autor
        System.out.println("\nExibe todos os livros ordenados por autor:");
        System.out.println("Livros ordenados por autor: \n" + onlineBookstore.showBooksByAuthor());

        //Pesquisa livros por autor
        System.out.println("\nPesquisa livros por autor:");
        String autorPesquisa = "Josh Malerman";
        onlineBookstore.findBookByAuthor(autorPesquisa);

        // Obtém e exibe o livro mais caro
        System.out.println("\nObtém e exibe o livro mais caro:");
        System.out.println("Book mais caro: " + onlineBookstore.findMoreExpensiveBk());

        // Obtém e exibe o livro mais barato
        System.out.println("\nObtém e exibe o livro mais barato:");
        System.out.println("Book mais barato: " + onlineBookstore.findMoreCheapBk());

        // Remover um livro pelo título
        System.out.println("\nRemover um livro pelo título: ");
        onlineBookstore.removeBook("1984");
        System.out.println(onlineBookstore.onlineBookstore);

  }
}

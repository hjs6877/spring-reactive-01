package com.itvillage.section08.class03;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Book {
    private String isbn;
    private String bookName;
    private String author;
}

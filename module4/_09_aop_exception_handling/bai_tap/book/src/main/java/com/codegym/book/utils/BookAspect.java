package com.codegym.book.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Aspect
@Component
public class BookAspect {
    //Logger logger = LoggerFactory.getLogger(BookAspect.class);

    String fileLibrary = "src\\main\\resources\\static\\LogLibrary.txt";
    String filePeople = "src\\main\\resources\\static\\LogPeople.txt";

    @AfterReturning("execution(* com.codegym.book.controller.BookController.rentBook(..)) && args (id,..)")
    public void insertRent(Integer id) {
        String text = String.format("Book có id là %d thuê vào lúc %s", id, LocalDateTime.now());
        writeLog(fileLibrary, text);
    }

    @AfterReturning("execution(* com.codegym.book.controller.BookController.payBook(..)) && args (idRent,..)")
    public void payRent(Integer idRent) {
        String text = String.format("Trả Book có mã thuê là %d vào lúc %s", idRent, LocalDateTime.now());
        writeLog(fileLibrary, text);
    }

    @AfterReturning("execution(* com.codegym.book.controller.*.*(..))")
    public void visits(JoinPoint point) {
        String text = String.format("Phương thức %s được gọi vào lúc %s", point.getSignature().getName(), LocalDateTime.now());
        writeLog(filePeople, text);
    }

    public void writeLog(String link, String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(link, true))) {
            bufferedWriter.write(text);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}

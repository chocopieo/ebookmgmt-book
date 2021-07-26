package ebookmanagement;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RepositoryRestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

//    @PatchMapping(value="/books/{bookId}")
//    @ResponseBody
//    public Book modifyBook(@PathVariable Long bookId, @RequestBody Book paramBook) {
//        String status = paramBook.getStatus();
//
//        Book book = new Book();
//        if("APPROVED".equals(status)) {
//            System.out.println(" ##### 승인 처리 ... ... ... ");
//
//            book = bookRepository.findById(bookId).get();
//            book.setStatus(status);
//            book.setApprovedDate(new Date());
//
//            bookRepository.save(book);
//
//        } else if ("REJECTED".equals(status)) {
//            System.out.println(" ##### 거절 처리 ... ... ... ");
//
//            book = bookRepository.findById(bookId).get();
//
//            Rejected rejected = new Rejected();
//            book.setStatus(status);
//            BeanUtils.copyProperties(book, rejected);
//            rejected.publishAfterCommit();
//
//            book.setRentId(null);
//            book.setUserId(null);
//            book.setStatus("POSSIBLE");
//            book.setApprovedDate(null);
//
//            bookRepository.save(book);
//        }
//        return book;
//    }

    @PatchMapping(value="/books/approve/{bookId}")
    @ResponseBody
    public Book approveBook(@PathVariable Long bookId) {

        System.out.println("\n\n ##### bookId : " + bookId + " 대여승인 처리 ##### \n\n");

        Book book = bookRepository.findById(bookId).get();
        book.setStatus("APPROVED");
        book.setApprovedDate(new Date());

        return bookRepository.save(book);
    }

    @PatchMapping(value="/books/reject/{bookId}")
    @ResponseBody
    public Book rejectBook(@PathVariable Long bookId) {

        System.out.println("\n\n ##### bookId : " + bookId + " 대여거절 처리 ##### \n\n");

        Book book = bookRepository.findById(bookId).get();

        Rejected rejected = new Rejected();
        book.setStatus("REJECTED");
        BeanUtils.copyProperties(book, rejected);
        rejected.publish();

        book.setRentId(null);
        book.setUserId(null);
        book.setStatus("POSSIBLE");
        book.setApprovedDate(null);

        return bookRepository.save(book);
    }
}

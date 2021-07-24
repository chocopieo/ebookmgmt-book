package ebookmanagement;

import ebookmanagement.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @Autowired BookRepository bookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_ApproveRequest(@Payload Paid paid) {

        if(!paid.validate()) return;

        System.out.println("\n\n##### listener ApproveRequest : " + paid.toJson() + "\n\n");

        Long bookId = paid.getBookId();
        Long rentId = paid.getRentId();
        Long userId = paid.getUserId();
        String status = paid.getStatus();

        if("PAID".equals(status)) {
            Book book = bookRepository.findById(bookId).get();
            book.setId(bookId);
            book.setRentId(rentId);
            book.setUserId(userId);
            book.setStatus(status);

            bookRepository.save(book);
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReturned_ReturnRequest(@Payload Returned returned) {

        if(!returned.validate()) return;

        System.out.println("\n\n##### listener ReturnRequest : " + returned.toJson() + "\n\n");

        Long rentId = returned.getId();
        String status = returned.getStatus();

        if("RETURNED".equals(status)) {
            Book book = bookRepository.findByRentId(rentId).get();
            book.setRentId(null);
            book.setUserId(null);
            book.setStatus("POSSIBLE");
            book.setApprovedDate(null);

            bookRepository.save(book);
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}

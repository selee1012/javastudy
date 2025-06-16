package example.demo.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StocksRepository stocksRepository;
    @Autowired
    private Written_byRepository written_byRepository;
    @Autowired
    private Published_byRepository published_byRepository;

    @Transactional
    public void insertBookAndRelated(int isbn, String title, int year, int price,
                                     String stocksCode, int stocksNum,
                                     String writer, String publisher) {
        bookRepository.insertBook(isbn, title, year, price);

        // Stocks insert
        stocksRepository.insertStocks(isbn, stocksCode, stocksNum);

        // Writer
        String writerAddress = written_byRepository.findAddressByName(writer);
        if (writerAddress == null) {
            throw new IllegalArgumentException("등록되지 않은 writer입니다: " + writer);
        }

        written_byRepository.insertWriter(writer, writerAddress, isbn);

        // Publisher
        published_byRepository.insertPublisher(publisher, isbn);
    }
}

package main;

import main.model.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Deal;

@RestController
public class ToDoListController {

    @Autowired
    private DealRepository dealRepository;

    // Запрос POST, создание дела
    @PostMapping("/deals/")
    public ResponseEntity add(Deal deal) {
        dealRepository.save(deal);
        return new ResponseEntity(HttpStatus.OK);
    }

    // Запрос DELETE, удаление дела
    @DeleteMapping("/deals/{id}")
    public ResponseEntity deleteId(@PathVariable int id) {
        dealRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    // Запрос PUT, обновление дела
    @PutMapping("/deals/{id}")
    public ResponseEntity update(@PathVariable int id, Deal deal) {
        dealRepository.save(deal);
        return new ResponseEntity(HttpStatus.OK);
    }

    // Запрос GET, получения всего списка дел
    @GetMapping("/deals/all")
    public @ResponseBody Iterable<Deal> getAllDeals() {
        return dealRepository.findAll();
    }

    // Запрос DELETE, удаление всего списка дел
    @DeleteMapping("/deals/all")
    public @ResponseBody void deleteAllDeals() {
        dealRepository.deleteAll();
    }
}

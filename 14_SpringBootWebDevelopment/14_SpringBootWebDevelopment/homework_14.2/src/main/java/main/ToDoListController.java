package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.Deal;

import java.util.List;

@RestController
public class ToDoListController {

    // Запрос POST, создание дела
    @PostMapping("/deals/")
    public int add(Deal deal) {
        return Notebook.addDeal(deal);
    }

    // Запрос DELETE, удаление дела
    @DeleteMapping("/deals/{id}")
    public ResponseEntity deleteId(@PathVariable int id) {
        Deal deal = Notebook.deleteDeal(id);
        if (deal == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(deal, HttpStatus.OK);
    }

    // Запрос PUT, обновление дела
    @PutMapping("/deals/{id}")
    public ResponseEntity update(@PathVariable int id, Deal deal) {
        Notebook.updateDeal(id, deal);
        if (deal == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(deal, HttpStatus.OK);
    }

    // Запрос GET, получения всего списка дел
    @GetMapping("/deals/")
    public List<Deal> list() {
        return Notebook.getAllDeals();
    }

    // Запрос DELETE, удаление всего списка дел
    @DeleteMapping("/deals/")
    public List<Deal> deleteAll() {
        return Notebook.deleteAllDeals();
    }
}

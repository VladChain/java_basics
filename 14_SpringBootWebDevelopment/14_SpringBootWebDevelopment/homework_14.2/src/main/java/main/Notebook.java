package main;

import response.Deal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Notebook {

    private static int currentId = 1;
    private static HashMap<Integer, Deal> deals = new HashMap<>();
    private static ArrayList<Deal> dealsList = new ArrayList<>();

    // Создание дела
    public static int addDeal(Deal deal) {
        int id = currentId++;
        deal.setId(id);
        deals.putIfAbsent(id, deal);
        return id;
    }

    // Удаление дела
    public static Deal deleteDeal(int dealId) {
        currentId--;
        if (deals.containsKey(dealId)) {
            return deals.remove(dealId);
        }
        return null;
    }

    // Обновление дела
    public static void updateDeal(int id, Deal deal) {
        deal.setId(id);
        deals.put(id, deal);
        dealsList.remove(--id);
        dealsList.add(deals.put(++id, deal));
    }

    // Получение списка дел
    public static List<Deal> getAllDeals() {
        dealsList.clear();
        dealsList.addAll(deals.values());
        return dealsList;
    }

    // Удаление списка дел
    public static List<Deal> deleteAllDeals() {
        currentId = 1;
        deals.clear();
        dealsList.clear();
        return dealsList;
    }
}

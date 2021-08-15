package users.redis;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

public class RedisMain {

    public static void main(String[] args) throws InterruptedException {

        ThreadLocalRandom random = ThreadLocalRandom.current();
        RedisStorage redisStorage = new RedisStorage();
        // Запуск Redis
        redisStorage.init();

        for (;;) {
            int user_id;
            for (user_id = 1; user_id <= 20; user_id++) {
                int numberRandom = random.nextInt(5, 15); // Каждый ~ 10 случай
                int userRandom = random.nextInt(1, 20);   // Случайный пользователь, оплативший услугу
                if (numberRandom == 10) {
                    redisStorage.paidUser(userRandom);
                    sleep(1000);
                    user_id = 0;
                } else {
                    redisStorage.addUser(user_id);
                }
                sleep(1000);
            }
        }
//        redisStorage.shutdown();
    }
}


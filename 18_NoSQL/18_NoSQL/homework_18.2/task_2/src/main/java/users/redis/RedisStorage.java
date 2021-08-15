package users.redis;

import org.redisson.Redisson;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.util.Date;

import static java.lang.System.out;

public class RedisStorage {

    // Объект для работы с Redis
    private RedissonClient redissonClient;

    // Объект для работы с Sorted Set
    private RScoredSortedSet<String> users;

    private final static String KEY = "Users";

    public void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redissonClient = Redisson.create(config);
        } catch (RedisConnectionException ex) {
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(ex.getMessage());
        }
        // Объект для работы с ключами
        users = redissonClient.getScoredSortedSet(KEY, StringCodec.INSTANCE);
    }

    void shutdown() {
        redissonClient.shutdown();
    }

    private double getTs() {
        return new Date().getTime() / 1000;
    }

     // Оплата пользователем услуги
    public void paidUser(int user_id) {
        users.add(getTs(), String.valueOf(user_id));
        System.out.println("\nПользователь: " + user_id + " оплатил услугу");
    }

    // Добавление пользователей
    public void addUser(int user_id) {
        users.add(getTs(), String.valueOf(user_id));
        String log = String.format("Пользователь: %d", user_id);
        out.println(log);
    }
}

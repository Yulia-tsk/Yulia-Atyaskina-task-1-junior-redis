package democashingredis.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Book")
public class Book implements Serializable {

    private Long id;
    private String name;
    private String author;
    private double price;
}

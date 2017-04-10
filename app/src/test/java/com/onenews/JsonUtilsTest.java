package com.onenews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by Administrator on 2017/4/10.
 */
public class JsonUtilsTest {
    private static final String TAG = "JsonUtilsTest";
    
    
    
    class User {
        String name;
        String sex;

        public User(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

    }


    @Test
    public void serialize() throws Exception {
        assertEquals("{\"name\":\"Lauren\",\"sex\":\"男\"}", JsonUtils.serialize(new User("Lauren", "男")));
    }

    @Test
    public void deserialize() throws Exception {
        assertNotNull(JsonUtils.deserialize("{\"name\":\"Lauren\",\"sex\":\"男\"}", User.class));
    }

    @Test
    public void deserialize1() throws Exception {
        assertNotNull(JsonUtils.deserialize("{\"name\":\"Lauren\",\"sex\":\"男\"}",NewsBean.class));
    }

}